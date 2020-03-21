package com.zll.demo.dao;

import com.zll.demo.dao.model.Customer;

import java.util.stream.Stream;

public interface CustomerDao {

    Stream<Customer> getAll();

    Customer getById(int id);

    boolean addConsumer(Customer customer);

    boolean deleteConsumer(int id);

    boolean updateConsumer(Customer customer);
}
