
import java.awt.*;


abstract class Shape {
    protected int x, y;
    protected Color color;
    public abstract void draw(Graphics g);
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public abstract int[] getCenter();
    public abstract double calcArea();

}
