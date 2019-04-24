
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.*;
import java.util.Random;

/**
 * Object of a single
 * instances of images of card
 * to and from
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class DestCards
{
    protected ArrayList<DestCard> destCards = new ArrayList<>();
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    protected ArrayList<DestCard> fromHand = new ArrayList<DestCard>();
    /**
     * Constructor for objects of class DestCard
     */
    public DestCards()
    {
        Path path = Paths.get("fwdboardandtransport");        
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path))
        {
            for(Path file: stream)
            {
                if (file.toString().contains("to"))
                {
                    destCards.add(new DestCard(toolkit.getImage(file.toString())));
                }

            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
        this.shuffle();

    }

    /**
     * Empty methods that had to be overriden to use MouseListener
     * 
     */
    public void mouseExited(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseClicked(MouseEvent e){
        destCardValues();
    }

    /**
     * Shuffles the deck of destination cards in a pseudorandom order.
     * 
     * @author names
     * @version date
     */
    public void shuffle() {
        for (int i = 0; i < destCards.size(); i++) {
            Random r = new Random();
            int randomIndex = r.nextInt(destCards.size());
            DestCard temp = destCards.get(i);
            destCards.set(i, destCards.get(randomIndex));
            destCards.set(randomIndex, temp);
        }
    }

    /**
     * 
     */
    public DestCard draw(){
        DestCard pickedUp = destCards.get(0);
        destCards.remove(0);
        return pickedUp;
    }

    /**
     * Will do once we have the players delt cards
     */
    public void returnCard(int choice){
        try{
            DestCard output = fromHand.get(choice);
            fromHand.remove(choice);
            destCards.add(output);

        } catch(IndexOutOfBoundsException e){
            System.err.println(e);
            System.exit(1);
        }
    }
    
    /**
     * Returns the value of a destination card 
     */
    public int destCardValues(){
        return 0;
    }
}
