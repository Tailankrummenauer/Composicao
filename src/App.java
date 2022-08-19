import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Criando os dados do trabalhador.
        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("----------------------------");

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
                new Department(departmentName)); // instanciando o worker e também o departamento

        // Criando os contratos
        System.out.println("----------------------------");
        System.out.print("How many contracts to this worker: ");
        int n = sc.nextInt();
        System.out.println("----------------------------");
        for (int i = 1; i<= n; i++) {
            System.out.println("Enter contract number #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hour = sc.nextInt();
            System.out.println("---------------");
            HourContract contract = new HourContract(contractDate, valuePerHour, hour);
            worker.addContract(contract); // adicionando o contrato (contract) dentro de weorker com metodo ADD
        }
        System.out.println();
        System.out.println("----------------------------");
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2)); //Conversao do mes e ano para int, procurando o que converter na string.
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("----------------------------");
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartment().getName());
        System.out.println("income for " + monthAndYear + ": " +String.format("%.2f", worker.income(year, month)));
        sc.close();


    }
}
