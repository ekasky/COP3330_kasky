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

    public int getMonth() {

        int month;

        do {

            System.out.print("Enter a month with format [mm]: ");

            while(!input.hasNextInt()) {
                System.out.print("Error...Not a valid month...Try again: ");
                input.next();
            }

            month = input.nextInt();

            if(month < 0 || month > 12) {
                System.out.println("Error...Not a valid month...Try again");
            }

        } while(month < 1 || month > 12);

        return month;

    }

}
