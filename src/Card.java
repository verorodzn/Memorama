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

    int cardWidth = 270;
    int cardHeight = 400;

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
        setIcon(cardImage); // Sets the icon of the clicked card to the cardImage associated with it
        int levelPairs = 3;

        if (card1 == null) {
            card1 = this; // Checks if it's the first card we're clicking, if it is, we assign it to card1
        } else {
            card2 = this; // If it's not, we assign it to card2
            panel.enabledButtons(false);

            Timer timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    // If cards are a pair, disable buttons, so that they stay revealed and cannot be clicked
                    if (card1.cardImage.equals(card2.cardImage)) { 
                        card1.setEnabled(false);
                        card2.setEnabled(false);
                        pairs++;

                        if (pairs == levelPairs) {
                            win();
                        }
                    } else {
                        // If cards aren't a pair, reset icons to hide images
                        card1.setIcon(null); 
                        card2.setIcon(null);
                    }
                    
                    //Reset method, so that we can compare other cards
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

    // Array with possible images
    public static ArrayList<Card> generateCards(Panel panel) {
        ArrayList<Card> cardList = new ArrayList<>();

        ImageIcon[] uniqueCardImages = {
            new ImageIcon("C:\\Users\\veror\\OneDrive\\Documentos\\GitHub\\Memorama\\src\\imgs\\tlacuahe1.png"),
            new ImageIcon("C:\\Users\\veror\\OneDrive\\Documentos\\GitHub\\Memorama\\src\\imgs\\fuego.png"),
            new ImageIcon("C:\\Users\\veror\\OneDrive\\Documentos\\GitHub\\Memorama\\src\\imgs\\conejo.png")
        };

        // Create pairs
        for (ImageIcon cardImageIcon : uniqueCardImages) {
            cardList.add(new Card(panel, cardImageIcon));
            cardList.add(new Card(panel, cardImageIcon));
        }

        // Shuffle so that the cards aren't always in the same order
        Collections.shuffle(cardList);
        return cardList;
    }
}