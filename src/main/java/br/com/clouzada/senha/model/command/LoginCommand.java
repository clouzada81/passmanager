package br.com.clouzada.senha.model.command;

import java.util.List;

public class LoginCommand {

    private String username;
    private String password;
    private List<URICommand> uris;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<URICommand> getUris() {
        return uris;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUris(List<URICommand> uris) {
        this.uris = uris;
    }
}
