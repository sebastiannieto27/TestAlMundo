package com.co.call.center.modelo;

import org.apache.log4j.Logger;



import com.co.call.center.config.properties.CallCenterGetPropertyValues;
import com.co.call.center.dispatcher.Dispatcher;
import com.co.call.center.parameter.ParametrosLlamada;


// TODO: Auto-generated Javadoc
/**
 * The Class Empleado.
 */
public abstract class Empleado extends Thread implements Comparable<Empleado> {	
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Empleado.class);
	
	/** The call center get property values. */
	public CallCenterGetPropertyValues callCenterGetPropertyValues;
	
	/** The nombre. */
	public String nombre;
	
	/** The rango. */
	protected int rango;
	
	/** The parametros llamada. */
	private ParametrosLlamada parametrosLlamada;
	
	/** The dispatcher. */
	private Dispatcher dispatcher;

	
	/**
	 * Instantiates a new empleado.
	 */
	public Empleado() {

	}
	
	/**
	 * Instantiates a new empleado.
	 *
	 * @param dispatcher the dispatcher
	 * @param nombre the nombre
	 */
	public Empleado(Dispatcher dispatcher,String nombre) {
		this.nombre=nombre;
		this.dispatcher=dispatcher;
	}
	
	
	
	/**
	 * Gets the orden.
	 *
	 * @return the orden
	 */
	public int getOrden(){
		return callCenterGetPropertyValues.getPrivilegio();
		
	}
	
	/* 
	 * metodo que se implememta de la clase Comparable y el cual nos brinda  la comparación de objetos, 
	 * permitiendo hacer ordenaciones de los mismos
	 * 
	 */
	public int compareTo(Empleado Empleado){
		
		if (this.getOrden()< Empleado.getOrden()) {
			return 1;

		}else if (this.getOrden() > Empleado.getOrden()) {
			return -1;
		}
		return 0;
		
	}
	
	/**
	 * Responder solicitud.
	 *
	 * @param parametrosLlamada the parametros llamada
	 * se responde la llamada y se inicia un hilo
	 */
	public void responderSolicitud(ParametrosLlamada parametrosLlamada){
		try {
			this.parametrosLlamada=parametrosLlamada;
			this.start();
			
		} catch (Exception e) {
			logger.error("Throwed Exception [FactoryEmpleado.responderSolicitud]: " +e.getMessage());
		}
	}
	

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Agregar empleado libre.
	 *
	 * @param dispatcher the dispatcher
	 * Este metodo abstracto es heredado por los tres tipos de empleado:
	 * operador
	 * supervisor
	 * director
	 * en el cual se agrega el empleado dependiendo el tipo de empleado que sea
	 */
	public abstract void agregarEmpleadoLibre(Dispatcher dispatcher);

	/* 
	 * Aqui se ejecuta un hilo que se extiende de la clase Thread
	 * se pone a dormir el hilo multiplica por los parametros de la llamada
	 * y se informa que la llamda ha sido atendida
	 * 
	 */
	public void run(){
		try {
			Thread.sleep(1000*parametrosLlamada.getPeriodoTiempo());
	        logger.info("Detalles de la llamada " + parametrosLlamada.getDetalles() + " que acaba de concluir. Tiempo :" + parametrosLlamada.getPeriodoTiempo());
            agregarEmpleadoLibre(dispatcher);
            logger.info("El empleado que atendio la llamada " + this.getNombre() + " esta disponible");
		} catch (Exception e) {
			logger.error("Throwed Exception [FactoryEmpleado.run]: " +e.getMessage());
		}
	}

	/* (
	 * @see java.lang.Thread#toString()
	 */
	@Override
	public String toString() {
		return "Empleado [callCenterGetPropertyValues="
				+ callCenterGetPropertyValues + ", nombre=" + nombre
				+ ", rango=" + rango + ", parametrosLlamada="
				+ parametrosLlamada + ", dispatcher=" + dispatcher + "]";
	}

	

}
