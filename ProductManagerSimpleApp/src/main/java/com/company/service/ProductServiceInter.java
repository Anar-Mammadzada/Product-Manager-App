package com.company.service;

import com.company.model.Product;

import java.util.List;

public interface ProductServiceInter {

    List<Product> getAll();

    Product getById(long id);

    void addProduct(Product product);

    void deleteProduct(long id);

}
