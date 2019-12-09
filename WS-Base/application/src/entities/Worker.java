package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

/* Importante:
 * Sempre que houver uma associação do tipo "Tem muitos", a mesma é instanciada em
 * em uma lista vazia e não inclusa no construtor principal:
 * 
 */

public class Worker {
	// --- > Atributos:
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	// ----------------------------------------------------------------------- >
	// --- > Associações:
	private Department department;
	// Importante já instanciar a lista:
	private List<HourContract> contracts = new ArrayList<>();

	// ----------------------------------------------------------------------- >
	// --- > Contrutores:
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		// Construtor sem lista:
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	// ----------------------------------------------------------------------- >
	// --- > Getters e Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}
	// ----------------------------------------------------------------------- >
	

}
