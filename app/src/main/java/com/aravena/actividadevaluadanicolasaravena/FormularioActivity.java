package com.aravena.actividadevaluadanicolasaravena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.aravena.actividadevaluadanicolasaravena.adapters.RecetaAdapter;
import com.aravena.actividadevaluadanicolasaravena.models.Receta;

import java.util.ArrayList;
import java.util.List;

public class FormularioActivity extends AppCompatActivity {
    public static ArrayList<Receta> recetasList = new ArrayList<>();
    //widgets
    EditText txtNombreReceta;
    RadioGroup rdbtnIngP;
    RadioGroup rdbtnBase;
    CheckBox cbCebolla, cbChampinon,
    cbMorron,
     cbTomate,
    cbTomateCherry,
     cbPalta,
    cbAjo,
     cbAlbaca,
     cbOregano;

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        //Referencias
        txtNombreReceta = findViewById(R.id.txtNombreReceta);
        rdbtnIngP = findViewById(R.id.rdbtnIngP);
        rdbtnBase = findViewById(R.id.rdbtnBase);

       cbCebolla = findViewById(R.id.cbCebolla);
        cbChampinon = findViewById(R.id.cbChampinon);
        cbMorron = findViewById(R.id.cbMorron);
        cbTomate = findViewById(R.id.cbTomate);
        cbTomateCherry = findViewById(R.id.cbTomateCherry);
        cbPalta = findViewById(R.id.cbPalta);
        cbAjo = findViewById(R.id.cbAjo);
        cbAlbaca = findViewById(R.id.cbAlbaca);
        cbOregano = findViewById(R.id.cbOregano);




        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total = 0.0;

                int id1 = rdbtnIngP.getCheckedRadioButtonId();
                RadioButton rb1 = findViewById(id1);



                int id2 = rdbtnBase.getCheckedRadioButtonId();
                RadioButton rb2 = findViewById(id2);



                String nombre = txtNombreReceta.getText().toString();




                if (nombre.equals("")) {
                    Toast.makeText(getApplicationContext(), "No ingresaste un nombre de receta", Toast.LENGTH_SHORT).show();

                }else{

                    if (rb1 == null)
                    {
                        // ninguno se selecciono
                        Toast.makeText(getApplicationContext(),"Seleccione un ingrediente principal", Toast.LENGTH_SHORT).show();

                    }else{
                        String rbb1 = rb1.getText().toString();
                        if (rbb1.equals("Carne" )||rbb1.equals("Pollo")){
                            total += 1500;
                        }else{
                            total +=2000;
                        }

                        if (rb2 == null)
                        {
                            // Ninguno se selecciono
                            Toast.makeText(getApplicationContext(),"Seleccione una base para la pizza", Toast.LENGTH_SHORT).show();

                        }else{
                            String rbb2 = rb2.getText().toString();
                            total +=500;
                            List<String> listaIngredientes = new ArrayList<>();
                            if (cbCebolla.isChecked() || cbChampinon.isChecked() || cbMorron.isChecked() || cbTomate.isChecked() || cbTomateCherry.isChecked() || cbPalta.isChecked()){
                                if (cbCebolla.isChecked()){
                                    listaIngredientes.add(cbCebolla.getText().toString());
                                    total+=1000;
                                }
                                if (cbChampinon.isChecked()){
                                    listaIngredientes.add(cbChampinon.getText().toString());
                                    total+=1000;
                                }
                                if (cbMorron.isChecked()){
                                    listaIngredientes.add(cbMorron.getText().toString());
                                    total+=1000;
                                }
                                if (cbTomate.isChecked()){
                                    listaIngredientes.add(cbTomate.getText().toString());
                                    total+=1000;
                                }
                                if (cbTomateCherry.isChecked()){
                                    listaIngredientes.add(cbTomateCherry.getText().toString());
                                    total+=1000;
                                }
                                if (cbPalta.isChecked()){
                                    listaIngredientes.add(cbPalta.getText().toString());
                                    total+=1000;
                                }
                                if ( cbAjo.isChecked() || cbAlbaca.isChecked() || cbOregano.isChecked()){
                                    String[] arrayIng = new String[listaIngredientes.size()];
                                    arrayIng = listaIngredientes.toArray(arrayIng);

                                    List<String> listaAlinos = new ArrayList<>();
                                    if (cbAjo.isChecked()){
                                        listaAlinos.add(cbAjo.getText().toString());
                                        total+=500;
                                    }
                                    if (cbAlbaca.isChecked()){
                                        listaAlinos.add(cbAlbaca.getText().toString());
                                        total+=500;
                                    }
                                    if (cbOregano.isChecked()){
                                        listaAlinos.add(cbOregano.getText().toString());
                                        total+=500;
                                    }

                                    String[] arrayAlino = new String[listaAlinos.size()];
                                    arrayAlino =  listaAlinos.toArray(arrayAlino);

                                    Receta receta = new Receta(nombre,rbb1,rbb2,arrayIng,arrayAlino,total);
                                    recetasList.add(receta);
                                    Toast.makeText(getApplicationContext(),"Se ha agregado tu receta", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getApplicationContext(),"Seleccione al menos 1 Aliño", Toast.LENGTH_SHORT).show();
                                }


                            }else {
                                Toast.makeText(getApplicationContext(),"Seleccione al menos 1 ingrediente", Toast.LENGTH_SHORT).show();
                            }



                        }

                    }
                }







            }
        });


    }

    public void openMain(View view) {
        Intent intent = new Intent(FormularioActivity.this, MainActivity.class);
        startActivity(intent);
    }



}