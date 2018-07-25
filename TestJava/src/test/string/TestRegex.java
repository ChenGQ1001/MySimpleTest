package test.string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestRegex {
	 public static boolean isIP(String ipaddr) {
	        Pattern p = Pattern.compile("(([01]?[\\d]{1,2})|(2[0-4][\\d])|(25[0-5]))(\\.(([01]?[\\d]{1,2})|(2[0-4][\\d])|(25[0-5]))){3}");
	        Matcher m = p.matcher(ipaddr);
	        return m.matches();
	    }

	    public static boolean isIPSubnet(String ipaddr) {
	        Pattern p = Pattern.compile("(([01]?[\\d]{1,2})|(2[0-4][\\d])|(25[0-5]))(\\.(([01]?[\\d]{1,2})|(2[0-4][\\d])|(25[0-5]))){3}(\\/(\\d|[1-2]\\d|3[0-2]))");
	        Matcher m = p.matcher(ipaddr);
	        return m.matches();
	    }
	    private List<String> iterateAddress(List<String> ips) {
	        List<String> ip = new ArrayList<String>();
	        for(String ipstr : ips){
	            if (TestRegex.isIP(ipstr) || TestRegex.isIPSubnet(ipstr)) {
	                ip.add(ipstr);
	            }
	        }
	        return ip;
	    }
	public static String extract(String txt, String regex, int groupindex)
			throws Exception {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(txt);
		if (m.find())
			return m.group(groupindex);
		return null;
	}
	public static void main(String[] args) {
		List<String> ip = new ArrayList<String>();
	}
}
