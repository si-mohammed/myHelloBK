package net.javaguides.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springmvc.entity.Adresse;
import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.service.AdresseService;
import net.javaguides.springmvc.service.CustomerService;

@RestController
@RequestMapping("/rest/adresse")
public class AdresseRestController {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(AdresseRestController.class);

	@Autowired
	private AdresseService adresseService;
	

	@RequestMapping(value = "/adresses", method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
    public List<Adresse> getAllAdresses() {
        return adresseService.getAdresses();
    }
}