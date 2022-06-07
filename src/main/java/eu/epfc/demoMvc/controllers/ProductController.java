package eu.epfc.demoMvc.controllers;

import eu.epfc.demoMvc.entities.Product;
import eu.epfc.demoMvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value="/index")
    public String index(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("productsList",products);
        return "products";
    }
    @RequestMapping(value="/edit",method = RequestMethod.GET)
    public String editProduct(Model model,Long id){
        Optional<Product> product = productRepository.findById(id);
        model.addAttribute("product",product.get());
        return "editProduct";
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "redirect:/index";
    }

    @RequestMapping(value="/form",method = RequestMethod.GET)
    public String formProduct(Model model){
        model.addAttribute("product",new Product());
        return "form_product";
    }

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String saveProduct(Product product){
        productRepository.save(product);
        return "confirmation";
    }

}
