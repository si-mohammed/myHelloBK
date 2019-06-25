package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.Compte;

@Repository("compteRepository")
public interface CompteRepository extends JpaRepository<Compte, Integer>, CompteDao {

}
