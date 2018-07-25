package test.file;

import java.io.File;
import java.util.List;

public class PrintName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File("D:\\NetEagle\\branches\\3.6.9.0\\client_web\\neteagle3\\cmdb\\change\\type");
		String[] files = file.list();
		for (String f : files) {
			System.out.println("/opt/neteagle3/jboss6.0/server/default/neteagle3/cmdb/change/type/"+f);
		}

	}

}
