package cz.upce.eshop.controller;

import cz.upce.eshop.DTO.AddOrEditProductDTO;
import cz.upce.eshop.entity.Product;
import cz.upce.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ExceptionHandler(RuntimeException.class)
    public String handleException(){
        return "error";
    }

    @GetMapping("/")
    public String showAllProducts(Model model){
        model.addAttribute("productList", productRepository.findAll());
        return "productList";
    }
    @GetMapping("/productDetail/{id}")
    public String showProductDetail(@PathVariable(required = false) Long id, Model model){
        try {
            model.addAttribute("product", productRepository.findById(id).get());
            return "productDetail";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping(value = {"/productForm","/productForm/{id}"})
    public String showProductForm(@PathVariable(required = false) Long id, Model model){
        if (id != null){
            Product byId = productRepository.findById(id).orElse(new Product());
            model.addAttribute("product",byId);

        }else {
            model.addAttribute("product", new AddOrEditProductDTO());
        }
        return "productForm";

    }
    @PostMapping("/productFormProces")
    public String productFormProcess(AddOrEditProductDTO addOrEditProductDTO){
        Product product = new Product();
        product.setName(addOrEditProductDTO.getProductName());
        product.setId(addOrEditProductDTO.getId());
        productRepository.save(product);
        return "redirect:/";
    }



}
