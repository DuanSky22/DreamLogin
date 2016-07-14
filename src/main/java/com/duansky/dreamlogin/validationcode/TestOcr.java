package com.duansky.dreamlogin.validationcode;

import java.io.File;
import java.io.IOException;

/**
 * Created by SkyDream on 2016/7/13.
 */
public class TestOcr {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //输入图片地址
        String path = "E://Programming//git//DreamLogin//zhihu.gif";
        try {
            String valCode = new OCR().recognizeText(new File(path), "gif");
            System.out.println(valCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
