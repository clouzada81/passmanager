package br.com.clouzada.senha.util.init;

import br.com.clouzada.senha.model.Credencial;
import br.com.clouzada.senha.model.Grupo;
import br.com.clouzada.senha.model.command.CredencialCommand;
import br.com.clouzada.senha.model.command.GrupoCommand;
import br.com.clouzada.senha.model.command.JSONCommand;
import br.com.clouzada.senha.model.command.SenhaCommand;
import br.com.clouzada.senha.model.repository.GrupoRepository;
import br.com.clouzada.senha.service.CredencialService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//@Configuration
class LoadDatabase {

    private List<GrupoCommand> grupoCommandList;
    private List<CredencialCommand> credencialCommandList;

    @Bean
    CommandLineRunner initDatabase(GrupoRepository grupoRepository, CredencialService credencialService) {
        return args -> {
            lerJSON();

            for (GrupoCommand grupoCommand : grupoCommandList) {
                Grupo grupo = new Grupo(grupoCommand.getName(), grupoCommand.getId());
            }

            for (CredencialCommand credencialCommand : credencialCommandList) {
                SenhaCommand senhaCommand = new SenhaCommand(credencialCommand.getLogin().getPassword().length(), true, true, true, true);
                Grupo grupo = grupoRepository.findByIdAntigo(credencialCommand.getFolderId());

                Credencial credencial;
                if (credencialCommand.getLogin().getUris() != null && !credencialCommand.getLogin().getUris().isEmpty()) {
                    credencial = new Credencial(
                            credencialCommand.getName(), credencialCommand.getLogin().getUsername(),
                            credencialCommand.getLogin().getUris().get(0).getUri(), grupo,
                            credencialCommand.getLogin().getPassword(), senhaCommand);
                } else {
                    credencial = new Credencial(
                            credencialCommand.getName(), credencialCommand.getLogin().getUsername(), grupo,
                            credencialCommand.getLogin().getPassword(), senhaCommand);
                }
                credencialService.salvar(credencial);
            }
        };
    }


    private void lerJSON() throws IOException {
        String json = String.join(" ", Files.readAllLines(Paths.get(""), StandardCharsets.ISO_8859_1));

        Gson gson = new Gson();
        JSONCommand jsonCommand = gson.fromJson(json, JSONCommand.class);

        this.grupoCommandList = jsonCommand.getFolders();
        this.credencialCommandList = jsonCommand.getItems();
    }
}
