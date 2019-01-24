package com.spring.sp.service;

import java.util.List;

import com.spring.sp.domain.Product;

public interface ProductService {

	public List<Product> listarProducto(Product product);
	
	public boolean registrarProducto(Product product);
	
	public Long cantidadProductos();
	
	
	
}
