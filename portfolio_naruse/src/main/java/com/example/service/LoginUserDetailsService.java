package com.example.service;

import com.example.domain.Account;
import com.example.repository.AccountRepository;
import com.example.web.AccountEditForm;
import com.example.web.AccountForm;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String loginid) throws UsernameNotFoundException {
        if (loginid == null || "".equals(loginid)) {
            throw new UsernameNotFoundException("LoginId is empty");
        }
        
        Account account = accountRepository.findFirstByLoginid(loginid);
        if(account == null) {
        	throw new UsernameNotFoundException("The requested user is not found." + loginid);
        }
        
        return new LoginUserDetails(account);
    }
    
    @Transactional
    public LoginUserDetails registerAdmin(String loginid, String name, String pass, String address) {
    	AccountForm accountform = new AccountForm(loginid, name, passwordEncoder.encode(pass), address);
    	Account account = new Account();
        BeanUtils.copyProperties(accountform, account);
        accountRepository.save(account);
        return new LoginUserDetails(account);
    }

    @Transactional
    public void registerUser(String loginid, String name, String pass, String address) {
    	AccountForm accountform = new AccountForm(loginid, name, passwordEncoder.encode(pass), address);
    	Account account = new Account();
        BeanUtils.copyProperties(accountform, account);
        accountRepository.save(account);
    }
    
    @Transactional
    public void registerUserEdit(Integer id, String loginid, String name, String pass, String address) {
    	AccountEditForm accounteditform = new AccountEditForm(name, address);
    	Account account = accountRepository.findByIdEquals(id);
        BeanUtils.copyProperties(accounteditform, account);
        account.setId(id);
        account.setLoginid(loginid);
        account.setPass(pass);
        accountRepository.save(account);
    }
}