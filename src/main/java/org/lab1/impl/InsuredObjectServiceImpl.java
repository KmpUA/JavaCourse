package org.lab1.impl;

import org.lab1.entities.InsuredObject;
import org.lab1.entities.Insurance;
import org.lab1.services.InsuredObjectService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InsuredObjectServiceImpl implements InsuredObjectService {

	@Override
	public List<InsuredObject> getInsuredObjects(Insurance insurance) {
		return insurance.getObjects();
	}

	@Override
	public void updateInsuredObjects(Insurance insurance, List<InsuredObject> updatedObjects) {
		insurance.setObjects(updatedObjects);
	}

	@Override
	public void addInsuredObject(Insurance insurance, InsuredObject insuredObject) {
		List<InsuredObject> insuredObjects = insurance.getObjects();
		insuredObjects.add(insuredObject);
		insurance.setObjects(insuredObjects);
	}

	@Override
	public void removeInsuredObject(Insurance insurance, InsuredObject insuredObject) {
		List<InsuredObject> insuredObjects = insurance.getObjects();
		insuredObjects.remove(insuredObject);
		insurance.setObjects(insuredObjects);
	}

	@Override
	public List<InsuredObject> sortInsuredObjectsByCriteria(Insurance insurance, Comparator<InsuredObject> comparator) {
		return insurance.getObjects()
				.stream()
				.sorted(comparator)
				.collect(Collectors.toList());
	}
}
