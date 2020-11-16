import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);
    private static TaskList list = new TaskList();

    public static void main(String[] args) {

        String[] mainMenuItems = {"Create a new list", "Load an existing list", "Quit"};

        int mainChoice;

        do {

            // Main menu
            menuHeader("Main Menu");
            menuItems(mainMenuItems);

            mainChoice = getInt();

            switch (mainChoice) {

                case 1:

                    listOptions();

                    break;

                case 2:

                    InFile in = new InFile();
                    in.inFile(list);
                    listOptions();

                    break;

                case 3:
                    System.out.println("\nGood Bye!");
                    break;

                default:
                    if(mainChoice != -1)
                        System.out.println("\nInvalid Input\n");
                    break;

            }



        } while(mainChoice != 3);


    }

    private static void menuHeader(String menuTitle) {

        System.out.println(menuTitle);
        for(int i = 0; i < menuTitle.length(); i++)
            System.out.print("-");
        System.out.println();

    }

    private static void menuItems(String[] items) {

        for(int i = 0; i < items.length; i++) {

            System.out.println(i+1 + ") " + items[i]);

        }

        System.out.print("> ");

    }

    public static int getInt() {

        int result;

        try {

            result = input.nextInt();

        }
        catch (InputMismatchException e) {
            System.out.println("\nInvalid input\n");
            input.next();
            result = -1;
        }

        return result;


    }

    private static void listOptions() {

        int choice;
        String[] items = {"view the list", "add an item", "edit an item", "remove an item", "mark an item as completed", "unmark an item as completed", "save the current list", "quit to the main menu"};

        do {

            menuHeader("List Operation Menu");
            menuItems(items);
            choice = getInt();

            switch(choice) {

                case 1:

                    list.displayList();

                    break;

                case 2:

                    list.addItem();

                    break;

                case 3:

                    list.editTask();

                    break;

                case 4:

                    list.removeItem();

                    break;

                case 5:

                    list.markAsComplete();

                    break;

                case 6:

                    list.unmarkAsComplete();

                    break;

                case 7:

                    OutFile out = new OutFile();

                    out.outFile(list);

                    break;

                case 8:
                    list.getList().clear();
                    break;

                default:
                    System.out.println("\nInvalid Input\n");
                    break;

            }

        } while(choice != 8);

    }

}
