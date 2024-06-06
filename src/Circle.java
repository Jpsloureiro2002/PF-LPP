import java.awt.*;
public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x,y,Color.BLACK);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public Circle() {
        super(0,0,Color.BLACK);
        this.x = 0;
        this.y = 0;
        this.radius = 100;
    }
    public Circle(Circle other) {
        super(other.getX(),other.getY(),Color.BLACK);
        this.x = other.getX();
        this.y = other.getY();
        this.radius = other.getRadius();
    }

    public int getRadius() {
        return radius;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int[] getCenter(){
        return new int[]{ radius/2 , radius/2 };
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(x, y, radius, radius);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calcArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString(){
        return super.toString() + " e de raio " + this.radius;
    }

    @Override
    public void print(){
        System.out.println(toString());
    }
}