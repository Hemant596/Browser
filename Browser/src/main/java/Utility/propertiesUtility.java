package Utility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class propertiesUtility {
	public void properties() throws IOException {
		
	
	
	Properties prop= new Properties();
	FileInputStream ip = new FileInputStream("C:\\Users\\sharma.hemant\\git\\Browser\\Browser\\config.properties");
	prop.load(ip);

}}
