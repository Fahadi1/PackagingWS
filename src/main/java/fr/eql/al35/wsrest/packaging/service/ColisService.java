package fr.eql.al35.wsrest.packaging.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eql.al35.wsrest.packaging.dao.ColisIRepository;
import fr.eql.al35.wsrest.packaging.dao.ParcelIRepository;
import fr.eql.al35.wsrest.packaging.entity.Colis;
import fr.eql.al35.wsrest.packaging.entity.Parcel;

@Service
@Transactional //aller verifier pq là ya un transactionnal 
public class ColisService implements ColisIService {
	
	@Autowired
	private ColisIRepository colisIRepository;
	
	@Autowired
	private ParcelIRepository parcelRepository;

	@Override
	public Colis getColisById(Integer id) {
		return colisIRepository.findById(id).get();
	}

	@Override
	public Colis getFinalWeight(Colis colis) {
		
		if (colis.getInitialWeight() <= 0.5) {
			Parcel parcel = parcelRepository.findById(1).get();
			colis.setParcel(parcel);
			System.out.println(colis.toString());
			colis.setFinalWeight(colis.getInitialWeight() + colis.getParcel().getWeight());
			return colis;
		}

		else if (colis.getInitialWeight() <= 1) {
			Parcel parcel = parcelRepository.findById(2).get();
			colis.setParcel(parcel);
			colis.setFinalWeight(colis.getInitialWeight() + colis.getParcel().getWeight());
			return colis;
		}

		else if (colis.getInitialWeight() <= 2) {
			Parcel parcel = parcelRepository.findById(3).get();
			colis.setParcel(parcel);
			colis.setFinalWeight(colis.getInitialWeight() + colis.getParcel().getWeight());
			return colis;
		}

		else if (colis.getInitialWeight() > 2) {
			Parcel parcel = parcelRepository.findById(4).get();
			colis.setParcel(parcel);
			colis.setFinalWeight(colis.getInitialWeight() + colis.getParcel().getWeight());
			return colis;
		} 
		return null;
	}

}
