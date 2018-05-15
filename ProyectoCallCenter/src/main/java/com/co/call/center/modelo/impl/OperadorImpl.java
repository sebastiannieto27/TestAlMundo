package com.co.call.center.modelo.impl;



import org.apache.log4j.Logger;

import com.co.call.center.config.properties.CallCenterGetPropertyValues;
import com.co.call.center.dispatcher.Dispatcher;
import com.co.call.center.modelo.Empleado;



// TODO: Auto-generated Javadoc
/**
 * The Class OperadorImpl.
 */
public class OperadorImpl extends Empleado {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(OperadorImpl.class);

	
	/**
	 * Instantiates a new operador impl.
	 */
	public OperadorImpl() {

	}

	/**
	 * Instantiates a new operador impl.
	 *
	 * @param dispatcher the dispatcher
	 * @param nombre the nombre
	 * @throws Exception the exception
	 */
	public OperadorImpl( Dispatcher dispatcher, String nombre) throws Exception{
		super(dispatcher,nombre);
		CallCenterGetPropertyValues properties=new CallCenterGetPropertyValues();
		super.rango=Integer.parseInt(properties.getPropValues("operador"));
		logger.info("create successfully Operador "+this); 
		
	}

	/* 
	 * se agrega el dispatcher dependiendo del empleado en este caso operador
	 */
	@Override
	public void agregarEmpleadoLibre(Dispatcher dispatcher) {
		try {
			dispatcher.adicionar(new OperadorImpl(dispatcher, nombre));
		} catch (Exception e) {
			logger.error("Throwed Exception [OperadorImpl.agregarEmpleadoLibre]: " +e.getMessage());

			
		}
      		
	}

	
	
	

}
