package test.net;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;

import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class RunPyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 PythonInterpreter interpreter = new PythonInterpreter();  
//	        interpreter.execfile("D:/1/python Test/test.py");  
//	        PyFunction func = (PyFunction) interpreter.get("test", PyFunction.class);  
//	        PyObject pyobj = func.__call__();  
//		Map<String, String> envmap = System.getenv();  
//        for(Map.Entry<String, String> entry:envmap.entrySet()){      
//             System.out.println(entry.getKey()+"--->"+entry.getValue());      
//        }  
//	    	PythonInterpreter interp = new PythonInterpreter();
//	    	PySystemState sys = Py.getSystemState();
//	    	System.out.println(sys.path.toString()); 
//	    	sys.path.add("D:\\Python");
//	    	interp.exec("import requests");
//			interp.execfile("D:\\1\\python Test\\APIC\\testpy.py");
//			PyFunction func = (PyFunction)interp.get("get_auth_token",PyFunction.class); 
//			PyObject pyobj = func.__call__(); 
//			System.out.println("anwser = " + pyobj.toString());
		try {
			System.out.println("start getTopo");
			File file = new File("D:\\1\\python Test\\APIC");
//			Process pr = Runtime.getRuntime().exec(new String[]{"python","import testpy",
//				    "testpy.get_auth_token()"},null,file);
//			Process pr = Runtime.getRuntime().exec("python D:\\BaiduYunDownload\\1.py");
//			Process pr = Runtime.getRuntime().exec(new String[]{"python","print(123)"});
			Process pr = Runtime.getRuntime().exec("python print(123)");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
