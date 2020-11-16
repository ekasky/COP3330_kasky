import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    static Scanner input = new Scanner(System.in);
    private ArrayList<TaskItem> list = new ArrayList<>();

    public ArrayList<TaskItem> getList() {
        return list;
    }

    public void setList(ArrayList<TaskItem> list) {
        this.list = list;
    }

    public void displayList() {

        System.out.println("Current Tasks");
        System.out.println("-------------");

        for(int i = 0; i < list.size(); i++) {

            System.out.println(i + ") " + list.get(i).toString());

        }

        System.out.println();

    }

    public void addItem() {

        TaskItem item = new TaskItem();

        if(!isTaskValid(item)) {
            return;
        }

        list.add(item);

    }

    public static boolean isTaskValid(TaskItem item) {

        if(!item.isTitleValid()) {
            System.out.println("\nWARNING: title must be at least 1 character long; task not created\n");
            return false;
        }

        if(!item.isDateValid()) {
            System.out.println("\nWARNING: invalid due date; task not created\n");
            return false;
        }

        return true;

    }

    public boolean isIndexValid(int index) {

        if(index < 0 || index > list.size()) {
            return false;
        }

        return true;

    }

    public void editTask() {

        System.out.print("Which task will you edit: ");
        int index = App.getInt();
        String tempTitle, tempDescription, tempDate;

        if(!isIndexValid(index)) {
            return;
        }

        System.out.print("Enter a new title for task " + index + ": ");
        tempTitle = input.nextLine();

        System.out.print("Enter a new description for task " + index + ": ");
        tempDescription = input.nextLine();

        System.out.print("Enter a new task due date (YYYY-MM-DD) for task " + index + ": ");
        tempDate = input.nextLine();

        TaskItem temp = new TaskItem(tempTitle, tempDescription, tempDate, false);

        if(!isTaskValid(temp)) {
            return;
        }

        list.set(index, temp);

    }

    public void removeItem() {

        System.out.print("Which task will you remove: ");
        int index = App.getInt();

        try {
            list.remove(index);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("\nWARNING: Task is not valid. Nothing to remove.\n");
        }


    }

    public void markAsComplete() {

        System.out.println("Uncompleted Tasks");
        System.out.println("-----------------");

        for(int i = 0; i < list.size(); i++) {

            if(!list.get(i).isComplete()) {
                System.out.println(i + ") " + list.get(i).toString());
            }

        }
        System.out.println();

        System.out.print("Which task will you mark as completed: ");
        int index = App.getInt();

        if(!isIndexValid(index)) {
            System.out.println("\nWARNING: Task is not valid. Nothing to mark.\n");
            return;
        }

        list.get(index).setComplete(true);

    }

    public void unmarkAsComplete() {

        System.out.println("Completed Tasks");
        System.out.println("-----------------");

        for(int i = 0; i < list.size(); i++) {

            if(list.get(i).isComplete()) {
                System.out.println(i + ") " + list.get(i).toString());
            }

        }
        System.out.println();

        System.out.print("Which task will you un-mark as completed: ");
        int index = App.getInt();

        if(!isIndexValid(index)) {
            System.out.println("\nWARNING: Task is not valid. Nothing to un-mark.\n");
            return;
        }

        list.get(index).setComplete(false);

    }

}
