package org.lab1.impl;

import org.lab1.entities.Insurance;
import org.lab1.services.InsuranceManagementService;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class InsuranceManagementServiceImpl implements InsuranceManagementService {

	private final List<Insurance> insuranceList;

	public InsuranceManagementServiceImpl(List<Insurance> insurances){
		this.insuranceList = insurances;
	}

	@Override
	public List<Insurance> getInsuranceList() {
		return insuranceList;
	}

	@Override
	public Insurance findInsuranceById(UUID id) {
		for (Insurance insurance : insuranceList) {
			if (insurance.getId().equals(id)) {
				return insurance;
			}
		}
		return null;
	}
	@Override
	public void sortByClientName() {
		insuranceList.sort((ins1, ins2) -> ins1.getClient().getFullName().compareTo(ins2.getClient().getFullName()));
	}

	@Override
	public void sortBySize() {
		Collections.sort(insuranceList);
	}

	@Override
	public void saveInsurance(Insurance insurance) {
		insuranceList.add(insurance);
	}

	@Override
	public void updateInsurance(Insurance updatedInsurance) {
		if(findInsuranceById(updatedInsurance.getId()).getId() != null){
			Insurance updatedRecord =  Insurance.builder()
					.id(updatedInsurance.getId())
					.client(updatedInsurance.getClient())
					.objects(updatedInsurance.getObjects())
					.types(updatedInsurance.getTypes())
					.worker(updatedInsurance.getWorker())
					.term(updatedInsurance.getTerm())
					.size(updatedInsurance.getSize())
					.build();
			insuranceList.set(insuranceList.indexOf(insuranceList.stream().filter(insurance -> insurance.getId() == updatedInsurance.getId()).toList().get(0)), updatedRecord);
		}
		else {
			throw new IllegalArgumentException("Insurance with ID " + updatedInsurance.getId() + " not found");
		}
	}

	@Override
	public void deleteInsurance(Insurance insurance) {
		insuranceList.remove(insurance);
	}
}
