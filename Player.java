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
        
        hand.put(Colors.BLUE, 0);
        hand.put(Colors.GREEN, 0);
        hand.put(Colors.BLACK, 0);
        hand.put(Colors.PINK, 0);
        hand.put(Colors.RED, 0);
        hand.put(Colors.ORANGE, 0);
        hand.put(Colors.RAINBOW, 0);
        
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
    protected int drawTransTicket( Tickets deck, int choice,int draw, ArrayList<Player> players ){
        //if second draw end turn
        if (draw == 0){
            isTurn = false;
        }
        //pick up card
<<<<<<< HEAD
        Colors temp = deck.pickup(choice).color();
=======
        Colors temp =deck.pickup(choice, players).color();
>>>>>>> 57615028d9e79a282db67558c9d52fab8e5d8931
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

    protected int drawDeckTransTicket(Tickets deck, int draw, ArrayList<Player> players){
        //if second draw end turn
        if (draw == 0){
            isTurn = false;
        }
        //pick up card
        Colors temp =deck.draw(players).color();
        hand.put(temp,hand.get(temp)+1);

        draw --;
        return draw;

    }

    protected void drawDestTickets(DestCards deck){
        //add two dest cards to hand
        // destHand.add(deck.draw());
        // destHand.add(deck.draw());
        //player chooses to remove one or none
        ArrayList<DestCard> dests = new ArrayList<>();
        if(deck.destCards.size() == 1)
        {
            dests.add(deck.draw());
        }
        else
        {
            dests.add(deck.draw());
            dests.add(deck.draw());
        }
        String[] choices = new String[3];
        if(dests.size() == 2)
        {
            for(int i = 0;i < 3;i++)
            {
                if(i == 2)
                    choices[i] = "Both Cards";
                else
                    choices[i] = dests.get(i).getStart() + " " + dests.get(i).getEnd();
            }
            String cardTaken = (String) JOptionPane.showInputDialog(null, "Select 1, or both cards", 
                    "Destination Card Selection", JOptionPane.QUESTION_MESSAGE, null,choices,choices[0]);
            if(cardTaken.equals(dests.get(0).getStart() + " " + dests.get(0).getEnd()))
            {
                destHand.add(dests.get(0));
                deck.add(dests.get(1));
            }
            else if(cardTaken.equals(dests.get(1).getStart() + " " + dests.get(0).getEnd()))
            {
                destHand.add(dests.get(1));
                deck.add(dests.get(0));
            }
            else
            {
                destHand.add(dests.get(0));
                destHand.add(dests.get(1));
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Only one dest Card left, dealt to your deck");
            destHand.add(dests.get(0));
            
        }
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
        //Think this should run off of the deck of the player, do like "RED-2" or something
        Colors[] options = {Colors.BLACK, Colors.BLUE, Colors.RED, 
                Colors.RAINBOW, Colors.GREEN, Colors.ORANGE, Colors.PINK};
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
