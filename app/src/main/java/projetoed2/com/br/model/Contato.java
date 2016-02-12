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
}
