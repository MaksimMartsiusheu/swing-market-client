package com.market.service;

import com.market.model.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO findById(Long id);

    void add(ProductDTO productDTO);

    void update(ProductDTO productDTO);

    void deleteById(Long id);
}
