package com.company.controller;

import com.company.model.Product;
import com.company.service.ProductServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppController {

    private final ProductServiceInter serviceInter;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> listProducts = serviceInter.getAll();
        model.addAttribute("listProducts",listProducts);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        serviceInter.addProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editProductForm(@PathVariable(name = "id") long id){
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = serviceInter.getById(id);
        mav.addObject("product",product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id){
        serviceInter.deleteProduct(id);
        return "redirect:/";
    }

}
