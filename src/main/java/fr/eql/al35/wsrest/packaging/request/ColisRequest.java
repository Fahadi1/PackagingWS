package fr.eql.al35.wsrest.packaging.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString

public class ColisRequest {
	
	private Double initialWeight;
	private Double finalWeight;	
	private String parcel;
}
