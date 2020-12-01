import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int run;
        TaskApp taskApp = new TaskApp();
        ContactApp contactApp = new ContactApp();

        do {

            appMenu();
            run = getInteger();

            switch (run) {

                case 1:
                    taskApp.mainLoop();
                    break;

                case 2:
                    contactApp.mainLoop();
                    break;

                case 3:
                    System.out.println("\nGood Bye!\n");
                    break;

                default:
                    System.out.println("\nWARNING: Not a valid choice.\n");
                    break;

            }

        } while(run != 3);

    }

    private static void appMenu() {

        System.out.println("Application Menu");
        System.out.println("----------------");
        System.out.println("1. Task list");
        System.out.println("2. Contact list");
        System.out.println("3. Quit");
        System.out.print("> ");

    }

    private static int getInteger() {

        int integer;

        try {
            integer = input.nextInt();
        }
        catch (InputMismatchException e) {
            input.next();
            return -1;
        }

        return integer;

    }

}
