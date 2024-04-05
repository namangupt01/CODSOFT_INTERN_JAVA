//Create a Student class to represent individual x. Include attributes such as name, roll
//        number, grade, and any other relevant details.
//        Implement a StudentManagementSystem class to manage the collection of x. Include
//        methods to add a student, remove a student, search for a student, and display all x.
//        1.
//        2.
//        3 . Design the user interface for the Student Management System. This can be a console-based
//interface
//        4. Implement methods to read and write student data to a storage medium, such as a file or a
//        database.
//        5. Allow users to interact with the Student Management System by providing options such as
//        adding a new student, editing an existing student's information, searching for a student, displaying all
//        x, and exiting the application.
//        6. Implement input validation to ensure that required fields are not left empty and that the student
//        data is in the correct format
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String name;
    private int rollNo;
    private char grade;
    private int age;
    private char sex;

    // Constructor
    public Student(String name, int rollNo, char grade, int age, char sex) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
        this.age = age;
        this.sex = sex;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}

public class StudentManagementSystem {

    private ArrayList<Student> x; // here i have used the student because it ensure type safety over there
    // and only add the objects of the Student class
  // here x is the instance of the arraylist to perform operations
    // Constructor for this class student management system
    public StudentManagementSystem() {
        x = new ArrayList<>();
    }

    // Method to add a student
    // here i have simply use the inbuilt function of the arraylist class that is .add()
    public void addStudent(Student student) {
        x.add(student);
    }

    // Method to remove a student
    public void removeStudent(Student student) {
        x.remove(student);
    }

    // Method to search for a student
    public Student searchStudent(String name) {
        for (Student student : x) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null; // Return null if not found
    }

    // Method to display all x
    public void displayAllx() {
        for (Student student : x) {
            System.out.println("Name: " + student.getName() + ", Roll No: " + student.getRollNo() +
                    ", Grade: " + student.getGrade() + ", Age: " + student.getAge() + ", Sex: " + student.getSex());
        }

    }
    public void editStudent(String name) {
        Student student = searchStudent(name);
        if (student != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Editing student: " + name);
            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new roll number: ");
            int newRollNo = scanner.nextInt();
            System.out.println("Enter new grade: ");
            char newGrade = scanner.next().charAt(0);
            System.out.println("Enter new age: ");
            int newAge = scanner.nextInt();
            System.out.println("Enter new sex (M/F): ");
            char newSex = scanner.next().charAt(0);
            // Update student information
            student.setName(newName);
            student.setRollNo(newRollNo);
            student.setGrade(newGrade);
            student.setAge(newAge);
            student.setSex(newSex);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student not found.");
        }



    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All x");
            System.out.println("5. Edit Student Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAdding a new student...");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter sex (M/F): ");
                    char sex = scanner.next().charAt(0);
                    sms.addStudent(new Student(name, rollNo, grade, age, sex));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.println("\nRemoving a student...");
                    System.out.print("Enter the name of the student to remove: ");
                    String removeName = scanner.nextLine();
                    Student toRemove = sms.searchStudent(removeName);
                    if (toRemove != null) {
                        sms.removeStudent(toRemove);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("\nSearching for a student...");
                    System.out.print("Enter the name of the student to search: ");
                    String searchName = scanner.nextLine();
                    Student foundStudent = sms.searchStudent(searchName);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println("Name: " + foundStudent.getName() + ", Roll No: " + foundStudent.getRollNo() +
                                ", Grade: " + foundStudent.getGrade() + ", Age: " + foundStudent.getAge() + ", Sex: " + foundStudent.getSex());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("\nDisplaying all x...");
                    sms.displayAllx();
                    break;
                case 5:
                    // Edit Student Information
                    System.out.print("Enter the name of the student to edit: ");
                    String editName = scanner.nextLine();
                    sms.editStudent(editName);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
