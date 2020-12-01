import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues() {

        ContactItem item = new ContactItem();

        assertFalse(item.createContact("", "", "", ""));

    }

    @Test
    public void creationSucceedsWithBlankEmail() {

        ContactItem item = new ContactItem();

        assertTrue(item.createContact("Joe", "Smith", "123-456-7890", ""));

    }

    @Test
    public void creationSucceedsWithBlankFirstName() {

        ContactItem item = new ContactItem();

        assertTrue(item.createContact("", "Smith", "123-456-7890", "j.smith@gmail.com"));

    }

    @Test
    public void creationSucceedsWithBlankLastName() {

        ContactItem item = new ContactItem();

        assertTrue(item.createContact("Joe", "", "123-456-7890", "j.smith@gmail.com"));

    }

    @Test
    public void creationSucceedsWithBlankPhone() {

        ContactItem item = new ContactItem();

        assertTrue(item.createContact("Joe", "Smith", "", "j.smith@gmail.com"));

    }

    @Test
    public void creationSucceedsWithNonBlankValues() {

        ContactItem item = new ContactItem();

        assertTrue(item.createContact("Joe", "Smith", "123-456-7890", "j.smith@gmail.com"));

    }

    @Test
    public void testToString() {

        ContactItem item = new ContactItem();
        item.createContact("Joe", "Smith", "123-456-7890", "j.smith@gmail.com");

        assertEquals("Name: Joe Smith\nPhone: 123-456-7890\nEmail: j.smith@gmail.com", item.toString());

    }


}