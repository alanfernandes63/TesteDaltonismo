package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        startActivityForResult(i,15);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);

        Log.i("teste","ttt");
        if(data != null) {
            Bundle b = data.getExtras();
            int bt = b.getInt("botao");
            if (requestCode != RESULT_CANCELED) {
                if (b.getInt("botao") == 1) {
                    TextView texto = findViewById(R.id.textView5);
                    texto.setText(b.getString("valor"));
                } else if (b.getInt("botao") == 2) {
                    TextView texto = findViewById(R.id.textView6);
                    texto.setText(b.getString("valor"));
                } else if (b.getInt("botao") == 3) {
                    TextView texto = findViewById(R.id.textView7);
                    texto.setText(b.getString("valor"));
                }
            }
        }

    }

    public void verificar(View v){
        TextView t1 = findViewById(R.id.textView5);
        TextView t2 = findViewById(R.id.textView6);
        TextView t3 = findViewById(R.id.textView7);
        TextView resposta = findViewById(R.id.textView8);
        if(t1.getText().toString().equals("") || t2.getText().toString().equals("")||t3.getText().toString().equals("")){
            Toast.makeText(this, "Campos faltando preencher", Toast.LENGTH_SHORT).show();
        }
        else{
            if(t1.getText().toString().equals("2") && t2.getText().toString().equals("29") || t3.getText().toString().equals("74")){
                resposta.setText("Voce não é daltonico");
            }
            else
                resposta.setText("Procure um especialista");
        }
    }
}
