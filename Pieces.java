
/**
 * cars
 * max number of cars: 15
 * decrement cars everytime is used
 * instance that is image of car
 * **Not used**
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pieces
{
    // instance variables - replace the example below with your own
    private String filename;
    private int count;
     
    /**
     * Constructor for objects of class Pieces
     */
    public Pieces(String filename)
    {
    	this.count = 15;
    	this.filename = filename;
    }

    public void placeCars(int amount) {
    	this.count = this.count - amount;
    }
}
