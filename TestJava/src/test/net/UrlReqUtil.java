package test.net;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
public class UrlReqUtil {

	 public static JSONObject get(String url){
	        HttpURLConnection http = null;
	        InputStream is = null;
	        try {
	            URL urlGet = new URL(url);
	            http = (HttpURLConnection) urlGet.openConnection();

	            http.setRequestMethod("GET");
	            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	            http.setDoOutput(true);
	            http.setDoInput(true);
	            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
	            System.setProperty("sun.net.client.defaultReadTimeout", "30000");

	            http.connect();

	            is =http.getInputStream();
	            int size =is.available();
	            byte[] jsonBytes =new byte[size];
	            is.read(jsonBytes);
	            String message=new String(jsonBytes,"UTF-8");
	            return JSONObject.fromObject(message);
	        } catch (Exception e) {
	            return null;
	        }finally {
	            if(null != http) http.disconnect();
	            try {
	                if (null != is) is.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	        }

	    }

	    public static String post(String url,String data){
	        HttpURLConnection http = null;
	        PrintWriter out = null;
	        BufferedReader reader = null;
	        try {
	            //创建连接
	            URL urlPost = new URL(url);
	            http = (HttpURLConnection) urlPost
	                    .openConnection();
	            http.setDoOutput(true);
	            http.setDoInput(true);
	            http.setRequestMethod("POST");
	            http.setUseCaches(false);
	            http.setInstanceFollowRedirects(true);
	            http.setRequestProperty("Content-Type",
	                    "application/json");
	            http.setRequestProperty("cache-control",
	                    "no-cache");
	            http.setRequestProperty("postman-token",
	                    "2f88b574-c08b-fb42-39e5-b595d43a32cb");

	            http.connect();

	            //POST请求
	            OutputStreamWriter outWriter = new OutputStreamWriter(http.getOutputStream(), "utf-8");
	            out = new PrintWriter(outWriter);
	            out.print(data);
	            out.flush();
	            out.close();
	            out = null;

	            //读取响应
	            reader = new BufferedReader(new InputStreamReader(
	                    http.getInputStream()));
	            String lines;
	            StringBuffer sb = new StringBuffer("");
	            while ((lines = reader.readLine()) != null) {
	                lines = new String(lines.getBytes(), "utf-8");
	                sb.append(lines);
	            }
	            reader.close();
	            reader = null;
	            System.out.println(sb.toString());
	            return sb.toString();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return null;
	        }finally {
	            if(null != http) http.disconnect();
	            if(null != out) out.close();
	            try{
	                if(null != reader) reader.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	        }

	    }
	    
	    public static void posttest1() {
	    	try {
	            HttpClient client = HttpClients.createDefault();
	            HttpPost request2 = new HttpPost("http://172.20.1.172/api/v1/ticket");
	            
	                List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	                nvps.add(new BasicNameValuePair("username", "admin"));  
	                nvps.add(new BasicNameValuePair("password", "eccom@123"));
//	                headers.setCacheControl("no-cache");
//	        		headers.add("postman-token", "2f88b574-c08b-fb42-39e5-b595d43a32cb");
	                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nvps, "UTF-8");
	                request2.setEntity(formEntity);
	                HttpResponse response2 = client.execute(request2);
	                HttpEntity entity = response2.getEntity();
	                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
	                String lines;
		            StringBuffer sb = new StringBuffer("");
		            while ((lines = reader.readLine()) != null) {
		                lines = new String(lines.getBytes(), "utf-8");
		                System.out.println("lines"+lines);
		                sb.append(lines);
		            }
		            reader.close();
		            reader = null;
		            System.out.println(sb.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://172.20.1.172/api/v1/ticket";
		String para = "{\n\t\"username\":\"admin\",\n\t\"password\":\"eccom@123\"\n}";
		post(url,para);
		//posttest1();
	}

}
