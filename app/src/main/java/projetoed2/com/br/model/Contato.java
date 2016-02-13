package projetoed2.com.br.model;

import java.util.Comparator;

/**
 * Created by Vagner on 12/02/2016.
 */
public class Contato implements Comparable<Contato> {

    private int id;
    private String nome;
    private int telefone;
    private int celular;
    private String email;

    public Contato(){
        super();
    }
    public Contato(int id,String nome,int telefone,int celular,String email){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    public int getTelefone(){
        return this.telefone;
    }
    public void setCelular(int celular){
        this.celular = celular;
    }
    public int getCelular() {
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
        if(this.nome.compareTo(another.getNome()) == -1){
            return -1;
        }else if(this.nome.compareTo(another.getNome()) == 1){
            return 1;
        }else{
            return  0;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.id+"\n");
        builder.append(this.nome+"\n");
        builder.append(telefone+"\n");
        builder.append(this.celular+"\n");
        builder.append(this.email+"\n");
        builder.append("\n");
        return builder.toString();
    }
}
