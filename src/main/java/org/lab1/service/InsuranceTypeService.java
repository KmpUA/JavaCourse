package org.lab1.service;

import org.lab1.entity.Insurance;
import org.lab1.entity.InsuranceType;

import java.util.List;

public interface InsuranceTypeService {
	List<InsuranceType> getInsuranceTypes(Insurance insurance);
	void updateInsuranceTypes(Insurance insurance, List<InsuranceType> updatedTypes);

	void sortInsuranceTypesByMonthPayment(List<InsuranceType> types);

	void sortInsuranceTypesByName(List<InsuranceType> types);
}
