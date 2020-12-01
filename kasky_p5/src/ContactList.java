import java.util.ArrayList;

public class ContactList {

    public ArrayList<ContactItem> list = new ArrayList<>();

    public boolean addContact(String firstName, String lastName, String phoneNumber, String email) {

        ContactItem item = new ContactItem();

        boolean val = item.makeContact(firstName, lastName, phoneNumber, email);

        if(val) {
            list.add(item);
            return true;
        }
        else {
            return false;
        }

    }

    public void printList() {

        System.out.println("Current List");
        System.out.println("------------");
        for(int i = 0; i < list.size(); i++)
            System.out.println(i + ") " + list.get(i).toString());
        System.out.println();

    }

}
