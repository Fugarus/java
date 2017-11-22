package framework.interface_drivers.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static webdriver.BaseEntity.infoMessage;


public class HttpsLib {
    public String sendPost(String url,String contentType){
        try {

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST"); con.setRequestProperty("Content-Type", contentType); con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.flush(); wr.close();

            infoMessage("Sending 'POST' request to URL : " + url);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String output;
            StringBuilder response = new StringBuilder();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();

            infoMessage(String.format("Response Code : %d\nResponse :\n%s", con.getResponseCode(),response.toString()));
            return response.toString();
        }catch (Exception ignored){

        }
        return null;
    }



}


