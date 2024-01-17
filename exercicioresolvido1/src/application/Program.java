package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("Digite o número de empregados: ");
        int n = sc.nextInt();

        for (int i = 1; i <=n; i++){
            System.out.println("Empregado #" + i +" informações:");
            System.out.println("Tercerizado? Y = sim || N = não");
            char ch = sc.next().charAt(0);

            System.out.println("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Horas: ");
            int hours = sc.nextInt();
            System.out.println("Valor por hora: ");
            double valuePerHour = sc.nextDouble();


            if (ch == 'Y'){
                System.out.println("Valor adicional: ");
                double additionalCharge = sc.nextDouble();
                list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else {
                list.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("Pagamentos: ");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }


    }
}
