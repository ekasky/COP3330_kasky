import java.util.Scanner;

public class DueDate {

    Scanner input = new Scanner(System.in);

    public int getYear() {

        int year;

        do {

            System.out.print("Enter a year with format [yyyy]: ");

            while(!input.hasNextInt()) {
                System.out.print("Error...Year not valid...Try again: ");
                input.next();
            }

            year = input.nextInt();

            if(year < 0) {
                System.out.println("Error...Year not valid...Try again");
            }

        } while(year < 0);

        return year;

    }

}
