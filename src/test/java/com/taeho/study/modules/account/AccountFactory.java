package com.taeho.study.modules.account;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.plaf.SpinnerUI;

@Component
@RequiredArgsConstructor
public class AccountFactory {

    @Autowired AccountRepository accountRepository;

    public Account createAccount(String nickname) {
        Account taeho = new Account();
        taeho.setNickname(nickname);
        taeho.setEmail(nickname + "@email.com");
        accountRepository.save(taeho);
        return taeho;
    }

}
