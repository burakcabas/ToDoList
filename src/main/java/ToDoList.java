import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static void main(String[] args) {
        // Initialize Scanner for user input and ArrayList to store tasks
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // Main program loop continues until user chooses to exit (choice 5)
        int choice;
        do {
            // Display Menu with options for task management
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Task functionality
                    System.out.print("Enter new task: ");
                    String newTask = scanner.nextLine();
                    tasks.add(newTask);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    // List Tasks functionality
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to display!");
                    } else {
                        System.out.println("Your Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ". " + tasks.get(i));
                        }
                    }
                    break;
                case 3:
                    // Mark Task Done functionality
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to mark done!");
                    } else {
                        System.out.println("Enter the number of the task to mark done:");
                        int taskNumber = scanner.nextInt() - 1; // Adjust for zero-based indexing
                        if (taskNumber >= 0 && taskNumber < tasks.size()) {
                            tasks.set(taskNumber, "[DONE] " + tasks.get(taskNumber)); // Update task with "[DONE]" prefix
                            System.out.println("Task marked done successfully!");
                        } else {
                            System.out.println("Invalid task number!");
                        }
                    }
                    break;
                case 4:
                    // Remove Task functionality
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove!");
                    } else {
                        System.out.println("Enter the number of the task to remove:");
                        int taskNumber = scanner.nextInt() - 1; // Adjust for zero-based indexing
                        if (taskNumber >= 0 && taskNumber < tasks.size()) {
                            tasks.remove(taskNumber);
                            System.out.println("Task removed successfully!");
                        } else {
                            System.out.println("Invalid task number!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);

        scanner.close(); // Close Scanner to avoid resource leaks
    }

    // Assumptions and Limitations:
    // * This program assumes that task descriptions are entered as strings.
    // * It does not support editing existing tasks.
    // * It does not store tasks persistently (e.g., to a file).
    // * The program assumes the user enters valid integers for task numbers (handled with checks).
}
