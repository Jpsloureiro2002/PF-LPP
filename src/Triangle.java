import java.awt.*;
public class Triangle extends Shape {
    private int[] xPoints, yPoints;

    public Triangle(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    @Override
    public void draw(Graphics g) {
        g.drawPolygon(xPoints, yPoints, 3);
    }
}