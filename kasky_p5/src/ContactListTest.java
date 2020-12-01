import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize() {

        ContactList list = new ContactList();
        int size = list.getList().size();
        list.addItem("Bob", "Jones", "987-654-3210", "bjones@outlook.com");
        boolean compare = size == list.getList().size();
        assertFalse(compare);


    }

    @Test
    public void editingItemsFailsWithAllBlankValues() {

        ContactList list = new ContactList();

        list.addItem("Bob", "Smith", "567-987-5453", "b.smith@gmail.com");

        assertFalse(list.editItem(0, "", "", "", ""));

    }

    @Test
    public void editingItemsFailsWithInvalidIndex() {

        ContactList list = new ContactList();

        list.addItem("Bob", "Smith", "567-987-5453", "b.smith@gmail.com");

        assertFalse(list.editItem(12, "Bobby", "Smith", "333-444-5555", "bobsmith@outlook.com"));

    }

    @Test
    public void editingSucceedsWithBlankFirstName() {

        ContactList list = new ContactList();

        list.addItem("Bob", "Smith", "567-987-5453", "b.smith@gmail.com");

        assertTrue(list.editItem(0, "", "Smith", "333-444-5555", "bobsmith@outlook.com"));

    }

    @Test
    public void editingSucceedsWithBlankLastName() {

        ContactList list = new ContactList();

        list.addItem("Bob", "Smith", "567-987-5453", "b.smith@gmail.com");

        assertTrue(list.editItem(0, "Bob", "", "333-444-5555", "bobsmith@outlook.com"));

    }

    @Test
    public void editingSucceedsWithBlankPhone() {

        ContactList list = new ContactList();

        list.addItem("Bob", "Smith", "567-987-5453", "b.smith@gmail.com");

        assertTrue(list.editItem(0, "Bob", "Smith", "", "bobsmith@outlook.com"));

    }

    @Test
    public void editingSucceedsWithBlankEmail() {

        ContactList list = new ContactList();

        list.addItem("Bob", "Smith", "567-987-5453", "b.smith@gmail.com");

        assertTrue(list.editItem(0, "Bob", "Smith", "234-556-2347", ""));

    }

    @Test
    public void editingSucceedsWithNonBlankValues() {

        ContactList list = new ContactList();

        list.addItem("Bob", "Smith", "567-987-5453", "b.smith@gmail.com");

        assertTrue(list.editItem(0, "Bob", "Smith", "234-556-2347", "bobsmith@outlook.com"));

    }

    @Test
    public void newListIsEmpty() {

        ContactList list = new ContactList();

        assertTrue(list.getList().size() == 0);

    }

    @Test
    public void removingItemsDecreasesSize() {

        ContactList list = new ContactList();

        list.addItem("Joe", "Smith", "865-234-1245", "smith@gmail.com");

        list.removeItem(0);

        assertTrue(list.getList().size() != 1);

    }

    @Test
    public void removingItemsFailsWithInvalidIndex() {

        ContactList list = new ContactList();

        list.addItem("Joe", "Smith", "865-234-1245", "smith@gmail.com");

        assertFalse(list.removeItem(77));

    }

    @Test
    public void savedContactListCanBeLoaded() {

        ContactList list = new ContactList();

        assertTrue(list.loadList("contactTest"));

    }

}