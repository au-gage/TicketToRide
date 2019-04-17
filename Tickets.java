 
import java.util.ArrayList;
import java.util.Random;
/**
 * instances of cards
 * color
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tickets
{
	private ArrayList<Colors> trainDeck;
	private Colors[] faceups = new Colors[5];
	private ArrayList<Colors> heldCards; //potentially an option? or maybe get data from Player objects.
	
	/**
	 * Constructor to initialize the deck of trains and shuffle them.
	 * 
	 * @author names
	 * @version date
	 */
    public Tickets() {
        this.trainDeck = new ArrayList<Colors>();
        for (int i = 0; i < 6; i++) trainDeck.add(Colors.BLUE);
        for (int i = 0; i < 6; i++) trainDeck.add(Colors.BLACK);
        for (int i = 0; i < 6; i++) trainDeck.add(Colors.RED);
        for (int i = 0; i < 6; i++) trainDeck.add(Colors.ORANGE);
        for (int i = 0; i < 6; i++) trainDeck.add(Colors.GREEN);
        for (int i = 0; i < 6; i++) trainDeck.add(Colors.PINK);
        for (int i = 0; i < 8; i++) trainDeck.add(Colors.RAINBOW);
        this.shuffle();
    }

    /**
     * Setup the initial start of the game.
     * 
     * @author names
     * @version date
     */
    public void setup() {
    	//DNF until decide how to deal cards to players with group.
    }
    
    /**
     * Draws a card from the deck of trains.
     * 
     * @author names
     * @version date
     * @return Colors the type of card pulled
     */
    public Colors draw() {
    	Colors output = trainDeck.get(0);
    	trainDeck.remove(0);
    	if (trainDeck.size() == 0) this.reset();
    	return output;
    }
    
    /**
     * Draws card from the set of faceup cards.
     * 
     * @author names
     * @version date
     * @return Colors the type of card pulled.
     */
    public Colors pickup(int choice) {
    	try {
    		Colors output = faceups[choice];
    		faceups[choice] = this.draw();
    		return output;
    	} catch (IndexOutOfBoundsException e) {
    		System.err.println(e);
    		System.exit(1);
    	}
		return Colors.NONE;
    }
    
    /**
     * Shuffles the deck of trains in a pseudorandom order.
     * 
     * @author names
     * @version date
     */
    public void shuffle() {
    	for (int i = 0; i < trainDeck.size(); i++) {
    		Random r = new Random();
    		int randomIndex = r.nextInt(trainDeck.size());
    		Colors temp = trainDeck.get(i);
    		trainDeck.set(i, trainDeck.get(randomIndex));
    		trainDeck.set(randomIndex, temp);
    	}
    }
    
    /**
     * Resets the deck when it is empty by gathering all discarded cards and reshuffling.
     * 
     * @author names
     * @version date
     */
    public void reset() {
    	//DNF until decide how to access cards in player's hands.
    	trainDeck.clear();
    	
    	//get number of each color missing from deck (aka in a player's hand)
    	
    	int blue;
    	int black;
    	int red;
    	int green;
    	int orange;
    	int pink;
    	int wild;
    	
    	
    	//populate the deck with remaining cards
    	for (int i = 0; i < 6-blue; i++) trainDeck.add(Colors.BLUE);
        for (int i = 0; i < 6-black; i++) trainDeck.add(Colors.BLACK);
        for (int i = 0; i < 6-red; i++) trainDeck.add(Colors.RED);
        for (int i = 0; i < 6-orange; i++) trainDeck.add(Colors.ORANGE);
        for (int i = 0; i < 6-green; i++) trainDeck.add(Colors.GREEN);
        for (int i = 0; i < 6-pink; i++) trainDeck.add(Colors.PINK);
        for (int i = 0; i < 8-wild; i++) trainDeck.add(Colors.RAINBOW);
        this.shuffle();
    }
}
