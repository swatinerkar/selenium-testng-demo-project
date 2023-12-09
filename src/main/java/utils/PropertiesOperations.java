package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesOperations {
	private String propFileLocation = System.getProperty("user.dir") + "/src/test/resource/Config.properties";
	private static PropertiesOperations propertiesObj;
	private Properties prop;

	private PropertiesOperations() throws IOException {
		this.prop = new Properties();
		FileInputStream fis = new FileInputStream(propFileLocation);
		this.prop.load(fis);
	}

	public static PropertiesOperations loadProperties() throws IOException {
		if (propertiesObj == null)
			synchronized (PropertiesOperations.class) {
				if (propertiesObj == null)
					propertiesObj = new PropertiesOperations();
			}
		return propertiesObj;
	}

	public String getPropertyValueByKey(String key) {
		return this.prop.getProperty(key);
	}
}
