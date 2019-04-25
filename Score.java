 

 


/**
 * Write a description of class Score here.
 *
 * @author (Cheryl McClean)
 * @version (a version number or a date)
 */
public class Score
{
    // instance variables - replace the example below with your own
    protected int score;

    /**
     * Constructor for objects of class Score
     */
    public Score()
    {
        // initialise instance variables
        score = 0;
    }

    protected int getValue(){
        return score;
    }
    protected int updateScoreRoute(Edges pathName){
        if(pathName.getIsCaptured() == true){
            score = score + pathName.length;
        }
        return score; 
    }
    
    protected int updateScoreDes(DestCard card){ //do not implement until end of game
        score = score + DestCard.destCardValues(card);
        return score; 
    }
    
    protected int updateScoreAttr(){ // do not implement until end of game
        int x = 1;
        if(x == 1){
            
            score = score + x;
        }
        return score; 
    }
    
    protected int updateScoreFailure(DestCard Card){ // do not implement until end of game
        int counter = 0;
        if(pathName.getIsCaptured() == false){
           counter = counter + pathName.length;
           score = score - counter; 
        }
        
        return score;
    }
    
    protected int updateScoreDesTotal(){
        int x = 1;
        score = score + x;
        return score;
    }
    
}
