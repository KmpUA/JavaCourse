package org.lab1.services;

import org.lab1.entities.InsuredObject;
import org.lab1.entities.Insurance;

import java.util.Comparator;
import java.util.List;

public interface InsuredObjectService {
	List<InsuredObject> getInsuredObjects(Insurance insurance);
	void updateInsuredObjects(Insurance insurance, List<InsuredObject> updatedObjects);
	void addInsuredObject(Insurance insurance, InsuredObject insuredObject);
	void removeInsuredObject(Insurance insurance, InsuredObject insuredObject);
	List<InsuredObject> sortInsuredObjectsByCriteria(Insurance insurance, Comparator<InsuredObject> comparator);
}
