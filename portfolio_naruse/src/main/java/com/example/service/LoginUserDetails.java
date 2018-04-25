package com.example.service;

import com.example.domain.Account;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    private final Account account;

    public LoginUserDetails(Account account) {
        super(account.getLoginid(), account.getPass(), AuthorityUtils.createAuthorityList("ROLE_ACCOUNT"));
        this.account = account;
    }
}