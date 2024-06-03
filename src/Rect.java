import java.awt.*;
public class Rect extends Shape {
    private int x, y, width, height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public int[] getCenter(){
        x = (int) (width / 2);
        y = (int) (height / 2);
        return new int[]{ x , y };
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calcArea(){
        return width * height;
    }
}