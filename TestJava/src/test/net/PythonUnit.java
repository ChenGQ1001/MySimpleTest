package test.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class PythonUnit {
	public static void getPathList(String token) {
		// Runtime.getRuntime().exec("python E:\\Python\\Script\\1.py");
				try {
					System.out.println("start getTopo");
					Process pr = Runtime.getRuntime().exec(
							"python E:\\Python\\Script\\2.py "+token);

					BufferedReader in = new BufferedReader(new InputStreamReader(
							pr.getInputStream()));
					String result = "";
					String line;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
						result += line;
					}
					in.close();
					pr.waitFor();
					System.out.println("end getTopo");
//					if (!"".equals(result)) {
//						ObjectMapper objectMap = new ObjectMapper();
//						Map<String,Object> remap = objectMap.readValue(result, Map.class);
//						System.out.println(((Map<String,Object>)remap.get("response")).get("serviceTicket"));
//					
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	public static void getPathById(String token, String id) {
		// Runtime.getRuntime().exec("python E:\\Python\\Script\\1.py");
				try {
					System.out.println("start getPathById");
					Process pr = Runtime.getRuntime().exec(
							"python E:\\Python\\Script\\3.py "+token+" "+id);

					BufferedReader in = new BufferedReader(new InputStreamReader(
							pr.getInputStream()));
					String result = "";
					String line;
					while ((line = in.readLine()) != null) {
						System.out.println(line);
						result += line;
					}
					in.close();
					pr.waitFor();
					System.out.println("end getPathById");
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	public static String getToken(){
		try {
			System.out.println("start");
			Process pr = Runtime.getRuntime().exec(
					"python E:\\Python\\Script\\1.py");

			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream()));
			String result = "";
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				result += line;
			}
			in.close();
			pr.waitFor();
			System.out.println("end");
			if (!"".equals(result)) {
				ObjectMapper objectMap = new ObjectMapper();
				Map<String,Object> remap = objectMap.readValue(result, Map.class);
				String tokenString = (String)((Map<String,Object>)remap.get("response")).get("serviceTicket");
				System.out.println(tokenString);
				return tokenString;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		// Runtime.getRuntime().exec("python E:\\Python\\Script\\1.py");
		//String token = getToken();
		getPathList("ST-242-17qdtZcPCfPF5cv0Q3Nl-cas");
		//getPathById("ST-242-17qdtZcPCfPF5cv0Q3Nl-cas","ed4e9337-60e0-4e5c-ac5a-52195afa2729");
	}
}
