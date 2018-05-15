package com.co.call.center.modelo.impl;

import org.apache.log4j.Logger;

import com.co.call.center.config.properties.CallCenterGetPropertyValues;
import com.co.call.center.dispatcher.Dispatcher;
import com.co.call.center.modelo.Empleado;

// TODO: Auto-generated Javadoc
/**
 * The Class DirectorImpl.
 */
public class DirectorImpl extends Empleado{
	
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(DirectorImpl.class);

	/**
	 * Instantiates a new director impl.
	 */
	public DirectorImpl() {
	
	}

	/**
	 * Instantiates a new director impl.
	 *
	 * @param dispatcher the dispatcher
	 * @param nombre the nombre
	 * @throws Exception the exception
	 */
	public DirectorImpl(Dispatcher dispatcher, String nombre) throws  Exception {
		super(dispatcher, nombre);
		CallCenterGetPropertyValues properties=new CallCenterGetPropertyValues();
		super.rango=Integer.parseInt(properties.getPropValues("director"));
		logger.info("create successfully Director "+this);
	}

	/* se agrega el dispatcher dependiendo del empleado en este caso director
	 * 
	 */
	@Override
	public void agregarEmpleadoLibre(Dispatcher dispatcher) {
		try {
			dispatcher.adicionar(new DirectorImpl(dispatcher, nombre));
		} catch (Exception e) {
			logger.error("Throwed Exception [DirectorImpl.agregarEmpleadoLibre]: " +e.getMessage());

		}
		
	}

	/* 
	 * @see com.co.call.center.modelo.Empleado#toString()
	 */
	@Override
	public String toString() {
		return "DirectorImpl [create successfully]";
	}
	
	

}
