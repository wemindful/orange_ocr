package com.dgw.orangeviwer;

import com.dgw.orangeviwer.config.TessData;
import com.dgw.orangeviwer.utils.TesseractMul;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@SpringBootTest
class OrangeViwerApplicationTests {
    private final static String PATH = "E:\\GItHubRepository\\orange_ocr\\orange_ocr-viwer\\src\\main\\resources\\resource\\常用汉字1000个.txt";
    @Test
    void contextLoads() {

    }

    //@Test
    public void test1() throws IOException, TesseractException {
        long stime=System.currentTimeMillis();
        BufferedImage img= ImageIO.read(new FileInputStream(new File("Z:\\1.png")));
        BufferedImage binaryimage= ImageHelper.convertImageToBinary(img);
        Tesseract tesseract= new TesseractMul("chi_sim").getCurrTesseract();
        tesseract.setTessVariable("tessedit_char_whitelist",splitChs());
        String str=tesseract.doOCR(binaryimage);
        System.out.println(str);
        long etime=System.currentTimeMillis();
        System.out.println(((etime-stime)/3600));
    }


    private static String splitChs() {
        final StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(PATH), "GBK"));
            String[] s = reader.readLine().split(" ");
            for (String s1 : s) {
                buffer.append(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return buffer.toString();
    }

    @Autowired
    private TessData tessData;

    @Test
    public void testPath(){
        System.out.println(tessData.getPath());
    }

    @Autowired
    private TesseractMul tesseractMul;

    @Test
    public void testGetPath(){
        Tesseract tesseract = tesseractMul.getCurrTesseract();
        System.out.println(tesseract);
    }
}
