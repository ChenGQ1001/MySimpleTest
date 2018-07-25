package test.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import difflib.DiffUtils;
import difflib.Patch;

public class CompareFile {
	public List<String> ignores = new ArrayList<String>();

	private List<String> fileToLines(String content) {
		// 去除开头的双引号
		if (!content.isEmpty() && "\"".equals(content.substring(0, 1)))
			content = content.substring(1);
		// 去除结尾的双引号
		if (!content.isEmpty()
				&& "\"".equals(content.substring(content.length() - 1)))
			content = content.substring(0, content.length() - 1);
		// 忽略所有的\r
		String[] contentArr = content.replaceAll("\\\\r", "").split("\\\\n");
		List<String> contentList = new ArrayList<String>();
		for (int i = 0; i < contentArr.length; i++) {
			// 去除开头结尾多余的空格
			contentList.add(contentArr[i].trim().replaceAll("'", ""));
		}
		return contentList;
	}

	public String replaceIgnore(String content) {
		for (String regex : ignores) {
			// System.out.println("regex:"+regex);
			content = content.replaceAll(regex, "");
		}
		return content;
	}

	public boolean isChanged(String file, String lastFile) {
		if (lastFile == null) {
			return true;
		}

		String data1 = "";
		String temp = null;
		try {
			BufferedReader br1 = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			while ((temp = br1.readLine()) != null) {
				data1 += temp;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		temp = null;

		String data2 = "";
		try {
			BufferedReader br2 = new BufferedReader(new InputStreamReader(
					new FileInputStream(lastFile)));
			while ((temp = br2.readLine()) != null) {
				data2 += temp;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String originalcontent = replaceIgnore(data1);
		String latestcontent = replaceIgnore(data2);
		List<String> original = fileToLines(originalcontent);
		List<String> latest = fileToLines(latestcontent);
		System.out.println("data1:" + original);
		System.out.println("data2:" + latest);
		Patch patch = DiffUtils.diff(original, latest);
		return patch.getDeltas().size() > 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompareFile cf = new CompareFile();
		cf.ignores.add(", \\d\\d:\\d\\d:\\d\\d,");
		cf.ignores.add(", (\\d+w)?\\d+d\\d+h,");
		cf.ignores.add(", ntp clock-period \\d+,");
		cf.ignores.add("ntp clock-period \\d+");
		cf.ignores.add(", NVRAM config last updated at (\\S| )*");
		cf.ignores.add("NVRAM config last updated at (\\S| )*");
		cf.ignores.add("Last configuration change at (\\S| )*");
		boolean ischange = cf.isChanged("C:\\Users\\Jack\\Desktop\\1\\5.txt",
				"C:\\Users\\Jack\\Desktop\\1\\6.txt");
		System.out.println(ischange);
	}

}
