
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
    private Colors color;
    private String name;
    private Points point;
    
    /**
     * Constructor for objects of class player
     */
    public Player(Colors color, String name)
    {
       this.color = color;
       this.name = name;
       point=new Points();
    }
    
    private void drawTransTicket(){
        //determine if player wants face up ticket or from pile
        //if face up then determine if taxi
            //if taxi or second draw,replace card and end player turn
            //else replace and ask if want card from pile or face up
        //if draw from pile ask if want a secpnd card from pile or face up card
        
    }
    private void drawDestTickets(){
        //add two dest cards to hand
        //player chooses to remove one or none
    }
    private void claimRoute(){
        //as which path
        //player chooses their cards based on path's needs
        //remove cards from player's hand
        //add cars to route
    }
}
