package com.co.call.center.config.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


// TODO: Auto-generated Javadoc
/**
 * The Class CallCenterGetPropertyValues.
 */
public class CallCenterGetPropertyValues {
	
	/** The input stream. */
	private  InputStream inputStream;
	
	/** The privilegio. */
	private int privilegio;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(CallCenterGetPropertyValues.class);
	
	/**
	 * Instantiates a new call center get property values.
	 */
	public CallCenterGetPropertyValues(){
		   
	   }
	
	  /**
  	 * Instantiates a new call center get property values.
  	 *
  	 * @param privilegio the privilegio
  	 */
  	public CallCenterGetPropertyValues( int privilegio){
		   this.privilegio=privilegio;
	   }

	  
	  /**
  	 * Gets the prop values.
  	 *
  	 * @param key the key
  	 * @return the prop values
  	 * @throws Exception the exception
  	 */
  	public  String getPropValues(String key) throws Exception {

			try {
				Properties prop = new Properties();
				String propFileName = "config.properties";

				inputStream = getClass().getClassLoader().getResourceAsStream(
						propFileName);

				if (inputStream != null) {
					prop.load(inputStream);
				} else {
					throw new FileNotFoundException("property file '"
							+ propFileName + "' not found in the classpath");
				}


				// get the property value and print it out
				logger.info(prop.getProperty(key) + "el valor del getProperty  " );

				return prop.getProperty(key);
				
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			} finally {
				inputStream.close();
			}
			return null;
		}
	  
	  /**
  	 * Gets the privilegio.
  	 *
  	 * @return the privilegio
  	 */
  	public int getPrivilegio() {
			return privilegio;
		}

}
