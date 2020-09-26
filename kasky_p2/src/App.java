import java.util.Scanner;

public class App {

    private static final Scanner input = new Scanner(System.in);


    /*
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


     */

    public static void main(String[] args) {

        double height = getUserHeight();
        double weight = getUserWeight();

        System.out.println(height);
        System.out.println(weight);
        
    }


    private static boolean moreInput() {

        char moreData;

        System.out.println("Enter more data [Y or N]: ");
        moreData = input.next().charAt(0);

        moreData = Character.toUpperCase(moreData);

        switch (moreData) {

            case 'Y':
                return true;

            case 'N':
                return false;

            default:
                System.out.println("Please enter either Y or N");
                return moreInput();

        }

    }

    private static double getPositiveDouble(String message) {

        double posDouble;

        posDouble = input.nextDouble();
        input.nextLine();

        if(posDouble < 0) {

            System.out.println("ERROR: Cannot be negative");
            System.out.print(message);
            return getPositiveDouble(message);

        }

        return posDouble;

    }

    private static double getUserHeight() {

        double height;

        System.out.print("Enter user's height [inches]: ");
        height = getPositiveDouble("Enter user's height [inches]: ");

        return height;


    }

    private static double getUserWeight() {

        double weight;

        System.out.print("Enter user's weight [lbs]: ");
        weight = getPositiveDouble("Enter user's weight [lbs]: ");

        return weight;

    }

}
