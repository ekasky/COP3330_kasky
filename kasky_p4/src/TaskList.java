import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    static Scanner input = new Scanner(System.in);
    private ArrayList<TaskItem> list = new ArrayList<>();

     public void addTask() {

        TaskItem item = new TaskItem();

        item.setTitle(getTitle());
        item.setDescription(getDescription());
        

     }

     private String getTitle() {

         String title = null;

         System.out.print("Task Title: ");

         title = input.nextLine();

         return title;



     }

     private String getDescription() {

         String description = null;

         System.out.print("Task Description: ");

         description = input.nextLine();

         return description;

     }

}
