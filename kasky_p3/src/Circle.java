public class Circle extends Shape2D {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double calcArea2D() {
        double area;
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    @Override
    public String getName() {
        return "circle";
    }

    @Override
    public double getArea() {
        return calcArea2D();
    }
}
