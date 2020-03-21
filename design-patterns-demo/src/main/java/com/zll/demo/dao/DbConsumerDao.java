package com.zll.demo.dao;

import com.zll.demo.dao.model.Customer;

import javax.sql.DataSource;
import java.util.stream.Stream;

public class DbConsumerDao implements CustomerDao {

    private DataSource dataSource;

    public DbConsumerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Stream<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public boolean addConsumer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteConsumer(int id) {
        return false;
    }

    @Override
    public boolean updateConsumer(Customer customer) {
        return false;
    }
}
