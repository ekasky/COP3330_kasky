import java.util.Scanner;

public class TaskApp extends App {

    private TaskList list = new TaskList();
    private Scanner input = new Scanner(System.in);

    @Override
    public void printMainMenu() {

        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Create a new list");
        System.out.println("2. Load a existing list");
        System.out.println("3. Quit");
        System.out.print("> ");

    }

    @Override
    public void printListMenu() {

        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println("1. View the List");
        System.out.println("2. Add a item");
        System.out.println("3. Edit a item");
        System.out.println("4. Remove a item");
        System.out.println("5. Mark an item as complete");
        System.out.println("6. Un-mark a item as complete");
        System.out.println("7. Save the current list");
        System.out.println("8. Quit to main menu");
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
        String title, description, date, filename;

        do {

            printListMenu();
            run = getInteger();

            switch (run) {

                case 1:
                    list.printList();
                    break;

                case 2:

                    System.out.print("Task Title: ");
                    title = input.nextLine();

                    System.out.print("Task Description: ");
                    description = input.nextLine();

                    System.out.print("Due date (YYYY-MM-DD): ");
                    date = input.nextLine();

                    list.addTask(title, description, date, false);

                    break;

                case 3:

                    System.out.print("Edit Task: ");
                    index = getInteger();

                    System.out.print("New Title for task " + index + ": ");
                    title = input.nextLine();

                    System.out.print("New Description for task " + index + ": ");
                    description = input.nextLine();

                    System.out.print("New Due Date (YYYY-MM-DD) for task " + index + ": ");
                    date = input.nextLine();

                    list.editItem(index, title, description, date);

                    break;

                case 4:

                    System.out.println("Remove Task: ");
                    index = getInteger();

                    list.removeItem(index);

                    break;

                case 5:

                    list.printUnComplete();

                    System.out.print("(-1 to cancel) > ");
                    index = getInteger();

                    if(!list.valIndex(index)) {
                        if(index != -1)
                            System.out.println("\nWARNING: Invalid item. nothing to mark\n");
                    }
                    else
                        list.getList().get(index).markAsComplete();

                    break;

                case 6:

                    list.printComplete();

                    System.out.print("(-1 to cancel) > ");
                    index = getInteger();

                    if(!list.valIndex(index)) {
                        if(index != -1)
                            System.out.println("\nWARNING: Invalid item. nothing to un-mark\n");
                    }
                    else
                        list.getList().get(index).UnMarkAsComplete();

                    break;

                case 7:

                    System.out.print("Save As: ");
                    filename = input.nextLine();

                    list.saveList(filename);

                    break;

                case 8:
                    list.getList().clear();
                    break;

                default:
                    System.out.println("\nWARNING: Not a valid choice.\n");
                    break;

            }

        } while(run != 8);

    }
}
