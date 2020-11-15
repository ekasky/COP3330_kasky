import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    Scanner input = new Scanner(System.in);
    ArrayList <TaskItem> list = new ArrayList<>();

    public void addTask() {

        String title;
        String description;

        System.out.print("Task Title: ");
        title = input.nextLine();

        System.out.print("Task Description: ");
        description = input.nextLine();

        TaskItem newItem = new TaskItem(title, description);
        list.add(newItem);

    }

    public void removeItem(int index) {

        int size = list.size();

        if(index < 0 || index > size) {
            System.out.println("Error...Index not valid");
        }
        else {

            list.remove(index);

        }

    }

    public void printList() {

        System.out.println("   Task List   ");
        System.out.println("---------------");

        for(int i = 0; i < list.size(); i++) {

            System.out.println(i + ") " + list.get(i));

        }

    }

}
