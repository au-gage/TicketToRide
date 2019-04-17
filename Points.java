package TicketToRide;


/**
 * Write a description of class Score here.
 *
 * @author (Cheryl McClean)
 * @version (a version number or a date)
 */
public class Points
{
    // instance variables - replace the example below with your own
    protected int score;

    /**
     * Constructor for objects of class Score
     */
    public Points()
    {
        // initialise instance variables
        score = 0;
    }

    protected int updateScoreRoute(Paths pathName){
        if(pathName.getIsCaptured() == true){
            score = score + pathName.length;
        }
        return score; 
    }
    
    protected int updateScoreDes(){ //do not implement until end of game
        int x = 1;
        if(x == 1){
            
            score = score + x;
        }
        return score; 
    }
    
    protected int updateScoreAttr(){ // do not implement until end of game
        int x = 1;
        if(x == 1){
            
            score = score + x;
        }
        return score; 
    }
    
    protected int updateScoreFailure(){ // do not implement until end of game
        int x = 1;
        if(x == 1){
           
           score = score - x; 
        }
        return score;
    }
    protected int updateScoreDesTotal(){
        int x = 1;
        score = score + x;
        return score;
    }
    
}
