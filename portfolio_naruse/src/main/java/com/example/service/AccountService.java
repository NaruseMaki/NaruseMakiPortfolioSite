package com.example.service;

import com.example.domain.Account;
import com.example.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    
    //顧客情報編集用
    public Account findByIdEquals(Integer accountid) {
    	return accountRepository.findByIdEquals(accountid);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findOne(Integer id) {
        return accountRepository.findOne(id);
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Integer id) {
    	accountRepository.delete(id);
    }
}
