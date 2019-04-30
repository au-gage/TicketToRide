
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
 * @author Derek McPhail, Mark Eliseo, Cheryl McClean, Austin Gage, Rose Wilson
 * @version (4/29/19)
 */
public class DestCards
{
    protected ArrayList<DestCard> destCards = new ArrayList<>();
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    protected ArrayList<DestCard> fromHand = new ArrayList<DestCard>();
    protected ArrayList<Image> images = new ArrayList<>();
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
                    images.add(toolkit.getImage(file.toString()).
                        getScaledInstance(119,200,Image.SCALE_DEFAULT));
                }

            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
        //add each dest card from images to deck

        destCards.add(new DestCard(images.get(0),"Central Park", "Chelsea",5));
        destCards.add(new DestCard(images.get(1),"Central Park", "Chinatown",8));
        destCards.add(new DestCard(images.get(2),"Central Park", "Gramercy Park",4));
        destCards.add(new DestCard(images.get(3),"Central Park", "Midtown West",3));
        destCards.add(new DestCard(images.get(4),"Chelsea", "Brooklyn",8));
        destCards.add(new DestCard(images.get(5),"Chelsea", "Wall Street",6));
        destCards.add(new DestCard(images.get(6),"Empire State Building", "Brooklyn",7));
        destCards.add(new DestCard(images.get(7),"Empire State Building", "Greenwich Village",3));
        destCards.add(new DestCard(images.get(8),"East Village", "Soho",4));
        destCards.add(new DestCard(images.get(9),"Gramercy Park", "Chinatown",4));
        destCards.add(new DestCard(images.get(10),"Lincoln Center", "Empire State Building",3));
        destCards.add(new DestCard(images.get(11),"Lower East Side", "Wall Street",2));
        destCards.add(new DestCard(images.get(12),"Times Square", "Brooklyn",8));
        destCards.add(new DestCard(images.get(13),"Times Square", "East Village",4));
        destCards.add(new DestCard(images.get(14),"Times Square", "Soho",6));
        destCards.add(new DestCard(images.get(15),"United Nations", "Midtown West",3));
        destCards.add(new DestCard(images.get(16),"United Nations", "Wall Street",8));

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
     * when a mouse is clicked, 
     * receive the value of destination cards
     */
    public void mouseClicked(MouseEvent e){
        destCardValues();
    }

    /**
     * Shuffles the deck of destination cards in a pseudorandom order.
     * 
     * 
     */
    public void shuffle() {

        for (int i = 0; i < destCards.size(); i++) {
            Random r = new Random();
            //recieves a sudorandom int to place next card
            int randomIndex = r.nextInt(destCards.size());
            DestCard temp = destCards.get(i);
            destCards.set(i, destCards.get(randomIndex));
            destCards.set(randomIndex, temp);
        }
    }

    /**
     * draws a card from the destination card deck
     * 
     * @return DestCard that was removed from deck
     */
    public DestCard draw(){
        //if no cards are left, display it
        if (destCards.size() == 0) {
            JOptionPane.showMessageDialog(null,
                "There are no more Destination Cards left");
            return null;

        } else {
            //cards are available, remove from deck
            DestCard pickedUp = destCards.get(0);
            destCards.remove(0);
            return pickedUp;
        }
    }

    /**
     * add a destination card to the deck
     * 
     * @param destcard to be added to deck
     */
    public void add(DestCard destCard)
    {
        destCards.add(destCard);
    }

    /**
     * returns a card from hand to deck
     * 
     * @param choice, which destcard to pull from hand
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
