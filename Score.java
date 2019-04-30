import java.util.ArrayList;
/**
 * Write a description of class Score here.
 *
 * @author (Cheryl McClean, Austin Gage, Rose Wilson,
 * Derek McPhail, Mark Eliseo )
 * @version (4/29/19)
 */
public class Score
{
    // instance variables - 
    //replace the example below with your own
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
            this.setScore(pathName.getLength() + this.score);
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
    protected int updateScoreDes(ArrayList<Edges> route,
    ArrayList<DestCard> cards){
        for(int i = 0;i < cards.size();i++)
        {
            if(cards.get(i).destCardCompleted(
                route,cards.get(i).start,cards.get(i).end))
            {
                this.setScore(score+cards.get(i).value);
            }
            else
            {
                this.setScore(score-cards.get(i).value);
            }
        }
        return score; 
    }

    /**
     * at end of game
     * add 1 when next to attraction
     * 
     * @return score value
     */

    protected int updateScoreAttr(ArrayList <Edges> edge, 
    ArrayList <String> tourist){ 

        
        for(int i = 0; i < edge.size(); i++){
            for(int j = 0; j < tourist.size(); j++){
                String word = edge.get(i).getStart() + 
                    edge.get(i).getEnd();
                if(word.contains(tourist.get(j))){
                    this.setScore(score++);
                }
            }

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
        int counter = 0;
        int destCardAmount = 10; //? 
        // if(card is not complete){
        // score = score - card.getValue();
        // counter ++
        // }
        return score;
    }

}
