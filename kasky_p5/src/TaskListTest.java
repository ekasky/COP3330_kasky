import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingItemsIncreasesSize() {

        TaskList list = new TaskList();

        list.addTask("Task 1", "This is the first task", "2023-05-01", false);
        list.addTask("Task 2", "This is the second task", "2050-12-16", false);

        assertTrue(list.getList().size() == 2);

    }

    @Test
    public void completingTaskItemChangesStatus() {

        TaskList list = new TaskList();
        list.addTask("Task 1", "This is the first task", "2023-05-01", false);
        list.getList().get(0).markAsComplete();
        assertTrue(list.getList().get(0).isComplete());

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {

        boolean complete;

        TaskList list = new TaskList();
        list.addTask("Task 1", "This is the first task", "2023-05-01", false);

        if(list.valIndex(-3)) {
            list.getList().get(-3).markAsComplete();
            complete = true;
        }
        else {
            complete = false;
        }

        assertFalse(complete);

    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertFalse(list.editItem(12, "Task", "New Description", "2020-05-12"));

    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertTrue(list.editItem(0, "Task", "New Description", "2020-05-12"));

    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertTrue(list.editItem(0, "Task", "Task Description", "2034-12-07"));

    }

    @Test
    public void editingItemTitleFailsWithEmptyString() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertFalse(list.editItem(0, "", "Task Description", "2034-12-07"));

    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertFalse(list.editItem(110, "Task", "Task Description", "2034-12-07"));

    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertTrue(list.editItem(0, "Task", "Task Description", "2034-12-07"));

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertFalse(list.editItem(0, "Task", "Task Description", "20e24-12-7"));

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertFalse(list.editItem(56, "Task", "Task Description", "2024-12-23"));

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD() {

        TaskList list = new TaskList();
        list.addTask("Task", "Task Description", "2020-05-12", false);

        assertFalse(list.editItem(0, "Task", "Task Description", "2021202"));

    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex() {

        boolean complete;

        TaskList list = new TaskList();

        list.addTask("Task 1", "This is the first task", "2001-03-12", false);

        if(list.valIndex(90)) {
           String description = list.getList().get(90).getDescription();
           complete = true;
        }
        else {
            complete = false;
        }

        assertFalse(complete);

    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex() {

        boolean complete;
        String description = "";

        TaskList list = new TaskList();

        list.addTask("Task 1", "This is the first task", "2001-03-12", false);

        if(list.valIndex(0)) {
            description = list.getList().get(0).getDescription();
            complete = true;
        }
        else {
            complete = false;
        }

        assertEquals("This is the first task", description);

    }

    @Test
    public void gettingItemDueDateFailsWithInvalidIndex() {

        boolean complete;
        String dueDate;

        TaskList list = new TaskList();

        list.addTask("Task 1", "This is the first task", "2001-03-12", false);

        if(list.valIndex(-12)) {
            dueDate = list.getList().get(-12).getDate();
            complete = true;
        }
        else {
            complete = false;
        }

        assertFalse(complete);

    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex() {

        boolean complete;
        String dueDate = "";

        TaskList list = new TaskList();

        list.addTask("Task 1", "This is the first task", "2001-03-12", false);

        if(list.valIndex(0)) {
            dueDate = list.getList().get(0).getDate();
            complete = true;
        }
        else {
            complete = false;
        }

        assertEquals("2001-03-12", dueDate);

    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex() {

        boolean complete;
        String title;

        TaskList list = new TaskList();

        list.addTask("Task 1", "This is the first task", "2001-03-12", false);

        if(list.valIndex(100)) {
            title = list.getList().get(100).getTitle();
            complete = true;
        }
        else {
            complete = false;
        }

        assertFalse(complete);

    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex() {

        boolean complete;
        String title = "";

        TaskList list = new TaskList();

        list.addTask("Task 1", "This is the first task", "2001-03-12", false);

        if(list.valIndex(0)) {
            title = list.getList().get(0).getTitle();
            complete = true;
        }
        else {
            complete = false;
        }

        assertEquals("Task 1", title);

    }

    @Test
    public void newListIsEmpty() {

        TaskList list = new TaskList();

        assertTrue(list.getList().size() == 0);

    }

    @Test
    public void removingItemsDecreasesSize() {

        TaskList list = new TaskList();

        list.addTask("Task 1", "Task 1 Description", "2020-03-04", false);
        list.addTask("Task 2", "Task 2 Description", "2021-03-04", true);
        list.addTask("Task 3", "Task 3 Description", "2022-03-04", false);

        int size = list.getList().size();

        list.removeItem(1);

        assertTrue(size > list.getList().size());

    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {

        TaskList list = new TaskList();

        list.addTask("Task 1", "Task 1 Description", "2020-03-04", false);
        list.addTask("Task 2", "Task 2 Description", "2021-03-04", true);
        list.addTask("Task 3", "Task 3 Description", "2022-03-04", false);

        int size = list.getList().size();

        assertFalse(list.removeItem(13));


    }

    @Test
    public void savedTaskListCanBeLoaded() {

        TaskList list = new TaskList();

        assertTrue(list.loadList("taskTest"));

    }

    @Test
    public void uncompletingTaskItemChangesStatus() {

        TaskList list = new TaskList();

        list.addTask("Task 1", "Task", "2020-03-12", true);

        assertFalse(list.getList().get(0).UnMarkAsComplete());

    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {

        boolean complete;

        TaskList list = new TaskList();

        list.addTask("Task 1", "Task", "2020-03-12", true);

        if(list.valIndex(112)) {
            complete = true;
            list.getList().get(112).UnMarkAsComplete();
        }
        else {
            complete = false;
        }

        assertFalse(complete);

    }


}