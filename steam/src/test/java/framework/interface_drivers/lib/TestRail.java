package framework.interface_drivers.lib;

import framework.interface_drivers.lib.testrail.APIClient;
import framework.interface_drivers.lib.testrail.APIException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestRail {

    public static void addResult(){
        APIClient client = new APIClient("http://<server>/testrail/");
        client.setUser("e.ryaboshapko");
        client.setPassword("Darkness");
        JSONObject c = null;
        try {
            c = (JSONObject) client.sendGet("get_case/1");
            System.out.println(c.get("title"));
        } catch (IOException | APIException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void addResult(int runId,int caseId,int statusId,String comment){
        APIClient client = new APIClient("http://portal.com/testrail/");
        client.setUser("login@variant2.com");
        client.setPassword("n2eeJrrb");
        Map data = new HashMap();
        data.put("status_id", new Integer(1));
        data.put("comment", "This test worked fine!");
        data.put("elapsed","15s");
        try {
            JSONObject o =(JSONObject)client.sendPost(String.format("add_result_for_case/%d/%d", runId,caseId), data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    public static void updateRun(){
        APIClient client = new APIClient("http://portal.com/testrail/");
        client.setUser("login@variant2.com");
        client.setPassword("n2eeJrrb");
        Map data = new HashMap();
        data.put("include_all", true);
        data.put("description", "This test worked fine!");
        try {
            client.sendPost("update_run/3", data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        addResult(3,6,1,"");
        //updateRun();
    }
}

