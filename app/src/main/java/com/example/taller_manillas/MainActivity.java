package com.example.taller_manillas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private Spinner c_material, c_dije, c_tipo, c_moneda;
    private TextView respuesta;
    private static  int dolar = 3200;
    private static int[][] tabla = new int[][] {
            new int[]{0, 0, 0, 100}, new int[]{0, 0, 1, 100}, new int[]{0, 0, 2, 80}, new int[]{0, 0, 3, 70},
            new int[]{0, 0, 1, 120}, new int[]{0, 1, 1, 120}, new int[]{0, 1, 2, 100}, new int[]{0, 1, 3, 90},
            new int[]{1, 0, 0, 90}, new int[]{1, 0, 1, 90}, new int[]{1, 0, 2, 70}, new int[]{1, 0, 3, 50},
            new int[]{1, 0, 1, 110}, new int[]{1, 1, 1, 110}, new int[]{1, 1, 2, 90}, new int[]{1, 1, 3, 80},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.c_material = findViewById(R.id.opciones_material);
        this.c_dije = findViewById(R.id.opciones_dije);
        this.c_tipo = findViewById(R.id.opciones_tipo);
        this.c_moneda = findViewById(R.id.opciones_moneda);
        this.respuesta = findViewById(R.id.respuesta);

        String[] a_material = getResources().getStringArray(R.array.opciones_material);
        String[] a_dije = getResources().getStringArray(R.array.opciones_dije);
        String[] a_tipo = getResources().getStringArray(R.array.opciones_tipo);
        String[] a_moneda = getResources().getStringArray(R.array.opciones_moneda);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, a_material);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, a_dije);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, a_tipo);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>( this, android.R.layout.simple_spinner_item, a_moneda);

        this.c_material.setAdapter(adapter1);
        this.c_dije.setAdapter(adapter2);
        this.c_tipo.setAdapter(adapter3);
        this.c_moneda.setAdapter(adapter4);

    }

    public  void calcular(View v){

        int i_m = this.c_material.getSelectedItemPosition();
        int i_d = this.c_dije.getSelectedItemPosition();
        int i_t = this.c_tipo.getSelectedItemPosition();
        int i_md = this.c_moneda.getSelectedItemPosition();

        int valor = this.findValor(i_m, i_d, i_t);

        switch (i_md){
            case 0:
                this.respuesta.setText( "$ " + (valor*dolar) );
                break;
            case 1:
                this.respuesta.setText( "$USD " + valor );
                break;
        }

    }

    public int  findValor(int x, int y, int z){

        for (int i=0; i< this.tabla.length; i++ ){
            if( this.tabla[i][0]==x && this.tabla[i][1]==y && this.tabla[i][2]==z ){
                return this.tabla[i][3];
            }
        }

        return 0;
    }

    public void limpiar(View v){
        this.respuesta.setText( "" );
    }

}
