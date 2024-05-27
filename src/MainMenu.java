import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    public MainMenu() {
        super("Leyendas Náhuatl Memorama"); 

        // Main panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Load the image
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\veror\\OneDrive\\Documentos\\GitHub\\Memorama\\src\\imgs\\nahuatl.png"); // Replace with your image path
        JLabel imageLabel = new JLabel(imageIcon);

        // Add image to the left
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = GridBagConstraints.REMAINDER; // Span the entire height
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panel.add(imageLabel, gbc);

        // Title label
        JLabel titleLabel = new JLabel("Leyendas Náhuatl Memorama", JLabel.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24f)); // Font size
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        // Description label
        JLabel descriptionLabel = new JLabel("Aprende sobre las leyendas de una manera divertida.", JLabel.CENTER);
        gbc.gridy++;
        panel.add(descriptionLabel, gbc);

        // Choose level label
        JLabel chooseLevelLabel = new JLabel("Elige tu nivel", JLabel.CENTER);
        gbc.gridy++;
        panel.add(chooseLevelLabel, gbc);

        // Create buttons
        JButton button1 = new JButton("Fácil");
        JButton button2 = new JButton("Medio");
        JButton button3 = new JButton("Difícil");
        JButton button4 = new JButton("Salir");

        // Add action listeners to buttons
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        // Add buttons to panel
        gbc.gridy++;
        panel.add(button1, gbc);
        gbc.gridy++;
        panel.add(button2, gbc);
        gbc.gridy++;
        panel.add(button3, gbc);
        gbc.gridy++;
        panel.add(button4, gbc);

        // Add panel
        add(panel);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Button Actions
        if (e.getActionCommand().equals("Fácil")) {
            System.out.println("You clicked the Fácil button.");
        } else if (e.getActionCommand().equals("Medio")) {
            System.out.println("You clicked the Medio button.");
        } else if (e.getActionCommand().equals("Difícil")) {
            System.out.println("You clicked the Difícil button.");
        } else if (e.getActionCommand().equals("Salir")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
