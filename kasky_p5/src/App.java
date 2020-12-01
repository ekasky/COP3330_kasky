import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {



    }

    private static void applicationMenu() {
        System.out.println("Application Menu");
        System.out.println("----------------");
        System.out.println("1. Task List");
        System.out.println("2. Contact List");
        System.out.println("3. Quit");
        System.out.print("> ");
    }



    public static int getInteger() {

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
