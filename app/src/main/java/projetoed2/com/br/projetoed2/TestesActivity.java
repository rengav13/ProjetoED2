package projetoed2.com.br.projetoed2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import projetoed2.com.br.arquivo.Arquivo;
import projetoed2.com.br.controle.ControleAVL;
import projetoed2.com.br.model.Contato;

public class TestesActivity extends AppCompatActivity {

    private TextView txtSalvar;
    private TextView txtLer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_testes);
            txtSalvar = (TextView) findViewById(R.id.edtSalvar);
            txtLer = (TextView) findViewById(R.id.edtLer);
        }
        catch (Exception e)
        {
            Mensagem("Erro : " + e.getMessage());
        }
    }
    private void Mensagem(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void click_Salvar(View v){
        Arquivo arquivo = new Arquivo();
        try {
            arquivo.writeFile(txtSalvar.getText().toString());
        } catch (IOException e) {
            Mensagem("Erro : " + e.getMessage());
        }
    }

    public void click_Carregar(View v)  {
        ControleAVL controleAVL = null;
        try {
            controleAVL = new ControleAVL();
        } catch (IOException e) {
            Mensagem("Falha ao abrir o arquivo");
        }
        try {
            controleAVL.geraAVL();
        } catch (IOException e) {
            Mensagem("Falha ao abrir o arquivo");
        }
        String texto = txtSalvar.getText().toString();
        int chave = Integer.parseInt(texto);
        if(controleAVL.pesquisar(chave) == null){
            txtLer.setText("Arquivo nao esta na arvore");
        }else {
            txtLer.setText(controleAVL.pesquisar(chave).toString());
        }
    }
}

