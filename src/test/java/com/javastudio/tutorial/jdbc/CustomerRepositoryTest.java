package com.javastudio.tutorial.jdbc;

import com.javastudio.tutorial.jdbc.dao.CustomerDao;
import com.javastudio.tutorial.jdbc.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

@JdbcTest
public class CustomerRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.update("INSERT INTO customer(first_name, last_name) values (?, ?)", "Hossein", "Mohammadi");
    }

    @Test
    void whenAddCustomer_thenItMustPersist() {
        CustomerDao customerDao = new CustomerDao(jdbcTemplate);
        logger.info("{}", customerDao.getCountOfCustomers());
        logger.info("_________________________");
    }

}
