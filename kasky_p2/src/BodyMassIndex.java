public class BodyMassIndex {

    private double weight;
    private double height;
    private double bmi;

    public BodyMassIndex(double height, double weight) {

        this.weight = weight;
        this.height = height;

    }

    public double calcBMI() {

        double BMI;

        BMI = (703 * this.weight) / Math.pow(this.height, 2);

        this.bmi = BMI;

        return BMI;

    }

}
