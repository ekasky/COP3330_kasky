import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    static Scanner input = new Scanner(System.in);
    private ArrayList<TaskItem> list = new ArrayList<>();

     public void addTask() {

        TaskItem item = new TaskItem();
        String title = getTitle();
        String description = getDescription();
        String date = getDate();

        if(title == null) {
            System.out.println("WARNING: title must be at least one character long. Task not created");
            return;
        }

        if(!isDateValid(date)) {
            return;
        }

        item.setTitle(title);
        item.setDescription(description);
        item.setDate(date);

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

     private String getDate() {

         String date = null;

         System.out.print("Task due date (YYYY-MM-DD): ");

         date = input.nextLine();

         return date;

     }

     private boolean isDateValid(String date) {

         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

         try {
             formatter.parse(date);
         }
         catch (Exception e) {
             System.out.println("WARNING: invalid due date; task not created");
             return false;
         }

         return true;

     }

    public void displayList() {

         System.out.println();
         System.out.println("Current List");
         System.out.println("------------");

         for(int i = 0; i < list.size(); i++) {
             System.out.println(i + ") " + list.get(i).toString());
         }

     }

}
