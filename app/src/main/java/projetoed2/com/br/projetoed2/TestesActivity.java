package projetoed2.com.br.projetoed2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import projetoed2.com.br.Service.ServiceContato;
import projetoed2.com.br.arquivo.Arquivo;
import projetoed2.com.br.model.Contato;

public class TestesActivity extends AppCompatActivity {

    private TextView txtSalvar;
    private TextView txtLer;
    private ServiceContato serviceContato = null;

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

    }

    public void click_Carregar(View v) {
        try {
            serviceContato = new ServiceContato();
        } catch (IOException e) {
            Mensagem("Falha ao abrir o arquivo");
        }
        Contato contato = new Contato(" 12","2323","324","vagnerbas");
        try {
            serviceContato.removerContato(contato);
        } catch (IOException e) {
            Mensagem("Eror ao remover contato");
        }

        if(serviceContato.pesquisaContato(" 12") == null){
            txtLer.setText("Arquivo nao esta na arvore 1");
        }else {
            txtLer.setText(serviceContato.getContatos().toString());
        }
        if(!serviceContato.getContatos().contains(contato)){
            for(int i=0;i<serviceContato.getContatos().size();i++){
                txtLer.append(serviceContato.getContatos().get(i).toString());
            }
            txtLer.setText("nao achou :"+serviceContato.getContatos().toString());
        }else {
            txtLer.setText(serviceContato.getContatos().toString());
        }
    }
}

