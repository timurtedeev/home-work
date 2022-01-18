package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.impl.FileAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileAccountRepositoryTest {

    FileAccountRepository accountRepository;

    @Test
    void onlyPersonalAccounts() throws IOException {
        String filePath = "src/main/resources/Accounts.txt";
        accountRepository = new FileAccountRepository(filePath);

        long clientId = 1L;
        Set<Long> actualAccounts = accountRepository.getAllAccountsByClientId(clientId);

        Set<Long> expected = new HashSet<Long>() {{
            add(111L);
            add(222L);
            add(333L);
        }};

        actualAccounts.forEach(e -> assertTrue(expected.contains(e)));
    }

    @Test
    void failGetAllAccountsByClientId() {
        long clientId = 1L;

        String filePath = "somePath";

        accountRepository = new FileAccountRepository(filePath);

        assertThrows(FileNotFoundException.class, () -> accountRepository.getAllAccountsByClientId(clientId));
    }

    @Test
    void updateAccountNumber() throws IOException {
        long clientId = 2L;
        long oldAccountNumber = 777;
        long newAccountNumber = 456;

        String filePath = "src/main/resources/Accounts.txt";
        accountRepository = new FileAccountRepository(filePath);
        accountRepository.updateAccountNumber(clientId, oldAccountNumber, newAccountNumber);
        Set<Long> actualAccounts = accountRepository.getAllAccountsByClientId(2L);

        Assertions.assertNotEquals(oldAccountNumber, actualAccounts.iterator().next());


    }


}