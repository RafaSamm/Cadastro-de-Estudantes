package br.com.rhssolutions.CadastroEstudantes.controller;

import br.com.rhssolutions.CadastroEstudantes.model.dto.EstudanteDTO;
import br.com.rhssolutions.CadastroEstudantes.model.entity.Estudante;
import br.com.rhssolutions.CadastroEstudantes.model.service.EstudanteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @GetMapping("/novo")
    public String novoEstudante(Model model) {
        var estudante = new Estudante();
        model.addAttribute("novoEstudante", estudante);
        return "/novo-estudante";
    }

    @PostMapping("/salvar")
    public String salvarEstudante(@ModelAttribute("novoEstudante")EstudanteDTO dto, RedirectAttributes attributes) {
        estudanteService.salvar(dto);
        attributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");
        return "redirect:/novo";
    }


}
