package fr.eql.al35.wsrest.packaging.service;

import fr.eql.al35.wsrest.packaging.entity.Colis;

public interface ColisIService {
	
	public Colis getColisById(Integer id);
	public Colis getFinalWeight(Colis colis);

}
