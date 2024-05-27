import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        new MainMenu();
        //Interface game = new Interface();
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