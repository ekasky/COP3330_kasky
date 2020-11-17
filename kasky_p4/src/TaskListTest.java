import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    TaskList list = new TaskList();

    @Test
    void isTaskValid() {

        TaskItem item = new TaskItem("Title", "description", "2020-11-16", true);

        assertTrue(TaskList.isTaskValid(item));


    }

    @Test
    public void newListIsEmpty() {

        TaskList list = new TaskList();
        int size = list.getList().size();
        assertEquals(size, 0);

    }

    @Test
    public void addingTaskItemsIncreasesSize(){

        int size = list.getList().size();
        TaskItem item = new TaskItem("Title", "description", "2020-11-16", true);
        list.getList().add(item);

        assertNotEquals(size, list.getList().size());

    }

}