package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    //componentes dinamicos:
    TextView txtResultado;
    EditText editNumA, editNumB;
    //variaveis:
    double resultado;
    int calculo;

    //metodo onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //integração entre xml e java
        editNumA = findViewById(R.id.edit_numeroA);
        editNumB = findViewById(R.id.edit_numeroB);
        txtResultado = findViewById(R.id.text_resultado);
        //fim da integração
    }
    //fim do onCreate

    //botao somar
    public void calcSomar (View v) {
        calculo = 0;
        calcTotal (calculo);
        txtResultado.setText("o resultado do calculo foi " + (Double.toString(resultado)));
    }

    //botao subtrair
    public void calcSubtrair (View v) {
        calculo = 1;
        calcTotal (calculo);
        txtResultado.setText("o resultado do calculo foi " + (Double.toString(resultado)));
    }

    //metodo do calculo total
    private double calcTotal (int calculo){

        String numeroA = editNumA.getText().toString();
        String numeroB = editNumB.getText().toString();
        double numA = Double.parseDouble(numeroA);
        double numB = Double.parseDouble(numeroB);

        //será identificado que botao foi apertado atraves da variavel calculo
        switch (calculo) {
            case 0:
                System.out.println ("somando" + numA + "com" + numB);
                resultado = numA + numB;
                break;

            case 1:
                System.out.println ("subtraindo" + numA + "com" + numB);
                resultado = numA - numB;
                break;

        }
        return resultado;
    }
    //fim do metodo calculo

    //integrando menu_main.xml

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.item_compartilhar){
            //intent implicita
            Intent c = new Intent (Intent.ACTION_SEND);
            c.setType ("text/plain");
            c.putExtra (Intent.EXTRA_SUBJECT, "Gasapp");
            c.putExtra (Intent.EXTRA_TEXT, txtResultado.getText());
            startActivity (Intent.createChooser(c, "Compartilhar..."));
        }

        return super.onOptionsItemSelected(item);
    }

}
