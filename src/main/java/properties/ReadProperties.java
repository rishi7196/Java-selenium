package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("data.properties");
		Properties prop= new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("url"));
		
		
	}

}
