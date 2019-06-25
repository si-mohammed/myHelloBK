package net.javaguides.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springmvc.entity.Utilisateur;
import net.javaguides.springmvc.service.UtilisateurService;


@RestController
@RequestMapping("/rest/utilisateur")
public class UtilisateurRestController {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(UtilisateurRestController.class);

	@Autowired
	private UtilisateurService utilisateurService;
	

	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }
	
	@RequestMapping(value = "/addutilisateur", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	
    public void addUtilisateur(@RequestBody Utilisateur utilisateur) {
		
        utilisateurService.saveUtilisateur(utilisateur);
    }
}
