package org.lab1.impl;

import org.lab1.service.impl.InsuranceTypeServiceImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.lab1.entity.Insurance;
import org.lab1.entity.InsuranceType;
import org.lab1.service.InsuranceTypeService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.lab1.impl.InsuranceManagementServiceTest.createSampleInsurance;

public class InsuranceTypesServiceImplTest {

	private InsuranceTypeService insuranceTypeService;
	private Insurance insurance;

	@BeforeTest
	public void setUp() {
		insuranceTypeService = new InsuranceTypeServiceImpl();
		insurance = createSampleInsurance("John", "Doe", LocalDateTime.of(2004, 7, 10 ,0 ,0), 1000);
	}

	@Test
	public void testGetInsuranceTypes() {
		List<InsuranceType> insuranceTypes = insuranceTypeService.getInsuranceTypes(insurance);
		assert insuranceTypes != null;
	}

	@Test
	public void testUpdateInsuranceTypes() {
		List<InsuranceType> updatedTypes = createSampleInsuranceTypes();

		insuranceTypeService.updateInsuranceTypes(insurance, updatedTypes);

		List<InsuranceType> insuranceTypes = insuranceTypeService.getInsuranceTypes(insurance);
		assert insuranceTypes != null;
		assert insuranceTypes.size() == updatedTypes.size();
	}

	private List<InsuranceType> createSampleInsuranceTypes() {
		List<InsuranceType> insuranceTypes = new ArrayList<>();
		insuranceTypes.add(new InsuranceType("Type1", "123", 500.0));
		insuranceTypes.add(new InsuranceType("Type2", "321", 750.0));
		return insuranceTypes;
	}
}
