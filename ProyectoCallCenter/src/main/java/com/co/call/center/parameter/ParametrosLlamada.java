package com.co.call.center.parameter;

import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametrosLlamada.
 */
public class ParametrosLlamada {

	/** The periodo tiempo. */
	private int periodoTiempo;
	
	/** The Detalles. */
	private String Detalles;
	
	/** The rdn. */
	private Random rdn;
	
	/** The Constant Maxima_Duracion. */
	public static final int Maxima_Duracion = 10;
	
	/** The Constant Minima_Duracion. */
	public static final int Minima_Duracion = 5;

	/**
	 * Instantiates a new parametros llamada.
	 */
	public ParametrosLlamada() {

	}

	/**
	 * Instantiates a new parametros llamada.
	 *
	 * @param Detalles the detalles
	 */
	public ParametrosLlamada(String Detalles) {
		this.Detalles = Detalles;
		rdn = new Random();
		periodoTiempo = rdn.nextInt(Maxima_Duracion - Minima_Duracion + 1)
				+ Minima_Duracion;
	}
	
	/**
	 * Gets the periodo tiempo.
	 *
	 * @return the periodo tiempo
	 */
	public int getPeriodoTiempo() {
		return periodoTiempo;
	}

	/**
	 * Sets the periodo tiempo.
	 *
	 * @param periodoTiempo the new periodo tiempo
	 */
	public void setPeriodoTiempo(int periodoTiempo) {
		this.periodoTiempo = periodoTiempo;
	}

	/**
	 * Gets the detalles.
	 *
	 * @return the detalles
	 */
	public String getDetalles() {
		return Detalles;
	}

	/**
	 * Sets the detalles.
	 *
	 * @param detalles the new detalles
	 */
	public void setDetalles(String detalles) {
		Detalles = detalles;
	}
}
