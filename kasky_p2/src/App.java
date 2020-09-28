import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    // Asks user if they have more data to enter
    private static boolean moreInput() {

        char userInput;

        System.out.print("Do you have more data Y or N: ");
        userInput = input.next().charAt(0);
        userInput = Character.toUpperCase(userInput);

        switch (userInput) {

            case 'Y':
                return true;

            case 'N':
                return false;

            default:
                System.out.println("ERROR: Invalid input -  Y or N");
                return moreInput();

        }

    }

    //Gets a positive double from user
    private static double getPositiveDouble(String message) {

        double posDouble;
        System.out.print(message);
        posDouble = input.nextDouble();

        if(posDouble < 0) {
            System.out.println("ERROR: Cannot be negative");
            return getPositiveDouble(message);
        }

        return posDouble;

    }

    // Gets Height from user
    private static double getUserHeight() {

        return getPositiveDouble("Enter Height in inches: ");

    }

    // Gets Weight from user
    private static double getUserWeight() {

        return getPositiveDouble("Enter Weight in pounds: ");

    }

    //Rounds a double to one decimal place
    public static double roundDoubleODP(double number) {

        return Math.round(number * 10.0) / 10.0;

    }

    //Prints last entered BMI and category
    private static void displayBmiInfo(BodyMassIndex bmi) {

        System.out.println("BMI: " + bmi.getBmi());
        System.out.println("Category: " + bmi.getCat());

    }

    //Prints average BMI from data entered

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {

        Iterator itr = bmiData.iterator();
        double bmiAvg = 0;

        while(itr.hasNext()) {

            BodyMassIndex temp = (BodyMassIndex)itr.next();
            bmiAvg += temp.getBmi();

        }

        bmiAvg = bmiAvg / bmiData.size();
        bmiAvg = roundDoubleODP(bmiAvg);

        System.out.println("Average BMI: " + bmiAvg);


    }


}
