package test.Gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class StringToGson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = "{\"fwpolicy\":[{\"name\":\"testurl\",\"protocol\":\"[{\\\"protocol\\\":\\\"tcp\\\",\\\"port\\\":\\\"any\\\"},{\\\"protocol\\\":\\\"udp\\\",\\\"port\\\":\\\"80\\\"}]\",\"deviceGroup\":\"PA-Production\",\"urlList\":[\"www.baidu.com\",\"www.eccom.com\"],\"sourceIPList\":[\"1.1.1.1\",\"www.eccom.com\"],\"sourceZone\":[],\"destIPList\":[\"2.2.2.2\"],\"destZone\":[],\"description\":\"\",\"paAction\":\"allow\",\"paApplications\":[],\"logStart\":\"no\",\"logEnd\":\"yes\",\"serverResponse\":\"no\",\"startDate\":1528214400000,\"endDate\":1528214400000,\"permanent\":\"true\",\"workOrderAction\":\"ADD\"}]}";
		try{
            Gson gson = new Gson(); 
            JsonObject jsonObject=gson.fromJson(string,JsonObject.class);
            JsonElement fwpolice=jsonObject.get("fwpolicy").getAsJsonArray().get(0);
            DefaultFwPolicyDto defaultFwPolicyDto = gson.fromJson(fwpolice, DefaultFwPolicyDto.class);
            System.out.println(defaultFwPolicyDto.getUrlList().toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
