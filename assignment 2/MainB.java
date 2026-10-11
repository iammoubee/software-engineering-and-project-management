
import java.util.Scanner;

class Employee {
    int salary; // Instance variable

    Employee(int salary) {
        this.salary = salary;
    }

    void display(int inputBonus) {
        int bonus = inputBonus; // Local variable

        System.out.println("\nInside display() Method:");
        System.out.println("Salary (Instance Variable): " + salary);
        System.out.println("Bonus (Local Variable): " + bonus);

        class Report { // Local inner class
            void show() {
                System.out.println("Report: Employee salary is " + salary);
            }
        }

        Report r = new Report();

        System.out.println("\nReport Object Created");
        System.out.println("Report Identity Hash Code: "
                + System.identityHashCode(r));

        r.show();
    }
}

public class MainB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        int salary = sc.nextInt();

        System.out.print("Enter bonus: ");
        int bonus = sc.nextInt();

        Employee e = new Employee(salary);

        System.out.println("\nEmployee Object Created");
        System.out.println("Employee Identity Hash Code: "
                + System.identityHashCode(e));

        e.display(bonus);

        sc.close();
    }
}
