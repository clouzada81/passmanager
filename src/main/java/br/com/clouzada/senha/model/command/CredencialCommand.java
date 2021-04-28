package br.com.clouzada.senha.model.command;

import java.util.Objects;

public class CredencialCommand {

    private String id;
    private String folderId;
    private String name;
    private String notes;
    private LoginCommand login;

    public String getId() {
        return id;
    }

    public String getFolderId() {
        return folderId;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public LoginCommand getLogin() {
        return login;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setLogin(LoginCommand login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredencialCommand that = (CredencialCommand) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
