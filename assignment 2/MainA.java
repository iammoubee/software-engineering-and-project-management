
import java.util.Scanner;

class Student {
    int age; // Instance variable

    Student(int age) {
        this.age = age;
    }

    void display(int inputMarks) {
        int marks = inputMarks; // Local variable

        System.out.println("Instance Variable (age): " + age);
        System.out.println("Local Variable (marks): " + marks);
    }
}

public class MainA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        Student s = new Student(age);

        System.out.println("Student Object Created");
        System.out.println("Object Identity Hash Code: "
                + System.identityHashCode(s));

        s.display(marks);

        sc.close();
    }
}
