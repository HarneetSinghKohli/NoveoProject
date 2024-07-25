package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class PropFileReader {
	private static	Properties prop;
	
	

	public  Properties PropFileRead(String configFilePath) throws IOException {
		prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(configFilePath);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new IOException("Could not load properties file: " + configFilePath);
        }

        return prop;
	}
	
	public  Properties JsonFileRead(String JsonFilePath) throws IOException {
		prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(JsonFilePath);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new IOException("Could not load properties file: " + JsonFilePath);
        }

        return prop;
	}
	
	public String getAPIURL(String ApiUrlPath) {
		String URLPath=prop.getProperty(ApiUrlPath);
		System.out.println("APIResource to test is "+URLPath);
		if(URLPath!=null) {
			return URLPath;
		}else {
			throw new RuntimeException("Issue with APIResource path");
		}
	}
	
	public String getAPIEndPoint(String APIEndpoint) {
		String endPoint=prop.getProperty(APIEndpoint);
		System.out.println("API End point to test is "+endPoint);
		if(endPoint!=null) {
			return endPoint;
		}else {
			throw new RuntimeException("Issue with API endPoint path");
		}
	}
	
}
