import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    void getTitle() {

        TaskItem item = new TaskItem("Task", "Description", "2020-11-16", false);

        String title = "Task";
        assertEquals(item.getTitle(), title);

    }

    @Test
    void setTitle() {

        TaskItem item = new TaskItem("Task", "Description", "2020-11-16", false);

        String title = "Title";

        item.setTitle(title);

        assertEquals(item.getTitle(), title);

    }

    @Test
    void getDescription() {

        TaskItem item = new TaskItem("Task", "Description", "2020-11-16", false);

        assertEquals(item.getDescription(), "Description");
    }

    @Test
    void setDescription() {

        TaskItem item = new TaskItem("Task", "Description", "2020-11-16", false);

        String description = "Test Description";

        item.setDescription(description);

        assertEquals(item.getDescription(), description);

    }

    @Test
    void getDate() {

        TaskItem item = new TaskItem("Task", "Description", "2020-11-16", false);

        assertEquals(item.getDate(), "2020-11-16");

    }

    @Test
    void isComplete() {

        TaskItem item = new TaskItem("Task", "Description", "2020-11-16", true);

        assertTrue(item.isComplete());

    }

    @Test
    void setComplete() {

        TaskItem item = new TaskItem("Task", "Description", "2020-11-16", true);

        boolean complete = false;

        item.setComplete(complete);

        assertFalse(item.isComplete());

    }

    @Test
    void isTitleValid() {

        TaskItem item = new TaskItem("Valid Title", "Description", "2020-11-16", true);

        assertTrue(item.isTitleValid());

    }

    @Test
    void isDateValid() {

        TaskItem item = new TaskItem("Valid Title", "Description", "2020-11-16", true);

        assertTrue(item.isDateValid());

    }
}