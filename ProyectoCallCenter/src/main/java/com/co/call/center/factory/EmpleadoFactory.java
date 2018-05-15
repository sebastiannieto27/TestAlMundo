package com.co.call.center.factory;

import com.co.call.center.config.properties.Constantes;
import com.co.call.center.dispatcher.Dispatcher;
import com.co.call.center.modelo.Empleado;
import com.co.call.center.modelo.impl.DirectorImpl;
import com.co.call.center.modelo.impl.OperadorImpl;
import com.co.call.center.modelo.impl.SupervisorImpl;



// TODO: Auto-generated Javadoc
/**
 * A factory for creating Empleado objects.
 */
public class EmpleadoFactory {
	
	/**
	 * Crear empleado.
	 *
	 * @param d the d
	 * @param tipoEmpleado the tipo empleado
	 * @return the empleado
	 * @throws Exception the exception
	 * metodo que crea el empleado dependiendo del tipo de empleado
	 */
	public Empleado crearEmpleado(Dispatcher d, String tipoEmpleado) throws Exception {
		switch(tipoEmpleado){
		case Constantes.OPERADOR:
			return new OperadorImpl(d,"Operador");
		case Constantes.SUPERVISOR:
			return new SupervisorImpl(d,"Supervisor");
		case Constantes.DIRECTOR:
			return new DirectorImpl(d,"Director");
		default:
			return null;
		}
	}

}
