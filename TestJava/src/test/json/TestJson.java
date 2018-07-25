package test.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

public class TestJson {

	public static String ReadFile(String Path) {
		BufferedReader reader = null;
		String laststr = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(Path);
			InputStreamReader inputStreamReader = new InputStreamReader(
					fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return laststr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String JsonContext = ReadFile("C:\\Users\\Jack\\Desktop\\dashboard\\data\\data1.json");
		Object json = new JSONTokener(JsonContext).nextValue();
		if (json instanceof JSONArray) {
			try {
				List<List<String>> reList = new ArrayList<List<String>>();
				JSONArray jsonArray = (JSONArray) json;
				int size = jsonArray.size();
				System.out.println("Size: " + size);
				if (size > 0) {
					Object obj = jsonArray.get(0);
					if (obj instanceof JSONObject) {
						JSONObject jsonObject = (JSONObject) obj;
						Iterator its = jsonObject.keys();
						List<String> headList = new ArrayList<String>();
						while (its.hasNext()) {
							String k = its.next().toString();
							headList.add(k);
						}
						reList.add(headList);
						for (int i = 0; i < size; i++) {
							JSONObject iObject = jsonArray.getJSONObject(i);
							int hsize = headList.size();
							List<String> bodyList = new ArrayList<String>();
							for (int j = 0; j < hsize; j++) {
								bodyList.add(iObject.getString(headList.get(j)));
							}
							reList.add(bodyList);
						}
					} else if (obj instanceof JSONArray) {
						for(int i = 0; i < size; i++){
							List<String> list = new ArrayList<String>();
							JSONArray iJSONArray = jsonArray.getJSONArray(i);
							int isize = iJSONArray.size();
							for(int j = 0; j < isize; j++){
								list.add(iJSONArray.getString(j));
							}
							reList.add(list);
						}
					}
					System.out.println(reList.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception error");
			}
		} else {
			System.out.println("error");
		}

	}
}
