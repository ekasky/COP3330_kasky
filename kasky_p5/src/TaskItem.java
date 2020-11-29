import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskItem {

    private String title;
    private String description;
    private String dueDate;
    private boolean complete;

    public String getTitle() {
        return title;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean setDueDate(int year, int month, int day) {

        try {
            LocalDate temp = LocalDate.of(year, month, day);

            if(temp.getYear() < 0) {
                return false;
            }

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.dueDate = temp.format(dateTimeFormatter);
            return true;


        }
        catch (DateTimeException e) {
            return false;
        }

    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void markComplete() {
        this.complete = true;
    }

    public void unmarkComplete() {
        this.complete = false;
    }

    public void createItem(String title, String description, int year, int month, int day, boolean complete) {

        boolean valTitle = setTitle(title);
        setDescription(description);
        boolean valDate = setDueDate(year, month, day);
        setComplete(false);
        
    }

}
