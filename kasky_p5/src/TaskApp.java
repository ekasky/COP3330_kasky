import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskApp extends TaskList {

    private static void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Create a new list");
        System.out.println("2. Load a existing list");
        System.out.println("3. Quit");
        System.out.print("> ");
    }

    private static void taskMenu() {
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1. View the List");
        System.out.println("2. Add a item");
        System.out.println("3. Edit a item");
        System.out.println("4. Remove a item");
        System.out.println("5. Mark an item as complete");
        System.out.println("6. Un-mark am item as complete");
        System.out.println("7. Save the current list");
        System.out.println("8. Quit to main menu");
        System.out.print("> ");
    }

    private void taskLoop() {

        int run, index;
        String title, description, date, filename;

        do {

            taskMenu();
            run = App.getInteger();

            switch (run) {

                case 1:
                    printList();
                    break;

                case 2:

                    System.out.print("Task Title: ");
                    title = input.nextLine();

                    System.out.print("Task Description: ");
                    description = input.nextLine();

                    System.out.print("Due Date (YYYY-MM-DD): ");
                    date = input.nextLine();

                    addTask(title, description, date, false);

                    break;

                case 3:

                    System.out.print("Edit task: ");
                    index = App.getInteger();

                    System.out.print("Enter a new title for task " + index + ": ");
                    title = input.nextLine();

                    System.out.print("Enter a new description for task " + index + ": ");
                    description = input.nextLine();

                    System.out.print("Enter a new due date (YYYY-MM-DD) for task " + index + ": ");
                    date = input.nextLine();

                    editItem(index, title, description, date);

                    break;

                case 4:

                    System.out.print("Remove task: ");
                    index = App.getInteger();

                    deleteItem(index);

                    break;

                case 5:

                    printUnComplete();

                    System.out.print("Task to mark (-1 to cancel): ");
                    index = App.getInteger();

                    if(!valIndex(index)) {
                        if (index != -1)
                            System.out.println("\nWARNING: Invalid item. nothing to mark\n");
                    }
                    else
                        list.get(index).markAsComplete();

                    break;

                case 6:

                    printComplete();
                    System.out.print("Task to un-mark (-1 to cancel): ");
                    index = App.getInteger();

                    if(!valIndex(index)) {
                        if (index != -1)
                            System.out.println("\nWARNING: Invalid item. nothing to un-mark\n");
                    }
                    else
                        list.get(index).unMarkAsComplete();


                    break;

                case 7:

                    System.out.print("Save As: ");
                    filename = input.nextLine();

                    writeToFile(filename);

                    break;

                case 8:
                    list.clear();
                    break;

                default:
                    System.out.println("\nWARNING: NOT A VALID CHOICE\n");
                    break;

            }

        } while(run != 8);

    }

    public void mainMenuLoop() {

        int run;
        String filename;

        do {

            mainMenu();
            run = App.getInteger();

            switch (run) {

                case 1:
                    taskLoop();
                    break;

                case 2:

                    System.out.print("Open File: ");
                    filename = input.nextLine();

                    boolean val = readFile(filename);

                    if(val)
                        taskLoop();

                    break;

                case 3:
                    break;

                default:
                    System.out.println("\nWARNING: NOT A VALID CHOICE\n");
                    break;

            }

        } while(run != 3);

    }

}
