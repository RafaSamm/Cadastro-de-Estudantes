package br.com.rhssolutions.CadastroEstudantes.controller;

import br.com.rhssolutions.CadastroEstudantes.model.dto.EstudanteDTO;
import br.com.rhssolutions.CadastroEstudantes.model.entity.Estudante;
import br.com.rhssolutions.CadastroEstudantes.model.exception.EstudanteNotFoundException;
import br.com.rhssolutions.CadastroEstudantes.model.service.EstudanteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;


@Controller
public class EstudanteController {

    final EstudanteService estudanteService;

    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping("/")
    public String listaEstudante(Model model) {
        model.addAttribute("listaEstudantes", estudanteService.listarEstudantes());
        return "/lista-estudantes";
    }

    @GetMapping("/novo")
    public String novoEstudante(Model model) {
        var estudante = new Estudante();
        model.addAttribute("novoEstudante", estudante);
        return "/novo-estudante";
    }

    @PostMapping("/salvar")
    public String salvarEstudante(@ModelAttribute("novoEstudante")
                                  @Valid EstudanteDTO dto, BindingResult erros,
                                  RedirectAttributes attributes) {
        if (erros.hasErrors()) { // se houver erros retorna para a página de cadastro
            return "/novo-estudante";
        }
        estudanteService.salvar(dto);
        attributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");
        return "redirect:/novo";
    }

    @GetMapping("/apagar/{id}")
    public String apagarEstudante(@PathVariable("id") UUID id, RedirectAttributes attributes) {
        try {
            estudanteService.apagarEstudante(id);
        } catch (EstudanteNotFoundException e) {
            attributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/";
    }




}
