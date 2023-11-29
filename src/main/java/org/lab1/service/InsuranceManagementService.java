package org.lab1.service;

import org.lab1.entity.Insurance;

import java.util.List;
import java.util.UUID;

public interface InsuranceManagementService {
	List<Insurance> getInsuranceList();
	Insurance findInsuranceById(UUID id);
	void sortByClientName();
	void sortBySize();
	void saveInsurance(Insurance insurance);
	void updateInsurance(Insurance insurance);
	void deleteInsurance(Insurance insurance);
}
