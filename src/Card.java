import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

class Card extends JButton{
    private ImageIcon cardImage;
    private int numCard;
    private static int numStatic = 0;
    private static Card card1;
    private static Card card2;
    private static int pairs = 0;
    private Panel panel;

    // Constructor
    public Card(Panel panel, ImageIcon cardImage){
        this.panel = panel;
        this.cardImage = cardImage;
        numCard = numStatic;
        numStatic++;
        this.setBackground(Color.WHITE);
        addActionListener(e -> isAPair());
    }

    private void isAPair() {
        setIcon(cardImage);

        if (card1 == null) {
            card1 = this;
        } else {
            card2 = this;
            panel.enabledButtons(false);

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    if (card1.cardImage.equals(card2.cardImage)) {
                        card1.setEnabled(false);
                        card2.setEnabled(false);
                        pairs++;

                        if (pairs == 3) {
                            win();
                        }
                    } else {
                        card1.setIcon(null); // Reset icon to hide image
                        card2.setIcon(null); // Reset icon to hide image
                    }

                    card1 = null;
                    card2 = null;
                    panel.enabledButtons(true);
                }

                private void win() {
                    JOptionPane.showMessageDialog(null, "¡Felicidades! Ganaste.");
                    System.exit(0);
                }
            });

            timer.setRepeats(false);
            timer.start();
        }
    }

    public static ArrayList<Card> generateCards(Panel panel) {
        ArrayList<Card> cardList = new ArrayList<>();

        ImageIcon[] uniqueCardImages = {
            new ImageIcon("C:\\Users\\veror\\OneDrive\\Documentos\\GitHub\\Memorama\\src\\imgs\\frog-prince.png"),
            new ImageIcon("C:\\Users\\veror\\OneDrive\\Documentos\\GitHub\\Memorama\\src\\imgs\\monkey.png"),
            new ImageIcon("C:\\Users\\veror\\OneDrive\\Documentos\\GitHub\\Memorama\\src\\imgs\\teddy-bear.png")
        };

        // Create pairs
        for (ImageIcon cardImageIcon : uniqueCardImages) {
            cardList.add(new Card(panel, cardImageIcon));
            cardList.add(new Card(panel, cardImageIcon));
        }

        Collections.shuffle(cardList);
        return cardList;
    }
}
