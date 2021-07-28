package fr.eql.al35.wsrest.packaging.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @ToString

public class ColisResponse {
	
	private Double initialWeight;
	private Double finalWeight;	
	private String size;
	private String message; 
}
