package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.CompteRemunere;

@Repository("compteRemunereRepository")
public interface CompteRemunereRepository extends JpaRepository<CompteRemunere, Integer> {

}
