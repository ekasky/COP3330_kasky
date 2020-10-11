public class Cube extends Shape3D {

    private double length;

    public Cube(double length) {
        this.length = length;
    }


    @Override
    public double calcArea3D() {
        double area;
        area = 6 * Math.pow(length, 2);
        return area;
    }

    @Override
    public double calcVolume() {
        double volume;
        volume = Math.pow(length, 3);
        return volume;
    }

    @Override
    public double getVolume() {
        return calcVolume();
    }

    @Override
    public String getName() {
        return "cube";
    }

    @Override
    public double getArea() {
        return calcArea3D();
    }
}
