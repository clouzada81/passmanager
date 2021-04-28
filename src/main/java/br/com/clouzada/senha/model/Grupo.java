package br.com.clouzada.senha.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "id_antigo")
    private String idAntigo;

    private String nome;

    @OneToMany(mappedBy = "grupo")
    private List<Credencial> credenciais;

    public Grupo() {
    }

    public Grupo(String nome) {
        this.nome = nome;
    }

    public Grupo(String nome, String idAntigo) {
        this.nome = nome;
        this.idAntigo = idAntigo;
    }

    public String getId() {
        return id;
    }

    public String getIdAntigo() {
        return idAntigo;
    }

    public String getNome() {
        return nome;
    }

    public List<Credencial> getCredenciais() {
        return Collections.unmodifiableList(this.credenciais);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdAntigo(String idAntigo) {
        this.idAntigo = idAntigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addCredencial(Credencial credencial) {
        this.credenciais.add(credencial);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return id.equals(grupo.id);
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
