package com.example.jogocapital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    //Desenvolvido por: Gustavo Kepka Chandoha - GRR20176925

    String[] arrayEstados = {"Paraná", "São Paulo", "Santa Catarina", "Pernambuco","Rio Grande do Norte","Sergipe","Tocantins","Distrito Federal","Minas Gerais","Goiás","Amazonas","Amapá","Mato Grosso","Pará","Rio de Janeiro"};
    String[] arrayCapital = {"Curitiba", "Sao Paulo", "Florianopolis", "Recife","Natal","Aracaju","Palmas","Brasilia","Belo Horizonte","Goiania","Manaus","Macapa","Cuiaba","Belam","Rio de Janeiro"};

    int tot = 0;
    int z = 0;
    int x = 0;
    boolean valido = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView pontos = findViewById(R.id.textViewPontuacao);
        pontos.setText(String.valueOf("   Pontos \n" + "   " + tot));

        sortea();

    }

    public void sortea(){


        if(z<5)
        {

              valido = true;
              String str;
              TextView estados = findViewById(R.id.textViewEstado);
              x = new Random().nextInt(arrayEstados.length);
                  str = String.valueOf(arrayCapital[x]);
                  estados.setText(String.valueOf(arrayEstados[x]));
                  z++;

        }else{
            valido = true;
            resetarjogo();
        }


    }

    public void resetarjogo(){

        TextView pontos = findViewById(R.id.textViewPontuacao);
        TextView resultado = findViewById(R.id.textViewAcertou);
        z=0;
        int  resultadofinal = tot;
        tot=0;

        pontos.setText(String.valueOf(tot));
        sortea();
        resultado.setText( "\n Você fez um total de: " + String.valueOf(resultadofinal)  + " pontos" + "\nVamos tentar denovo ?");




    }


    public void valida(View view) {


        EditText resposta = findViewById(R.id.editTextResposta);

        TextView estadosshow = findViewById(R.id.textViewEstado);

        TextView resultado = findViewById(R.id.textViewAcertou);

        String repostacomparar  =   Normalizer.normalize(resposta.getText().toString(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        String estadosorteado = arrayCapital[x];


        if(resposta.length() == 0) {

            Toast msg = Toast.makeText(this, "Voce nao digitou nada, caso queira pular clique no PROXIMO", Toast.LENGTH_SHORT);
            msg.show();
            return;
        }
       else if (valido == true) {
                if (arrayCapital[x].equalsIgnoreCase(repostacomparar)) {

                    valido = false;
                    resultado.setText("Acertou");
                    pontuacao(1);


                } else {

                    valido = false;
                    resultado.setText("Errou");
                    pontuacao(0);

                }
            }

        }



    public void pontuacao(int y){

        TextView pontos = findViewById(R.id.textViewPontuacao);


        if(y == 1){

            tot = tot + 10;
            pontos.setText(String.valueOf("   Pontos \n" + "   " + tot));

        }else
        {
            pontos.setText(String.valueOf("   Pontos \n" + "   " + tot));
        }

    }



    public void proximo(View view){


        EditText resposta = findViewById(R.id.editTextResposta);
        resposta.setText("");
        sortea();
        Button botaoproximo;
        botaoproximo = (Button) findViewById((R.id.button2));




    }



}