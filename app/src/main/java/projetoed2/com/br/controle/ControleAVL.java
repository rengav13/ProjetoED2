package projetoed2.com.br.controle;

import java.util.LinkedList;

import projetoed2.com.br.estruturadedados.ArvoreAVL;
import projetoed2.com.br.model.Contato;
import projetoed2.com.br.model.Node;

/**
 * Created by Vagner on 12/02/2016.
 */
public class ControleAVL {

    private ArvoreAVL contatosAVL = new ArvoreAVL();

    public Contato pesquisar(int chave){
        return contatosAVL.buscarNode(chave).getValor();
    }

    public void insere(Contato contato){
        contatosAVL.inserirNode(contato);
    }

    public void remover(int chave){
        contatosAVL.removerNode(chave);
    }

    private void geraAVL(LinkedList<Contato> lista){
        //TODO implementar inicialização da AVL
    }
    /*
    private String geraString(LinkedList<Contato> lista){
        //TODO implementar geração de String para escrever
    }

    private Contato geraContato(LinkedList<String> lista){
        //TODO implementar gerar Contato para utilizar na arvore
    }
    */

    public void write(LinkedList<String> lista){
        //TODO implementar escrita em arquivo
    }

    public LinkedList<String> read(){
        //TODO implementar leitura de arquivo
    }





    public ArvoreAVL getContatosAVL() {
        return contatosAVL;
    }
    public void setContatosAVL(ArvoreAVL contatosAVL) {
        this.contatosAVL = contatosAVL;
    }
}
