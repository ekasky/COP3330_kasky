public class TaskList {

    private static void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Create a new list");
        System.out.println("2. Load a existing list");
        System.out.println("3. Quit");
        System.out.print("> ");
    }

    public static void mainMenuLoop() {

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
