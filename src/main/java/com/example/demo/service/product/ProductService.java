package com.example.demo.service.product;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Iterable findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
