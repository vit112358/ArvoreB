/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alunos
 */
public class Pessoa {
    
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;
    
    public Pessoa(){
        
    }
    
    public Pessoa(Integer id, String Nome,String end,String tel){
        super();
        this.id=id;
        this.nome=Nome;
        this.endereco=end;
        this.telefone=tel;        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
 
    public int compara (Pessoa it) {
    if (this.id < it.id) {
        return -1;
    }else if (this.id > it.id){
        return 1;
    }
    return 0;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id +'}';
    }
}
