package com.market.service.impl;

import com.market.api.ProductRestControllerApi;
import com.market.model.ProductDTO;
import com.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRestControllerApi productRestApi;

    @Autowired
    public ProductServiceImpl(ProductRestControllerApi productRestApi) {
        this.productRestApi = productRestApi;
    }

    @Override
    public List<ProductDTO> findAll() {
        return this.productRestApi.getAllProductsUsingGET();
    }

    @Override
    public ProductDTO findById(Long id) {
        return this.productRestApi.getProductUsingGET(id);
    }

    @Override
    public void add(ProductDTO productDTO) {
        this.productRestApi.addProductUsingPOST(productDTO);
    }

    @Override
    public void update(ProductDTO productDTO) {
        this.productRestApi.updateProductUsingPUT(productDTO);
    }

    @Override
    public void deleteById(Long id) {
        this.productRestApi.deleteProductUsingDELETE(id);
    }
}
