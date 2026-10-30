
package escola.service;

import escola.model.Sala;
import escola.repository.SalaRepository;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    // Cadastrar sala
    public Sala cadastrar(Sala sala) {

        if (repository.existsByCodigo(sala.getCodigo())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Já existe uma sala com esse código"
            );
        }

        sala.setReservada(false);

        return repository.save(sala);
    }

    // Listar todas as salas
    public List<Sala> listar() {
        return repository.findAll();
    }

    // Buscar sala pelo ID
    public Sala buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Sala não encontrada"
            ));
    }

    // Reservar sala
    public Sala reservar(Long id) {

        Sala sala = buscarPorId(id);

        if (sala.isReservada()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "A sala já está reservada"
            );
        }

        sala.setReservada(true);

        return repository.save(sala);
    }

    // Liberar sala
    public Sala liberar(Long id) {

        Sala sala = buscarPorId(id);

        if (!sala.isReservada()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "A sala não está reservada"
            );
        }

        sala.setReservada(false);

        return repository.save(sala);
    }

    // Excluir sala
    public void excluir(Long id) {

        Sala sala = buscarPorId(id);

        if (sala.isReservada()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Não é possível excluir uma sala reservada"
            );
        }

        repository.delete(sala);
    }
}
