import java.util.Scanner;

public class DueDate {

    private int year;
    private int month;
    private int day;
    Scanner input = new Scanner(System.in);

    DueDate() {

        setYear();
        setMonth();
        setDay(year, month);

    }

    public void setYear() {

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

        this.year = year;

    }

    public void setMonth() {

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

        this.month = month;

    }

    public boolean leapYear(int year) {

        boolean leap = false;

        if(year % 400 == 0) {
            leap = true;
        }
        else if(year % 4 == 0 && year % 100 != 0) {
            leap = true;
        }
        else {
            leap = false;
        }

        return leap;

    }

    public void setDay(int year, int month) {

        boolean leap = leapYear(year);
        Scanner input = new Scanner(System.in);
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;

        if(leap) {
            numberOfDays[1] = 29;
        }

        do {

            System.out.print("Enter a day with format [dd]: ");

            while(!input.hasNextInt()) {

                System.out.print("Error...Not a valid day...Try again: ");
                input.next();
            }

            day = input.nextInt();

            if(day < 0 || day > numberOfDays[month-1]) {
                System.out.println("Error...Not a valid day...Try again");
            }

        } while(day < 1 || day > numberOfDays[month-1]);

        this.day = day;

    }

    @Override
    public String toString() {

        return "[" + year + "-" + month + "-" + day + "]";

    }
}
