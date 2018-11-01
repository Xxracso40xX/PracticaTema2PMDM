package com.studium.xxracso40xx.practicatema2pmdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Button boton;
    private TextView txtv;
    private EditText edit1;
    private EditText edit2;
    private EditText edit3;
    private String cadena;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioGroup grupo;
    private String cadena2;
    private String cadena3;
    private Switch sw;
    private Button boton2;
    private String cadena4="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.spinner1);
        boton = (Button) findViewById(R.id.button);
        txtv = (TextView) findViewById(R.id.textView1);
        edit1= (EditText) findViewById(R.id.editText1);
        edit2= (EditText) findViewById(R.id.editText2);
        edit3= (EditText) findViewById(R.id.editText3);
        radio1= (RadioButton) findViewById(R.id.radioButton1);
        radio2=(RadioButton) findViewById(R.id.radioButton2);
        sw = (Switch) findViewById(R.id.switch1);
        grupo= (RadioGroup) findViewById(R.id.radioGroupp);
        boton2 = (Button) findViewById(R.id.button2);
        //Creación de un ArrayList en el cual se encontrarán todos los Strings deseados.
        ArrayList<String> elementos = new ArrayList<String>();
        elementos.add(getResources().getString(R.string.casado));
        elementos.add(getResources().getString(R.string.separado));
        elementos.add(getResources().getString(R.string.viudo));
        elementos.add(getResources().getString(R.string.otro));
        ArrayAdapter adpt = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, elementos);
        spinner1.setAdapter(adpt);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Conseguir elemento seleccionado del array, siendo elemento el string que está seleccionado actualmente del string
                String elemento = (String) spinner1.getAdapter().getItem(position);
                cadena=elemento;
                //Mostrar texto que diga que elementos hemos seleccionado del array
                Toast.makeText(MainActivity.this, getResources().getString(R.string.seleccionaste) + elemento, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Pongamos un genero como predeterminado
        radio1.setChecked(true);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edit1.getText().toString().isEmpty() && !edit2.getText().toString().isEmpty() && !edit3.getText().toString().isEmpty()) {
                    edit1.setHintTextColor(getResources().getColor(R.color.gris));
                    edit2.setHintTextColor(getResources().getColor(R.color.gris));
                    edit3.setHintTextColor(getResources().getColor(R.color.gris));
                    txtv.setTextColor(getResources().getColor(R.color.gris));
                    if (radio1.isChecked()) {
                        //cadena2 = "hombre";
                        cadena2 = getResources().getString(R.string.hombre);
                    } else if (radio2.isChecked()) {
                        cadena2 = getResources().getString(R.string.mujer);
                    }
                    //SEGUIR HACIENDO COMO LAS DE ARRIBA CON TODOS LOS STRINGS BORRAR ESTO DESPUÉS
                    if (sw.isChecked()) {
                        cadena3 = getResources().getString(R.string.si_hijos);
                    } else {
                        cadena3 = getResources().getString(R.string.no_hijos);
                    }
                    int num1 = Integer.parseInt(edit3.getText().toString());
                    System.out.println(num1);
                    if (num1 >= 18) {
                        txtv.setText(edit2.getText().toString() + ", " + edit1.getText().toString() + ", " + getResources().getString(R.string.mayor_edad) + ", " + cadena2 + ", " + cadena + " " + getResources().getString(R.string.y) + " " + cadena3);
                    } else if (num1 < 18) {
                        txtv.setText(edit2.getText().toString() + ", " + edit1.getText().toString() + ", " + getResources().getString(R.string.menor_edad) + ", " + cadena2 + ", " + cadena + " " + getResources().getString(R.string.y) + " " + cadena3);
                    }
                } else {
                    if (edit1.getText().toString().isEmpty()) {
                        cadena4 = getResources().getString(R.string.nombre_no) + ", ";
                        //edit1.setHint(getResources().getString(R.string.nombre_no));
                        //edit1.setHintTextColor(getResources().getColor(R.color.rojo));
                    }
                    if (edit2.getText().toString().isEmpty()) {
                        cadena4 = cadena4 + getResources().getString(R.string.apellido_no) + ", ";
                        //edit2.setHint(getResources().getString(R.string.apellido_no));
                        //edit2.setHintTextColor(getResources().getColor(R.color.rojo));
                    }
                    if (edit3.getText().toString().isEmpty()) {
                        cadena4 = cadena4 + getResources().getString(R.string.edad_no) + ".";
                        //edit3.setHint(getResources().getString(R.string.edad_no));
                        //edit3.setHintTextColor(getResources().getColor(R.color.rojo));
                    }
                    /*
                    if (grupo.getCheckedRadioButtonId() == -1) {
                        cadena4 = cadena4 + getResources().getString(R.string.genero);
                        //txtv.setText(getResources().getString(R.string.genero));
                    }
                    */
                    txtv.setTextColor(getResources().getColor(R.color.rojo));
                    txtv.setText(cadena4);
                    cadena4 = "";
                }
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                edit1.setText("");
                edit2.setText("");
                edit3.setText("");
                txtv.setText("");
                radio1.setChecked(false);
                radio2.setChecked(false);
            }
        });
    }
}
