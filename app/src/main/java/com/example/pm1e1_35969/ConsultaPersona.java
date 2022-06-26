package com.example.pm1e1_35969;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm1e1_35969.Acciones.SQLiteConexion;
import com.example.pm1e1_35969.Acciones.Registro;

public class ConsultaPersona extends AppCompatActivity {

    SQLiteConexion conexion;
    EditText id, nombres, apellidos, edad, correo, direccion;
    Button btnconsulta, btneliminar, btnactualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_persona);

        init();

        btnconsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { BuscarPersona(); }
        });
    }
    private void BuscarPersona()
    {
        try
        {
            SQLiteDatabase db = conexion.getWritableDatabase();
            /* Parametros de BUSQUEDA de la sentencia SELECT*/
            String [] params = {id.getText().toString()};

            /* Campos a retornar  de la sentencia SELECT*/
            String [] fields = { Registro.nombres,
                    Registro.apellidos,
                    Registro.edad,
                    Registro.correo,
                    Registro.direccion};

            String WhereCondition = Registro.id + "=?";

            Cursor cdata = db.query(Registro.tablaUsuarios,
                    fields,
                    WhereCondition,params,null,null,null);

            cdata.moveToFirst();

            if(cdata.getCount() > 0 )
            {
                nombres.setText(cdata.getString(0));
                apellidos.setText(cdata.getString(1));
                edad.setText(cdata.getString(2));
                correo.setText(cdata.getString(3));
                direccion.setText(cdata.getString(4));


                Toast.makeText(getApplicationContext(),"Consultado con exito !!",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No hay datos !!",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(getApplicationContext(),"ha ocurrido un inconveniente !!",Toast.LENGTH_LONG).show();
        }


    }

    private void Eliminar()
    {


    }

    private void init()
    {
        conexion = new SQLiteConexion(this, Registro.NameDataBase, null, 1);

        btnconsulta = (Button) findViewById(R.id.btnbuscar);
        btneliminar = (Button) findViewById(R.id.btneliminar);
        btnactualizar = (Button) findViewById(R.id.btnactualizar);

        id = (EditText) findViewById(R.id.txtcid);
        nombres = (EditText) findViewById(R.id.txtcnombres);
        apellidos = (EditText) findViewById(R.id.txtcapellidos);
        edad = (EditText) findViewById(R.id.txtcedad);
        correo = (EditText) findViewById(R.id.txtccorreo);
        direccion = (EditText) findViewById(R.id.txtcdireccion);
    }
}