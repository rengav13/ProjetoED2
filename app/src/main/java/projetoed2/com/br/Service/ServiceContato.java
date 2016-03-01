package projetoed2.com.br.Service;

import java.io.IOException;
import java.util.LinkedList;

import projetoed2.com.br.controle.ControleAVL;
import projetoed2.com.br.estruturadedados.Ordenacao;
import projetoed2.com.br.model.Contato;

/**
 * Created by Vagner on 27/02/2016.
 *
 * @Class: serve como interface da view com a parte mais baixo nivel do software
 */
public class ServiceContato {
    private ControleAVL controleAVL;
    private LinkedList<Contato> contatos;

    /**
     * @throws IOException
     */
    public ServiceContato() throws IOException {
        this.controleAVL = new ControleAVL();
        this.contatos = controleAVL.geraContatos();
    }

    public LinkedList<Contato> getContatos() {
        return contatos;
    }

    public ControleAVL getControleAVL() {
        return controleAVL;
    }

    public void addContato(Contato contato) throws IOException {
       if(controleAVL.pesquisar(contato.getNome()) == null){
           controleAVL.insere(contato);
           contatos.add(contato);
           controleAVL.write(contatos);
       }else{
           // Faça alguma coisa
       }
    }

    public void removerContato(Contato contato) throws IOException {
        contatos.remove(contato);
        controleAVL.remover(contato.getNome());
        controleAVL.write(contatos);
    }

    /** Tive que fazer uma gambiarra aqui pois nosso id é o nome e mudando o nome ele continuaria deixando armazenado o valor antigo
     * por isso remover ele antes de atualizar
     *
     * @param contatoAnterior
     * @param novoContato
     * @throws IOException
     */
    public void updateContato(Contato contatoAnterior, Contato novoContato) throws IOException {
        controleAVL.remover(contatoAnterior.getNome());
        controleAVL.insere(novoContato);
        contatos.remove(contatoAnterior);
        contatos.add(novoContato);

        controleAVL.write(contatos);
    }

    public Contato pesquisaContato(String nome){
        return controleAVL.pesquisar(nome);
    }

}
