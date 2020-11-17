import java.util.InputMismatchException;
import java.util.Scanner;


public class App {

    private static Scanner input = new Scanner(System.in);
    private static TaskList list = new TaskList();

    public static void main(String[] args) {

        int userChoice;

        do {

            menu();
            userChoice = getInteger();

            switch (userChoice) {

                case 1:

                    listMenu();

                    break;

                case 2:

                    InFile in = new InFile();
                    in.inFile(list);

                    listMenu();

                    break;

                case 3:

                    System.out.println("Good Bye!");

                    break;

                default:

                    break;

            }


        } while(userChoice != 3);

    }

    private static void menu() {

        System.out.println("Main Menu");
        System.out.println("----------");
        System.out.println("1) create a new list");
        System.out.println("2) load a list");
        System.out.println("3) Exit");
        System.out.print("> ");

    }

    public static int getInteger() {

        int result;

        try {

            result = input.nextInt();
            input.nextLine();

        }
        catch (InputMismatchException e) {

            System.out.println("Not A Integer.");
            result = -1;

        }

        return result;

    }

    private static void listMenu() {

        int choice, index;
        String title, description, date;

        do {

            System.out.println("List Operation Menu");
            System.out.println("-------------------");
            System.out.println("1) view the list");
            System.out.println("2) add an item");
            System.out.println("3) edit an item");
            System.out.println("4) remove an item");
            System.out.println("5) mark an item as completed");
            System.out.println("6) unmark an item as completed");
            System.out.println("7) save the current list");
            System.out.println("8) quit to the main menu");
            System.out.print("> ");
            choice = getInteger();

            switch(choice) {

                case 1:

                    list.displayList();

                    break;

                case 2:

                    System.out.print("Task Title: ");
                    title = input.nextLine();

                    System.out.print("Task Description: ");
                    description = input.nextLine();

                    System.out.print("Due Date (YYYY-MM-DD): ");
                    date = input.nextLine();

                    list.addItemToList(title, description, date, false);

                    break;

                case 3:

                    System.out.print("Index: ");
                    index = getInteger();

                    System.out.print("Task Title: ");
                    title = input.nextLine();

                    System.out.print("Task Description: ");
                    description = input.nextLine();

                    System.out.print("Due Date (YYYY-MM-DD): ");
                    date = input.nextLine();

                    list.editItem(index, title, description, date);

                    break;

                case 4:

                    System.out.print("Index: ");
                    index = getInteger();

                    list.removeItem(index);

                    break;

                case 5:

                    list.displayUncomplete();

                    System.out.print("Index: ");
                    index = getInteger();

                    list.markItemAsComplete(index);

                    break;

                case 6:

                    list.displayComplete();

                    System.out.print("Index: ");
                    index = getInteger();

                    list.unMarkAsComplete(index);

                    break;

                case 7:

                    OutFile out = new OutFile();
                    out.outFile(list);

                    break;

                case 8:
                    list.getList().clear();
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;

            }

        } while(choice != 8);

    }

}
