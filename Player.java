import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
/**
 *Player class where the actions that players can take are implemented
 *
 * @author Rose Wilson, Austin Gage, Cheryl McClean, Derek McPhail, and Mark Eliseo
 * @version 4/29/19
 */
public class Player
{
    protected Colors color;
    protected String name;
    protected Score score;
    protected ArrayList<DestCard> destHand = new ArrayList<>();
    protected ArrayList<Edges> capturedEdges = new ArrayList<>();
    //protected Image 
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
        hand.put(Colors.NONE, 0);
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
     * @param players, the players of the game
     */
    protected int drawTransTicket( Tickets deck, int choice,int draw, ArrayList<Player> players ){
        //if second draw end turn
        if (draw == 0){
            isTurn = false;
        }
        //pick up card
        Colors temp =deck.pickup(choice, players).color();
        //If player has already drawn a card and attempts to draw a rainbow card
        if(!(draw == 1 && temp == Colors.RAINBOW))
            hand.put(temp,hand.get(temp)+1);
        else if(draw == 2 && temp == Colors.RAINBOW)
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
    /**
     * draws a face down transporation ticket from deck
     * 
     * @param deck, the current status of the deck in the game
     * @param draw, the number of draws currently used up
     * @param players the status of the players of the game
     */
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
    /**
     * draws two destination tickets
     * gives player option to discard one
     * 
     * @param deck current status of the deck
     */
    protected int drawDestTickets(DestCards deck){
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
                    choices[i] = dests.get(i).getStart() + " => " + dests.get(i).getEnd();
            }
            String cardTaken = (String) JOptionPane.showInputDialog(null, "Select 1 or both cards", 
                    "Destination Card Selection", JOptionPane.QUESTION_MESSAGE, null,choices,choices[0]);
            if(cardTaken == null) return 0;
            if(cardTaken.equals(dests.get(0).getStart() + " => " + dests.get(0).getEnd()))
            {
                destHand.add(dests.get(0));
                deck.add(dests.get(1));
                return 2;
            }
            else if(cardTaken.equals(dests.get(1).getStart() + " => " + dests.get(1).getEnd()))
            {
                destHand.add(dests.get(1));
                deck.add(dests.get(0));
                return 2;
            }
            else
            {
                destHand.add(dests.get(0));
                destHand.add(dests.get(1));
                return 2;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Only one dest Card left, dealt to your deck");
            destHand.add(dests.get(0));
            return 2;
        }
    }
    /**
     * allows the player to claim a route from a to b
     * 
     * @param edges, current status of game's edges
     * @param players, current statuc of game's players
     */
    protected int claimRoute(ArrayList<Edges> edges,ArrayList<Player> players){
        //ask which path
        String[] choices = new String[edges.size()];

        for (int i = 0; i <edges.size(); i++){
            choices[i] = edges.get(i).getStart() + "-" + edges.get(i).getEnd() + ": " + edges.get(i).getLength() + " " + edges.get(i).getColor();
        }

        //player chooses their cards based on path's needs
        String choiceString = (String) JOptionPane.showInputDialog(null, "Select a route", 
                "Route Slection", JOptionPane.QUESTION_MESSAGE, null,choices,choices[0]);
        if (choiceString == null) return 0;
        Edges choice = edges.get(0);
        boolean edgeFound = false;
        //transforms choice into edge
        int j = 0;
        while (j < edges.size() && !edgeFound){
            if(choiceString.equals(edges.get(j).getStart() + "-" + edges.get(j).getEnd() + ": " + edges.get(j).getLength() + " " 
                + edges.get(j).getColor())){
                if(!edges.get(j).getIsCaptured())
                {
                    choice = edges.get(j);
                    edgeFound = true;
                }
                else
                {
                    j++;
                }
            }
            else
                j++;
        }

        //cannot take route that is already taken

        if(choice.getIsCaptured() && choice.getWhoCaptured() == null)
        {
            JOptionPane.showMessageDialog(null, "Attempt to capture a double route that has already been captured with two players",
                "alert",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if(choice.getIsCaptured()) {
            JOptionPane.showMessageDialog(null, "Route Previously captured", "alert", JOptionPane.ERROR_MESSAGE); 
            return 0;
        } else if (amtOfTaxis < choice.length) {
            JOptionPane.showMessageDialog(null, "Not enough taxis to claim route", "alert", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else if (j >= edges.size()) {
            JOptionPane.showMessageDialog(null, "Attempt to capture a double route that has already been captured with two players",
                "alert",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        

        //choose payment options
        //Think this should run off of the deck of the player, do like "RED-2" or something
        Colors[] options = {Colors.BLACK, Colors.BLUE, Colors.RAINBOW, 
                Colors.GREEN, Colors.ORANGE, Colors.PINK, Colors.RED};
        int tempPay = 0;
        int tempRainbow = 0;
        Colors[] noneColor = new Colors[choice.length];
        int payIndex = 0;
        Colors previousColor = choice.getColor();
        for (int i = 0; i < choice.length; i ++){
            Colors payment = (Colors)JOptionPane.showInputDialog(null, "What color ticket will you be paying with?", 
                    "Ticket Selection", JOptionPane.QUESTION_MESSAGE, null,options,previousColor);
            previousColor = payment;
            if(choice.getColor() == Colors.NONE)
            {
                noneColor[i] = payment;
                if (noneColor[payIndex] == Colors.RAINBOW) {
                    if (hand.get(Colors.RAINBOW) - tempRainbow >= 1) {
                        tempRainbow++;
                    } else {
                        //display that payment is not possible
                        JOptionPane.showMessageDialog(null, "You do not have enough cards to pay for that", "alert", JOptionPane.ERROR_MESSAGE);
                        //restart turn somehow
                        return 0;
                    }
                    if (choice.length == 1) {
                        break;
                    } else {
                        payIndex++;
                    }
                } else if (noneColor[i] == Colors.RAINBOW) {
                    if (hand.get(Colors.RAINBOW) - tempRainbow >= 1) {
                        tempRainbow++;
                    } else {
                        //display that payment is not possible
                        JOptionPane.showMessageDialog(null, "You do not have enough cards to pay for that", "alert", JOptionPane.ERROR_MESSAGE);
                        //restart turn somehow
                        return 0;
                    }
                } else if (noneColor[payIndex] == noneColor[i]) {
                    if (hand.get(noneColor[payIndex]) - tempPay >= 1) {
                        tempPay++;
                    } else {
                        //display that payment is not possible
                        JOptionPane.showMessageDialog(null, "You do not have enough cards to pay for that", "alert", JOptionPane.ERROR_MESSAGE);
                        //restart turn somehow
                        return 0;
                    }
                } else {
                    //display that the wrong type of card was entered
                    JOptionPane.showMessageDialog(null, "Gray routes must be claimed monochromatically", "alert", JOptionPane.ERROR_MESSAGE);
                    //restart turn somehow
                    return 0;
                }
            }
            else if (choice.getColor() == payment) {
                if(hand.get(payment) - tempPay >= 1) {
                    tempPay ++;
                } 
                else {
                    //display that payment is not possible
                    JOptionPane.showMessageDialog(null, "You do not have enough cards to pay for that", "alert", JOptionPane.ERROR_MESSAGE);
                    //restart turn somehow
                    return 0;
                }
            }
            else if (payment == Colors.RAINBOW){
                if(hand.get(payment) - tempRainbow >= 1){
                    tempRainbow ++;
                } 
                else {
                    //display that payment is not possible
                    JOptionPane.showMessageDialog(null, "You do not have enough cards to pay for that", "alert", JOptionPane.ERROR_MESSAGE);
                    //restart turn somehow
                    return 0;
                }
            }
            else{
                //display that payment is not possible
                JOptionPane.showMessageDialog(null, "You chose the wrong color for the path", "alert", JOptionPane.ERROR_MESSAGE);
                //restart turn somehow
                return 0;
            }
        }

        //update score
        score.setScore(score.getValue() + choice.getLength());
        //add cars to route

        if(choice.getColor() == Colors.NONE)
        {
            if (payIndex > (choice.length - 1)) {
                hand.put(Colors.RAINBOW, hand.get(Colors.RAINBOW) - tempRainbow);
            } else {
                hand.put(noneColor[payIndex], hand.get(noneColor[payIndex]) - tempPay);
                hand.put(Colors.RAINBOW, hand.get(Colors.RAINBOW) - tempRainbow);
            }
        }
        else
        {
            hand.put(choice.getColor(),hand.get(choice.getColor())-tempPay);
            hand.put(Colors.RAINBOW,hand.get(Colors.RAINBOW)-tempRainbow);
        }
        //update score
        score.updateScoreRoute(choice);
        //add cars to route
        choice.Captured(true,this);
        edges.set(j,choice);
        //this.capturedEdges.add(choice);
        String word = edges.get(j).getStart() + edges.get(j).getEnd();
        if(j != 0)
        {
            if(players.size() == 2)
            {
                if(j != edges.size() - 1)
                {
                    if(word.equals(edges.get(j-1).getStart() + edges.get(j-1).getEnd()))
                    {
                        edges.get(j-1).Captured(true,null);
                    }
                    else if(word.equals(edges.get(j+1).getStart() + edges.get(j+1).getEnd()))
                    {
                        edges.get(j+1).Captured(true,null);
                    }
                }
                else if(j == edges.size() - 1)
                {
                    if(word.equals(edges.get(j+1).getStart() + edges.get(j+1).getEnd()))
                    {
                        edges.get(j-1).Captured(true,null);
                    }   
                }
            }
        }

        //amtOfTaxis gets subtracted by the length of the route
        amtOfTaxis = amtOfTaxis - choice.length;
        return 2;
    }
    /**
     * accessor method to get the player's color
     */
    protected Colors getColor()
    {
        return color;
    }
}
