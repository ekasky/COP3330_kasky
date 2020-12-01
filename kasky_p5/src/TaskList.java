import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList extends ListTemplate {

    private ArrayList<TaskItem> list = new ArrayList<>();

    public ArrayList<TaskItem> getList() {
        return list;
    }

    @Override
    public boolean valIndex(int index) {

        try {
            list.get(index);
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }

    }

    @Override
    public void printList() {

        System.out.println("Current List");
        System.out.println("------------");
        for(int i = 0; i < list.size(); i++)
            System.out.println(i + ") " + list.get(i).toString());
        System.out.println();

    }

    public boolean addTask(String title, String description, String date, boolean complete) {

        TaskItem item = new TaskItem();

        boolean val = item.makeItem(title, description, date, complete);

        if(val)
            list.add(item);
        else
            return false;

        return true;

    }

    public boolean editItem(int index, String title, String description, String date) {

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

    public void printComplete() {

        System.out.println("Complete List");
        System.out.println("-------------");
        for(int i = 0; i < list.size(); i++) {

            if(list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());

        }
        System.out.println();

    }

    public void printUnComplete() {
        System.out.println("Un-Complete List");
        System.out.println("----------------");
        for(int i = 0; i < list.size(); i++) {

            if(!list.get(i).isComplete())
                System.out.println(i + ") " + list.get(i).toString());

        }
        System.out.println();
    }

    @Override
    public boolean removeItem(int index) {

        if(valIndex(index)) {
            list.remove(index);
            return true;
        }
        else {
            System.out.println("\nWARNING: Invalid Task. Nothing to remove.\n");
            return false;
        }

    }

    @Override
    public boolean saveList(String filename) {

        String path = filename + ".txt";

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i = 0; i < list.size(); i++) {

                printWriter.println(list.get(i).getTitle());
                printWriter.println(list.get(i).getDescription());
                printWriter.println(list.get(i).getDate());
                printWriter.println(list.get(i).isComplete());

            }

            printWriter.close();
            return true;

        }
        catch (IOException e) {
            return false;
        }

    }

    @Override
    public boolean loadList(String filename) {

        String title, description, date, complete;

        String path = filename + ".txt";

        try {

            File file = new File(path);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {

                title = reader.nextLine();
                description = reader.nextLine();
                date = reader.nextLine();
                complete = reader.nextLine();

                addTask(title, description, date, Boolean.parseBoolean(complete));

            }

            return true;

        }
        catch (FileNotFoundException e) {
            System.out.println("\nWARNING: Could not open file.\n");
            return false;
        }

    }

}
