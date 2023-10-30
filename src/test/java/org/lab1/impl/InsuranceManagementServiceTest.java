package org.lab1.impl;

import org.lab1.entities.Client;
import org.lab1.entities.Worker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.lab1.entities.Insurance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InsuranceManagementServiceTest {

	private InsuranceManagementServiceImpl insuranceManagementService;
	private List<Insurance> insuranceList;

	@BeforeTest
	public void setUp() {
		insuranceList = new ArrayList<>();
		insuranceList.add(createSampleInsurance("John", "Doe", LocalDateTime.of(2004, 7, 10 ,0 ,0), 1000));
		insuranceList.add(createSampleInsurance("Sam", "Smith", LocalDateTime.of(2002, 7, 10 ,0 ,0), 1500));
		insuranceManagementService = new InsuranceManagementServiceImpl(insuranceList);
	}

	@Test
	public void testGetInsuranceList() {
		List<Insurance> retrievedInsuranceList = insuranceManagementService.getInsuranceList();
		Assert.assertEquals(retrievedInsuranceList.size(), insuranceList.size());
	}

	@Test
	public void testFindInsuranceById() {
		UUID idToFind = insuranceList.get(0).getId();
		Insurance foundInsurance = insuranceManagementService.findInsuranceById(idToFind);
		Assert.assertNotNull(foundInsurance);
		Assert.assertEquals(foundInsurance.getId(), idToFind);
	}

	@Test
	public void testSaveInsurance() {
		Insurance newInsurance = createSampleInsurance("Alice", "Johnson", LocalDateTime.of(2001, 7, 10 ,0 ,0), 1200);
		insuranceManagementService.saveInsurance(newInsurance);
		List<Insurance> retrievedInsuranceList = insuranceManagementService.getInsuranceList();
		Assert.assertTrue(retrievedInsuranceList.contains(newInsurance));
	}

	@Test
	public void testUpdateInsurance() {
		Insurance insuranceToUpdate = insuranceList.get(0);
		double updatedSize = 2000.0;
		insuranceToUpdate.setSize(updatedSize);
		insuranceManagementService.updateInsurance(insuranceToUpdate);
		System.out.println(insuranceManagementService.getInsuranceList());
		Insurance updatedInsurance = insuranceManagementService.findInsuranceById(insuranceToUpdate.getId());
		Assert.assertEquals(updatedInsurance.getSize(), updatedSize);
	}

	@Test
	public void testDeleteInsurance() {
		Insurance insuranceToDelete = insuranceList.get(1);
		insuranceManagementService.deleteInsurance(insuranceToDelete);
		List<Insurance> retrievedInsuranceList = insuranceManagementService.getInsuranceList();
		Assert.assertFalse(retrievedInsuranceList.contains(insuranceToDelete));
	}

	public static Insurance createSampleInsurance(String firstName, String lastName, LocalDateTime birthday, double size) {
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
}
