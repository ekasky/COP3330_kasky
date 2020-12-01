import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class TaskItem {

    private String title;
    private String description;
    private String date;
    private boolean complete;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public boolean isComplete() {
        return complete;
    }

    private boolean setTitle(String title) {

        if(title.length() < 1) {
            return false;
        }

        this.title = title;
        return true;

    }

    private void setDescription(String description) {
        this.description = description;
    }

    private boolean valDate(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            formatter.parse(date);
        }
        catch (DateTimeParseException e) {
            return false;
        }

        return true;

    }

    private boolean setDate(String date) {

        if(valDate(date))
            this.date = date;
        else
            return false;

        return true;

    }

    public boolean markAsComplete() {
        this.complete = true;
        return isComplete();
    }

    public boolean UnMarkAsComplete() {
        this.complete = false;
        return isComplete();
    }

    public boolean makeItem(String title, String description, String date, boolean complete) {

        boolean valTitle = setTitle(title);
        setDescription(description);
        boolean valDate = setDate(date);
        this.complete = complete;

        if(!valTitle) {
            System.out.println("\nWARNING: Title must be at least one character long. Item not created\n");
            return false;
        }
        else if(!valDate) {
            System.out.println("\nWARNING: Date must be formatted YYYY-MM-DD. Item not created\n");
            return false;
        }
        else
            return true;

    }

    @Override
    public String toString() {
        return "[" + date + "] " + title + ": " + description;
    }

}
