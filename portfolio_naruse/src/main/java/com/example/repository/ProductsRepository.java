package com.example.repository;

import com.example.domain.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
	//ページ処理なしで全て表示する時用(使わない)
    @Query("SELECT x FROM Products x ORDER BY x.id, x.name, x.price, x.maker, x.category")
    List<Products> findAllOrderByName();

    //ページで全て表示する時用
    @Query("SELECT x FROM Products x ORDER BY x.id, x.name, x.price, x.maker, x.category")
    Page<Products> findAllOrderByName(Pageable pageable);
    
    //カテゴリ別で表示する時用
    @Query("SELECT x FROM Products x WHERE x.category = ?1")
    Page<Products> findByCategryEquals(String category, Pageable pageable);
    
    //カートにいれる時用
    @Query("SELECT x FROM Products x WHERE x.id = ?1")
    Products findByIdEquals(Integer id);
}

