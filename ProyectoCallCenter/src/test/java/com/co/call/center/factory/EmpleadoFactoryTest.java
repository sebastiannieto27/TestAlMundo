package com.co.call.center.factory;

import com.co.call.center.dispatcher.Dispatcher;
import com.co.call.center.dispatcher.impl.DispatcherImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpleadoFactoryTest.
 */
public class EmpleadoFactoryTest extends TestCase {
	
	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test suite(){
		return new TestSuite(EmpleadoFactoryTest.class);
		
	}
	
	/**
	 * Test factory.
	 *
	 * @throws Exception the exception
	 */
	public void testFactory() throws Exception{
		EmpleadoFactory empleadoFactory=new EmpleadoFactory();
		Dispatcher d=new DispatcherImpl();
		empleadoFactory.crearEmpleado(d, "operador");
		
	}
	

}
