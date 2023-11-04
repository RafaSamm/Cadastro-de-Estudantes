package br.com.rhssolutions.CadastroEstudantes.model.service;

import br.com.rhssolutions.CadastroEstudantes.model.dto.EstudanteDTO;
import br.com.rhssolutions.CadastroEstudantes.model.entity.Estudante;
import br.com.rhssolutions.CadastroEstudantes.model.repository.EstudanteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class EstudanteService {

    final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public Estudante salvar(@Valid EstudanteDTO dto) {
        var estudante = new Estudante();
        BeanUtils.copyProperties(dto, estudante); // copia as propriedades de dto para estudante
        return repository.save(estudante);
    }

}
