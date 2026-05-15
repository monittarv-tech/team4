package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<String> products = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("products", products);

        return "index";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam String product) {

        products.add(product);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {

        products.remove(id);

        return "redirect:/";
    }
}