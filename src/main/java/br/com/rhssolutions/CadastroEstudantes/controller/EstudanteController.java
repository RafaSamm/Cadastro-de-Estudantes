package br.com.rhssolutions.CadastroEstudantes.controller;

import br.com.rhssolutions.CadastroEstudantes.model.service.EstudanteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudanteController {

    final EstudanteService estudanteService;
    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping("/")
    public String listaEstudante() {
        return "/lista-estudantes"; // retorna o html de cadastro de estudante
    }
}
