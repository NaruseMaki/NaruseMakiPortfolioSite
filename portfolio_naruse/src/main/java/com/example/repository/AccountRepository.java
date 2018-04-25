package com.example.repository;

import com.example.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	//ログインする時用
	@Query("SELECT x FROM Account x WHERE x.loginid = ?1")
    Account findFirstByLoginid(String loginid);
	
	@Query("SELECT x FROM Account x WHERE x.loginid = ?1 and x.name = ?2")
    Account findByLoginidAndNameEquals(String loginid, String name);
	
    //顧客情報編集用
    @Query("SELECT x FROM Account x WHERE x.id = ?1")
    Account findByIdEquals(Integer accountid);
}