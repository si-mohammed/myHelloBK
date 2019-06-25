package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.DemandeInscription;

@Repository("demandeInscriptionRepository")
public interface DemandeInscriptionRepository extends JpaRepository<DemandeInscription, Integer> {

}
