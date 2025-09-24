// com.ccrm.main.CCRMConsoleUI.java
package com.ccrm.main;

import com.ccrm.service.CCRMService;
import com.ccrm.util.CourseBuilder;
import com.ccrm.model.Student;
import com.ccrm.model.Course;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CCRMConsoleUI {
    private final CCRMService ccrnService = CCRMService.getInstance();
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void start() {
        System.out.println("Welcome to Campus Course & Records Manager!");
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1":
                        createStudent();
                        break;
                    case "2":
                        createCourse();
                        break;
                    case "3":
                        exportData();
                        break;
                    case "4":
                        importData();
                        break;
                    case "5":
                        listCourses();
                        break;
                    case "6":
                        searchCourses();
                        break;
                    case "7":
                        printCurrentDate();
                        break;
                    case "8":
                        running = false;
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Create a student");
        System.out.println("2. Create a course");
        System.out.println("3. Export students to CSV");
        System.out.println("4. Import students from CSV");
        System.out.println("5. List all courses");
        System.out.println("6. Search for courses");
        System.out.println("7. Print current date");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        ccrnService.addStudent(id, name, email);
        System.out.println("Student created successfully!");
    }

    private void createCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        System.out.print("Enter instructor name (optional): ");
        String instructor = scanner.nextLine();

        // Using the CourseBuilder
        CourseBuilder builder = new CourseBuilder(code).withTitle(title);
        if (!instructor.isEmpty()) {
            builder.withInstructor(instructor);
        }
        ccrnService.createCourse(builder);
        System.out.println("Course created successfully!");
    }

    private void exportData() {
        System.out.print("Enter file path to export students: ");
        String filePath = scanner.nextLine();
        try {
            ccrnService.exportStudentsToCsv(filePath);
            System.out.println("Students exported successfully to " + filePath);
        } catch (Exception e) {
            System.err.println("Export failed: " + e.getMessage());
        }
    }

    private void importData() {
        System.out.print("Enter file path to import students: ");
        String filePath = scanner.nextLine();
        try {
            ccrnService.importStudentsFromCsv(filePath);
            System.out.println("Students imported successfully from " + filePath);
        } catch (Exception e) {
            System.err.println("Import failed: " + e.getMessage());
        }
    }

    private void listCourses() {
        System.out.println("\n--- All Courses ---");
        // This is where you would call a ccrnService method to get and print all courses
        // For this example, we will assume a method getCourses() exists in the service.
        System.out.println("List of courses not implemented in this sample.");
    }

    private void searchCourses() {
        System.out.print("Enter keyword to search for courses: ");
        String keyword = scanner.nextLine();
        List<Course> results = ccrnService.searchCourses(keyword);
        if (results.isEmpty()) {
            System.out.println("No courses found for keyword '" + keyword + "'.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void printCurrentDate() {
        System.out.println("Current Date: " + dtf.format(LocalDate.now()));
    }

    public static void main(String[] args) {
        new CCRMConsoleUI().start();
    }
}
