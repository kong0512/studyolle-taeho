package com.taeho.study.modules.account;


import com.taeho.study.modules.account.form.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithSecurityContextFactory;



public class WithAccountSecurityContextFactory implements WithSecurityContextFactory<WithAccount> {
    @Autowired
    private AccountService accountService;

    @Override
    public SecurityContext createSecurityContext(WithAccount withAccount) {
        String nickname = withAccount.value();

        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setNickname(nickname);
        signUpForm.setEmail(nickname + "@email.com");
        signUpForm.setPassword("12345678");
        accountService.processNewAccount(signUpForm);

        UserDetails principal = accountService.loadUserByUsername(nickname);
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities());
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);

        return context;

    }
}
