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

        mainMenu.menuHeader("Main Menu");
        mainMenu.menuOptions(mainMenuOptions);

        newListMenu.menuHeader("List Operation Menu");
        newListMenu.menuOptions(newListOptions);

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

}
