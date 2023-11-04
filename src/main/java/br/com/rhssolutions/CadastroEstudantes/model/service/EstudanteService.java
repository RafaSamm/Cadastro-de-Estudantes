package br.com.rhssolutions.CadastroEstudantes.model.service;

import br.com.rhssolutions.CadastroEstudantes.model.repository.EstudanteRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {

    final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

}
