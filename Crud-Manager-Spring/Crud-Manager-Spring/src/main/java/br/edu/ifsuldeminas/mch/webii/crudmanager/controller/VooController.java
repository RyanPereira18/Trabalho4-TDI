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

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Voo;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Aeroporto;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.VooRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.AeroportoRepository;
import jakarta.validation.Valid;

@Controller
public class VooController {

    @Autowired
    private VooRepository vooRepo;

    @Autowired
    private AeroportoRepository aeroportoRepo;

    @GetMapping("/voos")
    public String listVoos(Model model) {
        List<Voo> voos = vooRepo.findAll();
        model.addAttribute("voos", voos);
        return "voo_page";
    }

    @GetMapping("/voos/form")
    public String vooForm(@ModelAttribute("voo") Voo voo, Model model) {
        List<Aeroporto> aeroportos = aeroportoRepo.findAll();
        model.addAttribute("aeroportos", aeroportos);
        return "voos/form";
    }

    @PostMapping("/voos/register")
    public String vooNew(@Valid @ModelAttribute("voo") Voo voo, BindingResult erros, Model model) {
        if (erros.hasErrors()) {
            List<Aeroporto> aeroportos = aeroportoRepo.findAll();
            model.addAttribute("aeroportos", aeroportos);
            return "voos/form";
        }
        vooRepo.save(voo);
        return "redirect:/voos";
    }

    @GetMapping("/voos/update/{id}")
    public String vooUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Voo> vooOpt = vooRepo.findById(id);
        Voo voo = vooOpt.orElseGet(Voo::new);

        List<Aeroporto> aeroportos = aeroportoRepo.findAll();
        model.addAttribute("aeroportos", aeroportos);
        model.addAttribute("voo", voo);
        
        return "redirect:/voos";
    }

    @GetMapping("/voos/delete/{id}")
    public String vooDelete(@PathVariable("id") Integer id) {
        vooRepo.deleteById(id);
        return "redirect:/voos";
    }
}
