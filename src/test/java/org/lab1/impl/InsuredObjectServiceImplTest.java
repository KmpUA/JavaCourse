package org.lab1.impl;

import org.lab1.entities.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.lab1.services.InsuredObjectService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class InsuredObjectServiceImplTest {

	private InsuredObjectService insuredObjectService;
	private Insurance insurance;
	private List<InsuredObject> insuredObjects;

	@BeforeTest
	public void setUp() {
		insuredObjectService = new InsuredObjectServiceImpl();
		insurance = createSampleInsurance("John", "Doe", LocalDateTime.of(2004, 7, 10 ,0 ,0), 1000);
		insuredObjects = insurance.getObjects();
	}

	@Test
	public void testGetInsuredObjects() {
		List<InsuredObject> retrievedObjects = insuredObjectService.getInsuredObjects(insurance);
		Assert.assertEquals(retrievedObjects, insuredObjects, "Retrieved insured objects do not match expected insured objects.");
	}

	@Test
	public void testUpdateInsuredObjects() {
		List<InsuredObject> updatedObjects = createUpdatedInsuredObjects();
		insuredObjectService.updateInsuredObjects(insurance, updatedObjects);

		List<InsuredObject> retrievedObjects = insuredObjectService.getInsuredObjects(insurance);
		Assert.assertEquals(retrievedObjects, updatedObjects, "Updated insured objects do not match retrieved insured objects.");
	}

	@Test
	public void testAddInsuredObject() {
		InsuredObject newInsuredObject = createNewInsuredObject();
		insuredObjectService.addInsuredObject(insurance, newInsuredObject);

		List<InsuredObject> retrievedObjects = insuredObjectService.getInsuredObjects(insurance);
		Assert.assertTrue(retrievedObjects.contains(newInsuredObject), "New insured object was not added.");
	}

	@Test
	public void testRemoveInsuredObject() {
		InsuredObject insuredObjectToRemove = insuredObjects.get(0);
		insuredObjectService.removeInsuredObject(insurance, insuredObjectToRemove);

		List<InsuredObject> retrievedObjects = insuredObjectService.getInsuredObjects(insurance);
		Assert.assertFalse(retrievedObjects.contains(insuredObjectToRemove), "Insured object was not removed.");
	}

	@Test
	public void testSortInsuredObjectsByValue() {
		Comparator<InsuredObject> sortByValue = Comparator.comparing(InsuredObject::getId);
		List<InsuredObject> sortedByValue = insuredObjectService.sortInsuredObjectsByCriteria(insurance, sortByValue);

		assertSortedById(sortedByValue);
	}

	@Test
	public void testSortInsuredObjectsByName() {
		Comparator<InsuredObject> sortByName = Comparator.comparing(InsuredObject::getName);
		List<InsuredObject> sortedByName = insuredObjectService.sortInsuredObjectsByCriteria(insurance, sortByName);

		assertSortedByName(sortedByName);
	}

	private void assertSortedById(List<InsuredObject> sortedList) {
		for (int i = 1; i < sortedList.size(); i++) {
			assert sortedList.get(i - 1).getId().compareTo(sortedList.get(i).getId()) <= 0;
		}
	}

	private void assertSortedByName(List<InsuredObject> sortedList) {
		for (int i = 1; i < sortedList.size(); i++) {
			assert sortedList.get(i - 1).getName().compareTo(sortedList.get(i).getName()) <= 0;
		}
	}

	private Insurance createSampleInsurance(String firstName, String lastName, LocalDateTime birthday, double size) {
		return Insurance.builder()
				.id(UUID.randomUUID())
				.client(new Client.Builder(firstName, lastName, birthday).build())
				.objects(new ArrayList<>())
				.types(new ArrayList<>())
				.worker(new Worker.Builder(lastName, firstName, birthday.minusDays(10000)).build())
				.term(LocalDateTime.now())
				.size(size)
				.build();
	}

	private List<InsuredObject> createUpdatedInsuredObjects() {
		List<InsuredObject> updatedObjects = new ArrayList<>();
		updatedObjects.add(new InsuredObject("Updated Car", "BMW F90 Competition"));
		updatedObjects.add(new InsuredObject("Updated House", "Villa in Sorento with Euro remont"));
		return updatedObjects;
	}

	private InsuredObject createNewInsuredObject() {
		return new InsuredObject("New Object", "Something");
	}
}

