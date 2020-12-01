import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList extends ListTemplate {

    private ArrayList<ContactItem> list = new ArrayList<>();

    public ArrayList<ContactItem> getList() {
        return list;
    }

    @Override
    public boolean valIndex(int index) {

        try {
            list.get(index);
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }

    }

    @Override
    public void printList() {

        System.out.println("Contact List");
        System.out.println("------------");
        for(int i = 0; i < list.size(); i++)
            System.out.println(i + ") " + list.get(i).toString());
        System.out.println();

    }

    public boolean addItem(String firstName, String lastName, String phoneNumber, String email) {

        ContactItem item = new ContactItem();

       boolean val = item.createContact(firstName, lastName, phoneNumber, email);

       if(val) {
           list.add(item);
           return true;
       }
       else {
           return false;
       }

    }

    public boolean editItem(int index, String firstName, String lastName, String phoneNumber, String email) {

        if(valIndex(index)) {

            ContactItem item = new ContactItem();
            boolean val = item.createContact(firstName, lastName, phoneNumber, email);

            if(val) {
                list.set(index, item);
                return true;
            }
            else {
                return false;
            }

        }
        else {
            System.out.println("\nWARNING: Invalid Contact. Nothing to edit.\n");
            return false;
        }



    }

    @Override
    public boolean removeItem(int index) {

        if(valIndex(index)) {
            list.remove(index);
            return true;
        }
        else {
            System.out.println("\nWARNING: Invalid Contact. Nothing to remove.\n");
            return false;
        }

    }

    @Override
    public boolean saveList(String filename) {

        String path = filename + ".txt";

        try {

            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(int i = 0; i < list.size(); i++) {

                printWriter.println(list.get(i).getFirstName());
                printWriter.println(list.get(i).getLastName());
                printWriter.println(list.get(i).getPhoneNumber());
                printWriter.println(list.get(i).getEmail());

            }

            printWriter.close();
            return true;

        }
        catch (IOException e) {
            return false;
        }

    }

    @Override
    public boolean loadList(String filename) {

        String firstName, lastName, phoneNumber, email;

        String path = filename + ".txt";

        try {

            File file = new File(path);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {

                firstName = reader.nextLine();
                lastName = reader.nextLine();
                phoneNumber = reader.nextLine();
                email = reader.nextLine();

                addItem(firstName, lastName, phoneNumber, email);

            }

            return true;

        }
        catch (FileNotFoundException e) {
            System.out.println("\nWARNING: Could not open file.\n");
            return false;
        }

    }
}
