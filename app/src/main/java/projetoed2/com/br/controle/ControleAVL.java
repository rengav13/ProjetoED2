package projetoed2.com.br.controle;

import android.util.Log;

import java.io.IOException;
import java.util.LinkedList;

import projetoed2.com.br.arquivo.Arquivo;
import projetoed2.com.br.estruturadedados.ArvoreAVL;
import projetoed2.com.br.estruturadedados.Ordenacao;
import projetoed2.com.br.model.Contato;

/**
 * Created by Vagner on 12/02/2016.
 */
public class ControleAVL {

    private Arquivo arquivo = new Arquivo();
    private Ordenacao ordenacao = new Ordenacao();
    private ArvoreAVL contatosAVL = new ArvoreAVL();

    public ControleAVL() throws IOException {
            this.geraAVL();
    }

    private void geraAVL() throws IOException {
        LinkedList<Contato> listaContatos = this.geraContatos();

        for(int i=0;i<listaContatos.size();i++){
            contatosAVL.inserirNode(listaContatos.get(i));
        }
    }

    /**
     *
     * Caso não encontre contato retorna null
     *
     * @param chave do tipo string
     * @return Contato
     *
     */
    public Contato pesquisar(String chave){
        if(contatosAVL.buscarNode(chave) == null){
            return null;
        }else{
            return contatosAVL.buscarNode(chave).getValor();
        }
    }

    public void insere(Contato contato){
        contatosAVL.inserirNode(contato);
    }

    public void remover(String chave){
        contatosAVL.removerNode(chave);
    }

    public LinkedList<Contato> geraContatos() throws IOException {
        LinkedList<String> lista = this.read();
       return this.geraContatos(lista);
    }
    private LinkedList<String> read() throws IOException {
        return arquivo.readFile();
    }

    /*
     * Logica para decodificação dos dados no arquivo:
     *  Nome --> Telefone --> Celular --> email --> "\n"
     */
    private LinkedList<Contato> geraContatos(LinkedList<String> lista) {
        int tamanho = lista.size()/5;
        if(!lista.isEmpty()) {
            LinkedList<Contato> listaContatos = new LinkedList<>();
            for (int i = 0; i < tamanho; i++) {
                String nome = lista.get(5 * i);
                String telefone = lista.get(5 * i + 1);
                String celular = lista.get(5 * i + 2);
                String email = lista.get(5 * i + 3);
                // O lista.get(5*i+4) é um espaço que é desconsiderado

                Contato contato = new Contato(nome,telefone, celular, email);
                listaContatos.add(contato);
            }
            return listaContatos;
        }else{
            return null;
        }
    }

    public void write(LinkedList<Contato> contatos) throws IOException {
        String texto = this.geraString(contatos);
        arquivo.writeFile(texto);
    }

    private String geraString(LinkedList<Contato> lista){
        ordenacao.shellSort(lista);
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<lista.size();i++){
            Contato contato = lista.get(i);
            String strContato = contato.toString();
            builder.append(strContato);
        }
        return builder.toString();
    }

    public ArvoreAVL getContatosAVL() {
        return contatosAVL;
    }
}
