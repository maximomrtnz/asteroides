package org.example.asteroides;

import java.util.Vector;

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones{
	
	private Vector<String> puntuaciones;
	
	public AlmacenPuntuacionesArray() {

        this.puntuaciones= new Vector<String>();

        this.puntuaciones.add("123000 Pepito Domingez");

        this.puntuaciones.add("111000 Pedro Martinez");

        this.puntuaciones.add("011000 Paco Pérez");

	}
	
	@Override
	public void guardarPuntuacion(int puntos, String nombre, long fecha) {
		// TODO Auto-generated method stub
		puntuaciones.add(0, puntos + " "+ nombre);
	}

	@Override
	public Vector<String> listaPuntuaciones(int cantidad) {
		// TODO Auto-generated method stub
		return this.puntuaciones;
	}
	
	
	

}
