import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    private static TaskList list = new TaskList();

    public static void main(String[] args) {

        App mainMenu = new App();
        String[] mainMenuOptions = {"Create a new list", "Load an existing list", "Quit"};
        int choice;

        // Main Menu
        do {

            mainMenu.menuHeader("Main Menu");
            mainMenu.menuOptions(mainMenuOptions);
            choice = getInteger();

            switch (choice) {

                case 1:
                    listOptions();
                    break;

                case 2:

                    InFile in = new InFile();
                    boolean exists = in.readFile(list);

                    if(exists == true) {
                        listOptions();
                    }

                    break;

                case 3:
                    System.out.println("Good Bye!");
                    break;

                case 0:
                    //Do nothing
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;

            }

        } while(choice != 3);

    }

    //Menu Functions
    private void menuHeader(String title) {

        System.out.println(title);
        for(int i = 0; i < title.length(); i++)
            System.out.print("-");
        System.out.println();

    }

    private void menuOptions(String[] options) {

        for(int i = 0 ; i < options.length; i++) {

            System.out.println(i+1 + ") " + options[i]);

        }

        System.out.print("> ");

    }

    // Get a integer
    public static int getInteger() {

        int result = 0;

        try {
            result = input.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            input.nextLine();
        }

        return result;

    }

    private static void listOptions() {


        App newListMenu = new App();

        String[] newListOptions = {"View the list", "Add an item", "Edit an item",
                "Remove an item", "Mark an item as completed", "Unmark an item as completed",
                "Save the current list", "Quit to the main menu"};
        int choice;
        int index;
        OutFile output = new OutFile();

        do {

            newListMenu.menuHeader("List Operation Menu");
            newListMenu.menuOptions(newListOptions);
            choice = getInteger();

            switch (choice) {

                case 1:
                    list.displayList();
                    break;

                case 2:
                    list.addTask();
                    break;

                case 3:
                    System.out.print("Task Index: ");
                    index = getInteger();
                    list.editTask(index);
                    break;

                case 4:
                    System.out.print("Task Index: ");
                    index =  getInteger();
                    list.removeItem(index);
                    break;

                case 5:
                    list.markAsComplete();
                    break;

                case 6:
                    list.unMarkComplete();
                    break;

                case 7:
                    output.writeToFile(list);
                    break;

                case 8:
                    list.clearList();
                    break;

                case 0:
                    //Do nothing
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;

            }


        } while(choice != 8);

    }

}
