package tqs.marketplace.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.marketplace.entities.Product;
import tqs.marketplace.services.ProductService;

import java.util.List;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> search(){
        return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/q={productName}")
    public ResponseEntity<List<Product>> searchByName(@PathVariable("productName") String productName){
        return new ResponseEntity<List<Product>>(productService.findByName(productName), HttpStatus.OK);
    }

    @GetMapping("/id={productId}")
    public ResponseEntity<Product> searchById(@PathVariable("productId") long productId){
        return new ResponseEntity<Product>(productService.findById(productId), HttpStatus.OK);
    }

}
