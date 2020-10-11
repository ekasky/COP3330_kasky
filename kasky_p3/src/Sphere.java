public class Sphere extends Shape3D {

    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }


    @Override
    public double calcArea3D() {
        double area;
        area = 4 * Math.PI * Math.pow(radius, 2);
        return area;
    }

    @Override
    public double calcVolume() {
        double volume;
        volume = (4.0/3.0) * (Math.PI * Math.pow(radius, 3));
        return volume;
    }

    @Override
    public double getVolume() {
        return calcVolume();
    }

    @Override
    public String getName() {
        return "sphere";
    }

    @Override
    public double getArea() {
        return calcArea3D();
    }
}
