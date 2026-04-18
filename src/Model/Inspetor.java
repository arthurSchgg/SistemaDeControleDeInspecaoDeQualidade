package Model;

import Exceptions.AreaAtuacaoVazia;
import Exceptions.MatriculaVazia;

public class Inspetor extends Pessoa{

    private Integer matricula;
    private enum AreaAtuacao{
        ELETRICA,
        MECANICA,
        AUTOMACAO,
        ELETRONICA,
        CONTROLEDEQUALIDADE;
    }
    private AreaAtuacao area;
    private boolean ativo;

    public Inspetor(String nome, String CPF, String telefone) {
        super(nome, CPF, telefone);
        this.matricula = 0;
        this.ativo = true;
    }

    public Inspetor(String nome, String CPF, String telefone, Integer matricula, AreaAtuacao area, boolean ativo) {
        super(nome, CPF, telefone);
        this.matricula = matricula;
        this.area = area;
        this.ativo = ativo;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        if(matricula == null || matricula <= 0){
            throw new MatriculaVazia("A mátricula não pode ser vazia!");
        } else {
            this.matricula = matricula;
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public AreaAtuacao getArea() {
        return area;
    }

    public void setArea(AreaAtuacao area) {
        if(area == null){
            throw new AreaAtuacaoVazia("A área de atuação é obrigatória!");
        } else {
            this.area = area;
        }
    }

    public boolean atividadeInpetor(){
        if(this.ativo == true){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void ExibirDados(){
        System.out.println("Nome: " + this.nome + ", CPF: " + this.CPF + ", Telefone: " + this.telefone +
                ", Mátricula: " + this.matricula + ", Ativo: " + this.ativo + "Área de Atuação: " + this.area);
    }
}
