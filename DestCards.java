 


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
                    images.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));
                }

            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
        destCards.add(new DestCard(images.get(0),"Central Park", "Chelsea"));
        destCards.add(new DestCard(images.get(1),"Central Park", "Chinatown"));
        destCards.add(new DestCard(images.get(2),"Central Park", "Gramercy Park"));
        destCards.add(new DestCard(images.get(3),"Central Park", "Midtown West"));
        destCards.add(new DestCard(images.get(4),"Chelsea", "Brooklyn"));
        destCards.add(new DestCard(images.get(5),"Chelsea", "Wall Street"));
        destCards.add(new DestCard(images.get(6),"Empire State Building", "Brooklyn"));
        destCards.add(new DestCard(images.get(7),"Empire State Building", "Greenwich Village"));
        destCards.add(new DestCard(images.get(8),"East Village", "Soho"));
        destCards.add(new DestCard(images.get(9),"Gramercy Park", "Chinatown"));
        destCards.add(new DestCard(images.get(10),"Lincoln Center", "Empire State Building"));
        destCards.add(new DestCard(images.get(11),"Lower East Side", "Wall Street"));
        destCards.add(new DestCard(images.get(12),"Times Square", "Brooklyn"));
        destCards.add(new DestCard(images.get(13),"Times Square", "East Village"));
        destCards.add(new DestCard(images.get(14),"Times Square", "Soho"));
        destCards.add(new DestCard(images.get(15),"United Nations", "Midtown West"));
        destCards.add(new DestCard(images.get(16),"United Nations", "Wall Street"));
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
    
    public void add(DestCard destCard)
    {
        destCards.add(destCard);
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
