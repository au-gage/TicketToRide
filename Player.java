import java.util.ArrayList;
import java.util.HashMap;
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
        hand.put(temp,hand.get(temp)+1);
        //if taxi end player turn
        if (temp == Colors.RAINBOW){
            isTurn = false;
        }
        draw --;
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
        //if taxi end player turn
        if (temp == Colors.RAINBOW){
            isTurn = false;
        }
        draw --;
        return draw;
        
    }
    protected void drawDestTickets(DestCards deck){
        //add two dest cards to hand
        destHand.add(deck.draw());
        destHand.add(deck.draw());
        //player chooses to remove one or none
    }
    protected void claimRoute(){
        //ask which path
        //player chooses their cards based on path's needs
        //remove cards from player's hand
        //update score
        //add cars to route
    }
    
    protected Colors getColor()
    {
        return color;
    }
}
