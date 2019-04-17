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
 * instances of images of card
 * to and from
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class DestCard
{
    protected ArrayList<Image> destCards;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    /**
     * Constructor for objects of class DestCard
     */
    public DestCard()
    {
        Path path = Paths.get("fwdboardandtransport");        
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path))
        {
            for(Path file: stream)
            {
                if (file.toString().contains("to"))
                {
                    destCards.add(toolkit.getImage(file.toString()));
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
            Image temp = destCards.get(i);
            destCards.set(i, destCards.get(randomIndex));
            destCards.set(randomIndex, temp);
        }
    }

    /**
     * Will do once we have the players delt cards
     */
    public void returnCard(){
        
    }
    
    
    /**
     * Returns the value of a destination card 
     */
    public int destCardValues(){
        return 0;
    }
}
