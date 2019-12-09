package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

/* Importante:
 * Sempre que houver uma associa��o do tipo "Tem muitos", a mesma � instanciada em
 * em uma lista vazia e n�o inclusa no construtor principal:
 * 
 */

public class Worker {
	// --- > Atributos:
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	// ----------------------------------------------------------------------- >
	// --- > Associa��es:
	private Department department;
	// Importante j� instanciar a lista:
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

	/*
	 * A lista est� sendo alterada por meio de m�todos, ou seja, ser� alterada
	 * apenas pelos mesmos:
	 * 
	 * public void setContracts(List<HourContract> contracts) { this.contracts =
	 * contracts; }
	 * 
	 */
	// ----------------------------------------------------------------------- >
	// --- > M�todos da classe:

	public void addContract(HourContract contract) {
		// por se tratar de uma lista � executado o comando de adicionar na lista:
		contracts.add(contract);
	}

	public void removerContract(HourContract contract) {
		// por se tratar de uma lista � executado o comando de remover na lista:
		contracts.remove(contract);
	}

	public double income(int year, int month) {

		double sum = baseSalary;
		// Instanciar o calend�rio:
		Calendar cal = Calendar.getInstance();

		for (HourContract c : contracts) {

			cal.setTime(c.getDate());

			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if (c_year == year && c_month == month) {
				sum += c.totalValue();
			}

		}
		return sum;
	}
}
