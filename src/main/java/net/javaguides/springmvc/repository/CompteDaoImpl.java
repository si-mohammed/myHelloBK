package net.javaguides.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;

import net.javaguides.springmvc.entity.Compte;

@Repository
@Transactional(readOnly = true)
public class CompteDaoImpl implements CompteDao{

	
	@PersistenceContext
    EntityManager entityManager;
	
	
	
	 @Override
	    public List<Compte> getCompteByIBAN(String IBAN) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM compte as c  WHERE c.IBAN = ?", Compte.class);
	        query.setParameter(1, IBAN );
	        return query.getResultList();
	    }
	 
	 @Override
	    public List<Compte> getCompteByRIB(String RIB) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM compte as c  WHERE c.RIB = ?", Compte.class);
	        query.setParameter(1, RIB );
	        return query.getResultList();
	    }
	
}
