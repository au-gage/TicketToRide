 
/**
 * Write a description of class Score here.
 *
 * @author (Cheryl McClean, Austin Gage, Rose Wilson, Derek McPhail, Mark Eliseo )
 * @version (4/29/19)
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
    /**
     * accessore for the current score
     * 
     * @return score value
     */
    protected int getValue(){
        return score;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
    /**
     * calculates score when a route is captured
     * 
     * @return score value
     */
    protected int updateScoreRoute(Edges pathName){
        if(pathName.getIsCaptured() == true){
            score = score + pathName.length;
        }
        return score; 
    }
    /**
     * at end of game, 
     * calculates score
     * based on achieved destination card
     * 
     * @param route the edge needed to earn card
     * @param card destination card to win
     * @return score value
     */
    protected int updateScoreDes(Edges route,DestCard card){ 
        score = score + DestCard.destCardValues(route,card);
        return score; 
    }
    /**
     * at end of game
     * add 1 when next to attraction
     * 
     * @return score value
     */
    protected int updateScoreAttr(){ 
        int x = 1;
        if(x == 1){
            
            score = score + x;
        }
        return score; 
    }
    /**
     * at end of game
     * subtract points for unused destination cards
     * 
     * @param card to be checked
     * @return amount needed to subtract
     */
    protected int updateScoreFailure(DestCard card){
        int counter = 0;//have every destcard use a ocunter so i can subtracts amount used
        int destCardAmount = 10; //? 
        // if(card is not complete){
              // score = score - card.getValue();
              // counter ++
        // }
        return score;
    }
    /**
     * at end of game
     * updates the total score
     * 
     * @return score value
     */
    protected int updateScoreDesTotal(){
        int x = 1;
        score = score + x;
        return score;
    }
    
}
