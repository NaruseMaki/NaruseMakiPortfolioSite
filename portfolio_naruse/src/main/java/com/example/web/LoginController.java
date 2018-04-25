package com.example.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.service.LoginUserDetailsService;

@Controller
public class LoginController {
	@Autowired
	LoginUserDetailsService loginUserDetailsService;
	
    @GetMapping(path = "loginForm")
    String loginForm() {
        return "loginForm";
    }
    
    @GetMapping(path = "accountcreate")
    public String accountcreate(Model model) {
    	model.addAttribute("accountForm", new AccountForm());
        return "accountcreate";
    }
    
    @GetMapping(path = "accountResult")
    public String accountResult() {
        return "accountResult";
    }

    
    @PostMapping(path = "accountcreate")
    public String accountcreatePost(Model model, @Valid AccountForm accountForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "accountcreate";
        }

        try {
        	loginUserDetailsService.registerUser(accountForm.getLoginid(), accountForm.getName(), accountForm.getPass(), accountForm.getAddress());
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("accountcreateError", true);
            return "accountcreate";
        }

        return "accountResult";
    }
}