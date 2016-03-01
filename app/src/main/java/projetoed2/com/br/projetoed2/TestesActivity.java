package projetoed2.com.br.projetoed2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import projetoed2.com.br.Service.ServiceContato;
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

    public void click_Carregar(View v) {
        ServiceContato serviceContato = null;
        try {
            serviceContato = new ServiceContato();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Contato contato = new Contato(txtSalvar.getText().toString(),"123","123",txtSalvar.getText().toString()+"@gmail.com");

        try {
            serviceContato.addContato(contato);
        } catch (IOException e) {
            e.printStackTrace();
        }
        txtLer.setText("pesquisar:? ");
        txtLer.append("\n Arvore \n" + serviceContato.getControleAVL().getContatosAVL().getRaiz().toString());
        txtLer.append(" \n Lista \n" + serviceContato.getContatos().toString().toString());

    }
}

