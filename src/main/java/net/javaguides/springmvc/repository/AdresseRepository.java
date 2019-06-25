package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.Adresse;

@Repository("adresseRepository")
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

}
