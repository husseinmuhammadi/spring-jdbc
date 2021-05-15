package com.javastudio.tutorial.jdbc.dao;

import com.javastudio.tutorial.jdbc.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

public class CustomerDao {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerDao.class);

    private final JdbcTemplate jdbcTemplate;

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomerDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Customer> findAll() {
        List<Customer> customers = Collections.EMPTY_LIST;
        jdbcTemplate.query("SELECT id, fist_name, last_name FROM customer", rs -> {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customers.add(customer);
            return customer;
        });
        return customers;
    }

    public int getCountOfCustomers() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM customer", Integer.class);
    }

    void dummy() {
        try {
            LOGGER.info("Creating tables ...");
            jdbcTemplate.execute("DROP TABLE IF EXISTS customer");
            jdbcTemplate.execute("CREATE TABLE customer(" +
                    "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
            LOGGER.info("Tables created successfully!");

            jdbcTemplate.update("INSERT INTO customer(first_name, last_name) values (?, ?)", "Hossein", "Mohammadi");
            jdbcTemplate.query("SELECT id, first_name, last_name from customer", resultSet -> {
                LOGGER.info("Id: {}", resultSet.getLong("id"));
                LOGGER.info("First name: {}", resultSet.getString("first_name"));
                LOGGER.info("Last name: {}", resultSet.getString("last_name"));
            });
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }

    }
}
