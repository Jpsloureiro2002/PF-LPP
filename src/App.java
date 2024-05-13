import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JPanel {
    private List<Shape> shapes = new ArrayList<>();
    private Shape currentShape;

    public App() {
        setLayout(null);  // Usar layout nulo para posicionar shapes livremente

        JButton btnAddShape = new JButton("Adicionar Forma");
        btnAddShape.addActionListener(e -> promptForShape());

        JFrame frame = new JFrame("Formas Geométricas Interativas");
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.add(btnAddShape, BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (currentShape != null && SwingUtilities.isLeftMouseButton(e)) {
                    shapes.add(currentShape);
                    shapes.toString();
                    currentShape = null;
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (currentShape != null) {
                    currentShape.setPosition(e.getX() - currentShape.getCenter()[0], e.getY() - currentShape.getCenter()[1]);
                    repaint();
                }
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    private void promptForShape() {
        String[] options = {"Retângulo", "Quadrado", "Círculo", "Triângulo"};
        String choice = (String) JOptionPane.showInputDialog(null, "Escolha a forma:", "Adicionar Forma", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice != null) {
            switch (choice) {
                case "Retângulo":
                    int width = Integer.parseInt(JOptionPane.showInputDialog("Largura:"));
                    int height = Integer.parseInt(JOptionPane.showInputDialog("Altura:"));
                    currentShape = new Rect(0, 0, width, height);
                    break;
                case "Quadrado":
                    int side = Integer.parseInt(JOptionPane.showInputDialog("Lado:"));
                    currentShape = new Rect(0, 0, side, side);
                    break;
                case "Círculo":
                    int radius = Integer.parseInt(JOptionPane.showInputDialog("Raio:"));
                    currentShape = new Circle(0, 0, radius);
                    break;
                case "Triângulo":
                    // Implementar lógica para triângulo
                    break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
        if (currentShape != null) {
            currentShape.draw(g);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
