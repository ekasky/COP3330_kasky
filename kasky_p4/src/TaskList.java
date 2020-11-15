import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    static Scanner input = new Scanner(System.in);
    private ArrayList<TaskItem> list = new ArrayList<>();

     public void addTask() {

        TaskItem item = new TaskItem();
        String title = getTitle();
        String description = getDescription();


        if(title == null) {
            System.out.println("WARNING: title must be at least one character long. Task not created");
            return;
        }

        item.setTitle(title);
        item.setDescription(description);

        list.add(item);


     }

     private String getTitle() {

         String title = null;

         System.out.print("Task Title: ");

         title = input.nextLine();

         if(title.length() < 1) {
             return null;
         }

         return title;



     }

     private String getDescription() {

         String description = null;

         System.out.print("Task Description: ");

         description = input.nextLine();

         return description;

     }

     /*
     private String getDate() {

         String date = null;

         System.out.println();

     }

      */

    public void displayList() {

         System.out.println();
         System.out.println("Current List");
         System.out.println("------------");

         for(int i = 0; i < list.size(); i++) {
             System.out.println(i + ") " + list.get(i).toString());
         }

     }

}
