package projetoed2.com.br.model;

/**
 * Created by Vagner on 12/02/2016.
 */

public class Node {

    private Node esquerda;
    private Node direita;
    private Node pai;
    private Contato valor;
    private String chave;
    private int balanceamento;

    public Node(String chave,Contato valor) {
        this.setEsquerda(this.setDireita(this.setPai(null)));
        this.setBalanceamento(0);
        this.setChave(chave);
        this.valor = valor;
    }

    public void setValor(Contato valor) {
        this.valor = valor;
    }
    public Contato getValor() {
        return valor;
    }
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public Node getPai() {
        return pai;
    }

    public Node setPai(Node pai) {
        this.pai = pai;
        return pai;
    }

    public Node getDireita() {
        return direita;
    }

    public Node setDireita(Node direita) {
        this.direita = direita;
        return direita;
    }
    public Node getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    @Override
    public String toString() {
        if (this.direita == null && this.esquerda != null) {
            return this.chave +" FE:[" + this.esquerda + "]"+" FD:[null]" ;
        } else if (this.direita != null && this.esquerda == null) {
            return this.chave + " FE:[null]"+" FD:[" + this.direita + "]";
        } else if (this.direita == null && this.esquerda == null) {
            return this.chave + " FE:[null]" + " FD:[null]";
        } else {
            return this.chave + " FE:["+this.esquerda + "]"+" FD:[" + this.direita + "]";
        }
    }
}
