package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int botao;
    String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle param = new Bundle();
        int botao = param.getInt("botao");
        valor = param.getString("valor");
        resposta();
    }

    public void resposta(){

        Toast.makeText(this, "botao " + botao, Toast.LENGTH_SHORT).show();
        if(botao != 0){
            TextView r1 = findViewById(R.id.textView5);
            TextView r2 = findViewById(R.id.textView6);
            TextView r3 = findViewById(R.id.textView7);
            switch (botao){
                case 1:
                  r1.setText(valor);
            }
        }
    }


    public void view2(View v){
        Intent i = new Intent(this,TesteActivity.class);
        Bundle param = new Bundle();


        if (R.id.button == v.getId()){
            param.putInt("botao",1);
        }
        else if(R.id.button2 == v.getId()){
            param.putInt("botao",2);
        }
        else if(R.id.button3 == v.getId()){
            param.putInt("botao",3);
        }
        i.putExtras(param);

        startActivity(i);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED)
            System.out.print("ada");

    }
}
