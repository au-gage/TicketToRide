import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
/**
 * color
 * name
 * points
 * make moves
 * have 
 *
 * @author Rose Wilson
 * @version 4/14/19
 */
public class Player
{
    protected Colors color;
    protected String name;
    protected Score score;
    protected ArrayList<DestCard> destHand = new ArrayList<>();
    protected boolean isTurn;
    int amtOfTaxis = 15;
    //hashmap, keys are colors
    HashMap<Colors,Integer> hand = new HashMap<>();
    /**
     * Constructor for objects of class player
     * 
     * 
     * @param color the player's color
     * @param name the player's name
     */
    public Player(Colors color, String name)
    {
        this.color = color;
        this.name = name;
        score=new Score();
    }

    /**
     * draws a face up transportation ticket
     * tracks number of draws occurred
     * ends turn when taxi is drawn or is second draw
     * 
     * @param deck of transportation cards in which to draw from
     * @param choice, which face up card to choose
     * @param draw, the number of draws the player has drawn this turn
     */
    protected int drawTransTicket( Tickets deck, int choice,int draw){
        //if second draw end turn
        if (draw == 0){
            isTurn = false;
        }
        //pick up card
        Colors temp =deck.pickup(choice).color();
        //If player has already drawn a card and attempts to draw a rainbow card
        if(!(draw == 1 && temp == Colors.RAINBOW))
            hand.put(temp,hand.get(temp)+1);
        //if taxi end player turn
        if (temp == Colors.RAINBOW){
            draw--;
            isTurn = false;
        }
        //If player has drawn a face up and attempts to draw a rainbow card
        draw--;
        return draw;

    }

    protected int drawDeckTransTicket(Tickets deck, int draw){
        //if second draw end turn
        if (draw == 0){
            isTurn = false;
        }
        //pick up card
        Colors temp =deck.draw().color();
        hand.put(temp,hand.get(temp)+1);

        draw --;
        return draw;

    }

    protected void drawDestTickets(DestCards deck){
        //add two dest cards to hand
        destHand.add(deck.draw());
        destHand.add(deck.draw());
        //player chooses to remove one or none

    }



    protected void claimRoute(ArrayList<Edges> edges){
        //ask which path

        String[] choices = new String[edges.size()];

        for (int i = 0; i <edges.size(); i++){
            choices[i] = edges.get(i).getStart() + "-" + edges.get(i).getEnd() + ": " + edges.get(i).getLength() + " " + edges.get(i).getColor();
        }

        //player chooses their cards based on path's needs
        String choiceString = (String) JOptionPane.showInputDialog(null, "Select a route", 
                "Route Slection", JOptionPane.QUESTION_MESSAGE, null,choices,choices[0]);
        Edges choice = edges.get(0);
        //transforms choice into edge
        for (int i = 0; i<edges.size();i++){
            if(choiceString.equals(edges.get(i).getStart() + "-" + edges.get(i).getEnd() + ": " + edges.get(i).getLength() + " " + edges.get(i).getColor())){
                choice = edges.get(i);
            }
        }

        //cannot take route that is already taken
        if(choice.getIsCaptured()){
            JOptionPane.showMessageDialog(null, "Route Previously captured", "alert", JOptionPane.ERROR_MESSAGE); 
            return;
        }

        //choose payment options
        Colors[] options = {Colors.BLACK, Colors.BLUE, Colors.RED, 
                Colors.RAINBOW, Colors.GREEN, Colors.ORANGE, Colors.PINK, Colors.PURPLE ,
                Colors.WHITE, Colors.YELLOW};
        int tempPay = 0;
        int tempRainbow = 0;
        for (int i = 0; i < choice.length; i ++){

            Colors payment = (Colors)JOptionPane.showInputDialog(null, "What color ticket will you be paying with?", 
                    "Ticket Selection", JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
            if (choice.getColor() == payment){
                if(hand.get(payment) - tempPay > 1){
                    tempPay ++;
                } 
                else {
                    //display that payment is not possible
                    JOptionPane.showMessageDialog(null, "You do not have enough cards to pay for that", "alert", JOptionPane.ERROR_MESSAGE);
                    //restart turn somehow
                    return;
                }
            }
            else if (payment == Colors.RAINBOW){
                if(hand.get(payment) - tempRainbow > 1){
                    tempRainbow ++;
                } 
                else {
                    //display that payment is not possible
                    JOptionPane.showMessageDialog(null, "You do not have enough cards to pay for that", "alert", JOptionPane.ERROR_MESSAGE);
                    //restart turn somehow
                    return;
                }
            }
            else{
                //display that payment is not possible
                JOptionPane.showMessageDialog(null, "You chose the wrong color for the path", "alert", JOptionPane.ERROR_MESSAGE);
                //restart turn somehow
                return;
            }
        }
        //remove cards from player's hand
        hand.put(choice.getColor(),hand.get(choice.getColor())-tempPay);
        hand.put(Colors.RAINBOW,hand.get(Colors.RAINBOW)-tempRainbow);
        //update score
        score.updateScoreRoute(choice);
        //add cars to route

        //amtOfTaxis gets subtracted by the length of the route
        amtOfTaxis = amtOfTaxis - choice.length;
    }

    protected Colors getColor()
    {
        return color;
    }
}
