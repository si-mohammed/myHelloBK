package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.CompteCourantStd;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface CompteCourantStdService {

	public List<CompteCourantStd> getCompteCourantStds();

	public void saveCompteCourantStd(CompteCourantStd theCompteCourantStd);

	public CompteCourantStd getCompteCourantStd(int theId) throws ResourceNotFoundException;

	public void deleteCompteCourantStd(int theId) throws ResourceNotFoundException;
	
}
