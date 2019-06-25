package net.javaguides.springmvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.Query;
import net.javaguides.springmvc.entity.Utilisateur;

@Repository
@Transactional(readOnly = true)
public class UtilisateurDaoImpl implements UtilisateurDao{

	
	@PersistenceContext
    EntityManager entityManager;
	
	
	
	 @Override
	    public List<Utilisateur> getUtilisateurByName(String name) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM utilisateur as c  WHERE c.first_name = ?", Utilisateur.class);
	        query.setParameter(1, name );
	        return query.getResultList();
	    }
	 @Override
	    public List<Utilisateur> getUtilisateurBytelephoneFixe(String numphone) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM utilisateur as c  WHERE c.telephoneFixe = ?", Utilisateur.class);
	        query.setParameter(1, numphone );
	        return query.getResultList();
	    }
	 @Override
	    public List<Utilisateur> getUtilisateurBytelephoneMobile(String numphone) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM utilisateur as c  WHERE c.telephoneMobile = ?", Utilisateur.class);
	        query.setParameter(1, numphone );
	        return query.getResultList();
	    }
	 @Override
	    public List<Utilisateur> getUtilisateurBylogin(String login) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM utilisateur as c  WHERE c.login = ?", Utilisateur.class);
	        query.setParameter(1, login );
	        return query.getResultList();
	    }
	 @Override
	    public List<Utilisateur> getUtilisateurByemail(String email) {
	        Query query = entityManager.createNativeQuery("SELECT c.* FROM utilisateur as c  WHERE c.email = ?", Utilisateur.class);
	        query.setParameter(1, email );
	        return query.getResultList();
	    }
	
}
