package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.NonNull;
import lombok.val;


public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isClientHasContract(long clientId, long contractNumber) {
        val accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(contractNumber);
    }

    public boolean isClientEmail(long clientId, @NonNull String email) {
        val emailById = accountRepository.getClientEmailByClientId(clientId);
        return email.equals(emailById);
    }
}