package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.Utilisateur;

@Repository("utilisateurRepository")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>, UtilisateurDao {

}
