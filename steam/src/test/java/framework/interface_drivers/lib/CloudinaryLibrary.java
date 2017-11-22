package framework.interface_drivers.lib;

import com.cloudinary.Cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CloudinaryLibrary {
    private String api_key;
    private String api_secret;
    private String cloud_name;

    public CloudinaryLibrary(String api_key, String api_secret, String cloud_name) {
        this.api_key = api_key;
        this.api_secret = api_secret;
        this.cloud_name = cloud_name;
    }

    public Map uploadImage(String dirToImage){
        Cloudinary cloudinary = new Cloudinary();

        File file = new File(dirToImage);

        try {
            return cloudinary.uploader().upload(file,Cloudinary.asMap("api_key",api_key,"api_secret",api_secret,"cloud_name",cloud_name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
