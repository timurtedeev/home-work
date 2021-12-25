package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);
    }

    @Test
    void contractExist() {
        Set<Long> accounts = new HashSet<>();
        accounts.add(111L);

        long clientId = 1L;
        long contractNumber = 111L;


        when(accountRepository.getAllAccountsByClientId(clientId)).thenReturn(accounts);

        assertTrue(accountService.isClientHasContract(clientId, contractNumber));
    }

    @Test
    void contractNotExist() {
        Set<Long> accounts = new HashSet<>();
        accounts.add(222L);

        long clientId = 1L;
        long contractNumber = 111L;

        when(accountRepository.getAllAccountsByClientId(clientId)).thenReturn(accounts);

        assertFalse(accountService.isClientHasContract(clientId, contractNumber));
    }

    @Test
    void emailMatch() {
        Map<Long, String> clientInfo = new HashMap<>();
        clientInfo.put(2L, "ivan@mail.ru");

        long clientId = 2L;
        String clientEmail = "ivan@mail.ru";

        when(accountRepository.getClientEmailByClientId(clientId)).thenReturn(clientInfo.get(2L));

        assertTrue(accountService.isClientEmail(clientId, clientEmail));
    }

    @Test
    void emailDoesNotMatch() {
        Map<Long, String> clientInfo = new HashMap<>();
        clientInfo.put(2L, "test@mail.ru");

        long clientId = 2L;
        String clientEmail = "ivan@mail.ru";

        when(accountRepository.getClientEmailByClientId(clientId)).thenReturn(clientInfo.get(2L));

        assertFalse(accountService.isClientEmail(clientId, clientEmail));
    }

    @Test
    void repositoryHasTreeMethods() {
        assertEquals(2, AccountRepository.class.getMethods().length);
    }

    @Test
    void serviceHasTreeMethods() {
        assertEquals(2, AccountService.class.getMethods().length - Object.class.getMethods().length);
    }

}