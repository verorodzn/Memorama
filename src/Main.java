import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        new MainMenu();
    }
}

class Interface extends JFrame {
    public Interface(int numCards) {
        add(new Panel(numCards));
        setTitle("Memorama");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class Panel extends JPanel {
    private ArrayList<Card> cards;

    public Panel(int numCards) {
        int rows = (int)Math.ceil(numCards / 4.0); // Calculates how many rows we'll need depending on the number of cards
        this.setLayout(new GridLayout(rows, 4));

        cards = Card.generateCards(this, numCards);
        for (Card c : cards) {
            add(c);
        }
    }

    public void enabledButtons(boolean option) {
        for (Card c : cards) {
            if (c.getBackground() == Color.WHITE) {
                c.setEnabled(option);
            }
        }
    }
}