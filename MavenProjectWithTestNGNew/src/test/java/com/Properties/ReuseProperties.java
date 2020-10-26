package com.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReuseProperties {
	
		String filename;
		FileInputStream file;
		
		
		public ReuseProperties(String filename) throws IOException {
			this.filename=filename;
		}
		
		public String getProperty(String key) throws IOException {
			String value="";
			try {
			
			File f= new File(filename);
			file= new FileInputStream(f);
			Properties p= new Properties();
			p.load(file);
			value= p.getProperty(key);
			//file.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return value;
		}
		
		
		public void closePropertiesFile() throws IOException {
			
			file.close();
		
		

	}


}
