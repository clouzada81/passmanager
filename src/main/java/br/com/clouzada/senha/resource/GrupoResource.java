package br.com.clouzada.senha.resource;

import br.com.clouzada.senha.exception.SenhaException;
import br.com.clouzada.senha.model.Grupo;
import br.com.clouzada.senha.service.GrupoService;
import br.com.clouzada.senha.service.GrupoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
public class GrupoResource {

    private GrupoService grupoService;

    @Autowired
    public GrupoResource(GrupoServiceImpl grupoService) {
        this.grupoService = grupoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Grupo>> listar() throws SenhaException {
        return ResponseEntity.ok(this.grupoService.listar());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Grupo> buscar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.grupoService.buscar(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Grupo> inserir(@RequestBody @Validated Grupo grupo) {
        this.grupoService.salvar(grupo);
        return ResponseEntity.status(HttpStatus.OK).body(grupo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Grupo> alterar(@RequestBody @Validated Grupo grupo) {
        this.grupoService.alterar(grupo);
        return ResponseEntity.status(HttpStatus.OK).body(grupo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> excluir(@PathVariable("id") Long id) {
        this.grupoService.excluir(this.grupoService.buscar(id));
        return ResponseEntity.ok().build();
    }
}
