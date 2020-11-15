import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice = 0;
        int newMenuChoice = 0;

        do {

            //Print Main Menu
            System.out.println("Main Menu");
            System.out.println("---------");
            mainOptions();

            //Get User Input
            try {
                choice = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input");
                input.nextLine();
            }

            // Run choice user inputted
            switch (choice) {

                case 1:

                    //Print new list menu
                    System.out.println("List Operation Menu");
                    System.out.println("---------");
                    newListOptions();

                    //Get User Input
                    try {
                        newMenuChoice = input.nextInt();
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid Input");
                        input.nextLine();
                    }

                    newListSwitch(newMenuChoice);

                    break;

                case 2:
                    System.out.println("Placeholder 2");
                    break;

                case 3:
                    System.out.println("Good Bye!");
                    break;

                default:
                    if(choice != 0)
                        System.out.println("Invalid Input");
                    break;

            }


        } while(choice != 3);

    }

    private static void mainOptions() {

        System.out.println("1) Create a new list");
        System.out.println("2) Load a existing list");
        System.out.println("3) Quit");
        System.out.print("> ");

    }

    private static void newListOptions() {

        System.out.println("1) View the list");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as completed");
        System.out.println("6) Un-Mark an item as completed");
        System.out.println("7) Save the current list");
        System.out.println("8) Quit to main menu");
        System.out.print("> ");

    }

    private static void newListSwitch(int choice) {

        switch (choice) {

            case 1:
                System.out.println("Placeholder 1");
                break;

            case 2:
                System.out.println("Placeholder 2");
                break;

            case 3:
                System.out.println("Placeholder 3");
                break;

            case 4:
                System.out.println("Placeholder 4");
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

                break;

        }

    }

}
