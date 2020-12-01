import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    private Scanner input = new Scanner(System.in);
    private ArrayList<TaskItem> list = new ArrayList<>();

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

        do {

            mainMenu();
            run = App.getInteger();

            switch (run) {

                case 1:
                    taskLoop();
                    break;

                case 2:
                    break;

                case 3:
                    break;

                default:
                    System.out.println("\nWARNING: NOT A VALID CHOICE\n");
                    break;

            }

        } while(run != 3);

    }

    private boolean addTask(String title, String description, String date, boolean complete) {

        TaskItem item = new TaskItem();

        boolean val = item.makeItem(title, description, date, complete);

        if(val)
            list.add(item);
        else
            return false;

        return true;

    }

    private void printList() {

        System.out.println("Current List");
        System.out.println("------------");
        for(int i = 0; i < list.size(); i++)
            System.out.println(i + ") " + list.get(i).toString());
        System.out.println();

    }

    private void printComplete() {

        System.out.println("Complete List");
        System.out.println("-------------");
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }

    private void printUnComplete() {

        System.out.println("Un-Complete List");
        System.out.println("----------------");
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }

    private boolean valIndex(int index) {

        try {
            list.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;

    }

    private boolean editItem(int index, String title, String description, String date) {

        if(!valIndex(index)) {
            System.out.println("\nWARNING: Invalid item. Nothing to edit\n");
            return false;
        }

        TaskItem item = new TaskItem();

        boolean val = item.makeItem(title, description, date, list.get(index).isComplete());

        if(val)
            list.set(index, item);
        else
            return false;

        return true;

    }

    private boolean deleteItem(int index) {

        if(!valIndex(index)) {
            System.out.println("\nWARNING: Invalid item. Nothing to delete\n");
            return false;
        }
        else {
            list.remove(index);
            return true;
        }

    }

    private boolean writeToFile(String filename) {

        String path = filename + ".txt";

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i = 0; i < list.size(); i++) {
                printWriter.println(list.get(i).getDate());
                printWriter.println(list.get(i).getTitle());
                printWriter.println(list.get(i).getDescription());
                printWriter.println(list.get(i).isComplete());
            }

            printWriter.close();
            return true;

        }
        catch (IOException e) {
            return false;
        }

    }

}
