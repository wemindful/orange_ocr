package com.dgw.orangeviwer.controller;

import com.alibaba.fastjson.JSON;
import com.dgw.orangeviwer.config.TessData;
import com.dgw.orangeviwer.constants.Constant;
import com.dgw.orangeviwer.entity.OcrTexts;
import com.dgw.orangeviwer.services.OcrAccessService;
import com.dgw.orangeviwer.services.OcrTextService;
import com.dgw.orangeviwer.services.UserService;
import com.dgw.orangeviwer.utils.FileUtils;
import com.dgw.orangeviwer.utils.TesseractMul;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.json.Json;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-07 23:23
 **/
@Controller
public class OcrController {

    private Logger logger=Logger.getLogger(OcrController.class.getName());

    @Autowired
    private OcrTextService ocrTextService;

    @Autowired
    private OcrAccessService ocrAccessService;

    @Autowired
    private HttpSession session;

    private static String currentPeople;

    @Autowired
    private TesseractMul tesseractMul;

    @Autowired
    private TessData tessData;


    @PostMapping("/uploadAuth")
    @ResponseBody
    public Map imageUpload(String username) {
        Map<String, Object> root = new HashMap<String, Object>(1);
        // 身份校验
        if(username==null){ username="";}
        if(session.getAttribute("user")!=null&&session.getAttribute("user").equals(username)){
            root.put("auth",1);
            currentPeople=username;
        }else{
            root.put("auth",0);
        }
        return root;
    }

    @PostMapping("/imageUpload")
    @ResponseBody
    public Map imageUpload(@RequestParam("fileName") MultipartFile file) {

        //上传结果信息
        String result_msg = "";
        //上传结果代码
        String result_code = "";
        // 识别结果
        String ocr_result = "";

        Map<String, Object> root = new HashMap<String, Object>();

        if (file.getSize() / 1000 > 100) {
            result_msg = "图片大小不能超过100KB";
            result_code = "404";
        } else {
            //判断上传文件格式
            String fileType = file.getContentType();
            if (fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpeg")) {
                // 要上传的目标文件存放的绝对路径
                //用src为保存绝对路径不能改名只能用原名，不用原名会导致ajax上传图片后在前端显示时出现404错误-->原因未知
                //  String localPath="F:\\IDEAProject\\imageupload\\src\\main\\resources\\static\\img";
                final String localPath = Constant.IMAGE_PATH+"\\img";
                //上传后保存的文件名(需要防止图片重名导致的文件覆盖)
                //获取文件名
                String fileName = file.getOriginalFilename();
                //获取文件后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                //重新生成文件名
                fileName = UUID.randomUUID() + suffixName;
                if (FileUtils.upload(file, localPath, fileName)) {
                    //文件存放的相对路径(一般存放在数据库用于img标签的src)
                    String relativePath = "img/" + fileName;
                    //前端根据是否存在该字段来判断上传是否成功
                    root.put("relativePath", relativePath);
                    result_msg = "图片上传成功";
                    String result = discernImg(relativePath);
                    ocr_result=result;
                    // 保存 识别结果
                    saveOcr(ocr_result, relativePath);
                    ocrAccessService.updatAaccessCount(new Date());
                } else {
                    result_msg = "图片上传失败";
                }
            } else {
                result_msg = "图片格式不正确";
            }
        }

        root.put("result_msg", result_msg);
        root.put("result_code", result_code);
        root.put("ocr_result", ocr_result);
        String root_json = JSON.toJSONString(root);
        return root;
    }

    private void saveOcr(String ocr_result, String localPath) {
        OcrTexts texts = new OcrTexts();
        texts.setTextName(ocr_result);
        texts.setImagePath(localPath);
        texts.setTagInputDate(new Date());
        texts.setAccessDate(new Date());
        texts.setApplyPeople(currentPeople);
        ocrTextService.save(texts);
    }

    private String discernImg(String imagePath){
        String result="";
        long stime=System.currentTimeMillis();
        try {
            BufferedImage img= ImageIO.read(new FileInputStream(new File(imagePath)));
            BufferedImage grayscale = ImageHelper.convertImageToGrayscale(img);
            BufferedImage binaryimage= ImageHelper.convertImageToBinary(grayscale);
            // Tesseract tesseract= new TesseractMul("chi_sim").getCurrTesseract();
            Tesseract tesseract = tesseractMul.getCurrTesseract(tessData.getPath());
            result=tesseract.doOCR(binaryimage);
            img=null;
            binaryimage=null;
        } catch (IOException e) {
            logger.warning("读取图片失败!");
            e.printStackTrace();
        } catch (TesseractException e) {
            logger.warning("OCR引擎失败!");
            e.printStackTrace();
        }
        long etime=System.currentTimeMillis();
        logger.info("识别花费时间"+((etime-stime))+"ms");
        return result;
    }
}
