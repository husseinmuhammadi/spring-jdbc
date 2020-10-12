package com.javastudio.tutorial.jdbc;

import com.javastudio.tutorial.jdbc.dao.CustomerDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

@JdbcTest
@Sql({"schema.sql", "test-data.sql"})
public class CustomerRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void whenAddCustomer_thenItMustPersist() {
        CustomerDao customerDao = new CustomerDao(jdbcTemplate);
        int countOfCustomers = customerDao.getCountOfCustomers();
        Assertions.assertThat(countOfCustomers).isEqualTo(4);
    }
}
