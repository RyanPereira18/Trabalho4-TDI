package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Aeroporto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.AeroportoRepository;
import jakarta.validation.Valid;

@Controller
public class AeroportoController {

    @Autowired
    private AeroportoRepository aeroportoRepo;

    @GetMapping("/aeroportos")
    public String listAeroportos(Model model) {
        List<Aeroporto> aeroportos = aeroportoRepo.findAll();
        model.addAttribute("aeroportos", aeroportos);
        return "aeroporto_page";
    }

    @GetMapping("/aeroportos/form")
    public String aeroportoForm(@ModelAttribute("aeroporto") Aeroporto aeroporto) {
        return "aeroportos/form";
    }

    @PostMapping("/aeroportos/register")
    public String aeroportoNew(@Valid @ModelAttribute("aeroporto") Aeroporto aeroporto, BindingResult erros) {
        if (erros.hasErrors()) {
            return "aeroportos/form";
        }
        aeroportoRepo.save(aeroporto);
        return "redirect:/aeroportos";
    }

    @GetMapping("/aeroportos/update/{id}")
    public String aeroportoUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Aeroporto> aeroportoOpt = aeroportoRepo.findById(id);
        Aeroporto aeroporto = aeroportoOpt.orElseGet(Aeroporto::new);
        model.addAttribute("aeroporto", aeroporto);
        return "redirect:/aeroportos";
    }

    @GetMapping("/aeroportos/delete/{id}")
    public String aeroportoDelete(@PathVariable("id") Integer id) {
        aeroportoRepo.deleteById(id);
        return "redirect:/aeroportos";
    }
}
