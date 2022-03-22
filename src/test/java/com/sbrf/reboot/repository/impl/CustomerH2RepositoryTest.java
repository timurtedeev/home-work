package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerH2RepositoryTest {

    private static CustomerRepository customerRepository;

    @BeforeAll
    public static void before() throws SQLException {
        customerRepository = new CustomerH2Repository();
        customerRepository.createTable();
    }

    @Test
    void getAll() throws SQLException {
        boolean tomCreated = customerRepository.createCustomer("Tom", "tom@ya.ru");

        List<Customer> all = customerRepository.getAll();

        assertTrue(all.size() != 0);
    }

    @Test
    void createCustomer() throws SQLException {

        boolean mariaCreated = customerRepository.createCustomer("Maria", "maria98@ya.ru");

        assertTrue(mariaCreated);
    }

    @Test
    void getById() throws SQLException {

        boolean testCreated = customerRepository.createCustomer("test", "test98@ya.ru");

        List<Customer> all = customerRepository.getAll();

        Customer testFromList = all.iterator().next();

        Customer testFromDb = customerRepository.getById(testFromList.getId());


        assertEquals(testFromList, testFromDb);
    }

    @Test
    void deleteById() throws SQLException {
        boolean testCreated = customerRepository.createCustomer("test", "test98@ya.ru");

        List<Customer> all = customerRepository.getAll();

        Customer test = all.iterator().next();

        customerRepository.deleteById(test.getId());

        Customer beforeDelete = customerRepository.getById(test.getId());

        assertNull(beforeDelete.getId());
    }
}