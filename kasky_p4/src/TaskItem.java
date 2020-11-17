import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskItem {

    static Scanner input = new Scanner(System.in);

    private String title;
    private String description;
    private String date;
    private boolean complete;

    TaskItem() {

        System.out.print("Task Title: ");
        this.title = input.nextLine();

        System.out.print("Task Description: ");
        this.description = input.nextLine();

        System.out.print("Task due date (YYYY-MM-DD): ");
        this.date = input.nextLine();

    }

    TaskItem(String title, String description, String date, boolean complete) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.complete = complete;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "[" + date + "]" + " " + title + ": " + description;
    }

    public boolean isTitleValid() {

        if(title.length() < 1) {
            return false;
        }

        return true;
    }

    public boolean isDateValid() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            formatter.parse(this.date);
        }
        catch (Exception e) {
            return false;
        }

        return true;

    }



}
