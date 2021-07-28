package fr.rql.al35.wsrest.packaging.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CalcColis implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;	
	private Double initialWeight;
	private Double finalWeight;	
	private String parcel;

}
