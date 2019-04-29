import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.*;
/**
 * Class to contain transit card objects and handle drawing or picking up cards.
 *
 * @author Mark Eliseo and Austin Gage
 * @version April 2019
 */
public class Tickets
{
    protected ArrayList<Ticket> trainDeck = new ArrayList<>();
    protected Ticket[] faceups = new Ticket[5];
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    /**
     * Initializes the deck of shuffled transit cards and the face-up pile.
     * 
     * @author Mark Eliseo and Austin Gage
     * @version April 2019
     */
    public Tickets() {
        Path path = Paths.get("fwdboardandtransport");        
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for(Path file: stream) {
                if (file.toString().equals("fwdboardandtransport\\blackcard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.BLACK));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\bluecard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.BLUE));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\colorcard.jpg")) {
                    for(int i = 0;i < 8;i++) {
                        trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.RAINBOW));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\greencard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.GREEN));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\orangecard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.ORANGE));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\pinkcard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.PINK));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\redcard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        trainDeck.add(new Ticket(toolkit.getImage(file.toString()),Colors.RED));
                    }
                }
            }
        }
        catch(Exception e) {
            System.exit(0);
        }
        for(int i = 0;i < trainDeck.size();i++) {
            trainDeck.get(i).setImage(trainDeck.get(i).getImage().getScaledInstance(200, 119, Image.SCALE_DEFAULT));
        }
        this.shuffle();
        for(int i = 0;i < 5;i++) {
            faceups[i] = trainDeck.get(i);
            trainDeck.remove(i);
        }
        boolean rainbows = false;
        while (!rainbows) {
            int rainbowCount = 0;
            for (int i = 0; i < faceups.length; i++) {
                if (faceups[i].color() == Colors.RAINBOW) {
                    rainbowCount++;
                }
            }
            if (rainbowCount >= 3) {
                for (int i = 0; i < faceups.length; i++) {
                    faceups[i] = trainDeck.get(i);
                    trainDeck.remove(i);
                }
            } else {
                rainbows = true;
            }
        }
    }

    /**
     * Draws a card from the deck of trains.
     * 
     * @author Mark Eliseo
     * @version April 2019
     * @param players The list of players currently playing the game.
     * @return The card that is drawn from the deck.
     */
    public Ticket draw(ArrayList<Player> players) {
        Ticket output = trainDeck.get(0);
        trainDeck.remove(0);
        if (trainDeck.size() == 0) this.reset(players);
        return output;
    }

    /**
     * Draws card from the set of faceup cards.
     * 
     * @author Mark Eliseo
     * @version April 2019
     * @param choice The index of what card is picked up.
     * @param players The list of players currently playing the game.
     * @return The card that is selected from the face-up cards.
     */
    public Ticket pickup(int choice, ArrayList<Player> players) {
        try {
            Ticket output = faceups[choice];
            faceups[choice] = this.draw(players);
            this.checkFaceUps(players);
            return output;
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e);
            System.exit(1);
        }
        return null;
    }

    /**
     * Check and handle the possibility of 3 rainbow cards in the faceups pile.
     * 
     * @author Mark Eliseo
     * @version April 2019
     * @param players The list of players currently playing the game.
     */
    public void checkFaceUps(ArrayList<Player> players) {
        //check how many rainbow cards are in the faceup line.
        int rainbowCount = 0;
        for (int i = 0; i < faceups.length; i++) {
            if (faceups[i].color() == Colors.RAINBOW) rainbowCount++;
        }
        
        //If there are 3 or more rainbow cards present, reset all 5 cards and check for rainbows again.
        if (rainbowCount >= 3) {
            for (int i = 0; i < faceups.length; i++) {
                faceups[i] = this.draw(players);
            }
            this.checkFaceUps(players);
        }
    }

    /**
     * Shuffles the deck of transit tickets in a pseudorandom order.
     * 
     * @author Mark Eliseo
     * @version April 2019
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

    /**
     * Resets the deck when it is empty by gathering all discarded cards and reshuffling.
     * 
     * @author Mark Eliseo
     * @version April 2019
     * @param players The list of players currently playing the game.
     */
    public void reset(ArrayList<Player> players) {
        //ensure that the deck is empty.
        if (!trainDeck.isEmpty()) {
            trainDeck.clear();
        }

        //get number of each card type missing from the deck (aka in a player's hand)
        int blue = 0;
        int green = 0;
        int black = 0;
        int pink = 0;
        int red = 0;
        int orange = 0;
        int wild = 0;
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            blue += player.hand.get(Colors.BLUE);
            green += player.hand.get(Colors.GREEN);
            black += player.hand.get(Colors.BLACK);
            pink += player.hand.get(Colors.PINK);
            red += player.hand.get(Colors.RED);
            orange += player.hand.get(Colors.ORANGE);
            wild += player.hand.get(Colors.RAINBOW);
        }

        //populate the deck with remaining cards
        Path path = Paths.get("fwdboardandtransport");        
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for(Path file: stream) {
                if (file.toString().equals("fwdboardandtransport\\blackcard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        Image icon = toolkit.getImage(file.toString()).getScaledInstance(200,119,Image.SCALE_DEFAULT);
                        trainDeck.add(new Ticket(icon,Colors.BLACK));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\bluecard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        Image icon = toolkit.getImage(file.toString()).getScaledInstance(200,119,Image.SCALE_DEFAULT);
                        trainDeck.add(new Ticket(icon,Colors.BLUE));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\colorcard.jpg")) {
                    for(int i = 0;i < 8;i++) {
                        Image icon = toolkit.getImage(file.toString()).getScaledInstance(200,119,Image.SCALE_DEFAULT);
                        trainDeck.add(new Ticket(icon,Colors.RAINBOW));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\greencard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        Image icon = toolkit.getImage(file.toString()).getScaledInstance(200,119,Image.SCALE_DEFAULT);
                        trainDeck.add(new Ticket(icon,Colors.GREEN));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\orangecard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        Image icon = toolkit.getImage(file.toString()).getScaledInstance(200,119,Image.SCALE_DEFAULT);
                        trainDeck.add(new Ticket(icon,Colors.ORANGE));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\pinkcard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        Image icon = toolkit.getImage(file.toString()).getScaledInstance(200,119,Image.SCALE_DEFAULT);
                        trainDeck.add(new Ticket(icon,Colors.PINK));
                    }
                }
                else if (file.toString().equals("fwdboardandtransport\\redcard.jpg")) {
                    for(int i = 0;i < 6;i++) {
                        Image icon = toolkit.getImage(file.toString()).getScaledInstance(200,119,Image.SCALE_DEFAULT);
                        trainDeck.add(new Ticket(icon,Colors.RED));
                    }
                }
            }
        }
        catch(Exception e) {
            System.exit(0);
        }
        this.shuffle();
    }
}
