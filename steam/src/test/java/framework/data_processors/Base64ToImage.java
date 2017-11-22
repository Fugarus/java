package framework.data_processors;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import webdriver.PropertiesResourceManager;

import javax.imageio.ImageIO;
import java.awt.geom.IllegalPathStateException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Base64ToImage {
    private final static String PROJECT_PROPERTIES_FILE="project.properties";
    private final static String DIR_SAVE_IMAGE=new PropertiesResourceManager(PROJECT_PROPERTIES_FILE).getProperty("dirSaveImage");
    private final static String EXPANSION_IMAGE=new PropertiesResourceManager(PROJECT_PROPERTIES_FILE).getProperty("expansionImage");

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Encode image to string
     * @param image The image to encode
     * @param type jpeg, bmp, ...
     * @return encoded string
     */
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static String encodeImageToString(String dir){
        try {
            File image=new File(dir);
            BufferedImage img = ImageIO.read(image);
            return encodeToString(img, EXPANSION_IMAGE);
        }catch (IOException e){
            throw new IllegalPathStateException(String.format("Can't encode Image to String\nImage:\n", dir));
        }
    }

    public static String decodeXlsBase64ToImage(String xlsBase64,String name){
        return decodeBase64ToImage(xlsBase64.split(",")[1],name);
    }

    public static String decodeBase64ToImage(String base64,String name){
        try {
            BufferedImage newImg=decodeToImage(base64);
            File image=new File(DIR_SAVE_IMAGE+name+"."+EXPANSION_IMAGE);
            ImageIO.write(newImg, EXPANSION_IMAGE, image);
            return image.getAbsolutePath();
        }catch (IOException ignored){
            throw new IllegalPathStateException(String.format("Can't decode base64 to image\nBase64:\n%s", base64));
        }
    }
}
