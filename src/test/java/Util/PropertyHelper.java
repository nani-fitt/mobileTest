package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {
	
		public static  Properties loadData() {
			String environment ="staging";
			Properties p = new Properties();
			try {
				if (environment.equalsIgnoreCase("staging")) {
					FileInputStream f = new FileInputStream("./src/property/DataDriverStaging.properties");
					p.load(f);
				}
				else if (environment.equalsIgnoreCase("preprod")) {
					FileInputStream f = new FileInputStream("data/TestDataPreProd.properties");
					p.load(f);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return p;
		}
	}


