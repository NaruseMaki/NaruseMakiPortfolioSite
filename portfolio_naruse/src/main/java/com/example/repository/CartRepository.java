package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	//ページ処理なしで全て表示する時用
    @Query("SELECT x FROM Products x ORDER BY x.id, x.name, x.price, x.maker, x.category")
    List<Cart> findAllOrderByName();
    
	//ページで全て表示する時用
    @Query("SELECT x FROM Cart x ORDER BY x.accountid, x.productsid, x.cartid, x.name, x.price, x.maker, x.category, x.count")
    Page<Cart> findAllOrderByName(Pageable pageable);
    
    //アカウント別に表示する時用
    @Query("SELECT x FROM Cart x WHERE x.accountid = ?1")
    Page<Cart> findByAccountidEquals(Integer accountid, Pageable pageable);
    
    //カート内商品の個数を確かめる用
    @Query("SELECT x FROM Cart x WHERE x.accountid = ?1")
    List<Cart> findByAccountidEquals(Integer accountid);
    
    //各個人のカートに同じ商品が入ってるか確かめる用
    @Query("SELECT x FROM Cart x WHERE x.accountid = ?1 and x.productsid = ?2")
    Cart findByAccountidAndProductsid(Integer accountid, Integer productsid);
}
