package app;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entitiesEnum.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        System.out.print("Name: ");
        String workerName = sc.nextLine();

        System.out.print("Level; ");
        String level = sc.nextLine();

        System.out.print("Base salary: ");
        double salary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(level),salary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();


        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(int i = 1; i <= n; i++){
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Data (DD/MM/YYYY): " );

            sc.nextLine();
            String dmy = sc.next();
            LocalDate date = LocalDate.parse(dmy,df);

            System.out.print("Value por hour: ");
            double valueHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int duration = sc.nextInt();

            HourContract contract = new HourContract(date, valueHour, duration);

            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): " );
        sc.nextLine();
        String monthAndYear = sc.next();

        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));


        System.out.println("Name: " +worker.getName());
        System.out.println("Department: " +worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));





        sc.close();
    }
}
