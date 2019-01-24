package com.spring.sp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.sp.domain.Product;
import com.spring.sp.service.ProductService;
import com.spring.sp.utils.JdbcTemplateUtils;


@Service
public class ProductServiceImpl implements ProductService{

	private JdbcTemplateUtils jdbcUtils;

    @Autowired
    public void setJdbcUtils(JdbcTemplateUtils jdbcUtils){
        this.jdbcUtils=jdbcUtils;
    }
    
	@Override
	public List<Product> listarProducto(Product product) {
		 Map<String,Object> params=new HashMap<>();       
         params.put("p_name",product.getName());    
         Map<String, Object> map = jdbcUtils.callStoreProcedure("find_product",params);
         List<Product> lista = new ArrayList((map.values()));
         return lista;        
	}

	@Override
	public boolean registrarProducto(Product product) {		
		Map<String,Object> params=new HashMap<>();
		try {
			params.put("id",UUID.randomUUID().toString());
	        params.put("p_code",product.getCode());
	        params.put("p_name",product.getName());
	        params.put("weight",product.getWeight());
	        jdbcUtils.callStoreProcedure("create_product",params);	        
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
		return true;
	}

	@Override
	public Long cantidadProductos() {
		 Long count=(Long) jdbcUtils.callStoredFunction( "count_product",null,Long.class);
	     return count;
	}
	
}
