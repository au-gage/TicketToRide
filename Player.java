package TicketToRide;


 

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
    protected Points score;
    protected ArrayList<DestCard> DestHand = new ArrayList<>();
    //hashmap, keys are colors
    HashMap<Colors,Integer> hand = new HashMap<>();
    /**
     * Constructor for objects of class player
     */
    public Player(Colors color, String name)
    {
       this.color = color;
       this.name = name;
       score=new Points();
    }
    // /**
     // * 
     // */
    // protected void drawTransTicket( Tickets deck, int choice,int draw){
        // //determine if taxi
        // hand.put(deck.pickup(choice));
        // //if taxi or second draw,replace card and end player turn
        
        // //else replace and ask if want card from pile or face up
        // //if draw from pile ask if want a secpnd card from pile or face up card
        
    // }
    protected void drawPileTicket(Tickets deck){
        
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
