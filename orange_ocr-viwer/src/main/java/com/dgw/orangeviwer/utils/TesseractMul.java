package com.dgw.orangeviwer.utils;

import com.dgw.orangeviwer.OrangeViwerApplication;
import com.dgw.orangeviwer.constants.Constant;
import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.system.ApplicationHome;

import java.io.File;
import java.io.IOException;

public class TesseractMul {

    //private final static String path = System.getProperty("user.dir")+"/tessdata";//基础目录
    //测试目录
    private final static String path = getPath()+" ";


    private String Language="chi_sim";
    public TesseractMul(String lang){
        this.Language=lang;
    }

    private TesseractMul(){
    }

    public Tesseract getCurrTesseract(){
        Tesseract tesseract=new Tesseract();
        tesseract.setLanguage(Language);
        tesseract.setDatapath("E:\\GItHubRepository\\orange_ocr\\orange_ocr-viwer\\src\\main\\resources\\tessdata");
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