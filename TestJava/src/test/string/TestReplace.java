package test.string;

public class TestReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String format = "test($2)";
//		format = format.replaceAll("\\$2", "".replaceAll("\\$", "\\\\\\$"));
//		System.out.println(format);
		
		String format = "\"dddffd\":123,\"disabled\":true,\"disabled\":false,\"disabled\":true";
		format = format.replaceAll("\"disabled\":true", "\"disabled\":false");
		System.out.println(format);
	}

}
