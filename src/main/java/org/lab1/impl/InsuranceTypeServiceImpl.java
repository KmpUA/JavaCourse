package org.lab1.impl;

import org.lab1.entities.Insurance;
import org.lab1.entities.InsuranceType;
import org.lab1.services.InsuranceTypeService;

import java.util.Comparator;
import java.util.List;

public class InsuranceTypeServiceImpl implements InsuranceTypeService {

	@Override
	public List<InsuranceType> getInsuranceTypes(Insurance insurance) {
		return insurance.getTypes();
	}

	@Override
	public void updateInsuranceTypes(Insurance insurance, List<InsuranceType> updatedTypes) {
		insurance.setTypes(updatedTypes);
	}

	@Override
	public void sortInsuranceTypesByMonthPayment(List<InsuranceType> types) {
		types.sort(Comparator.comparingDouble(InsuranceType::getMonthPayment));
	}

	@Override
	public void sortInsuranceTypesByName(List<InsuranceType> types) {
		types.sort(Comparator.comparing(InsuranceType::getType));
	}
}
