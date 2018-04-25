package com.example.service;

import com.example.domain.Products;
import com.example.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;
    
    //ページ処理なしで全て表示する時用(使わない)
    public List<Products> findAll() {
        return productsRepository.findAllOrderByName();
    }
    
    //ページで全て表示する時用
    public Page<Products> findAll(Pageable pageable) {
        return productsRepository.findAllOrderByName(pageable);
    }
    
    //カテゴリ別で表示する時用
    public Page<Products> findByCategryEquals(String categry, Pageable pageable) {
        return productsRepository.findByCategryEquals(categry, pageable);
    }
    
    //カートにいれる時用
    public Products findByIdEquals(Integer id){
    	return productsRepository.findByIdEquals(id);
    }
    
    
    public Products findOne(Integer id) {
        return productsRepository.findOne(id);
    }

    public Products create(Products products) {
        return productsRepository.save(products);
    }

    public Products update(Products products) {
        return productsRepository.save(products);
    }

    public void delete(Integer id) {
    	productsRepository.delete(id);
    }
}
