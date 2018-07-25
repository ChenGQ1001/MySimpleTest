package test.file;

import java.io.File;

public class RenameFolder {
	public static void main(String[] args) {
		new File("C:\\Users\\Jack\\Desktop\\mysql test").renameTo(new File("mysql test"));  
	}
}
