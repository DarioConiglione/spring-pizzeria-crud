package org.lessons.java.spring_pizzeria_crud.controllers;

import java.util.List;

import org.lessons.java.spring_pizzeria_crud.models.Pizza;
import org.lessons.java.spring_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/pizze")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Pizza> listaPizze;

        if (keyword != null && !keyword.isEmpty()) {
            listaPizze = pizzaRepository.findByNameContainingIgnoreCase(keyword);
        } else {
            listaPizze = pizzaRepository.findAll();
        }
        model.addAttribute("pizze", listaPizze);
        return "pizze/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {

        Pizza pizza = pizzaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza non trovata"));

        model.addAttribute("pizza", pizza);
        return "pizze/show";
    }
}
