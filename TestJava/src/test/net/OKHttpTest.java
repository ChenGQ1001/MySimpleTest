package test.net;

import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;

public class OKHttpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OkHttpClient client = new OkHttpClient();

//    	MediaType mediaType = MediaType.parse("application/json");
//    	RequestBody body = RequestBody.create(mediaType, "{\n\t\"username\":\"admin\",\n\t\"password\":\"eccom@123\"\n}");
//    	Request request = new Request.Builder()
//    	  .url("http://172.20.1.172/api/v1/ticket")
//    	  .post(body)
//    	  .addHeader("content-type", "application/json")
//    	  .addHeader("cache-control", "no-cache")
//    	  .addHeader("postman-token", "8e02f6ea-aee1-7b63-23a3-17503447fb16")
//    	  .build();
//
//    	try {
//			Response response = client.newCall(request).execute();
//			String string = response.body().toString();
//			System.out.println(string);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
