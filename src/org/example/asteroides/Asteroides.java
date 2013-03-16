package org.example.asteroides;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Asteroides extends Activity {

	private Button botonAcercaDe;
	private Button botonPreferencias;
	private Button botonPuntuaciones;
	private Button botonSalir;
	private Button botonJugar;
	
	private MediaPlayer mp;
	
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		this.botonAcercaDe = (Button) findViewById(R.id.boton_acerca_de);
		this.botonPreferencias = (Button) findViewById(R.id.boton_configurar);
		this.botonPuntuaciones = (Button) findViewById(R.id.boton_puntuaciones);
		this.botonSalir = (Button) findViewById(R.id.boton_salir);
		this.botonJugar = (Button) findViewById(R.id.boton_arrancar);

		this.botonAcercaDe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarAcercaDe(null);
			}
		});

		this.botonPreferencias.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lanzarPreferencias(null);
			}
		});

		this.botonPuntuaciones.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				lanzarPuntuaciones(null);
			}
		});

		this.botonSalir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				salir();
			}
		});

		this.botonJugar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				lanzarJuego(null);
			}
		});
		
		//Add Music
		
		mp = MediaPlayer.create(this, R.raw.space_atmosphere);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
		/** true -> el menú ya está visible */

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.acercaDe:
			lanzarAcercaDe(null);
			break;
		case R.id.config:
			lanzarPreferencias(null);
			break;
		}

		return true;
		/** true -> consumimos el item, no se propaga */
	}

	public void lanzarAcercaDe(View view) {
		Intent i = new Intent(this, AcercaDe.class);
		startActivity(i);
	}

	public void lanzarPreferencias(View view) {
		Intent i = new Intent(this, Preferencias.class);
		startActivity(i);
	}

	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
	}

	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Juego.class);
		startActivity(i);
	}

	public void salir() {
		finish();
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
		//Start Music
		mp.start();
	}

	@Override
	protected void onPause() {
		//mp.pause();
		Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
		super.onPause();
	}

	@Override
	protected void onStop() {
		mp.pause();
		Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
		super.onStop();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}
	
	//Methods to Save State when aplication is kill
	
	@Override
	protected void onSaveInstanceState(Bundle savedState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(savedState);
        if (mp != null) {
            int pos = mp.getCurrentPosition();
            savedState.putInt("posicion", pos);
        }
		
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedState);
		if (savedState != null && mp != null) {
            int pos = savedState.getInt("posicion");
            mp.seekTo(pos);
		}
	}
	

}
