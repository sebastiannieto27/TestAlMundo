package com.co.call.center.dispatcher.impl;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.log4j.Logger;

import com.co.call.center.dispatcher.Dispatcher;
import com.co.call.center.modelo.Empleado;
import com.co.call.center.parameter.ParametrosLlamada;

// TODO: Auto-generated Javadoc
/**
 * The Class DispatcherImpl.
 */
public class DispatcherImpl extends Thread implements  Dispatcher {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(DispatcherImpl.class);
	
	/** The trabajador libre. */
	BlockingQueue<Empleado> trabajadorLibre;
	
	/** The parametros llamadas. */
	BlockingQueue<ParametrosLlamada> parametrosLlamadas;
	
	/**
	 * Instantiates a new dispatcher impl.
	 */
	public DispatcherImpl(){
		trabajadorLibre= new PriorityBlockingQueue<Empleado>();
		parametrosLlamadas=new LinkedBlockingQueue<ParametrosLlamada>();
		
	}

	/* 
	 * El metodo dispatchCall cumple la funcion de asignar la llamada entrante y ponerlo en la cola de llamadas
	 * se utilizan las estrucuturas de datos como son las colas
	 */
	public void dispatchCall(ParametrosLlamada parametrosLlamada) {
		try {
    		logger.info("Llamada Entrante... " + parametrosLlamada.getDetalles());
    		this.parametrosLlamadas.put(parametrosLlamada);

		} catch (Exception e) {
			logger.error("Throwed Exception [DispatcherImpl.dispatchCall]: " +e.getMessage());
		}		
	}

	/* 
	 * Aqui se adicional los empleados que estan libres para atender las llamadas
	 */
	public void adicionar(Empleado empleado) {
		this.trabajadorLibre.add(empleado);
		
	}
	
	/**
	 * Gets the trabajador libre.
	 *
	 * @return the trabajador libre
	 */
	public Queue<Empleado> getTrabajadorLibre() {
		return trabajadorLibre;
	}

	/**
	 * Gets the parametros llamadas.
	 *
	 * @return the parametros llamadas
	 */
	public Queue<ParametrosLlamada> getParametrosLlamadas() {
		return parametrosLlamadas;
	}
	
	/* 
	 * Aqui se lanza el hilo estendiendo de la clase Thread, se inicia la y espera a que un trabajador lo atienda
	 */
	public void run(){
		ParametrosLlamada parametrosLlamada;
		Empleado Empleado;
		try {
			while (true) {
				parametrosLlamada=parametrosLlamadas.take();
				logger.info("Proceso de llamada Iniciando " + parametrosLlamada.getDetalles());
				Empleado=trabajadorLibre.take();
				logger.info(" El trabajador  " + Empleado.getNombre() + " te va atender la llamada " + parametrosLlamada.getDetalles());
                Empleado.responderSolicitud(parametrosLlamada);
			}
			
		} catch (Exception e) {
			logger.error("Throwed Exception [DispatcherImpl.run]: " +e.getMessage());
		}
	}

}
