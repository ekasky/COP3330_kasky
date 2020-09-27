import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BodyMassIndex {

    private double weight;
    private double height;
    private double bmi;
    private String cat;

    public BodyMassIndex(double height, double weight) {

        this.weight = weight;
        this.height = height;
        calcBMI();
        category();

    }

    public double calcBMI() {

        double BMI;

        BMI = (703 * this.weight) / Math.pow(this.height, 2);
        BMI = roundNumberOneDecimal(BMI);
        this.bmi = BMI;

        return BMI;

    }

    private static double roundNumberOneDecimal(double num) {

        double rounded = Math.round(num * 10.0) / 10.0;
        return rounded;


    }

    public String category() {

        if(this.bmi < 18.5) {

            this.cat = "Under Weight";
            return "Under Weight";

        }
        else if(this.bmi >= 18.5 && this.bmi <= 24.9) {

            this.cat = "Normal Weight";
            return "Normal Weight";

        }
        else if(this.bmi >= 25 && this.bmi <= 29.9) {

            this.cat = "Over Weight";
            return "Over Weight";

        }
        else if(this.bmi >= 30) {

            this.cat = "Obesity";
            return "Obesity";

        }
        else {

            this.cat = "ERROR";
            return "ERROR";

        }



    }


}
