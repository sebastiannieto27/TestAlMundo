package com.co.call.center.dispatcher.impl;


import org.apache.log4j.Logger;

import com.co.call.center.config.properties.Constantes;
import com.co.call.center.factory.EmpleadoFactory;
import com.co.call.center.parameter.ParametrosLlamada;
import com.co.call.center.view.View;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// TODO: Auto-generated Javadoc
/**
 * The Class DispatcherImplTest.
 */
public class DispatcherImplTest extends TestCase {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(DispatcherImplTest.class);

	/**
	 * Suite.
	 *
	 * @return the test
	 */
	public static Test suite(){
		return new TestSuite(DispatcherImplTest.class);
		
	}
	
	
	/**
	 *
	 *Aqui vamos a poder poner el numero de llamadas que queremos.
	 *
	 */
	public void testDispatcherOpcion(){
		
		View ob = new View();
		int tam = ob.conocerDatos("Introduzca el numero de llamadas");
		while (tam < 0) {
			ob.mostrarDatos("Vuelva digitar el numero");
			tam = ob.conocerDatos("Introduzca el numero de llamadas");
		}
		testDispatcherMultiplesLlamadas(tam);
		
	}
	
	/**
	 * Test dispatcher multiples llamadas.
	 */
	public void testDispatcherMultiplesLlamadas(int tam){
		  try {
		int j=5;
		for(int i=1; i<=tam; i++){
			DispatcherImpl dispatcher= new DispatcherImpl();
			dispatcher.start();
			if (j>i) {
			EmpleadoFactory empleadoFactory=new EmpleadoFactory();
				dispatcher.adicionar(empleadoFactory.crearEmpleado(dispatcher, Constantes.OPERADOR));		
			}else if (j<i) {
				EmpleadoFactory empleadoFactory=new EmpleadoFactory();
				dispatcher.adicionar(empleadoFactory.crearEmpleado(dispatcher, Constantes.SUPERVISOR));
				
			}else if (i==j) {
				EmpleadoFactory empleadoFactory=new EmpleadoFactory();
				dispatcher.adicionar(empleadoFactory.crearEmpleado(dispatcher, Constantes.DIRECTOR));	
			}
			ParametrosLlamada parametrosLlamada=new ParametrosLlamada(String.valueOf(i));
			parametrosLlamada.setPeriodoTiempo(5);
			dispatcher.dispatchCall(parametrosLlamada);
			//assertTrue(dispatcher.getParametrosLlamadas().isEmpty());
		}
			} catch (Exception e) {
				logger.error("Throwed Exception [DispatcherImplTest.testDispatcherMultiplesLlamadas]: " +e.getMessage());
			}
		
	}

}
