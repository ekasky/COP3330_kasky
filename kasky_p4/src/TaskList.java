import java.util.ArrayList;

public class TaskList {

    private ArrayList<TaskItem> list = new ArrayList<>();

    public ArrayList<TaskItem> getList() {
        return list;
    }

    public void setList(ArrayList<TaskItem> list) {
        this.list = list;
    }

    public boolean addItemToList(String title, String description, String date, boolean complete) {

        boolean valid;
        TaskItem item = new TaskItem();
        valid = item.createItem(title, description, date, complete);

        if (valid) {
            list.add(item);
            return true;
        } else {
            System.out.print("Task Not Added.\n\n");
            return false;
        }

    }

    public void displayList() {

        System.out.println("Current Tasks");
        System.out.println("-------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ") " + list.get(i).toString());
        }
        System.out.println();

    }

    public void displayUncomplete() {

        System.out.println("Uncompleted Tasks");
        System.out.println("-----------------");
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isComplete()) {
                System.out.println(i + ") " + list.get(i).toString());
            }
        }
        System.out.println();

    }

    public void displayComplete() {

        System.out.println("Completed Tasks");
        System.out.println("---------------");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isComplete()) {
                System.out.println(i + ") " + list.get(i).toString());
            }
        }
        System.out.println();

    }

    public boolean editItem(int index, String title, String description, String date) {

        boolean validTitle, validDate;

        try {
            TaskItem item = new TaskItem();
            validTitle = item.setTitle(title);
            item.setDescription(description);
            validDate = item.setDate(date);

            if (validDate == false) {
                System.out.println("WARNING: Invalid Date. Task not changed.");
                return false;
            }
            else if(validTitle == false) {
                System.out.println("WARNING: Invalid Title. Task not changed.");
                return false;
            }
            else {

                list.get(index).setTitle(title);
                list.get(index).setDescription(description);
                list.get(index).setDate(date);

                return true;
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid Index. No item to edit.");
            return false;
        }

    }

    public boolean removeItem(int index) {

        try {
            list.remove(index);
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid Index. No item to remove.");
            return false;
        }


    }

    public boolean markItemAsComplete(int index) {


        try {

            list.get(index).setComplete(true);
            return true;

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid Index. No item to mark.");
            return false;
        }


    }

    public boolean unMarkAsComplete(int index) {

        try {
            list.get(index).setComplete(false);
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid Index. No item to un-mark.");
            return false;
        }


    }

    public String getItemTitle(int index) {

        try {

            return list.get(index).getTitle();

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid Index. No title to get.");
            return null;
        }


    }

    public String getItemDescription(int index) {

        try {

            return list.get(index).getDescription();

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid Index. No description to get.");
            return null;
        }


    }

    public String getItemDate(int index) {

        try {

            return list.get(index).getDate();

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("WARNING: Invalid Index. No date to get.");
            return null;
        }


    }


}
