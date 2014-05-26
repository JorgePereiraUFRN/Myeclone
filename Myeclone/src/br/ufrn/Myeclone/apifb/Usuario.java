package br.ufrn.Myeclone.apifb;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.restfb.types.Comment;
import com.restfb.types.Post;
import com.restfb.types.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Anthonini
 */
public class Usuario implements  Serializable {
    
    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setTemInfo(boolean b){
        this.temInfo = b;
    }
    
    public boolean temInfo(){
        return this.temInfo;
    }

    public Usuario(String id, String nome, String descricao, String aniversario, String email, String genero, String local) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.aniversario = aniversario;
        this.email = email;
        this.genero = genero;
        this.local = local;
    }
    
    private String id;
    private String nome;
    private String descricao;
    private String aniversario;
    private String email;
    private String genero;
    private String local;
    private String info; 

    private boolean temInfo;
    
    public Usuario(String id, String nome){
        this.id = id;
        this.nome = nome;
        this.temInfo = false;
    }
    
    public String formatar(String s){
	if(s != null){
		return s;
	}
	else{
		return "Sem informacoes";
	}
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public String getAniversaio() {
        return this.aniversario;
    }
    public String getEmail() {
        return this.email;
    }
    public String getGenero() {
        return this.genero;
    }
    public String getLocal() {
        return this.local;
    }
    
    @Override
    public String toString(){
        return this.nome+"\n"+this.aniversario+"\n"+this.id+"\n"+this.info+"\n"+this.local;
    }
}
