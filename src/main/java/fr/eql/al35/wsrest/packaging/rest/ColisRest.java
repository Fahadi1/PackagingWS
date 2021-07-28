package fr.eql.al35.wsrest.packaging.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.eql.al35.wsrest.packaging.entity.Colis;
import fr.eql.al35.wsrest.packaging.request.ColisRequest;
import fr.eql.al35.wsrest.packaging.response.ColisResponse;
import fr.eql.al35.wsrest.packaging.service.ColisIService;

@RestController
@RequestMapping(value="/api-colis", headers="Accept=application/json")
public class ColisRest {	

	@Autowired
	private ColisIService colisService;

	@GetMapping("/colis/{idColis}") // http://localhost:8087/api-colis/colis/{id}
	public Colis getColis(@PathVariable("idColis") Integer idColis) {
		System.out.println("sysout du getColis");
		return colisService.getColisById(idColis);
	}

	@SuppressWarnings("unused")
	@PostMapping("/weight/") // http://localhost:8087/weight/ 
	public ColisResponse getWeigth(@RequestBody ColisRequest colisRequest) {
		System.out.println("méthode POST");
		Colis colis = new Colis();
		BeanUtils.copyProperties(colisRequest, colis);

		ColisResponse response = new ColisResponse();
		//n'appelle pas le service si le poids entré est null ou trop lourd
		if (colis.getInitialWeight() == 0 || colis.getInitialWeight() >= 70 ) {
			response.setMessage("Poids incorrect");
			return response;	
		} else 
			BeanUtils.copyProperties(colisService.getFinalWeight(colis), response);
		response.setMessage("OK");
		response.setSize(colis.getParcel().getSize()); 
		return response;
	}
}


