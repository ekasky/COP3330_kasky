public class TaskItem {

    private String title;
    private String description;
    private DueDate date;

    TaskItem(String title, String description) {

        this.title = title;
        this.description = description;
        date = new DueDate();
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
}
