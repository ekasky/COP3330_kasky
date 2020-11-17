import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskItem {

    private static Scanner input = new Scanner(System.in);

    private String title;
    private String description;
    private String date;
    private boolean complete;

    public TaskItem() {}

    public String getTitle() {
        return this.title;
    }

    public boolean setTitle(String title) {

        if(title.length() < 1) {
            return false;
        }
        else {
            this.title = title;
            return true;
        }

    }

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {

        this.description = description;
        return true;

    }

    public boolean setDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            formatter.parse(date);
        }
        catch (Exception e) {
            return false;
        }

        this.date = date;
        return true;

    }

    public String getDate() {
        return date;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public boolean createItem(String title, String description, String date, boolean complete) {

        boolean titleValid, dateValid;

        titleValid = setTitle(title);
        setDescription(description);
        dateValid = setDate(date);
        setComplete(complete);

        if(titleValid == false) {
            System.out.print("\nWARNING: Title Invalid. ");
            return false;
        }
        else if(dateValid == false) {
            System.out.print("\nWARNING: Date Invalid. ");
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    public String toString() {
        return "[" + date + "] " + title + ": " + description;

    }
}
