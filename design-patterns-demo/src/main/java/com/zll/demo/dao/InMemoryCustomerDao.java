package com.zll.demo.dao;

import com.zll.demo.dao.model.Customer;

import java.util.stream.Stream;

public class InMemoryCustomerDao implements CustomerDao {
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
