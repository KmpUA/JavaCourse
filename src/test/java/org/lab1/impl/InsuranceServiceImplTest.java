package org.lab1.impl;

import org.lab1.services.InsuranceService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.lab1.entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class InsuranceServiceImplTest {

	private InsuranceService insuranceService;
	private Insurance insurance;

	@BeforeClass
	public void setUp() {
		insuranceService = new InsuranceServiceImpl();
		Client client = new Client.Builder("John", "Doe", LocalDateTime.parse("2000-10-10T19:34:50.63")).build();
		List<InsuredObject> objects = new ArrayList<>();
		List<InsuranceType> types = new ArrayList<>();
		Worker worker = new Worker.Builder("Alice", "Doe", LocalDateTime.parse("1990-10-11T19:34:50.63")).build();
		Date term = new Date();
		double size = 1000.0;
		insurance = new Insurance(UUID.randomUUID(), client, objects, types, worker, term, size);
	}

	@Test
	public void testAddInsuredObject() {
		InsuredObject insuredObject = new InsuredObject("Sock", "Sock of my granddad from WWII");
		insuranceService.addInsuredObject(insurance, insuredObject);

		List<InsuredObject> insuredObjects = insurance.getObjects();
		Assert.assertTrue(insuredObjects.contains(insuredObject));
	}

	@Test
	public void testRemoveInsuredObject() {
		InsuredObject insuredObject = new InsuredObject("House", "One room flat located in some village");
		insuranceService.addInsuredObject(insurance, insuredObject);

		List<InsuredObject> insuredObjects = insurance.getObjects();
		Assert.assertTrue(insuredObjects.contains(insuredObject));

		insuranceService.removeInsuredObject(insurance, insuredObject);
		insuredObjects = insurance.getObjects();
		Assert.assertFalse(insuredObjects.contains(insuredObject));
	}

	@Test
	public void testUpdateInsuredObjects() {
		List<InsuredObject> updatedObjects = new ArrayList<>();
		InsuredObject updatedObject1 = new InsuredObject("Updated Car", "BMW M5 F90");
		InsuredObject updatedObject2 = new InsuredObject("Updated House", "400m^2 house somewhere in Italy");
		updatedObjects.add(updatedObject1);
		updatedObjects.add(updatedObject2);

		insuranceService.updateInsuredObjects(insurance, updatedObjects);
		List<InsuredObject> insuredObjects = insuranceService.getInsuredObjects(insurance);

		Assert.assertTrue(insuredObjects.contains(updatedObject1));
	}

	@Test
	public void testGetInsuredObjects() {
		List<InsuredObject> insuredObjects = insuranceService.getInsuredObjects(insurance);
		Assert.assertEquals(insurance.getObjects(), insuredObjects);
	}
	@Test
	public void testGetInsuranceTypes() {
		List<InsuranceType> insuredTypes = insuranceService.getInsuranceTypes(insurance);
		Assert.assertEquals(insurance.getTypes(), insuredTypes);
	}

	@Test
	public void testUpdateInsuranceTypes() {
		List<InsuredObject> updatedObjects = new ArrayList<>();
		InsuredObject updatedObject1 = new InsuredObject("Updated Car", "BMW M5 F90");
		InsuredObject updatedObject2 = new InsuredObject("Updated House", "400m^2 house somewhere in Italy");
		updatedObjects.add(updatedObject1);
		updatedObjects.add(updatedObject2);

		insuranceService.updateInsuredObjects(insurance, updatedObjects);
		List<InsuredObject> insuredObjects = insuranceService.getInsuredObjects(insurance);

		Assert.assertTrue(insuredObjects.contains(updatedObject1));
	}

	@Test
	public void testSaveInsurance() {
		insuranceService.saveInsurance(insurance);
		Assert.assertTrue(insuranceService.getInsuranceList().contains(insurance));
	}

	@Test
	public void testFindInsuranceById() {
		insuranceService.saveInsurance(insurance);
		Insurance foundInsurance = insuranceService.findInsuranceById(insurance.getId());
		Assert.assertEquals(foundInsurance, insurance);
	}

	@Test
	public void testUpdateInsurance() {
		Client updatedClient = new Client.Builder("Jane", "Smith", LocalDateTime.parse("2001-11-10T19:34:50.63")).build();
		insurance.setClient(updatedClient);
		insuranceService.updateInsurance(insurance);
		Insurance updatedInsurance = insuranceService.findInsuranceById(insurance.getId());
		Assert.assertEquals(updatedInsurance.getClient(), updatedClient);
	}

	@Test
	public void testDeleteInsurance() {
		insuranceService.deleteInsurance(insurance);
		Insurance deletedInsurance = insuranceService.findInsuranceById(insurance.getId());
		Assert.assertNull(deletedInsurance);
	}
}
