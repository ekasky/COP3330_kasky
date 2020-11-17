import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void setTitleValid() {

        TaskItem item = new TaskItem();
        String title = "Task 1";

        assertTrue(item.setTitle(title));

    }

    @Test
    public void failToSetTitle() {

        TaskItem item = new TaskItem();
        String title = "";

        assertFalse(item.setTitle(title));

    }

    @Test
    public void setDescription() {

        TaskItem item = new TaskItem();
        String description = "Test Task Description";

        assertTrue(item.setDescription(description));

    }

    @Test
    public void failWithInvalidDate() {

        TaskItem item = new TaskItem();
        String date = "2020/02/03";

        assertFalse(item.setDate(date));

    }

    @Test
    public void failWithInvalidDate2() {

        TaskItem item = new TaskItem();
        String date = "";

        assertFalse(item.setDate(date));
    }

    @Test
    public void failWithInvalidDate3() {

        TaskItem item = new TaskItem();
        String date = "2020-2-2";

        assertFalse(item.setDate(date));
    }

    @Test
    public void setValidDate() {

        TaskItem item = new TaskItem();
        String date = "2020-11-16";

        assertTrue(item.setDate(date));

    }

    @Test
    public void createInvalidTaskWithInvalidDate() {

        TaskItem item = new TaskItem();
        assertFalse(item.createItem("Title", "Description", "2020 1 02", false));

    }

    @Test
    public void createInvalidTaskWithInvalidTitle() {

        TaskItem item = new TaskItem();
        assertFalse(item.createItem("", "Description", "2020-01-10", true));

    }

    @Test
    public void createValidTaskWithValidDate() {

        TaskItem item = new TaskItem();
        assertTrue(item.createItem("Title", "Description", "2020-01-10", false));

    }

    @Test
    public void createValidTaskWithValidTitle() {

        TaskItem item = new TaskItem();
        assertTrue(item.createItem("Valid Title", "Description", "2020-01-10", false));

    }


}