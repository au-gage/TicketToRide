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
    protected ArrayList<DestCard> DestHand = new ArrayList<>();
    protected boolean isTurn;
    //hashmap, keys are colors
    HashMap<Colors,Integer> hand = new HashMap<>();
    /**
     * Constructor for objects of class player
     */
    public Player(Colors color, String name)
    {
       this.color = color;
       this.name = name;
       score=new Score();
    }
    

    // /**
     // * 
     // */
    protected void drawTransTicket( Tickets deck, int choice,int draw){
        if (draw == 0){
            isTurn = false;
        }
         //determine if taxi
        Colors temp =deck.pickup(choice).color();
        hand.put(temp,hand.get(temp)+1);
        //if taxi or second draw,end player turn
        if (temp == Colors.RAINBOW){
            isTurn = false;
        }
    
        
    }
    protected void drawDestTickets(){
        //add two dest cards to hand
        //player chooses to remove one or none
    }
    protected void claimRoute(){
        //as which path
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
