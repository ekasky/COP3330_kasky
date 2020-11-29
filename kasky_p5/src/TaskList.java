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

}
