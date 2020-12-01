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

}
