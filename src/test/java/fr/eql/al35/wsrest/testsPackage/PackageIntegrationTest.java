package fr.eql.al35.wsrest.testsPackage;


import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import fr.eql.al35.wsrest.packaging.PackagingApplication;
import fr.eql.al35.wsrest.packaging.entity.Colis;
import fr.eql.al35.wsrest.packaging.response.ColisResponse;
import fr.eql.al35.wsrest.service.RestTemplateHeaderModifierInterceptor;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PackagingApplication.class})
class PackageIntegrationTest {

	private static RestTemplate restTemplate;
	private String  baseUrlWsPoids = "http://localhost:8087/api-colis/weight/";
	private URI url = URI.create(baseUrlWsPoids);

	@BeforeAll
	public static void Init() {
		restTemplate = initRestTemplate();
	} 

	public static RestTemplate initRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		}
		interceptors.add(new RestTemplateHeaderModifierInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@DisplayName("TI Verify that the message is OK with a correct initial weight")
	@Test
	void TI_MessageOK() {
		Colis colis = new Colis();
		colis.setInitialWeight(0.4);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertEquals("OK", colisresponse.getMessage());
	} 


	@DisplayName("Verify the finalWeight is not null")
	@Test
	public void TestFinalWeightNotNull()
	{
		Colis colis = new Colis();
		colis.setInitialWeight(0.4);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertNotNull(colisresponse.getFinalWeight());		
	}
	
	@DisplayName("Verify the size is not null")
	@Test
	public void TestSizeNotNull()
	{
		Colis colis = new Colis();
		colis.setInitialWeight(0.4);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertNotNull(colisresponse.getSize());		
	}
	
	@DisplayName("Verify the message is not null")
	@Test
	public void TestMessageNotNull()
	{
		Colis colis = new Colis();
		colis.setInitialWeight(0.4);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertNotNull(colisresponse.getMessage());		
	}	
	
	
	@DisplayName("Verify the finalWeight is null with a 0.0 parcel weight")
	@Test
	public void FinalWeightNullWithWeight_0()
	{
		Colis colis = new Colis();
		colis.setInitialWeight(0.0);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertNull(colisresponse.getFinalWeight());		
	}	
	
	@DisplayName("Verify the size is null with a 0.0 parcel weight")
	@Test
	public void SizeNullWithWeight_0()
	{
		Colis colis = new Colis();
		colis.setInitialWeight(0.0);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertNull(colisresponse.getFinalWeight());		
	}
	

	@DisplayName("TI Verify that the message is OK with a correct initial weight2")
	@Test
	void TI_MessageType() {
		Colis colis = new Colis();
		colis.setInitialWeight(0.5);
		String observedData = restTemplate.postForObject(url, colis, String.class);
		String expectedJson = "{\"initialWeight\":0.5,\"finalWeight\":0.6,\"size\":\"small\",\"message\":\"OK\"}";
		try {
			JSONAssert.assertEquals(expectedJson, observedData, true);
		} catch (JSONException e) {			
			e.printStackTrace();
		}
	} 

	@DisplayName("TI Verify that the message is KO with a 0.0 initial weight")
	@Test
	void TI_MessageKO_1() {
		Colis colis = new Colis();
		colis.setInitialWeight(0.0);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertEquals("Poids incorrect", colisresponse.getMessage());
	}

	@DisplayName("TI Verify that the message is KO with a > 70 initial weight")
	@Test
	void TI_MessageKO_2() {
		Colis colis = new Colis();
		colis.setInitialWeight(70.0);
		ColisResponse colisresponse;
		colisresponse = restTemplate.postForObject(url, colis, ColisResponse.class);
		System.out.println(colisresponse);
		assertEquals("Poids incorrect", colisresponse.getMessage());
	}

}
