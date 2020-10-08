package com.taeho.study.modules.study;

import com.taeho.study.modules.account.Account;
import com.taeho.study.modules.account.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudyTest {

    Study study;
    Account account;
    UserAccount userAccount;

    @BeforeEach
    void beforeEach() {
        study = new Study();
        account = new Account();
        account.setNickname("taeho");
        account.setPassword("12345678");
        userAccount = new UserAccount(account);

    }

    @Test
    void isJoinable() {
        study.setPublished(true);
        study.setRecruiting(true);

        assertTrue(study.isJoinable(userAccount));
    }

    @Test
    void isJoinable_false_for_manager() {
        study.setPublished(true);
        study.setRecruiting(true);
        study.addManager(account);

        assertFalse(study.isJoinable(userAccount));
    }

    @Test
    void isJoinable_false_for_member() {
        study.setPublished(true);
        study.setRecruiting(true);
        study.addMember(account);

        assertFalse(study.isJoinable(userAccount));
    }


    @Test
    void isJoinable_false_for_non_recruiting_study() {
        study.setPublished(true);
        study.setRecruiting(false);

        assertFalse(study.isJoinable(userAccount));

        study.setPublished(false);
        study.setRecruiting(true);

        assertFalse(study.isJoinable(userAccount));
    }


    @Test
    void isManager() {
        study.addManager(account);
        assertTrue(study.isManager(userAccount));
    }

    @Test
    void isMember() {
        study.addMember(account);
        assertTrue(study.isMember(userAccount));
    }

}
