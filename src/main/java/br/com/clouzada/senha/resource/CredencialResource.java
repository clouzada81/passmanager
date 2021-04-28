package br.com.clouzada.senha.resource;

import br.com.clouzada.senha.exception.SenhaException;
import br.com.clouzada.senha.model.Credencial;
import br.com.clouzada.senha.model.command.SenhaCommand;
import br.com.clouzada.senha.service.CredencialService;
import br.com.clouzada.senha.service.CredencialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credencial")
public class CredencialResource {

    private CredencialService credencialService;

    @Autowired
    public CredencialResource(CredencialServiceImpl credencialService) {
        this.credencialService = credencialService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Credencial>> listar() throws SenhaException {
        return ResponseEntity.ok(this.credencialService.listar());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Credencial> buscar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.credencialService.buscar(id));
    }

    @RequestMapping(value = "/senha", method = RequestMethod.POST)
    public ResponseEntity<SenhaCommand> gerarSenha(@RequestBody @Validated SenhaCommand senhaCommand) {
        senhaCommand.setSenha(this.credencialService.gerarSenha(senhaCommand));
        return ResponseEntity.ok(senhaCommand);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Credencial> inserir(@RequestBody @Validated Credencial credencial) {
        this.credencialService.salvar(credencial);
        return ResponseEntity.status(HttpStatus.OK).body(credencial);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Credencial> alterar(@RequestBody @Validated Credencial credencial) {
        this.credencialService.alterar(credencial);
        return ResponseEntity.status(HttpStatus.OK).body(credencial);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        this.credencialService.excluir(this.credencialService.buscar(id));
        return ResponseEntity.ok().build();
    }
}
