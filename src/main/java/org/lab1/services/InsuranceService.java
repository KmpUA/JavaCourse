package org.lab1.services;

import org.lab1.entities.Insurance;
import org.lab1.entities.InsuredObject;
import org.lab1.entities.InsuranceType;

import java.util.List;
import java.util.UUID;

public interface InsuranceService {
	List<Insurance> getInsuranceList();
	List<InsuredObject> getInsuredObjects(Insurance insurance);

	void updateInsuredObjects(Insurance insurance, List<InsuredObject> updatedObjects);

	List<InsuranceType> getInsuranceTypes(Insurance insurance);

	void updateInsuranceTypes(Insurance insurance, List<InsuranceType> updatedTypes);

	Insurance findInsuranceById(UUID id);

	void saveInsurance(Insurance insurance);

	void updateInsurance(Insurance insurance);

	void deleteInsurance(Insurance insurance);
	void addInsuredObject(Insurance insurance, InsuredObject insuredObject);
	void removeInsuredObject(Insurance insurance, InsuredObject insuredObject);
}
