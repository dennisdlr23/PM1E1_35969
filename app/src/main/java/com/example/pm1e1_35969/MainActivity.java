package com.example.pm1e1_35969;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm1e1_35969.Acciones.Registro;
import com.example.pm1e1_35969.Acciones.SQLiteConexion;

public class MainActivity extends AppCompatActivity {

    Button btnagregar, btnConsulta;
    EditText txtnombres, txtapellidos, txtedad, txtcorreo, txtdireccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregar();

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Agregarpersona(); }
        });

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),ConsultaPersona.class);
                startActivity(intent);

            }
        });
    }
    private void agregar()
    {
        txtnombres = (EditText) findViewById(R.id.txtnombres);
        txtapellidos = (EditText) findViewById(R.id.txtapellidos);
        txtedad = (EditText) findViewById(R.id.txtedad);
        txtcorreo = (EditText) findViewById(R.id.txtcorreo);
        txtdireccion = (EditText) findViewById(R.id.txtdireccion);

        btnagregar = (Button) findViewById(R.id.btnagregar);
        btnConsulta = (Button) findViewById(R.id.btnConsulta);
    }
    private void Agregarpersona()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Registro.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Registro.nombres, txtnombres.getText().toString());
        valores.put(Registro.apellidos, txtapellidos.getText().toString());
        valores.put(Registro.edad, txtedad.getText().toString());
        valores.put(Registro.correo, txtcorreo.getText().toString());
        valores.put(Registro.direccion, txtdireccion.getText().toString());

        Long resultado = db.insert(Registro.tablaUsuarios, Registro.id, valores);

        Toast.makeText(getApplicationContext(), "Registro Ingresado", Toast.LENGTH_LONG).show();

        db.close();

        ClearScreen();
    }
    private void ClearScreen()
    {
        txtnombres.setText("");
        txtapellidos.setText("");
        txtedad.setText("");
        txtcorreo.setText("");
        txtdireccion.setText("");
    }
}