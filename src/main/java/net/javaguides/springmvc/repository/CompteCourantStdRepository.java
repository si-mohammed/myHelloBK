package net.javaguides.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.entity.CompteCourantStd;

@Repository("CompteCourantStdRepository")
public interface CompteCourantStdRepository extends JpaRepository<CompteCourantStd, Integer> {

}
