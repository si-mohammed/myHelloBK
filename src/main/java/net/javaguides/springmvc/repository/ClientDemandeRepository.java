package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.ClientDemande;

@Repository("clientDemandeRepository")
public interface ClientDemandeRepository extends JpaRepository<ClientDemande, Integer> {

}
