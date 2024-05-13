import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JPanel {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        App panel = new App();
        panel.addShape(new Rect(10, 10, 50, 30));
        panel.addShape(new Circle(100, 100, 30));
        panel.addShape(new Triangle(new int[]{150, 170, 190}, new int[]{150, 120, 150}));
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}