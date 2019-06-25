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

import net.javaguides.springmvc.entity.ClientDemande;
import net.javaguides.springmvc.service.ClientDemandeService;


@RestController
@RequestMapping("/rest")
public class ClientDemandeRestController {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientDemandeRestController.class);

	@Autowired
	private ClientDemandeService clientDemandeService;
	

	@RequestMapping(value = "/clientDemandes", method = RequestMethod.GET,  produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
    public List<ClientDemande> getAllClientDemandes() {
        return clientDemandeService.getClientDemandes();
    }

}
