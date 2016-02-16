package projetoed2.com.br.controle;

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

    public Contato pesquisar(int chave){
        if(contatosAVL.buscarNode(chave) == null){
            return null;
        }else{
            return contatosAVL.buscarNode(chave).getValor();
        }
    }

    public void insere(Contato contato){
        contatosAVL.inserirNode(contato);
    }

    public void remover(int chave){
        contatosAVL.removerNode(chave);
    }

    public void geraAVL() throws IOException {
        LinkedList<String> listaContatosStr = this.read();
        LinkedList<Contato> listaContatos = this.geraContatos(listaContatosStr);

        for(int i=0;i<listaContatos.size();i++){
            contatosAVL.inserirNode(listaContatos.get(i));
        }
    }

    private String geraString(LinkedList<Contato> lista){
        //TODO implementar metodo de ordenação para ordenar a lista antes de gerar a String para escrever no arquivo
        ordenacao.shellSort(lista); // O problema aqui é que o metodo shell recebe um vetor sendo que tem que receber uma lista
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<lista.size();i++){
         Contato contato = lista.get(i);
            String strContato = contato.toString();
            builder.append(strContato);
        }
        return builder.toString();
    }

    /*
     * Logica para decodificação dos dados no arquivo:
     *  id --> Nome --> Telefone --> Celular --> email --> "\n"
     */
    private LinkedList<Contato> geraContatos(LinkedList<String> lista) {
        int tamanho = lista.size()/6;
        if(!lista.isEmpty()) {
            LinkedList<Contato> listaContatos = new LinkedList<>();
            for (int i = 0; i < tamanho; i++) {
                String id = lista.get(6 * i);
                String nome = lista.get(6 * i + 1);
                String telefone = lista.get(6 * i + 2);
                String celular = lista.get(6 * i + 3);
                String email = lista.get(6 * i + 4);
                // O lista.get(6*i+5) é um espaço que é desconsiderado

                Contato contato = new Contato(stringToInt(id), nome, stringToInt(telefone), stringToInt(celular), email);
                listaContatos.add(contato);
            }
            return listaContatos;
        }else{
            return null;
        }
    }

    private int stringToInt(String palavra){
        return Integer.parseInt(palavra);
    }

    public void write(String texto) throws IOException {
        arquivo.writeFile(texto);
    }

    public LinkedList<String> read() throws IOException {
        return arquivo.readFile();
    }

    public ArvoreAVL getContatosAVL() {
        return contatosAVL;
    }

    public void setContatosAVL(ArvoreAVL contatosAVL) {
        this.contatosAVL = contatosAVL;
    }
}
