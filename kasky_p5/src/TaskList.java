import java.util.ArrayList;

public class TaskList {

    private ArrayList<TaskItem> list = new ArrayList<>();

    public boolean addTask(String title, String description, int year, int month, int day, boolean complete) {

        TaskItem item = new TaskItem();
        boolean val = item.createItem(title, description, year, month, day, complete);

        if(val) {
            list.add(item);
            return true;
        }
        else {
            return false;
        }

    }

    public void printList() {

        System.out.println("Current Tasks");
        System.out.println("-------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }

    public void printComplete() {

        System.out.println("Complete Tasks");
        System.out.println("--------------");
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }

    public void printUnComplete() {

        System.out.println("UnComplete Tasks");
        System.out.println("----------------");
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }


    public boolean removeTask(int index) {

        try {

            list.remove(index);

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid task selected. Nothing to remove.");
            return false;
        }

        return true;

    }

}
