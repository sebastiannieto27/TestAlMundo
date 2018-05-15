package com.co.call.center.dispatcher;

import com.co.call.center.modelo.Empleado;
import com.co.call.center.parameter.ParametrosLlamada;


// TODO: Auto-generated Javadoc
/**
 * The Interface Dispatcher.
 */
public interface Dispatcher {
	
	/**
	 * Dispatch call.
	 *
	 * @param parametrosLlamada the parametros llamada
	 */
	public void dispatchCall(ParametrosLlamada parametrosLlamada);
	
	/**
	 * Adicionar.
	 *
	 * @param empleado the empleado
	 */
	public void adicionar(Empleado empleado);

}
