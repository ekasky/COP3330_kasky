import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void makeItemFailsWithInvalidDueDate() {

        TaskItem item = new TaskItem();

        assertFalse(item.makeItem("Task One", "This is the first task", "2020-2-12", false));

    }

    @Test
    public void makeItemFailsWithInvalidTitle() {

        TaskItem item = new TaskItem();

        assertFalse(item.makeItem("", "This is the first task", "2020-12-07", false));

    }

    @Test
    public void makeItemSucceedsWithValidDueDate() {

        TaskItem item = new TaskItem();

        assertTrue(item.makeItem("Task 1", "Description for task one", "2021-01-12", true));

    }

    @Test
    public void testToString() {

        TaskItem item = new TaskItem();

        item.makeItem("Task 1", "Description for first task", "2021-12-01", false);

        assertEquals("[2021-12-01] Task 1: Description for first task", item.toString());

    }

}