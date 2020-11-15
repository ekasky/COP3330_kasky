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

    public void changeCompletion(int index) {

        int size = list.size();

        if(index < 0 || index >= size) {
            System.out.println("Error...Invalid Item");
        }
        else {

            if(list.get(index).getComplete() == true) {
                System.out.println(list.get(index).getTitle() + " unmarked");
                list.get(index).setComplete(false);
            }
            else {
                System.out.println(list.get(index).getTitle() + " marked as complete");
                list.get(index).setComplete(true);
            }

        }

        System.out.println();

    }

    public void printList() {

        System.out.println("   Task List   ");
        System.out.println("---------------");

        for(int i = 0; i < list.size(); i++) {

            System.out.println(i + ") " + list.get(i));

        }

        System.out.println();

    }

    public void printComplete() {

        System.out.println("   Complete Tasks   ");
        System.out.println("--------------------");

        for(int i = 0; i < list.size(); i++) {

            if(list.get(i).getComplete() == true) {
                System.out.println(i + ") " + list.get(i));
            }

        }

        System.out.println();

    }

}
