package test.net;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;

public class HTTPSClientTest {

    public static void main(String[] args) throws Exception {
        HttpClient httpClient = null;

        httpClient = new HTTPSTrustClient().init();
        //httpClient = new HTTPSCertifiedClient().init();

        String url = "https://172.20.1.172/api/v1/ticket";
        //String url = "https://1.2.6.2:8011/xxx/api/getHealth";

        Map<String, String> paramHeader = new HashMap<String, String>();
        paramHeader.put("content-type", "application/json");
       // paramHeader.put("Accept", "application/json");
        Map<String, String> paramBody = new HashMap<String, String>();
        paramBody.put("username", "admin");
        paramBody.put("password", "eccom@123");
        String result = HTTPSClientUtil.doPost(httpClient, url, paramHeader, paramBody);
        
        //String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);
        
        System.out.println(result);
    }

}