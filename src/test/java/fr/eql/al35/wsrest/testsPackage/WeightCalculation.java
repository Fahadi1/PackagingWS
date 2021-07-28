package fr.eql.al35.wsrest.testsPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fr.eql.al35.wsrest.packaging.PackagingApplication;
import fr.eql.al35.wsrest.packaging.entity.Colis;
import fr.eql.al35.wsrest.packaging.service.ColisService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PackagingApplication.class})
class WeightCalculation {

	@Autowired
	private ColisService colisService; 

	Colis colis = new Colis();	

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 0.4 kg")
	void UT_weight04() {		
		colis.setInitialWeight(0.4);
		assertEquals(0.5, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 0.5 kg")
	void UT_weight05() {		
		colis.setInitialWeight(0.5);
		assertEquals(0.6, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 0.6 kg")
	void UT_weight06() {		
		colis.setInitialWeight(0.6);
		assertEquals(0.85, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 0.9 kg")
	void UT_weight09() {		
		colis.setInitialWeight(0.9);
		assertEquals(1.15, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 1.0 kg")
	void UT_weight10() {		
		colis.setInitialWeight(1.0);
		assertEquals(1.25, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 1.1 kg")
	void UT_weight11() {		
		colis.setInitialWeight(1.1);
		assertEquals(1.6, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 1.9 kg")
	void UT_weight19() {		
		colis.setInitialWeight(1.9);
		assertEquals(2.4, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 2.0 kg")
	void UT_weight20() {		
		colis.setInitialWeight(2.0);
		assertEquals(2.5, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

	@Test
	@DisplayName("TU Calcul the parcel weight with initial weight 2.1 kg")
	void UT_weight21() {		
		colis.setInitialWeight(2.1);
		assertEquals(3.1, colisService.getFinalWeight(colis).getFinalWeight(), "Incorrect parcel weight");
	}

}
