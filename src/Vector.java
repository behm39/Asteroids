
public class Vector {

    private double x, y;

    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(double theta) {
        this.x = Math.cos(theta);
        this.y = Math.sin(theta);
    }

    public Vector(Vector v) {
        this.x = v.getX();
        this.y = v.getY();
    }

    public void add(Vector v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public void sub(Vector v) {
        this.x -= v.getX();
        this.y -= v.getY();
    }

    public double getDistance(Vector v) {
        double dx = this.x - v.getX();
        double dy = this.y - v.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void scale(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    public double getMag() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public void setMag(double mag) {
        double oldmag = this.getMag();
        this.x /= oldmag;
        this.y /= oldmag;
        this.scale(mag);
    }

    public double getTheta() {
        if (this.x == 0) {
            return 0;
        }
        return Math.atan(this.y / this.x);
    }

    public void setTheta(double theta) {
        double mag = this.getMag();
        this.x = Math.cos(theta);
        this.y = Math.sin(theta);
        this.scale(mag);
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
