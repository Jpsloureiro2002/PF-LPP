import java.awt.*;
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
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
}