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

        if(!isTitleValid(title)) {
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

     private boolean isTitleValid(String title) {

         boolean valid = false;

         try {
             if(title.length() >= 1) {
                 valid = true;
             }
         }
         catch (NullPointerException e) {
             System.out.println();
             System.out.println("WARNING: title must be at least one character long. Task not created");
             System.out.println();
             valid = false;
         }

         return valid;

     }

     private boolean isDateValid(String date) {

         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");

         try {
             formatter.parse(date);
         }
         catch (Exception e) {
             System.out.println();
             System.out.println("WARNING: invalid due date; task not created");
             System.out.println();
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

         System.out.println();

     }


     public void editTask(int index) {

         try {

             TaskItem appendTask = new TaskItem();
             String title = null;
             String description = null;
             String date = null;

             appendTask = list.get(index);

             title = getTitle();

             if(!isTitleValid(title)) {
                 return;
             }

             description = getDescription();

             date = getDate();

             if(!isDateValid(date)) {
                 return;
             }

             appendTask.setTitle(title);
             appendTask.setDescription(description);
             appendTask.setDate(date);

             list.set(index, appendTask);

         }

         catch (IndexOutOfBoundsException e) {

             System.out.println();
             System.out.println("Warning: Index does not exist. Cannot edit task");
             System.out.println();
             return;

         }

     }

     public void removeItem(int index) {

         try {

             list.remove(index);

         }
         catch (IndexOutOfBoundsException e) {

             System.out.println();
             System.out.println("Warning: Index does not exist. Cannot remove task");
             System.out.println();
             return;

         }

     }

     public void markAsComplete() {

         int index;

         System.out.println("Uncompleted Tasks");
         System.out.println("-----------------");
         for(int i = 0; i < list.size(); i++) {

             if(!list.get(i).getComplete()) {

                 System.out.println(i + ") " + list.get(i).toString());

             }

         }
         System.out.println();

         System.out.print("Which task will you mark as completed: ");
         index = App.getInteger();

         try {

             list.get(index).setComplete(true);

         }
         catch (IndexOutOfBoundsException e) {
             System.out.println();
             System.out.println("Warning: Index does not exist. Cannot remove task");
             System.out.println();
             return;
         }

     }

     public void unMarkComplete() {

         int index;

         System.out.println("Completed Tasks");
         System.out.println("---------------");
         for(int i = 0; i < list.size(); i++) {

             if(list.get(i).getComplete()) {

                 System.out.println(i + ") " + list.get(i).toString());

             }

         }
         System.out.println();

         System.out.print("Which task will you un-mark as completed: ");
         index = App.getInteger();

         try {

             list.get(index).setComplete(false);

         }
         catch (IndexOutOfBoundsException e) {
             System.out.println();
             System.out.println("Warning: Index does not exist. Cannot remove task");
             System.out.println();
             return;
         }

     }

     public void clearList() {
         list.clear();
     }

}
