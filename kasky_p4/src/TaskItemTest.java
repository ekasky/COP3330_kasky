import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    // ****************** Failed is title Valid Test ******************

    @Test
    public void isTitleValidFail() {

        TaskItem item = new TaskItem("", "Description", "2020-02-05", false);

        assertEquals(item.isTitleValid(), false);

    }

    // ****************** Successful is title Valid Test ******************

    @Test
    public void isTitleValid() {

        TaskItem item = new TaskItem("Task", "Description", "2020-02-05", false);

        assertEquals(item.isTitleValid(), true);

    }

    @Test
    public void isTitleValid2() {

        TaskItem item = new TaskItem("1", "Description", "2020-02-05", false);

        assertEquals(item.isTitleValid(), true);

    }

    @Test
    public void isTitleValid3() {

        TaskItem item = new TaskItem("Task One", "Description", "2020-02-05", false);

        assertEquals(item.isTitleValid(), true);

    }

    // ********* is Date Valid fail tests ***********

    @Test
    public void isDateValidFail() {

        TaskItem item = new TaskItem("Task One", "Description", "2020-2-05", false);

        assertEquals(item.isDateValid(), false);
    }

    @Test
    public void isDateValidFail2() {

        TaskItem item = new TaskItem("Task One", "Description", "20200205", false);

        assertEquals(item.isDateValid(), false);
    }

    @Test
    public void isDateValidFail3() {

        TaskItem item = new TaskItem("Task One", "Description", "2020/07/12", false);

        assertEquals(item.isDateValid(), false);
    }

    // ********* is Date Valid pass tests ***********

    @Test
    public void isDateValid() {

        TaskItem item = new TaskItem("Task One", "Description", "2020-02-05", false);

        assertEquals(item.isDateValid(), true);
    }

    @Test
    public void isDateValid2() {

        TaskItem item = new TaskItem("Task One", "Description", "2025-02-14", false);

        assertEquals(item.isDateValid(), true);
    }

}