package br.com.clouzada.senha.model.command;

import java.util.Objects;

public class SenhaCommand {

    private Integer tamanhoSenha;
    private Boolean maiusculas;
    private Boolean minusculas;
    private Boolean numeros;
    private Boolean caracteresEspeciais;
    private String senha;
    private String senhaCriptografada;

    public SenhaCommand() {
    }

    public SenhaCommand(Integer tamanhoSenha, Boolean maiusculas, Boolean minusculas, Boolean numeros, Boolean caracteresEspeciais) {
        this.tamanhoSenha = tamanhoSenha;
        this.maiusculas = maiusculas;
        this.minusculas = minusculas;
        this.numeros = numeros;
        this.caracteresEspeciais = caracteresEspeciais;
    }

    public Integer getTamanhoSenha() {
        return tamanhoSenha;
    }
    public Boolean getMaiusculas() {
        return maiusculas;
    }
    public Boolean getMinusculas() {
        return minusculas;
    }
    public Boolean getNumeros() {
        return numeros;
    }
    public Boolean getCaracteresEspeciais() {
        return caracteresEspeciais;
    }
    public String getSenha() {
        return senha;
    }
    public String getSenhaCriptografada() {
        return senhaCriptografada;
    }

    public void setTamanhoSenha(Integer tamanhoSenha) {
        this.tamanhoSenha = tamanhoSenha;
    }
    public void setMaiusculas(Boolean maiusculas) {
        this.maiusculas = maiusculas;
    }
    public void setMinusculas(Boolean minusculas) {
        this.minusculas = minusculas;
    }
    public void setNumeros(Boolean numeros) {
        this.numeros = numeros;
    }
    public void setCaracteresEspeciais(Boolean caracteresEspeciais) {
        this.caracteresEspeciais = caracteresEspeciais;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setSenhaCriptografada(String senhaCriptografada) {
        this.senhaCriptografada = senhaCriptografada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SenhaCommand that = (SenhaCommand) o;
        return senhaCriptografada.equals(that.senhaCriptografada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senhaCriptografada);
    }

    @Override
    public String toString() {
        StringBuffer sbRetorno = new StringBuffer("SenhaCommand {");
        sbRetorno.append("tamanhoSenha=").append(tamanhoSenha).append(", maiusculas=").append(maiusculas)
                .append(", minusculas=").append(minusculas).append(", numeros=").append(numeros)
                .append(", caracteresEspeciais=").append(caracteresEspeciais).append(", senha='")
                .append(senha).append("\', senhaCriptografada='").append(senhaCriptografada).append("\'}");
        return sbRetorno.toString();
    }
}
