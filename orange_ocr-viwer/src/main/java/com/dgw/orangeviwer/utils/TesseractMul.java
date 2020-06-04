package com.dgw.orangeviwer.utils;

import com.dgw.orangeviwer.config.TessData;
import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class TesseractMul {

    //private final static String path = System.getProperty("user.dir")+"/tessdata";//基础目录
    //测试目录
    private final static String path = getPath()+" ";

    private String language ="chi_sim";
    public TesseractMul(String lang){
        this.language =lang;
    }

    public TesseractMul(){ }


    /**
     * 测试识别方法
     * @return
     */
    public Tesseract getCurrTesseract(){
        Tesseract tesseract=new Tesseract();
        tesseract.setLanguage(language);
        tesseract.setDatapath("E:\\GItHubRepository\\orange_ocr\\orange_ocr-viwer\\src\\main\\resources\\tessdata");
        tesseract.setOcrEngineMode(ITessAPI.TessOcrEngineMode.OEM_LSTM_ONLY);
        return tesseract;
    }

    /**
     * 生产方法
     * @param path
     * @return
     */
    public Tesseract getCurrTesseract(String path){
        Tesseract tesseract=new Tesseract();
        tesseract.setLanguage(language);
        tesseract.setDatapath(path);
        System.out.println("path目录"+path);
        tesseract.setOcrEngineMode(ITessAPI.TessOcrEngineMode.OEM_LSTM_ONLY);
        return tesseract;
    }

    private static String getPath(){
        String path="";
        try {
            File directory = new File("resources/tessdata");
            path = directory.getCanonicalFile().getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}