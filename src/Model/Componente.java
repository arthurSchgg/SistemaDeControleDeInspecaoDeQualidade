package Model;

import Exceptions.CodigoVazio;
import Exceptions.NomeComponenteVazio;
import Exceptions.SetorOrigemVazio;
import Exceptions.TipoVazio;

public class Componente {

    private Integer codigo;
    private String nome;

    private enum tipo {
        BOBINA,
        ROTOR,
        ESTATOR,
        PLACA_ELETRONICA,
        EIXO,
        CARCACA_DE_MOTOR,
        SENSOR_INDUSTRIAL;
    }

    private String setorOrigem;

    public enum status {
        AGUARDANDO_INSPECAO,
        APROVADO,
        REPROVADO,
        BLOQUEADO;
    }

    private tipo tipoProduto;
    private status statusProduto;

    public Componente() {
        this.codigo = 0;
        this.nome = "";
        this.setorOrigem = "";
    }

    public Componente(Integer codigo, String nome, tipo tipoProduto, String setorOrigem, status statusProduto) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.setorOrigem = setorOrigem;
        this.statusProduto = status.AGUARDANDO_INSPECAO;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        if(codigo == null){
            throw new CodigoVazio("O código do produto não pode ser vazio!");
        } else {
            this.codigo = codigo;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()){
            throw new NomeComponenteVazio("O nome do componente não pode ser vazio!");
        } else {
            this.nome = nome;
        }
    }

    public String getSetorOrigem() {
        return setorOrigem;
    }

    public void setSetorOrigem(String setorOrigem) {
        if(setorOrigem == null || setorOrigem.isEmpty()){
            throw new SetorOrigemVazio("O setor de origem não pode ser vazio!");
        } else {
            this.setorOrigem = setorOrigem;
        }
    }

    public tipo getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(tipo tipoProduto) {
        if(tipoProduto == null){
            throw new TipoVazio("O tipo do produto não pode ser vazio!");
        } else {
            this.tipoProduto = tipoProduto;
        }
    }

    public status getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(status statusProduto) {
        this.statusProduto = statusProduto;
    }

    public void aprovar() {
        this.statusProduto = status.APROVADO;
    }

    public void reprovar(){
        this.statusProduto = status.REPROVADO;
    }

    public void bloqueado(){
        this.statusProduto = status.BLOQUEADO;
    }

    public boolean validaçãoInspeção (Componente componente){
        if(componente.getStatusProduto() == status.APROVADO && componente.getStatusProduto() == status.BLOQUEADO){
            return true;
        } else if(componente.getStatusProduto() == status.REPROVADO){
            System.out.println("Status só irá ser inspecionado novamente com liberação manual!");
            return false;
        }
        return true;
    }

    public void ExibirDados() {
        System.out.println("Código: " + this.codigo + ", Nome: " + this.nome + ", Tipo do produto: " + this.tipoProduto
                + ", Setor origem: " + this.setorOrigem + ", Status do produto: " + this.statusProduto);
    }

}
