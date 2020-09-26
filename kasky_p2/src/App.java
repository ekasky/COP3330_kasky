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

        double x = getPositiveDouble();

        System.out.println(x);

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

    private static double getPositiveDouble() {

        double posDouble;

        posDouble = input.nextDouble();
        input.nextLine();

        if(posDouble < 0) {

            System.out.println("ERROR: Cannot be negative");
            return getPositiveDouble();

        }

        return posDouble;

    }

}
