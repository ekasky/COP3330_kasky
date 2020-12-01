public class ContactApp {

    private static void mainMenu() {

        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Create a new list");
        System.out.println("2. Load an existing list");
        System.out.println("3. Quit");
        System.out.print("> ");

    }

    private static void contactMenu() {

        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1. View the list");
        System.out.println("2. Add an item");
        System.out.println("3. Edit an item");
        System.out.println("4. Remove a item");
        System.out.println("5. Save the current list");
        System.out.println("6. Quit to main menu");
        System.out.print("> ");

    }

    public void contactLoop() {

        int run;

        do {

            contactMenu();
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
                    
                default:
                    System.out.println("\nWARNING: NOT A VALID CHOICE\n");
                    break;

            }

        } while(run != 6);

    }

    public void mainLoop() {

        int run;

        do {

            mainMenu();
            run = App.getInteger();

            switch (run) {

                case 1:
                    contactLoop();
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
