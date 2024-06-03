import java.awt.*;

public class Triangle extends Shape {
    private int[] xPoints, yPoints;

    public Triangle(int base, int height) {
        // Calculate the coordinates based on the base and height
        int halfBase = base / 2;
        xPoints = new int[]{-halfBase, halfBase, 0};
        yPoints = new int[]{0, 0, -height};
    }

    @Override
    public void draw(Graphics g) {
        g.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void setPosition(int x, int y) {
        int[] center = getCenter();
        int deltaX = x - center[0];
        int deltaY = y - center[1];
    
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] += deltaX;
            yPoints[i] += deltaY;
        }
    }
    
    @Override
    public int[] getCenter() {
        int xSum = 0, ySum = 0;
        for (int i = 0; i < xPoints.length; i++) {
            xSum += xPoints[i];
            ySum += yPoints[i];
        }
        return new int[]{xSum / xPoints.length, ySum / yPoints.length};
    }

    @Override
    public double calcArea() {
        // Base is the distance between the first two points
        int base = Math.abs(xPoints[1] - xPoints[0]);
        // Height is the distance from the base to the top vertex
        int height = Math.abs(yPoints[2] - yPoints[0]);
        return (base * height) / 2.0;
    }
}
