package framework.support;

import java.awt.*;
import java.awt.image.PixelGrabber;

import static webdriver.BaseEntity.infoMessage;


/**
 * Сравнивает между собой 2 изображения
 * Пример: Assert.assertEquals(true,CompareImage.CompareImages(firstFile,secondFile));
 */
public class CompareImage {
    public static boolean CompareImages(String baseFile, String actualFile) {
        infoMessage("Compare image: ["+baseFile+"] and ["+actualFile+"]");
        boolean compareResult = false;
        Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
        Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);
        try {
            PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
            PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
            int[] baseImageData = null;
            int[] actualImageData = null;
            if(baseImageGrab.grabPixels()) {
                int width = baseImageGrab.getWidth();
                int height = baseImageGrab.getHeight();
                baseImageData = new int[width * height];
                baseImageData = (int[])baseImageGrab.getPixels();
            }
            if(actualImageGrab.grabPixels()) {
                int width = actualImageGrab.getWidth();
                int height = actualImageGrab.getHeight();
                actualImageData = new int[width * height];
                actualImageData = (int[])actualImageGrab.getPixels();
            }
            infoMessage("\tBase file ["+baseFile+"]:"+baseImageGrab.getWidth()+"x"+baseImageGrab.getHeight());
            infoMessage("\tActual file ["+actualFile+"]:"+actualImageGrab.getWidth()+"x"+actualImageGrab.getHeight());

            if ((baseImageGrab.getHeight() != actualImageGrab.getHeight()) || (baseImageGrab.getWidth()!=actualImageGrab.getWidth())){
                compareResult = false;
            }else if(java.util.Arrays.equals(baseImageData,actualImageData)){
                compareResult = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        infoMessage(String.format("\tResult: %s", compareResult));
        return compareResult;
    }
}
