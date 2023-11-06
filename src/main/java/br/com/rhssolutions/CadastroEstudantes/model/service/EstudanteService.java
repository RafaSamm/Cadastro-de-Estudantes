package br.com.rhssolutions.CadastroEstudantes.model.service;

import br.com.rhssolutions.CadastroEstudantes.model.dto.EstudanteDTO;
import br.com.rhssolutions.CadastroEstudantes.model.entity.Estudante;
import br.com.rhssolutions.CadastroEstudantes.model.exception.EstudanteNotFoundException;
import br.com.rhssolutions.CadastroEstudantes.model.repository.EstudanteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstudanteService {

    final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public Estudante salvar(EstudanteDTO dto) {
        var estudante = new Estudante();
        BeanUtils.copyProperties(dto, estudante); // copia as propriedades de dto para estudante
        return repository.save(estudante);
    }

    public Iterable<Estudante> listarEstudantes() {
        return repository.findAll();
    }

    public Estudante listarEstudantePorId(UUID id) throws EstudanteNotFoundException {
        Optional<Estudante> estudante = repository.findById(id);
        if (estudante.isPresent()) {
            return estudante.get();
        } else {
            throw new EstudanteNotFoundException("Estudante com id: " + id + " não existe!");
        }

    }

    public void apagarEstudante(@PathVariable("id") UUID id) throws EstudanteNotFoundException {
        var estudante = listarEstudantePorId(id);
        repository.delete(estudante);
    }


    public Estudante atualizarEstudante(UUID id, EstudanteDTO dto) throws EstudanteNotFoundException {
        var estudante = listarEstudantePorId(id);
        BeanUtils.copyProperties(dto, estudante);
        return repository.save(estudante);
    }

    public Iterable<Estudante> listarEstudantesPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome); // retorna uma lista de estudantes com o nome passado como parâmetro. Caso não haja nenhum estudante com o nome passado como parâmetro, retorna uma lista vazia.
    }
}
