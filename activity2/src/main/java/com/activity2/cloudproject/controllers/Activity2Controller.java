package com.activity2.cloudproject.controllers;

import com.activity2.cloudproject.repository.ProductRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.activity2.cloudproject.ProductService;
import com.activity2.cloudproject.models.product;

import jakarta.validation.Valid;


@Controller
//@RequestMapping ("/")
public class Activity2Controller{

    private final ProductRepository productRepository;
    private final ProductService productService;

    public Activity2Controller(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    // Links the "/create" endpoint to the create.html template
    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        ModelAndView model = new ModelAndView("create");
        model.addObject("product", new product());
        return model;
    }

    // Handles the form submission for creating a new product
    @PostMapping("/create")
    public String createNewProduct(@Valid @ModelAttribute  product product) {
        productService.saveProduct(product);

        return "redirect:/";

    }

    // Links the "/edit" endpoint to the edit.html template
    @GetMapping("/edit")
    public ModelAndView getEditForm() {
        ModelAndView model = new ModelAndView("edit");
        model.addObject("product", new product());
        return model;
    }

    // Handles the form submission for updating an existing product
    @RequestMapping("/update")
    public product updateProduct(@Valid @ModelAttribute  product product) {
        return productService.updateProduct(product);
    }
    

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "index";
    }

    @GetMapping("/delete")
    public ModelAndView getDeleteForm() {
        ModelAndView model = new ModelAndView("delete");
        model.addObject("product", new product());
        return model;
    }

    @RequestMapping("/deleteProduct")
    public void deleteProduct(@Valid @ModelAttribute  product product) {
        productService.deleteProduct(product.getId());
    }


}