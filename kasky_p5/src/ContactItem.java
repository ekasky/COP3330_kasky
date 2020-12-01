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



}
