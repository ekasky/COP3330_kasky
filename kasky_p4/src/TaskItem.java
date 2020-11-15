public class TaskItem {

    private String title;
    private String description;
    private DueDate date;
    private boolean complete;

    TaskItem(String title, String description) {

        this.title = title;
        this.description = description;
        this.date = new DueDate();
        this.complete = false;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {

        return date.toString();

    }

    public void setDueDate() {

        date = new DueDate();

    }

    public boolean getComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {

        this.complete = complete;

    }

    @Override
    public String toString() {

        return date + " " + title + ": " + description;

    }
}
