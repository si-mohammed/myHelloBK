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

import net.javaguides.springmvc.entity.Administrateur;
import net.javaguides.springmvc.service.AdministrateurService;

@RestController
@RequestMapping("/rest/administrateur")
public class AdministrateurRestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdministrateurRestController.class);

	@Autowired
	private AdministrateurService administrateurService;
	

	@RequestMapping(value = "/administrateurs", method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurService.getAdministrateurs();
    }
}
