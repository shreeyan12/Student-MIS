import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        while (true) {
            System.out.println("==============================");
            System.out.println("Welcome to Student Management System");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Retrieve Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Show All Students");
            System.out.println("7. Save Students");
            System.out.println("8. Exit");
            System.out.println("==============================");
            System.out.print("Please enter your choice (1-8): ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = sc.next();
                        System.out.print("Enter student ID: ");
                        int studentId = sc.nextInt();
                        System.out.print("Enter email: ");
                        String email = sc.next();
                        Student student = new Student(studentId, name, email);
                        sms.addStudent(student);
                        System.out.println("Student added successfully. LCID 00017002809");
                        break;

                    case 2:
                        System.out.print("Enter student ID: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new student name: ");
                        String newName = sc.next();
                        System.out.print("Enter new email: ");
                        String newEmail = sc.next();
                        sms.updateStudent(updateId, newName, newEmail);
                        System.out.println("Student updated successfully. LCID 00017002809");
                        break;

                    case 3:
                        System.out.print("Enter student ID: ");
                        int retrieveId = sc.nextInt();
                        sms.getStudent(retrieveId);
                        System.out.println("Retrieve operation completed. LCID 00017002809");
                        break;

                    case 4:
                        System.out.print("Enter student ID: ");
                        int deleteId = sc.nextInt();
                        sms.deleteStudent(deleteId);
                        System.out.println("Student removed successfully. LCID 00017002809");
                        break;

                    case 5:
                        System.out.print("Enter student ID: ");
                        int studentIdEnroll = sc.nextInt();
                        System.out.print("Enter course ID: ");
                        int courseId = sc.nextInt();
                        sms.enrollStudentInCourse(studentIdEnroll, courseId);
                        System.out.println("Student enrolled in course. LCID 00017002809");
                        break;

                    case 6:
                        sms.showAllStudents();
                        System.out.println("Show all students operation completed. LCID 00017002809");
                        break;

                    case 7:
                        sms.saveStudents();
                        System.out.println("Students data saved successfully. LCID 00017002809");
                        break;


                    case 8:
                        System.out.println("Exiting the system...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Please enter a valid number between 1 and 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
            }
        }
    }
}