import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class App {

    private static Scanner input = new Scanner(System.in);

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

    public abstract void printMainMenu();
    public abstract void printListMenu();
    public abstract void mainLoop();
    public abstract void listLoop();

}
