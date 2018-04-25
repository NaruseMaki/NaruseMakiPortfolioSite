package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cart;
import com.example.repository.CartRepository;

@Service
@Transactional
public class CartService {
	@Autowired
	CartRepository cartrepository;
	
	//ページ処理なしで全て表示する時用(使ってない)
	public List<Cart> findAll() {
        return cartrepository.findAllOrderByName();
    }
	
	//ページで全て表示する時用(使ってない)
	public Page<Cart> findAll(Pageable pageable) {
        return cartrepository.findAllOrderByName(pageable);
    }
	
	//アカウント別に表示する時用
	public Page<Cart> findByAccountidEquals(Integer accountid, Pageable pageable) {
        return cartrepository.findByAccountidEquals(accountid, pageable);
    }
	
	//カート内商品の個数を確かめる用
	public List<Cart> findByAccountidEquals(Integer accountid) {
        return cartrepository.findByAccountidEquals(accountid);
    }
    
	//各個人のカートに同じ商品が入ってるか確かめる用
    public Cart findByAccountidAndProductsid(Integer accountid, Integer productsid) {
        return cartrepository.findByAccountidAndProductsid(accountid, productsid);
    }
    
    public Cart findOne(Integer id) {
        return cartrepository.findOne(id);
    }

    public Cart create(Cart cart) {
        return cartrepository.save(cart);
    }

    public Cart update(Cart cart) {
        return cartrepository.save(cart);
    }

    public void delete(Integer cartid) {
    	cartrepository.delete(cartid);
    }
}
