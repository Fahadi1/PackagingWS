package fr.eql.al35.wsrest.packaging.dao;

import org.springframework.data.repository.CrudRepository;

import fr.eql.al35.wsrest.packaging.entity.Parcel;

public interface ParcelIRepository extends CrudRepository<Parcel, Integer>{
	

}
