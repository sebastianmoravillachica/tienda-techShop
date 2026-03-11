package com.techShop.techShop.controller;

import com.techShop.techShop.domain.Categoria;
import com.techShop.techShop.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

   @GetMapping("/listado")
    public String inicio(Model model) {

    var categorias = categoriaService.getCategorias(false);

    model.addAttribute("categorias", categorias);
    model.addAttribute("totalCategorias", categorias.size());

    
    model.addAttribute("categoria", new Categoria());

    return "categoria/listado";
    }
}