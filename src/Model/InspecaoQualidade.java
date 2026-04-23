package Model;

import java.util.Date;

public class InspecaoQualidade {

    private int numero;
    private Date data;
    private String criterioAvaliacao;
    private enum Resultado{
        APROVADO,
        REPROVADO,
        BLOQUEADO;
    }
    private Resultado resultado;
    private String observacao;
    private Inspetor inspetor;
    private Componente componente;

    public InspecaoQualidade(){
        this.numero = 0;
        this.data = new Date();
        this.criterioAvaliacao = "";
        this.observacao = "";
        this.inspetor = null;
        this.componente = null;
    }

    public InspecaoQualidade(int numero, Date data, String criterioAvaliacao, String observacao,
                             Inspetor inspetor, Componente componente) {
        this.numero = numero;
        this.data = data;
        this.criterioAvaliacao = criterioAvaliacao;
        this.observacao = observacao;
        this.inspetor = inspetor;
        this.componente = componente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCriterioAvaliacao() {
        return criterioAvaliacao;
    }

    public void setCriterioAvaliacao(String criterioAvaliacao) {
        this.criterioAvaliacao = criterioAvaliacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Inspetor getInspetor() {
        return inspetor;
    }

    public void setInspetor(Inspetor inspetor) {
        this.inspetor = inspetor;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public void aprovarComponente(Componente componente) {
        if (this.resultado == resultado.APROVADO) {
            componente.aprovar();
        } else if (this.resultado == resultado.REPROVADO){
            componente.reprovar();
        } else {
            componente.bloqueado();
        }
    }

    public void ExibirDados(){
        System.out.println("Número: " + this.numero + ", Data (DD/MM/AAAA):" + this.data + ", Críterio Avaliação: "
                + this.criterioAvaliacao + ", Observação: " + this.observacao + ", Inspetor: " + this.inspetor + ", " +
                "Componente: " + this.componente);
    }
}
