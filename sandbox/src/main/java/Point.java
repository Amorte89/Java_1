public class Point {

    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Point p1(double x1, double y1) {
        this.x1 = x1;
        this.y1 = y1;

        return this;
    }

    public Point p2(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;

        return this;
    }

    public double distance(Point p2) {
        double d = Math.sqrt((p2.x2 - this.x1) * (p2.x2 - this.x1) + (p2.y2 - this.y1) * (p2.y2 - this.y1));
        return d;
    }

    @Override
    public String toString() {

        return this.x1 + ";" + this.y1;
    }

    public String toString1() {

        return this.x2 + ";" + this.y2;
    }
}