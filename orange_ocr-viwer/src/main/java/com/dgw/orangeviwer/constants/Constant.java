package com.dgw.orangeviwer.constants;

import java.net.URL;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-07 00:47
 **/
public class Constant {

    public static  String IMAGE_PATH="";

    public static void main(String[] args) {
        URL url = Constant.class.getClassLoader().getResource("");
        System.out.println(url);
    }
}
