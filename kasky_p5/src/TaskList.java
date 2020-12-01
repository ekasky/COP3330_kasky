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

    private boolean addTask(String title, String description, String date, boolean complete) {

        TaskItem item = new TaskItem();

        boolean val = item.makeItem(title, description, date, complete);

        if(val)
            list.add(item);
        else
            return false;

        return true;

    }

    private void printList() {

        System.out.println("Current List");
        System.out.println("------------");
        for(int i = 0; i < list.size(); i++)
            System.out.println(i + ") " + list.get(i).toString());
        System.out.println();

    }

    private void printComplete() {

        System.out.println("Complete List");
        System.out.println("-------------");
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }

    private void printUnComplete() {

        System.out.println("Un-Complete List");
        System.out.println("----------------");
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }

    private boolean valIndex(int index) {

        try {
            list.get(index);
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;

    }

    private boolean editItem(int index, String title, String description, String date) {

        if(!valIndex(index)) {
            System.out.println("\nWARNING: Invalid item. Nothing to edit\n");
            return false;
        }

        TaskItem item = new TaskItem();

        boolean val = item.makeItem(title, description, date, list.get(index).isComplete());

        if(val)
            list.set(index, item);
        else
            return false;

        return true;

    }

    private boolean deleteItem(int index) {

        if(!valIndex(index)) {
            System.out.println("\nWARNING: Invalid item. Nothing to delete\n");
            return false;
        }
        else {
            list.remove(index);
            return true;
        }

    }

}
