package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// -------------------------------------------------------------------- >
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();

		System.out.println("Enter worker data:");

		System.out.print("Name: ");
		String workerName = sc.nextLine();

		System.out.print("Level: ");
		String workerLevel = sc.nextLine();

		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		// instanciamento do funcion�rio que vai receber os atributos
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));
		// --- > Worker � uma classe enumerada, logo h� a necessidade de convers�o de
		// valores:
		// --- > Deparment � uma classe, logo h� a necessidade de instancia��o da mesma
		// mesma para receber os valores:

		// -------------------------------------------------------------------- >
		System.out.print("How many contracts to this worker? ");
		int N = sc.nextInt();
		// -------------------------------------------------------------------- >
		for (int i = 1; i <= N; i++) {
			System.out.println("Enter contract #" + i + " data:");

			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());

			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();

			System.out.print("Duration (hours):");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			worker.addContract(contract);

		}
		// -------------------------------------------------------------------- >
		// -------------------------------------------------------------------- >
		sc.close();

	}

}
