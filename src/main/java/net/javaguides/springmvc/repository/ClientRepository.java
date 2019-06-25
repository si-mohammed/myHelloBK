package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Integer>, ClientDao {

}
