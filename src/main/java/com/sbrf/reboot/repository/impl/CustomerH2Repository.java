package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:C:\\Users\\tedeev_tp\\IdeaProjects\\home-work\\db";

    private final String USER = "sa";
    private final String PASS = "";


    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM CUSTOMER";
        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Customer customer = getCustomer(resultSet);
                        customers.add(customer);
                    }
                }
            }
        }
        return customers;
    }

    @Override
    public boolean createCustomer(String name, String eMail) throws SQLException {
        String sql = "INSERT INTO CUSTOMER (S_NAME, eMail) VALUES (?,?)";
        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, eMail);
                preparedStatement.executeUpdate();
            }
        }
        return true;
    }

    @Override
    public Customer getById(Long id) throws SQLException {
        String sql = "SELECT * FROM CUSTOMER WHERE I_ID = ?";
        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return getCustomer(resultSet);
                }
            }
        }
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM CUSTOMER WHERE I_ID = ?";
        try (Connection conn = getConnection()) {
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        }
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection Error");
        }
        return conn;
    }

    public Customer getCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        if (resultSet.next()) {
            customer.setId(resultSet.getLong("I_ID"));
            customer.setName(resultSet.getString("S_NAME"));
            customer.seteMail(resultSet.getString("EMAIL"));
        }
        return customer;
    }

    @Override
    public void createTable() throws SQLException {
        try (Connection conn = getConnection()) {
            String sql =
                    "DROP TABLE IF EXISTS customer;" +
                            "CREATE TABLE customer (" +
                            "I_ID INT PRIMARY KEY AUTO_INCREMENT," +
                            "S_NAME VARCHAR(255)," +
                            "EMAIL VARCHAR(255)," +
                            ");";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
        }
    }
}


