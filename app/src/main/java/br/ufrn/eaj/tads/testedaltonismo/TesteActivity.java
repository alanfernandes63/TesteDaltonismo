package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TesteActivity extends AppCompatActivity {
    int botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        ImageView img = findViewById(R.id.imageView);

        Bundle param = getIntent().getExtras();
        int indice = param.getInt("botao");
        botao = indice;
        if(indice == 1){
            img.setImageDrawable(getResources().getDrawable(R.drawable.teste1));
        }
        else if(indice == 2){
            img.setImageDrawable(getResources().getDrawable(R.drawable.teste2));
        }
        else if(indice == 3){
            img.setImageDrawable(getResources().getDrawable(R.drawable.teste3));
        }
    }

    public void ok(View v){
        EditText texto = findViewById(R.id.editText);
        Intent i = new Intent();
        Bundle param = new Bundle();

        param.putString("valor",texto.getText().toString());
        if (texto.getText().toString().equals("")) {
            Toast.makeText(this, "Insira um valor!", Toast.LENGTH_SHORT).show();
        }else {
            param.putInt("botao",botao);
            param.putString("valor",texto.getText().toString());
            i.putExtras(param);
            setResult(1, i);
            finish();
        }
    }

    public  void cancelar(View view){
        setResult(RESULT_CANCELED);
        finish();

    }

}
