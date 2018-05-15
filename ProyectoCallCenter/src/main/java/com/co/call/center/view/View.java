package com.co.call.center.view;

import javax.swing.JOptionPane;

public class View {
	
	  public int conocerDatos(String m) {
	        return Integer.parseInt(JOptionPane.showInputDialog(m));
	    }

	    public void mostrarDatos(String m) {
	        JOptionPane.showMessageDialog(null, m);
	    }

}
