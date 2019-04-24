
package TicketToRide;


 
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.ArrayList;


import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.*;
/**
 * instances of cards
 * color
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tickets
{
    private ArrayList<Ticket> trainDeck = new ArrayList<>();
    protected Ticket[] faceups = new Ticket[5];
    private ArrayList<Ticket> heldCards; //potentially an option? or maybe get data from Player objects.
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    /**
     * Constructor to initialize the deck of trains and shuffle them.
     * 
     * @author names
     * @version date
     */
    public Tickets() {
        {
            Path path = Paths.get("fwdboardandtransport");        
            try(DirectoryStream<Path> stream = Files.newDirectoryStream(path))
            {
                for(Path file: stream)
                {
                    System.out.println(file.toString());
                    if (file.toString().equals("fwdboardandtransport\\blackcard.jpg"))
                    {
                        for(int i = 0;i < 6;i++)
                        {
                            trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.BLACK));
                        }
                    }
                    else if (file.toString().equals("fwdboardandtransport\\bluecard.jpg"))
                    {
                        for(int i = 0;i < 6;i++)
                        {
                            trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.BLUE));
                        }
                    }
                    else if (file.toString().equals("fwdboardandtransport\\colorcard.jpg"))
                    {
                        for(int i = 0;i < 8;i++)
                        {
                            trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.RAINBOW));
                        }
                    }
                    else if (file.toString().equals("fwdboardandtransport\\greencard.jpg"))
                    {
                        for(int i = 0;i < 6;i++)
                        {
                            trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.GREEN));
                        }
                    }
                    else if (file.toString().equals("fwdboardandtransport\\orangecard.jpg"))
                    {
                        for(int i = 0;i < 6;i++)
                        {
                            trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.ORANGE));
                        }
                    }
                    else if (file.toString().equals("fwdboardandtransport\\pinkcard.jpg"))
                    {
                        for(int i = 0;i < 6;i++)
                        {
                            trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.PINK));
                        }
                    }
                    else if (file.toString().equals("fwdboardandtransport\\redcard.jpg"))
                    {
                        for(int i = 0;i < 6;i++)
                        {
                            trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.RED));
                        }
                    }
                }
            }
            catch(Exception e)
            {
                System.exit(0);
            }
            this.shuffle();
            for(int i = 0;i < 5;i++)
            {
                faceups[i] = trainDeck.get(i);
                trainDeck.remove(i);
            }
        }
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
    public Ticket draw() {
        Ticket output = trainDeck.get(0);
        trainDeck.remove(0);
        //if (trainDeck.size() == 0) this.reset();
        return output;
    }

    /**
     * Draws card from the set of faceup cards.
     * 
     * @author names
     * @version date
     * @return Colors the type of card pulled.
     */
    public Ticket pickup(int choice) {
        try {
            Ticket output = faceups[choice];
            faceups[choice] = this.draw();
            return output;
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
            System.exit(1);
        }
        return null;
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
            Ticket temp = trainDeck.get(i);
            trainDeck.set(i, trainDeck.get(randomIndex));
            trainDeck.set(randomIndex, temp);
        }
    }

    // /**
     // * Resets the deck when it is empty by gathering all discarded cards and reshuffling.
     // * 
     // * @author names
     // * @version date
     // */
    // public void reset() {
        // //DNF until decide how to access cards in player's hands.
        // trainDeck.clear();

        // //get number of each color missing from deck (aka in a player's hand)

        // int blue;
        // int black;
        // int red;
        // int green;
        // int orange;
        // int pink;
        // int wild;

        // //populate the deck with remaining cards
        // for (int i = 0; i < 6-blue; i++) trainDeck.add(Colors.BLUE);
        // for (int i = 0; i < 6-black; i++) trainDeck.add(Colors.BLACK);
        // for (int i = 0; i < 6-red; i++) trainDeck.add(Colors.RED);
        // for (int i = 0; i < 6-orange; i++) trainDeck.add(Colors.ORANGE);
        // for (int i = 0; i < 6-green; i++) trainDeck.add(Colors.GREEN);
        // for (int i = 0; i < 6-pink; i++) trainDeck.add(Colors.PINK);
        // for (int i = 0; i < 8-wild; i++) trainDeck.add(Colors.RAINBOW);
        // this.shuffle();
    // }
}
