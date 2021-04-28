package br.com.clouzada.senha.model;

import br.com.clouzada.senha.model.command.SenhaCommand;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credencial")
public class Credencial {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String nome;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "senha_antiga")
    private String senhaAntiga;

    @Column(name = "senha_usuario")
    private String senhaUsuario;
    private String url;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    @JsonBackReference
    private Grupo grupo;

    @Transient
    private SenhaCommand senhaCommand;

    public Credencial() {}

    public Credencial(String nome, String nomeUsuario, String url, Grupo grupo, String senhaAntiga, SenhaCommand senhaCommand) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.url = url;
        this.grupo = grupo;
        this.senhaAntiga = senhaAntiga;
        this.senhaCommand = senhaCommand;
    }

    public Credencial(String nome, String nomeUsuario, Grupo grupo, String senhaAntiga, SenhaCommand senhaCommand) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.grupo = grupo;
        this.senhaAntiga = senhaAntiga;
        this.senhaCommand = senhaCommand;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public String getUrl() {
        return url;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public SenhaCommand getSenhaCommand() {
        return senhaCommand;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setSenhaCommand(SenhaCommand senhaCommand) {
        this.senhaCommand = senhaCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credencial that = (Credencial) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return nome;
    }
}