package com.spring.sp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sp.domain.Product;
import com.spring.sp.service.ProductService;


@RestController
@RequestMapping("api/product")
public class ProductApi {   
   
    @Autowired
    private ProductService productService;
   
    @GetMapping("/find-product")
    public @ResponseBody List<Product> callFunctionCountProductJdbc(@RequestBody Product product){
    	return productService.listarProducto(product);
    }
    
    @PostMapping("/sp-create-product")
    public @ResponseBody boolean callProcedureJdbc(@RequestBody Product product){
        return productService.registrarProducto(product);
    }
    
    @GetMapping("/sp-count-product")
    public Long callFunctionCountProductJdbc(){
        return productService.cantidadProductos();
    }
}
