package com.evolvedadrian.inventory.controller;

import com.evolvedadrian.inventory.entity.Category;
import com.evolvedadrian.inventory.entity.Product;
import com.evolvedadrian.inventory.entity.Supplier;
import com.evolvedadrian.inventory.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return this.productService.getProductById(id);
    }

    @GetMapping("/sku/{sku}")
    public Optional<Product> findProductBySku(@PathVariable String sku){
        return this.productService.findProductBySku(sku);
    }

    @GetMapping("/name/{name}")
    public List<Product> findProductByName(@PathVariable String name){
        return this.productService.findProductsByName(name);
    }

    @GetMapping("/category/{id}")
    public List<Product> findProductByCategory(@PathVariable Integer id){
        return this.productService.findProductsByCategory(id);
    }

    @GetMapping("/supplier/{id}")
    public List<Product> findProductBySupplier(@PathVariable Integer id){
        return this.productService.findProductsBySupplier(id);
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Product> findProductByPriceBetween(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice){
        return this.productService.findProductsByPriceBetween(minPrice, maxPrice);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        this.productService.deleteProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product){
        product.setId(id);
        return this.productService.updateProduct(product);
    }
}
