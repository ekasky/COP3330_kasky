import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class ContactItem {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    ContactItem() {
        firstName = " ";
        lastName = " ";
        phoneNumber = " ";
        email = " ";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    private boolean setFirstName(String firstName) {

        if (firstName.length() < 1) {
            System.out.println("No First Name Set");
            return false;
        }

        this.firstName = firstName;
        return true;

    }

    private boolean setLastName(String lastName) {

        if (lastName.length() < 1) {
            System.out.println("No Last Name Set");
            return false;
        }

        this.lastName = lastName;
        return true;

    }

    private boolean valPhoneNumber(String phoneNumber) {

        try {
            MaskFormatter formatter = new MaskFormatter("###-###-####");
            formatter.valueToString(phoneNumber);
            return true;
        } catch (ParseException e) {
            System.out.println("\nWARNING: Phone number must be formatted XXX-XXX-XXXX. Phone number not added.\n");
            return false;
        }

    }

    private boolean setPhoneNumber(String phoneNumber) {

        if (phoneNumber.length() < 1) {
            System.out.println("No Phone Number Added");
            return false;
        }

        if (valPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            return true;
        }
        else {
            return false;
        }

    }

    private boolean setEmail(String email) {

        if(email.length() < 1) {
            System.out.println("No Email Set");
            return false;
        }

        this.email = email;
        return true;

    }

    public boolean createContact(String firstName, String lastName, String phoneNumber, String email) {

        boolean valFN = setFirstName(firstName);
        boolean valLN = setLastName(lastName);
        boolean valPhone = setPhoneNumber(phoneNumber);
        boolean valEmail = setEmail(email);

        if(!valFN && !valLN && !valPhone && !valEmail) {
            System.out.println("\nWARNING: At least on field must be completed. Contact no created.\n");
            return false;
        }

        return true;

    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\nPhone: " + phoneNumber + "\nEmail: " + email;
    }
}
