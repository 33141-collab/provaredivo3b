
package escola.controller;

import escola.model.Sala;
import escola.service.SalaService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    // Cadastrar sala - 201
    @PostMapping
    public ResponseEntity<Sala> cadastrar(
            @Valid @RequestBody Sala sala) {

        Sala novaSala = service.cadastrar(sala);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(novaSala.getId())
            .toUri();

        return ResponseEntity.created(location).body(novaSala);
    }

    // Listar salas - 200
    @GetMapping
    public ResponseEntity<List<Sala>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // Buscar pelo ID - 200 ou 404
    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Reservar sala - 200 ou 409
    @PostMapping("/{id}/reservar")
    public ResponseEntity<Sala> reservar(@PathVariable Long id) {
        return ResponseEntity.ok(service.reservar(id));
    }

    // Liberar sala - 200 ou 409
    @PostMapping("/{id}/liberar")
    public ResponseEntity<Sala> liberar(@PathVariable Long id) {
        return ResponseEntity.ok(service.liberar(id));
    }

    // Excluir sala - 204 ou 409
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
