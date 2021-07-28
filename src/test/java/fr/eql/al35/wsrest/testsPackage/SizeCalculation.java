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

class SizeCalculation {

	@Autowired
	private ColisService colisService;

	Colis colis = new Colis();

	@Test
	@DisplayName("TU Verify the parcel size is small with initial weight 0.4 kg")	
	void TU_CalculSize_04_small() {		
		colis.setInitialWeight(0.4);
		assertEquals("small", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is small with initial weight 0.5kg")
	void TU_CalculSize_05_small() {
		colis.setInitialWeight(0.5);
		assertEquals("small", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is medium with initial weight 0.6kg")
	void TU_CalculSize_06_medium() {
		colis.setInitialWeight(0.6);
		assertEquals("medium", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is medium with initial weight 0.9kg")
	void TU_CalculSize_09_medium() {
		colis.setInitialWeight(0.9);
		assertEquals("medium", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is medium with initial weight 0.9g")
	void TU_CalculSize_1_medium() {
		colis.setInitialWeight(0.9);
		assertEquals("medium", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is medium with initial weight 1.0g")
	void TU_CalculSize_11_medium() {
		colis.setInitialWeight(1.0);
		assertEquals("medium", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is large with initial weight 1.2kg")
	void TU_CalculSize_12_large() {
		colis.setInitialWeight(1.2);
		assertEquals("large", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is large with initial weight 1.9kg")
	void TU_CalculSize_19_large() {
		colis.setInitialWeight(1.9);
		assertEquals("large", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is large with initial weight 2.0kg")
	void TU_CalculSize_2_large() {
		colis.setInitialWeight(2.0);
		assertEquals("large", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}

	@Test
	@DisplayName("TU Verify the parcel size is kingsize with initial weight 2.1kg")
	void TU_CalculSize_21_large() {
		colis.setInitialWeight(2.1);
		assertEquals("kingsize", colisService.getFinalWeight(colis).getParcel().getSize(), "Incorrect parcel size");
	}
}
