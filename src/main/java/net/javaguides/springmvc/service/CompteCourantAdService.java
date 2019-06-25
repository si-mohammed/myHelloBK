package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.CompteCourantAd;
import net.javaguides.springmvc.exception.ResourceNotFoundException;

public interface CompteCourantAdService {

	public List<CompteCourantAd> getCompteCourantAds();

	public void saveCompteCourantAd(CompteCourantAd theCompteCourantAd);

	public CompteCourantAd getCompteCourantAd(int theId) throws ResourceNotFoundException;

	public void deleteCompteCourantAd(int theId) throws ResourceNotFoundException;
	
}
