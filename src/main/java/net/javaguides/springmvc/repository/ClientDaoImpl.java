package net.javaguides.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;

import net.javaguides.springmvc.entity.Client;

@Repository
@Transactional(readOnly = true)
public class ClientDaoImpl implements ClientDao{

	
	@PersistenceContext
    EntityManager entityManager;
		
	 @Override
	    public List<Client> getClientByName(String name) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM client as c  WHERE c.first_name = ?", Client.class);
	        query.setParameter(1, name );
	        return query.getResultList();
	    }
	
	
}
