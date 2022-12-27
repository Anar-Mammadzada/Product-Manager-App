package com.company.service;

import com.company.model.Product;
import com.company.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServiceInter{

    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void addProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        repository.deleteById(id);
    }
}
