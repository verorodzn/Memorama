import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        Interface game = new Interface();
    }
}

class Interface extends JFrame{

    // Constructor
    public Interface(){
        //Panel
        add(new Panel());
        setTitle("Memorama");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

class Panel extends JPanel{
    
    private ArrayList<Card> cards;

    // Constructor
    public Panel(){
        this.setLayout(new GridLayout(2,3));
        // Adding cards (buttons)
        cards = Card.generateCards(this);

        for(Card c:cards){
            add(c);
        }
    }

    public void enabledButtons(boolean option){
        for(Card c: cards){
            if (c.getBackground() == Color.WHITE){
                c.setEnabled(option);
            }
        }
    }
}

class Card extends JButton{
    private Color[] colors = {Color.BLUE, Color.BLUE,
                            Color.RED, Color.RED,
                            Color.YELLOW, Color.YELLOW};
    
    private int numButton;
    private static int numStatic = 0;
    private static Card button1;
    private static Card button2;
    private static int clicks = 0;
    private static int pairs = 0;
    private Panel panel;

    // Constructor
    public Card(Panel panel){
        this.panel = panel;
        numButton =  numStatic;
        numStatic++;
        this.setBackground(Color.WHITE);
        addActionListener(e-> isAPair());
    }

    private void isAPair() {
        setBackground(colors[numButton]);
        clicks++;

        if(button1 == null){
            button1 = this;
        } else {
            button2 = this;
            panel.enabledButtons(false);

            Timer timer = new Timer(500, new ActionListener() {
                @Override public void actionPerformed(ActionEvent arg0){
                    if(button1.getBackground() == button2.getBackground()){
                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        pairs ++;
                        
                        if(pairs == 3){
                            win();
                        }

                    } else{
                        button1.setBackground(Color.WHITE);
                        button2.setBackground(Color.WHITE);
                    }

                    button1 = null;
                    button2 = null;
                    panel.enabledButtons(true);
                }

                private void win(){
                    JOptionPane.showMessageDialog(null, "¡Felicidades! Ganaste con solo " + clicks + " clics.");
                    System.exit(0);
                }
            });

            timer.setRepeats(false);
            timer.start();
        }
    }

    public static ArrayList<Card> generateCards(Panel panel){
        ArrayList<Card> cardList = new ArrayList<Card>();

        for (int i=0; i<6; i++){
            cardList.add(new Card(panel));
        }

        Collections.shuffle(cardList);

        return cardList;
    }
}