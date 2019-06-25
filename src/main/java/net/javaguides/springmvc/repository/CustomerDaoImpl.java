package net.javaguides.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.entity.Customer;

import javax.persistence.Query;

@Repository
@Transactional(readOnly = true)
public class CustomerDaoImpl implements CustomerDao{

	
	@PersistenceContext
    EntityManager entityManager;
	
		@Override
	    public List<Customer> getCustomerByName(String name) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM customer as c  WHERE c.first_name = ?", Customer.class);
	        query.setParameter(1, name );
	        return query.getResultList();
	    }
	
	
}
