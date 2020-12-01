import java.util.Scanner;

public class ContactApp extends App {

    private ContactList list = new ContactList();
    private Scanner input = new Scanner(System.in);

    @Override
    public void printMainMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Create a new contact list");
        System.out.println("2. Load a existing contact list");
        System.out.println("3. Quit");
        System.out.print("> ");
    }

    @Override
    public void printListMenu() {
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1. View the list");
        System.out.println("2. Add a contact");
        System.out.println("3. Edit a contact");
        System.out.println("4. Remove a contact");
        System.out.println("5. Save the contact list");
        System.out.println("6. Quit to main menu");
        System.out.print("> ");
    }

    @Override
    public void mainLoop() {

        int run;
        String filename;

        do {

            printMainMenu();
            run = getInteger();

            switch (run) {

                case 1:
                    listLoop();
                    break;

                case 2:

                    System.out.print("Open: ");
                    filename = input.nextLine();

                    boolean val = list.loadList(filename);

                    if(val)
                        listLoop();

                    break;

                case 3:
                    //Return to application menu
                    break;

                default:
                    System.out.println("\nWARNING: Not a valid choice.\n");
                    break;

            }

        } while(run != 3);

    }

    @Override
    public void listLoop() {

        int run, index;
        String firstName, lastName, phoneNumber, email, filename;

        do {

            printListMenu();
            run = getInteger();

            switch (run) {

                case 1:
                    list.printList();
                    break;

                case 2:

                    System.out.print("First Name: ");
                    firstName = input.nextLine();

                    System.out.print("Last Name: ");
                    lastName = input.nextLine();

                    System.out.print("Phone (###-###-####): ");
                    phoneNumber = input.nextLine();

                    System.out.print("Email: ");
                    email = input.nextLine();

                    list.addItem(firstName, lastName, phoneNumber, email);

                    break;

                case 3:

                    System.out.print("Edit Contact: ");
                    index = getInteger();

                    System.out.print("New first name for contact " + index + ": ");
                    firstName = input.nextLine();

                    System.out.print("New last name for contact " + index + ": ");
                    lastName = input.nextLine();

                    System.out.print("New phone number for contact " + index + ": ");
                    phoneNumber = input.nextLine();

                    System.out.print("New email for contact " + index + ": ");
                    email = input.nextLine();

                    list.editItem(index, firstName, lastName, phoneNumber, email);

                    break;

                case 4:

                    System.out.print("Remove Contact: ");
                    index = getInteger();

                    list.removeItem(index);

                    break;

                case 5:

                    System.out.print("Save As: ");
                    filename = input.nextLine();

                    list.saveList(filename);

                    break;

                case 6:
                    list.getList().clear();
                    break;

                default:
                    System.out.println("\nWARNING: Not a valid choice.\n");
                    break;

            }

        } while(run != 6);

    }
}
