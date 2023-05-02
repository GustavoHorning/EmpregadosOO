package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String departmentName = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int payDay = sc.nextInt();
        System.out.print("Email: ");
        sc.nextLine();
        String departmentEmail = sc.nextLine();
        System.out.print("Telefone: ");
        String departmentPhone = sc.nextLine();
        Department department = new Department(departmentName,payDay,new Address(departmentEmail,departmentPhone));

        System.out.println();
        System.out.print("Quantos funcionários tem o departamento?: ");
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.printf("Dados do funcionário %d: \n",i+1);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salário: ");
            double salary = sc.nextDouble();
            department.addEmployee(new Employee(name,salary));
        }
        System.out.println("");
        System.out.println("FOLHA DE PAGAMENTO: ");
        showReport(department);


    }
    private static void showReport(Department dept) {
        System.out.printf("Departamento %s = R$ %.2f\n",dept.getName(),dept.payroll());
        System.out.printf("Pagamento realizado no dia %d\n",dept.getPayDay());
        System.out.println("Funcionários: ");
        for (Employee emp : dept.getEmployees()) {
            System.out.println(emp.getName());
        }
        System.out.printf("Para dúvidas favor entrar em contato: %s\n",dept.getAddress().getEmail());
    }
}
