package test.python;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.python.core.PyFunction;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class RunPy {
	public static Object execFile(String fileName,String functionName) {
		PythonInterpreter interp = new PythonInterpreter();
		interp.execfile(fileName);
		PyFunction func = (PyFunction)interp.get(functionName,PyFunction.class); 
		PyObject pyobj = func.__call__();  
		return pyobj;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "D:\\1\\python Test\\test.py";
		Object obj = null;
		try {
			obj = RunPy.execFile(path,"main");
		}catch (Exception e) {
			System.out.println("python 文件执行错误");
			return;
		}
		PyObject po=(PyObject)obj;
		if(po.isSequenceType()){
			List<List<String>> reLists = new ArrayList<List<String>>();
			try {
				PyList pylist=(PyList)obj;
				for (int i = 0; i < pylist.size(); i++) {
					//List<String> row = (List<String>)pylist.get(0);
					PyList row = (PyList)pylist.get(i);
					List<String> rowList = new ArrayList<String>();
					for (int j = 0; j < row.size(); j++) {
						String ret = row.get(j).toString();
						String newStr;
						newStr = new String(ret.getBytes("iso8859-1"), "utf-8");
						rowList.add(newStr);
					}
					reLists.add(rowList);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("文件执行结果格式错误，请检查文件！");
			return;
		}

	}

}
