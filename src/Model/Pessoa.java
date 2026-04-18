package Model;

import Exceptions.CPFVazio;
import Exceptions.NomeVazio;
import Exceptions.TelefoneVazio;

public class Pessoa {
    protected String nome;
    protected String CPF;
    protected String telefone;

    public Pessoa(){
        this.nome = "";
        this.CPF = "";
        this.telefone = "";
    }

    public Pessoa(String nome, String CPF, String telefone){
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()){
            throw new NomeVazio("O nome não pode ser vazio!");
        } else {
            this.nome = nome;
        }
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if(CPF == null || CPF.isEmpty()){
            throw new CPFVazio("O CPF não pode ser vazio!");
        } else {
            this.CPF = CPF;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone == null || telefone.isEmpty()){
            throw new TelefoneVazio("O telefone não pode ser vazio!");
        } else {
            this.telefone = telefone;
        }
    }

    public void ExibirDados(){
        System.out.println("Nome: " + this.nome + ", CPF: " + this.CPF + ", Telefone: " + this.telefone);
    }
}
