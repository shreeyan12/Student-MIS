import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.ser";

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully. LCID 00017002809");
    }

    public void updateStudent(int studentId, String newName, String newEmail) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                student.setName(newName);
                student.setEmail(newEmail);
                System.out.println("Student updated successfully. LCID 00017002809");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void getStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                students.remove(student);
                System.out.println("Student removed successfully. LCID 00017002809");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void enrollStudentInCourse(int studentId, int courseId) {
        Enrollment enrollment = new Enrollment(studentId, courseId);
        System.out.println("Student enrolled in course. LCID 00017002809");
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Students data saved successfully. LCID 00017002809");
        } catch (IOException e) {
            System.out.println("Error saving students data: " + e.getMessage());
        }
    }
}