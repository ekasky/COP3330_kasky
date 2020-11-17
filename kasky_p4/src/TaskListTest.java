import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void completingTaskItemChangesStatus() {

        TaskList list = new TaskList();
        list.addItemToList("Task 1", "Description", "2020-11-15", false);
        list.markItemAsComplete(0);

        assertTrue(list.getList().get(0).isComplete());

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {

        int index = 100;
        TaskList list = new TaskList();
        list.addItemToList("Task 1", "Description", "2020-11-15", false);

        assertFalse(list.markItemAsComplete(index));

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex2() {

        int index = -1;
        TaskList list = new TaskList();
        list.addItemToList("Task 1", "Description", "2020-11-15", true);

        assertFalse(list.markItemAsComplete(index));

    }

    @Test
    public void editingTaskItemChangesValues() {

        boolean valid;
        TaskList list = new TaskList();
        String title = "Title";
        String description = "Description";
        String date = "2020-02-12";

        list.addItemToList(title,description,date, true);
        list.editItem(0, "New Title", "New Description", "2020-03-01");

        if(list.getList().get(0).getTitle() == title && list.getList().get(0).getDescription() == description && list.getList().get(0).getDate() == date) {
            valid = false;
        }
        else {
            valid = true;
        }

        assertTrue(valid);

    }

    @Test
    public void editingTaskItemDescriptionChangesValue() {

        boolean valid;
        TaskItem item = new TaskItem();
        String newDescription = "New Description";
        item.createItem("title", "Description", "2020-04-30", false);
        item.setDescription(newDescription);

        if(item.getDescription() == newDescription) {
            valid = true;
        }
        else {
            valid = false;
        }

        assertTrue(valid);

    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {

        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "3021-12-21", true);

        assertFalse(list.editItem(2, "Title", "New Description", "3021-12-21"));

    }

    @Test
    public void editingTaskItemDueDateChangesValue() {

        boolean valid;
        TaskItem item = new TaskItem();
        String newDate = "2020-05-04";
        item.createItem("title", "Description", "2020-04-30", false);
        item.setDate(newDate);

        if(item.getDate() == newDate) {
            valid = true;
        }
        else {
            valid = false;
        }

        assertTrue(valid);

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {

        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2030-11-23", false);

        assertFalse(list.editItem(5, "Title", "New Description", "3021-12-21"));

    }

    @Test
    public void editingTaskItemTitleChangesValue() {

        boolean valid;
        TaskItem item = new TaskItem();
        String newTitle = "New Title";
        item.createItem("title", "Description", "2020-04-30", false);
        item.setTitle(newTitle);

        if(item.getTitle() == newTitle) {
            valid = true;
        }
        else {
            valid = false;
        }

        assertTrue(valid);

    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {

        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2020-12-02", true);

        assertFalse(list.editItem(-2, "Title", "New Description", "3021-12-21"));

    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {

        boolean result;
        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2020-12-02", true);
        String description = list.getItemDescription(100);

        if(description == null) {
            result = true;
        }
        else {

            result = false;

        }

        assertTrue(result);

    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {

        boolean result;
        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2020-12-02", false);
        String description = list.getItemDescription(0);

        if(description == null) {
            result = false;
        }
        else {

            result = true;

        }

        assertTrue(result);

    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {

        boolean result;
        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2020-12-02", false);
        String date = list.getItemDate(-12);

        if(date == null) {
            result = true;
        }
        else {

            result = false;

        }

        assertTrue(result);

    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {

        boolean result;
        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2020-12-02", false);
        String date = list.getItemDate(0);

        if(date == null) {
            result = false;
        }
        else {

            result = true;

        }

        assertTrue(result);

    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {

        boolean result;
        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2020-12-02", true);
        String title = list.getItemTitle(2);

        if(title == null) {
            result = true;
        }
        else {

            result = false;

        }

        assertTrue(result);

    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {

        boolean result;
        TaskList list = new TaskList();
        list.addItemToList("Title", "Description", "2020-12-02", false);
        String title = list.getItemTitle(0);

        if(title == null) {
            result = false;
        }
        else {

            result = true;

        }

        assertTrue(result);

    }

    @Test
    public void newTaskListIsEmpty() {

        TaskList newList = new TaskList();
        int size = newList.getList().size();

        assertEquals(size, 0);

    }

    @Test
    public void removingTaskItemsDecreasesSize() {

        TaskList newList = new TaskList();
        newList.addItemToList("Title", "description", "2020-09-12", false);
        newList.addItemToList("Title 2", "description 2", "2020-09-13", false);
        int size = newList.getList().size();
        newList.removeItem(0);

        assertEquals(newList.getList().size(), 1);

    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {

        TaskList newList = new TaskList();
        newList.addItemToList("Title", "description", "2022-19-22", true);

        assertFalse(newList.removeItem(2));

    }


}