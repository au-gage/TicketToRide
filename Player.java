<<<<<<< HEAD
package TicketToRide;


=======
import java.util.ArrayList;
>>>>>>> 6e6c7207cf554945b958141fba38608919a91a81
/**
 * color
 * name
 * points
 * make moves
 * have 
 *
 * @author Rose Wilaon
 * @version 4/14/19
 */
public class Player
{
    protected Colors color;
    protected String name;
    protected Points score;
    //Black,red,green,blue,orange,pink,rainbow
    protected int[] tickets = new int[7];
    protected ArrayList<DestCard> DestHand;
    /**
     * Constructor for objects of class player
     */
    public Player(Colors color, String name)
    {
       this.color = color;
       this.name = name;
       score=new Points();
    }
    /**
     * 
     */
    protected void drawTransTicket(boolean pile){
        //determine if player wants face up ticket or from pile
        
        if (pile == false){
            //if face up then determine if taxi
            
        }
        
        
            //if taxi or second draw,replace card and end player turn
            //else replace and ask if want card from pile or face up
        //if draw from pile ask if want a secpnd card from pile or face up card
        
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
    
}
