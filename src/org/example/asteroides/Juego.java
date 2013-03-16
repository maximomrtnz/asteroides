package org.example.asteroides;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Juego extends Activity {

	private VistaJuego vistaJuego;
	private MediaPlayer mp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.juego);
		this.vistaJuego = (VistaJuego) findViewById(R.id.VistaJuego);
		
		//Add Music
		mp = MediaPlayer.create(this, R.raw.game);
	}

	@Override
	protected void onPause() {
		super.onPause();
		this.vistaJuego.getThread().pausar();
		//Stop music
		mp.stop();
		
		//Unregister Sensor
		this.vistaJuego.unregisterSensor(getApplicationContext());
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.vistaJuego.getThread().reanudar();
		//Start music
		mp.start();
		
		//Register Sensor
		this.vistaJuego.registerSensor(getApplicationContext());
	}

	@Override
	protected void onDestroy() {
		this.vistaJuego.getThread().detener();
		super.onDestroy();
	}
	
	

}
