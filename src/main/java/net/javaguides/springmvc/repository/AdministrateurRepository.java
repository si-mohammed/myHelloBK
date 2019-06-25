package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.Administrateur;

@Repository("administrateurRepository")
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer> {

}
