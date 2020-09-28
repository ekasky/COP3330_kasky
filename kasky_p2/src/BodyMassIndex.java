public class BodyMassIndex {

    private double height;
    private double weight;
    private double bmi;
    private String cat;

    public BodyMassIndex(double height, double weight) {

            this.height = height;
            this.weight = weight;
            calcBmi();
            category();

    }

    public double getBmi() {
        return bmi;
    }

    public String getCat() {
        return cat;
    }

    public void calcBmi() {

        bmi = (703 * weight) / Math.pow(height, 2);
        bmi = App.roundDoubleODP(bmi);

    }

    public void category() {

        if(bmi < 18.5) {
            cat = "Under Weight";
        }
        else if( bmi >= 18.5 && bmi <= 24.9 ) {
            cat = "Normal Weight";
        }
        else if(bmi >= 25 && bmi <= 29.9) {
            cat = "Over Weight";
        }
        else if(bmi >= 30) {
            cat = "Obese";
        }
        else {
            cat = "ERROR";
        }

    }

}
