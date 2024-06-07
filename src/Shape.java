import java.awt.*;

public abstract class Shape implements Cloneable {
    protected int x, y;
    protected Color color;

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Shape() {
        this.x = 0;
        this.y = 0;
        this.color = Color.white;
    }

    public Shape(Shape other) {
        this.x = other.x;
        this.y = other.y;
        this.color = new Color(other.color.getRGB());
    }

    public abstract void draw(Graphics g);

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract int[] getCenter();
    public abstract double calcArea();

    @Override
    public Shape clone() {
        try {
            Shape cloned = (Shape) super.clone();
            cloned.color = new Color(this.color.getRGB());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shape shape = (Shape) obj;
        return x == shape.x && y == shape.y && (color != null ? color.equals(shape.color) : shape.color == null);
    }

    @Override
    public String toString() {
        String typeName = getClass().getSimpleName();
        return String.format("%s nas coordenadas (%d, %d) com a cor %s", typeName, x, y, colorToString());
    }

    private String colorToString() {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    public void print() {
        System.out.println(this.toString());
    }
}


