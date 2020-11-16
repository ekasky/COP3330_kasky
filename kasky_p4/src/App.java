import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        App mainMenu = new App();
        App newListMenu = new App();
        String[] mainMenuOptions = {"Create a new list", "Load an existing list", "Quit"};
        String[] newListOptions = {"View the list", "Add an item", "Edit an item",
                "Remove an item", "Mark an item as completed", "Unmark an item as completed",
                "Save the current list", "Quit to the main menu"};
        int choice;
        TaskList list = new TaskList();
        int index;


        // Main Menu
        do {

            mainMenu.menuHeader("Main Menu");
            mainMenu.menuOptions(mainMenuOptions);
            choice = getInteger();

            switch (choice) {

                case 1:

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
                                System.out.println("Placeholder 5");
                                break;

                            case 6:
                                System.out.println("Placeholder 6");
                                break;

                            case 7:
                                System.out.println("Placeholder 7");
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

                    break;

                case 2:
                    System.out.println("Choice 2");
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

}
