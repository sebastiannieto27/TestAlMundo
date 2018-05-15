package com.co.call.center.modelo.impl;

import org.apache.log4j.Logger;

import com.co.call.center.config.properties.CallCenterGetPropertyValues;
import com.co.call.center.dispatcher.Dispatcher;
import com.co.call.center.modelo.Empleado;

// TODO: Auto-generated Javadoc
/**
 * The Class SupervisorImpl.
 */
public class SupervisorImpl extends Empleado {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(SupervisorImpl.class);

	/**
	 * Instantiates a new supervisor impl.
	 */
	public SupervisorImpl() {
		
	}

	/**
	 * Instantiates a new supervisor impl.
	 *
	 * @param dispatcher the dispatcher
	 * @param nombre the nombre
	 * @throws Exception the exception
	 */
	public SupervisorImpl(Dispatcher dispatcher, String nombre) throws Exception {
		super(dispatcher, nombre);
		CallCenterGetPropertyValues properties=new CallCenterGetPropertyValues();
		super.rango=Integer.parseInt(properties.getPropValues("supervisor"));
		logger.info("create successfully Supervisor "+this);
		}

	/* 
	 * se agrega el dispatcher dependiendo del empleado en este caso supervisor
	 */
	@Override
	public void agregarEmpleadoLibre(Dispatcher dispatcher) {
		try {
			dispatcher.adicionar(new SupervisorImpl(dispatcher, nombre));
		} catch (Exception e) {
			logger.error("Throwed Exception [SupervisorImpl.agregarEmpleadoLibre]: " +e.getMessage());

		}
		
	}

	/* 
	 * @see com.co.call.center.modelo.Empleado#toString()
	 */
	@Override
	public String toString() {
		return "SupervisorImpl [create successfully]";
	}
	
	

}
