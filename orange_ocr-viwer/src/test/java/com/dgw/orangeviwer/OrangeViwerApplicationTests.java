package com.dgw.orangeviwer;

import com.dgw.orangeviwer.utils.TesseractMul;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
class OrangeViwerApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void test1() throws IOException, TesseractException {
        long stime=System.currentTimeMillis();
        BufferedImage img= ImageIO.read(new FileInputStream(new File("Z:\\1.png")));
        BufferedImage binaryimage= ImageHelper.convertImageToBinary(img);
        Tesseract tesseract= new TesseractMul("chi_sim").getCurrTesseract();
        String str=tesseract.doOCR(binaryimage);
        System.out.println(str);
        long etime=System.currentTimeMillis();
        System.out.println(((etime-stime)/3600));
    }

}
