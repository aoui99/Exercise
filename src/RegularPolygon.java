public class RegularPolygon {
    private int n;
    private double side;
    private double x;
    private double y;

    public RegularPolygon() {
        this.n = 3;
        this.side = 1.;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
        this.x = 0;
        this.y = 0;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public double getSide() {
        return side;
    }

    public int getN() {
        return n;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        double perimeter = this.side * this.n;
        return perimeter;
    }

    public double getAera() {
        int n = this.n;
        double s = this.side;
        double aera = n * s * s / (4 * Math.tan(Math.PI / n));
        return aera;
    }

}

class testRegularPolygon {
    public static void main(String[] args) {
        RegularPolygon rp1 = new RegularPolygon();
        RegularPolygon rp2 = new RegularPolygon(6, 4);
        RegularPolygon rp3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.printf("RP1的周长：%f\n", rp1.getPerimeter());
        System.out.printf("RP1的面积：%f\n", rp1.getAera());
        System.out.printf("RP2的周长：%f\n", rp2.getPerimeter());
        System.out.printf("RP2的面积：%f\n", rp2.getAera());
        System.out.printf("RP3的周长：%f\n", rp3.getPerimeter());
        System.out.printf("RP3的面积：%f\n", rp3.getAera());
    }
}
