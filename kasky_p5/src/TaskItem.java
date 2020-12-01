import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

        if(title.length() < 1)
            return false;
        else
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

    public boolean setDate(String date) {
        if(valDate(date))
            this.date = date;
        else
            return false;

        return true;
    }

}
