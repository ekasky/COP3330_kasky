import java.util.Scanner;
import java.util.stream.StreamSupport;

public class TaskApp {

    private Scanner input = new Scanner(System.in);
    private TaskList list = new TaskList();

    public void mainMenu() {

        System.out.println("Task Main Menu");
        System.out.println("--------------");
        System.out.println("1. Create a new list");
        System.out.println("2. Load a existing list");
        System.out.println("3. Quit");
        System.out.print("> ");

    }

    public void TaskLoop() {

        int run;

        do {

            mainMenu();
            run = App.getInteger();

            switch (run) {

                case 1:
                    operationLoop();
                    break;

                case 2:

                    break;

                case 3:
                    // Return to main loop
                    break;

                default:
                    System.out.println("WARNING: Not a valid choice.");
                    break;

            }

        } while(run != 3);

    }

    public void listMenuOptions() {

        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1. View the list");
        System.out.println("2. Add a item");
        System.out.println("3. Edit a item");
        System.out.println("4. Remove a item");
        System.out.println("5. Save the current list");
        System.out.println("6. Quit to main menu");
        System.out.print("> ");

    }

    public void operationLoop() {

        int run;

        do {

            listMenuOptions();
            run = App.getInteger();

            switch (run) {

                case 1:
                    list.printList();
                    break;

                case 2:

                    System.out.print("Task Title: ");
                    String title = input.nextLine();

                    System.out.print("Task Description: ");
                    String description = input.nextLine();

                    System.out.print("Task Due Date (YYYY-MM-DD): ");
                    String date = input.nextLine();

                    list.addTask(title, description, date, false);

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                default:
                    System.out.println("WARNING: Invalid choice.");
                    break;

            }

        } while(run != 6);

    }

}
