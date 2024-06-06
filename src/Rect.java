import java.awt.*;
public class Rect extends Shape {
    private int width, height;

    public Rect(int x, int y, int width, int height) {
        super(x,y,Color.BLACK);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Rect() {
        super(0,0,Color.BLACK);
        this.x = 0;
        this.y = 0;
        this.width = 100;
        this.height = 500;
    }
    public Rect(Rect other) {
        super(other.getY(),other.getY(),Color.BLACK);
        this.x = other.getX();
        this.y = other.getY();
        this.width = other.getWidth();
        this.height = other.getHeight();
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
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

    @Override
    public String toString(){
        return super.toString() + " com altura de " + this.height + " e larguda de " + this.width;
    }

    @Override
    public void print(){
        System.out.println(toString());
    }
}