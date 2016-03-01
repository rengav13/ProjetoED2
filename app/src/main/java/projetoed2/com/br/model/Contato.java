package projetoed2.com.br.model;

import java.util.Comparator;

/**
 * Created by Vagner on 12/02/2016.
 */
public class Contato implements Comparable<Contato> {

    private String nome;
    private String telefone;
    private String celular;
    private String email;

    public Contato(){
        super();
    }

    public Contato(String nome,String telefone,String celular,String email){
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }
    public String getCelular() {
        return this.celular;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    @Override
    public int compareTo(Contato another) {
       return this.nome.compareTo(another.getNome());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.nome+"\n");
        builder.append(this.telefone+"\n");
        builder.append(this.celular+"\n");
        builder.append(this.email+"\n");
        builder.append("\n");
        return builder.toString();
    }
}
