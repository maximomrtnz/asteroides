package org.example.asteroides;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Asteroides extends Activity {
	
	private Button botonAcercaDe;
	private Button botonPreferencias;
	private Button botonPuntuaciones;
	private Button botonSalir;
	
	public static AlmacenPuntuaciones almacen= new AlmacenPuntuacionesArray();	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		this.botonAcercaDe = (Button)findViewById(R.id.boton_acerca_de);
		this.botonPreferencias = (Button)findViewById(R.id.boton_configurar);
		this.botonPuntuaciones = (Button)findViewById(R.id.boton_puntuaciones);
		this.botonSalir = (Button)findViewById(R.id.boton_salir);
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	      super.onCreateOptionsMenu(menu);
	      MenuInflater inflater = getMenuInflater();
	      inflater.inflate(R.menu.menu, menu);
	      return true; /** true -> el menú ya está visible */
		
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
		 
         return true; /** true -> consumimos el item, no se propaga*/
	}
	
	public void lanzarAcercaDe(View view){
	      Intent i = new Intent(this, AcercaDe.class);
	      startActivity(i);
	}
	
	public void lanzarPreferencias(View view){
		Intent i = new Intent(this,Preferencias.class);
		startActivity(i);
	}
	
	public void lanzarPuntuaciones(View view){
		Intent i = new Intent(this, Puntuaciones.class);
		startActivity(i);
	}
	
	public void salir(){
		finish();
	}
	
}
