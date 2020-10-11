public class Pyramid extends Shape3D {

    private double length;
    private double width;
    private double height;

    public Pyramid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }


    @Override
    public double calcArea3D() {
        double area;
        area = length * width + length * Math.sqrt( Math.pow(width/2, 2) + Math.pow(height, 2) )
                + width * Math.sqrt( Math.pow(length/2, 2) + Math.pow(height, 2) );
        area = Math.round(area * 100.0) / 100.0;
        return area;
    }

    @Override
    public double calcVolume() {
        double volume;
        volume = (length * width * height) / 3;
        return volume;
    }

    @Override
    public double getVolume() {
        return calcVolume();
    }

    @Override
    public String getName() {
        return "pyramid";
    }

    @Override
    public double getArea() {
        return calcArea3D();
    }


}
