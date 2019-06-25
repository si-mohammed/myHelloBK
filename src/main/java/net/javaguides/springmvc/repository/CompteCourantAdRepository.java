package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.CompteCourantAd;

@Repository("CompteCourantAdRepository")
public interface CompteCourantAdRepository extends JpaRepository<CompteCourantAd, Integer> {

}
