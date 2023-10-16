package org.lab1.impl;

import org.lab1.entities.Insurance;
import org.lab1.entities.InsuredObject;
import org.lab1.entities.InsuranceType;
import org.lab1.services.InsuranceService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InsuranceServiceImpl implements InsuranceService {

	private final List<Insurance> insuranceList = new ArrayList<>();

	@Override
	public List<InsuredObject> getInsuredObjects(Insurance insurance) {
		return insurance.getObjects();
	}

	@Override
	public void updateInsuredObjects(Insurance insurance, List<InsuredObject> updatedObjects) {
		insurance.setObjects(updatedObjects);
	}

	@Override
	public List<InsuranceType> getInsuranceTypes(Insurance insurance) {
		return insurance.getTypes();
	}

	@Override
	public void updateInsuranceTypes(Insurance insurance, List<InsuranceType> updatedTypes) {
		insurance.setTypes(updatedTypes);
	}

	@Override
	public Insurance findInsuranceById(UUID id) {
		return insuranceList.stream()
				.filter(insurance -> insurance.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public void saveInsurance(Insurance insurance) {
		insuranceList.add(insurance);
	}

	@Override
	public void updateInsurance(Insurance updatedInsurance) {
		for (int i = 0; i < insuranceList.size(); i++) {
			Insurance insurance = insuranceList.get(i);
			if (insurance.getId().equals(updatedInsurance.getId())) {
				insuranceList.set(i, updatedInsurance);
				return;
			}
		}
	}

	@Override
	public void deleteInsurance(Insurance insurance) {
		insuranceList.remove(insurance);
	}

	@Override
	public void addInsuredObject(Insurance insurance, InsuredObject insuredObject) {
		insurance.getObjects().add(insuredObject);
	}

	@Override
	public void removeInsuredObject(Insurance insurance, InsuredObject insuredObject) {
		insurance.getObjects().remove(insuredObject);
	}

	public List<Insurance> getInsuranceList(){
		return this.insuranceList;
	}
}
