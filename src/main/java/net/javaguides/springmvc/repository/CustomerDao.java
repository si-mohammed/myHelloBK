package net.javaguides.springmvc.repository;

import java.util.List;

import net.javaguides.springmvc.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomerByName(String name);
}
