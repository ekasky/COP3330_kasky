import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class ContactItem {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

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

    public boolean setFirstName(String firstName) {


        if(firstName.length() > 1) {
            this.firstName = firstName;
            return true;
        }
        else {
            return false;
        }

    }

    public boolean setLastName(String lastName) {

        if(lastName.length() > 1) {
            this.lastName = lastName;
            return true;
        }
        else {
            return false;
        }

    }

    private boolean valPhone(String phoneNumber) {

        try {
            MaskFormatter formatter = new MaskFormatter("(AAA)-AAA-AAAA");
            formatter.valueToString(phoneNumber);
            return true;
        }
        catch (ParseException e) {
            return false;
        }

    }

    public boolean setPhoneNumber(String phoneNumber) {

        if(valPhone(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            System.out.println(phoneNumber);
            return true;
        }
        else {
            return false;
        }


    }

    private boolean valEmail(String email) {

        if(email.contains("@")) {
            return true;
        }
        else {
            return false;
        }

    }

    public boolean setEmail(String email) {

        if(valEmail(email)) {
            this.email = email;
            return true;
        }
        else {
            return false;
        }

    }

}
