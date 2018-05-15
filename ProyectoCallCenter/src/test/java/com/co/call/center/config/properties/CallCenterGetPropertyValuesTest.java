package com.co.call.center.config.properties;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// TODO: Auto-generated Javadoc
/**
 * The Class CallCenterGetPropertyValuesTest.
 */
public class CallCenterGetPropertyValuesTest extends  TestCase {
	
	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test Suite(){
		return new TestSuite(CallCenterGetPropertyValuesTest.class);
	}
	
	/**
	 * Test lectura properties.
	 *
	 * @throws Exception the exception
	 */
	public void testLecturaProperties() throws Exception{
		CallCenterGetPropertyValues property=new CallCenterGetPropertyValues();
		property.getPropValues("supervisor");
		
	}

}
