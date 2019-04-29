import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.*;
/**
 * determines who is playing and win conditions
 * Will also incorporate all the paths and prob captures
 * how many players
 * what color
 * what name
 * implements player, board, paths, and run the playing of the game
 *
 * @author Austin Gage, Mark Eliseo, Cheryl McClean,Rose Wilson, and Derek McPhail 
 * @version (4/29/19)
 */
public class Game extends JPanel implements MouseListener
{
    boolean gameStarted;
    private ArrayList<Edges> edges = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    protected Tickets ticketDeck = new Tickets();
    protected DestCards destDeck = new DestCards();
    protected int turn;
    protected int amtOfMoves = 2;
    private Image board;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Image background;
    private Image destCardBack;
    private Image transCardBack;
    private ArrayList<Image> tickets = new ArrayList<>();
    boolean turnOver = false;
    boolean lastTurnBegins = false;
    int maxTurn = -99;
    /**
     * constructor for the game class
     * makes the board and players
     */
    public Game()
    {
        setPreferredSize(new Dimension(910,1024)); //Dimension subject to change
        addMouseListener(this);
        Path path = Paths.get("fwdboardandtransport");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path))
        {
            for(Path file: stream)
            {
                if(file.toString().equals("fwdboardandtransport\\Board.jpg"))
                {
                    board = toolkit.getImage(file.toString());
                    board = board.getScaledInstance(534,750,Image.SCALE_DEFAULT);
                }
                else if(file.toString().equals("fwdboardandtransport\\background.jpg"))
                {
                    background = toolkit.getImage(file.toString());
                    background = background.getScaledInstance(1280, 1024, Image.SCALE_DEFAULT);
                }
                else if(file.toString().equals("fwdboardandtransport\\DestTicket.jpg"))
                {
                    destCardBack = toolkit.getImage(file.toString());
                    destCardBack = destCardBack.getScaledInstance(119, 200, Image.SCALE_DEFAULT);
                }
                else if(file.toString().equals("fwdboardandtransport\\NYcard.jpg"))
                {
                    transCardBack = toolkit.getImage(file.toString());
                    transCardBack = transCardBack.getScaledInstance(119, 200, Image.SCALE_DEFAULT);
                }
                else if (file.toString().equals("fwdboardandtransport\\blackcard2.jpg")) {
                    tickets.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));

                }
                else if (file.toString().equals("fwdboardandtransport\\bluecard2.jpg")) {
                    tickets.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));

                }
                else if (file.toString().equals("fwdboardandtransport\\colorcard2.jpg")) {
                    tickets.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));

                }
                else if (file.toString().equals("fwdboardandtransport\\greencard2.jpg")) {
                    tickets.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));

                }
                else if (file.toString().equals("fwdboardandtransport\\orangecard2.jpg")) {
                    tickets.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));

                }
                else if (file.toString().equals("fwdboardandtransport\\pinkcard2.jpg")) {
                    tickets.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));

                }
                else if (file.toString().equals("fwdboardandtransport\\redcard2.jpg")) {
                    tickets.add(toolkit.getImage(file.toString()).getScaledInstance(119,200,Image.SCALE_DEFAULT));

                }
            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
        gameStarted = true;
        MakePlayers();
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
     * This method checks to see where the mouse was clicked, and calls
     * the appropriate method, like if twist is pressed or if enter is pressed
     * @param the MouseEvent that started the method
     */
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        if(turn != maxTurn + 1 || lastTurnBegins != true)
        {
            //Draw face up Card, starting with first, second, etc
            if(x >= 700 && x <= 900 && y >=0 && y <= 119 && amtOfMoves > 0)
            {
                if(ticketDeck.faceups[0].color() == Colors.RAINBOW)
                {
                    if(amtOfMoves == 2)
                    {
                        players.get(turn % players.size()).drawTransTicket(ticketDeck,0,amtOfMoves, players);
                        amtOfMoves -= 2;
                    }

                }
                else
                {
                    players.get(turn % players.size()).drawTransTicket(ticketDeck,0,amtOfMoves, players);
                    amtOfMoves--;    
                }
            }
            else if(x >= 700 && x <= 900 && y >=120 && y <= 239 && amtOfMoves > 0)
            {
                if(ticketDeck.faceups[1].color() == Colors.RAINBOW)
                {
                    if(amtOfMoves == 2)
                    {
                        players.get(turn % players.size()).drawTransTicket(ticketDeck,1,amtOfMoves, players);
                        amtOfMoves -= 2;
                    }

                }
                else
                {
                    players.get(turn % players.size()).drawTransTicket(ticketDeck,1,amtOfMoves, players);
                    amtOfMoves--;    
                }
            }
            else if(x >= 700 && x <= 900 && y >=240 && y <= 359 && amtOfMoves > 0)
            {
                if(ticketDeck.faceups[2].color() == Colors.RAINBOW)
                {
                    if(amtOfMoves == 2)
                    {
                        players.get(turn % players.size()).drawTransTicket(ticketDeck,2,amtOfMoves, players);
                        amtOfMoves -= 2;
                    }

                }
                else
                {
                    players.get(turn % players.size()).drawTransTicket(ticketDeck,2,amtOfMoves, players);
                    amtOfMoves--;    
                }
            } 
            else if(x >= 700 && x <= 900 && y >=360 && y <= 479 && amtOfMoves > 0)
            {
                if(ticketDeck.faceups[3].color() == Colors.RAINBOW)
                {
                    if(amtOfMoves == 2)
                    {
                        players.get(turn % players.size()).drawTransTicket(ticketDeck,3,amtOfMoves, players);
                        amtOfMoves -= 2;
                    }

                }
                else
                {
                    players.get(turn % players.size()).drawTransTicket(ticketDeck,3,amtOfMoves, players);
                    amtOfMoves--;    
                }
            }
            else if(x >= 700 && x <= 900 && y >=480 && y <= 599 && amtOfMoves > 0)
            {
                if(ticketDeck.faceups[4].color() == Colors.RAINBOW)
                {
                    if(amtOfMoves == 2)
                    {
                        players.get(turn % players.size()).drawTransTicket(ticketDeck,4,amtOfMoves, players);
                        amtOfMoves -= 2;
                    }
                }
                else
                {
                    players.get(turn % players.size()).drawTransTicket(ticketDeck,4,amtOfMoves, players);
                    amtOfMoves--;    
                }
            }

            //Draw from Dest deck
            else if(x >= 681 && x <= 797 && y >= 597 && y <= 792 && amtOfMoves > 1)
            {
                if(destDeck.destCards.size() > 0)
                {
                    players.get(turn % players.size()).drawDestTickets(destDeck);
                    amtOfMoves -= 2;
                }
            }
            //Draw from transport deck
            else if(x >= 800 && x <= 900 && y >= 598 && y <= 795 && amtOfMoves > 0)
            {
                players.get(turn % players.size()).drawDeckTransTicket(ticketDeck,amtOfMoves,players);
                amtOfMoves--;
            }
            //540,0,145,50 Claim Route button pressed
            else if(x >= 540 && x <= 685 && y >=0 && y <= 55 && amtOfMoves == 2)
            {
                amtOfMoves -= players.get(turn % players.size()).claimRoute(edges,players);
            }
            //End turn pressed, only shows up when player is out of moves
            else if(x >= 540 && x <= 685 && y >= 400 && y <= 450 && amtOfMoves == 0)
            {
                turnOver = false; 
                turn++;
                amtOfMoves = 2;
            }

            if(players.get(turn % players.size()).amtOfTaxis <= 2 && !lastTurnBegins)
            {
                lastTurnBegins = true;
                maxTurn = turn + players.size();
            }

            //e.consume();
            repaint();
            if(amtOfMoves <= 0)
            {            
                turnOver = true;
                repaint();
            }
        }

    }

    /**
     * Method that paints the JPanel
     * 
     * @param a Graphics object g
     * 
     */
    @Override
    public void paintComponent( Graphics g ) { 
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.WHITE);
        g.drawImage(background,0,0,this);
        g.drawImage(board, 0, 0, this);

        g2.fillRoundRect(540,5,145,50, 10, 10);
        g2.fillRoundRect(540,200,145,50, 10, 10);

        g2.setColor(Color.BLACK);
        Font font = new Font("SERIF",Font.PLAIN,20);
        g2.setFont(font);
        g2.drawString("Claim Route", 560,35);
        g2.drawString("Current Taxis: " + players.get(turn % players.size()).amtOfTaxis,542,230);
        if(turnOver)
        {
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(540,400,145,50, 10, 10);
            g2.setColor(Color.BLACK);
            g2.drawString("End Turn", 575,430);
        }

        if(lastTurnBegins)
        {
            g2.setColor(Color.WHITE);
            g2.fillRect(540,600,145,50);
            g2.setColor(Color.BLACK);
            g2.drawString("Warning: Last Turn", 550,625);
        }

        if(players.size() > 1)
        {
            for(int i = 0;i < players.get(turn % players.size()).destHand.size();i++)
            {
                g.drawImage(players.get(turn % players.size()).destHand.get(i).getImage(),100 * i,720,this);
                //g.drawImage(players.get(turn % players.size()).hand.get(Colors.RED).getImage(),100 * i, 900,this);
            }
            g2.setColor(Color.WHITE);
            for(int i = 0;i < tickets.size();i++)
            {
                g.drawImage(tickets.get(i),100*i,900,this);
                g.fillOval((100*i) + 10, 900,25,25);
            }
            g2.setColor(Color.BLACK);
            g.drawString(Integer.toString(players.get(turn % players.size()).hand.get(Colors.BLACK)),17,917);
            g.drawString(Integer.toString(players.get(turn % players.size()).hand.get(Colors.BLUE)),117,917);
            g.drawString(Integer.toString(players.get(turn % players.size()).hand.get(Colors.RAINBOW)),217,917);
            g.drawString(Integer.toString(players.get(turn % players.size()).hand.get(Colors.GREEN)),317,917);
            g.drawString(Integer.toString(players.get(turn % players.size()).hand.get(Colors.ORANGE)),417,917);
            g.drawString(Integer.toString(players.get(turn % players.size()).hand.get(Colors.PINK)),517,917);
            g.drawString(Integer.toString(players.get(turn % players.size()).hand.get(Colors.RED)),617,917);
        }

        for(int i = 0;i < 5;i++)
        {
            g.drawImage(ticketDeck.faceups[i].getImage(),700,119*i,this);
        }
        if(destDeck.destCards.size() > 0)
            g.drawImage(destCardBack,681,595,this);
        if(ticketDeck.trainDeck.size() > 0)
            g.drawImage(transCardBack,800,595,this);
        for(int i = 0; i < edges.size();i++)
        {
            if(edges.get(i).getIsCaptured())
            {
                if(edges.get(i).getWhoCaptured() != null)
                {
                    Player temp = edges.get(i).getWhoCaptured();
                    if(temp.color == Colors.BLUE)
                    {
                        g.setColor(Color.BLUE);
                    }
                    else if(temp.color == Colors.WHITE)
                    {
                        g.setColor(Color.WHITE);
                    }
                    else if(temp.color == Colors.PURPLE)
                    {
                        g.setColor(Color.MAGENTA);
                    }
                    else if(temp.color == Colors.YELLOW)
                    {
                        g.setColor(Color.YELLOW);
                    }
                    int x1 = edges.get(i).x1;
                    int y1 = edges.get(i).y1;
                    int x2 = edges.get(i).x2;
                    int y2 = edges.get(i).y2;
                    g2.setStroke(new BasicStroke(5));
                    g2.drawLine(x1,y1,x2,y2);
                }
            }
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Ticket To Ride: NY");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game label = new Game();
        frame.add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
    /**
     * a main method to display the GUI
     * 
     * @param args not utilized
     */
    public static void main(String[] args)
    {
        createAndShowGUI();
    }
    /**
     * initializes Player objects
     * based on input that from user
     */
    protected void MakePlayers()
    {
        Integer[] numSet = {2,3,4};
        int amt = JOptionPane.showOptionDialog(null, "Select the Amount of Players",
                "Players", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, numSet, numSet[0]);
        amt += 2;
        for(int i = 1;i <= amt;i++)
        {
            String name = JOptionPane.showInputDialog(null, "Enter the name of Player " + i,
                    "Input a name", JOptionPane.QUESTION_MESSAGE);
            boolean getColor = false;
            while(!getColor)
            {
                boolean colorUsed = false;
                Colors[] colorSet = {Colors.BLUE, Colors.WHITE, Colors.PURPLE, Colors.YELLOW};
                int colorIndex = JOptionPane.showOptionDialog(null, "Select the color of Player " + i,
                        "Choose a Color: ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, colorSet, colorSet[0]);
                Colors currentColor = colorSet[colorIndex];
                if(i == 1)
                {
                    players.add(new Player(currentColor, name));
                    getColor = true;
                }
                else
                {
                    for(int j = 0;j < players.size();j++)
                    {
                        if (currentColor == players.get(j).getColor())
                        {
                            colorUsed = true;
                        }
                    }
                    if(!colorUsed)
                    {
                        players.add(new Player(currentColor, name));
                        getColor = true;
                    }
                }
            }
        }

        MakePaths();
    }

    /**
     * Adds all Path objects into an ArrayList
     * 
     */
    protected void MakePaths()
    {

        edges.add(new Edges("Lincoln Center","Central Park",Colors.ORANGE,2,102,38,250,28,true));
        edges.add(new Edges("Lincoln Center","Midtown West",Colors.RED,2,102,38,82,178));

        edges.add(new Edges("Lincoln Center","Times Square",Colors.GREEN,2,90,41,177,160));
        edges.add(new Edges("Lincoln Center","Times Square",Colors.BLUE,2,115,38,187,156));

        edges.add(new Edges("Central Park","Times Square",Colors.RED,2,254,30,190,160));
        edges.add(new Edges("Central Park","Times Square",Colors.BLACK,2,240,28,180,156));
        edges.add(new Edges("Central Park","United Nations",Colors.PINK,3,250,28,381,148));

        edges.add(new Edges("Midtown West","Chelsea",Colors.BLUE,2,82,178,120,320));
        edges.add(new Edges("Midtown West","Times Square",Colors.NONE,1,82,178,187,156));
        edges.add(new Edges("Midtown West","Empire State Building",Colors.GREEN,2,82,178,245,240));

        edges.add(new Edges("Times Square","Empire State Building",Colors.PINK,1,190,160,255,242));
        edges.add(new Edges("Times Square","Empire State Building",Colors.ORANGE,1,175,156,245,240));
        edges.add(new Edges("Times Square","United Nations",Colors.NONE,2,187,156,381,148));

        edges.add(new Edges("United Nations","Empire State Building",Colors.BLACK,2,381,148,245,240));
        edges.add(new Edges("United Nations","Gramercy Park",Colors.GREEN,3,381,148,307,312));

        edges.add(new Edges("Empire State Building", "Gramercy Park",Colors.RED,1,250,242,310,315));
        edges.add(new Edges("Empire State Building", "Gramercy Park",Colors.BLUE,1,260,240,320,312));

        edges.add(new Edges("Chelsea","Soho",Colors.PINK,4,120,320,190,563));
        edges.add(new Edges("Chelsea","Empire State Building",Colors.NONE,2,130,330,260,247));
        edges.add(new Edges("Chelsea","Empire State Building",Colors.NONE,2,120,320,245,240));
        edges.add(new Edges("Chelsea","Gramercy Park",Colors.ORANGE,2,120,320,307,312));
        edges.add(new Edges("Chelsea","Greenwich Village",Colors.GREEN,3,110,323,265,445));
        edges.add(new Edges("Chelsea","Greenwich Village",Colors.RED,3,125,320,278,443));

        edges.add(new Edges("Gramercy Park","Greenwich Village",Colors.PINK,2,315,315,285,445));
        edges.add(new Edges("Gramercy Park","Greenwich Village",Colors.BLACK,2,300,312,270,443));
        edges.add(new Edges("Gramercy Park","East Village",Colors.NONE,2,307,312,428,433));

        edges.add(new Edges("Greenwich Village","Soho",Colors.ORANGE,2,278,443,190,563));
        edges.add(new Edges("Greenwich Village","Chinatown",Colors.NONE,2,290,445,330,582));
        edges.add(new Edges("Greenwich Village","Chinatown",Colors.NONE,2,275,443,310,580));
        edges.add(new Edges("Greenwich Village","Lower East Side",Colors.NONE,2,278,443,412,526));
        edges.add(new Edges("Greenwich Village","East Village",Colors.BLUE,2,278,443,428,433));

        edges.add(new Edges("East Village","Lower East Side",Colors.BLACK,1,428,433,412,526));

        edges.add(new Edges("Lower East Side","Chinatown",Colors.BLUE,1,412,526,318,580));
        edges.add(new Edges("Lower East Side","Brooklyn",Colors.NONE,3,412,526,479,695));

        edges.add(new Edges("Soho","Wall Street",Colors.NONE,2,190,563,272,682));

        edges.add(new Edges("Chinatown","Wall Street",Colors.GREEN,1,312,582,275,680));
        edges.add(new Edges("Chinatown","Wall Street",Colors.PINK,1,335,580,290,682));
        edges.add(new Edges("Chinatown","Brooklyn",Colors.RED,3,320,583,480,697));
        edges.add(new Edges("Chinatown","Brooklyn",Colors.ORANGE,3,335,575,495,690));

        edges.add(new Edges("Wall Street","Brooklyn",Colors.BLUE,3,270,680,482,698));
        edges.add(new Edges("Wall Street","Brooklyn",Colors.BLACK,3,272,690,479,710));

        DealDestCards();
    }
    /**
     * deals the destination cards to players
     * to be utilized at start of game
     */
    private void DealDestCards()
    {
        for(int i = 0;i < players.size();i++)
        {
            DestCard[] dests = new DestCard[2];
            dests[0] = destDeck.draw();
            dests[1] = destDeck.draw();
            String[] choices = new String[3];
            choices[0] = dests[0].getStart() + " => " + dests[0].getEnd();
            choices[1] = dests[1].getStart() + " => " + dests[1].getEnd();
            choices[2] = "Both Cards";
            String cardTaken = (String) JOptionPane.showInputDialog(null, players.get(i).name + ", select 1 or both cards", 
                    "Destination Card Selection", JOptionPane.QUESTION_MESSAGE, null,choices,choices[0]);
            if (cardTaken == null) cardTaken = "";
            if(cardTaken.equals(dests[0].getStart() + " => " + dests[0].getEnd()))
            {
                players.get(i).destHand.add(dests[0]);
                destDeck.add(dests[1]);
            }
            else if(cardTaken.equals(dests[1].getStart() + " => " + dests[1].getEnd()))
            {
                players.get(i).destHand.add(dests[1]);
                destDeck.add(dests[0]);
            }
            else
            {
                players.get(i).destHand.add(dests[0]);
                players.get(i).destHand.add(dests[1]);
            }
        }
    }
    /**
     * initializes a turn
     */
    private void game()
    {
        boolean gameOver = false;
        boolean turnOver = false;
        int turn = 0;
    }
}
