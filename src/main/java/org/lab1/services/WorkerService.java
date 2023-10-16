package org.lab1.services;

import org.lab1.entities.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WorkerService {
	private final List<Worker> workers;

	public WorkerService(List<Worker> Workers) {
		this.workers = Workers;
	}

	public List<Worker> sortWorkersWithStream(){
		return workers.stream()
				.sorted()
				.collect(Collectors.toList());
	}

	public List<Worker> sortWorkers(){
		List<Worker> result = new ArrayList<>(List.copyOf(workers));
		Collections.sort(result, new Comparator<Worker>() {
			@Override
			public int compare(Worker o1, Worker o2) {
				if (o1.getFirstName().charAt(0) != o2.getFirstName().charAt(0))
					return o1.getFirstName().charAt(0) - o2.getFirstName().charAt(0);
				else return o1.getLastName().charAt(0) - o2.getLastName().charAt(0);
			}
		});
		return result;
	}

	public List<Worker> sortWorkersByAgeWithStream(){
		return workers.stream()
				.sorted((c1, c2) -> c2.getBirthdate().compareTo(c1.getBirthdate()))
				.collect(Collectors.toList());
	}

	public List<Worker> sortWorkersByAge(){
		List<Worker> result = new ArrayList<>(List.copyOf(workers));
		result.sort(new Comparator<Worker>() {
			@Override
			public int compare(Worker o1, Worker o2) {
				return o2.getBirthdate().compareTo(o1.getBirthdate());
			}
		});
		return result;
	}
}
