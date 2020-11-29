public class TaskApp {

    public void mainMenu() {

        System.out.println("Task Main Menu");
        System.out.println("--------------");
        System.out.println("1. Create a new list");
        System.out.println("2. Load a existing list");
        System.out.println("3. Quit");
        System.out.print("> ");

    }

    public void TaskLoop() {

        int run;

        do {

            mainMenu();

        } while(run != 3);

    }

}
