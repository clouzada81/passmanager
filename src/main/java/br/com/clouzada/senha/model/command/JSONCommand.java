package br.com.clouzada.senha.model.command;

import java.util.List;

public class JSONCommand {

    private List<GrupoCommand> folders;
    private List<CredencialCommand> items;

    public List<GrupoCommand> getFolders() {
        return folders;
    }

    public List<CredencialCommand> getItems() {
        return items;
    }

    public void setFolders(List<GrupoCommand> folders) {
        this.folders = folders;
    }

    public void setItems(List<CredencialCommand> items) {
        this.items = items;
    }
}
