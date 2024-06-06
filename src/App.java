import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class App extends JPanel {
    private List<Shape> shapes = new ArrayList<>();
    private Shape currentShape;

    public App() {
        setLayout(new BorderLayout());  // Define o layout do JPanel principal

        // Cria um novo JPanel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Usa FlowLayout para alinhar os botões lado a lado

        JButton btnAddShape = new JButton("Adicionar Forma");
        JButton btnCalcAr = new JButton("Calcular Área");
        JButton btnPrintShapes = new JButton("Imprimir Formas");

        JFrame frame = new JFrame("Planta de Casa");
        btnAddShape.addActionListener(e -> promptForShape());
        btnCalcAr.addActionListener(e -> calArea(frame));
        btnPrintShapes.addActionListener(e -> printShapes()); 

        // Adiciona os botões ao JPanel de botões
        buttonPanel.add(btnAddShape);
        buttonPanel.add(btnCalcAr);
        buttonPanel.add(btnPrintShapes);

        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);  // Adiciona o painel de botões ao sul do JFrame
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
                    int base = Integer.parseInt(JOptionPane.showInputDialog("Base:"));
                    int triHeight = Integer.parseInt(JOptionPane.showInputDialog("Altura:"));
                    currentShape = new Triangle(base, triHeight);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Forma desconhecida: " + choice);
                    break;
            }
        }
    }

    private void calArea(JFrame frame){
        double area = 0;
        for (Shape shape : shapes) {
            area += shape.calcArea();
        }

        System.out.println(area);
        JOptionPane.showMessageDialog(frame, String.format("%.2f m^2", area), "Área", JOptionPane.INFORMATION_MESSAGE);
    }
    private void printShapes() {
        if (shapes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há formas para exibir.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    
        // Criar um JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Detalhes da Forma");
        dialog.setSize(500, 500);
        dialog.setLayout(new BorderLayout());
    
        // Área de texto para exibir informações da forma
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        dialog.add(scrollPane, BorderLayout.CENTER);
    
        // Botão Next para navegar pelas formas
        JButton nextButton = new JButton("Next");
        dialog.add(nextButton, BorderLayout.SOUTH);
    
        // Define um index inicial e atualiza a área de texto com a primeira forma
        final int[] currentIndex = {0};
        textArea.setText(shapes.get(currentIndex[0]).toString());
    
        nextButton.addActionListener(e -> {
            currentIndex[0]++;
            if (currentIndex[0] >= shapes.size()) {
                currentIndex[0] = 0; // Volta para o início se alcançar o final da lista
            }
            textArea.setText(shapes.get(currentIndex[0]).toString());
            shapes.get(currentIndex[0]).print(); 
        });
    
        // Exibe o diálogo
        dialog.setLocationRelativeTo(null); // Centraliza o diálogo na tela
        dialog.setVisible(true);
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
