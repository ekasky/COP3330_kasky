import java.util.ArrayList;

public class TaskList {

    private ArrayList<TaskItem> list = new ArrayList<>();

    private static void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Create a new list");
        System.out.println("2. Load a existing list");
        System.out.println("3. Quit");
        System.out.print("> ");
    }

    private static void taskMenu() {
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1. View the List");
        System.out.println("2. Add a item");
        System.out.println("3. Edit a item");
        System.out.println("4. Remove a item");
        System.out.println("5. Mark an item as complete");
        System.out.println("6. Un-mark am item as complete");
        System.out.println("7. Save the current list");
        System.out.println("8. Quit to main menu");
    }

    private void taskLoop() {

        int run;

        do {

            taskMenu();
            run = App.getInteger();

            switch (run) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                default:
                    System.out.println("\nWARNING: NOT A VALID CHOICE\n");
                    break;

            }

        } while(run != 8);

    }

    public void mainMenuLoop() {

        int run;

        do {

            mainMenu();
            run = App.getInteger();

            switch (run) {

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                default:
                    System.out.println("\nWARNING: NOT A VALID CHOICE\n");
                    break;

            }

        } while(run != 3);

    }

}
