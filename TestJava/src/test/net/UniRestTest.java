package test.net;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UniRestTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			HttpResponse<String> response = Unirest.post("http://172.20.1.172/api/v1/ticket")
					  .header("content-type", "application/json")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "2f88b574-c08b-fb42-39e5-b595d43a32cb")
					  .body("{\n\t\"username\":\"admin\",\n\t\"password\":\"eccom@123\"\n}")
					  .asString();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
