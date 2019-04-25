import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
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
 * @author Austin Gage
 * @version (a version number or a date)
 */
public class Game extends JPanel implements MouseListener
{
    boolean gameStarted;
    private ArrayList<Edges> edges = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    protected Tickets ticketDeck = new Tickets();
    protected DestCards destDeck = new DestCards();
    protected int turn;

    private Image board;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Image background;
    private Image destCardBack;
    private Image transCardBack;
    
    public Game()
    {
        setPreferredSize(new Dimension(900,900)); //Dimension subject to change
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
                    background = background.getScaledInstance(1280, 900, Image.SCALE_DEFAULT);
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
        //Code to check if the player wants to claim a route, take from Ticket or Transport deck, or take face up
        //Depending on what they click will call methods found in player class
        //players.get(turn % players.size()).drawDestTickets();
        if(x <= 102-18)
        {
            
        }
        turn++;
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
        g2.setStroke(new BasicStroke(2));
        g.drawImage(background,0,0,this);
        g.drawImage(board, 0, 0, this);
        for(int i = 0;i < 5;i++)
        {
            g.drawImage(ticketDeck.faceups[i].getImage(),700,119*i,this);
        }
        g.drawImage(destCardBack,681,595,this);
        g.drawImage(transCardBack,800,595,this);
        for(int i = 0; i < edges.size();i++)
        {
            if(edges.get(i).getIsCaptured())
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
                g.fillRect(x1,y1, (int) Math.abs(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))),10);
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

    public static void main(String[] args)
    {
        createAndShowGUI();
    }

    protected void MakePlayers()
    {
        int amt = 0;
        while(amt == 0)
        {
            String num = JOptionPane.showInputDialog(null, "Enter the Amount of Players",
                    "Input 2-4", JOptionPane.QUESTION_MESSAGE);
            try
            {
                amt = Integer.parseInt(num);
            }
            catch(Exception e)
            {
            }
            if(amt > 4 || amt < 2)
            {
                amt = 0;
            }
        }
        for(int i = 1;i <= amt;i++)
        {
            String name = JOptionPane.showInputDialog(null, "Enter the name of Player " + i,
                    "Input a name", JOptionPane.QUESTION_MESSAGE);
            boolean getColor = false;

            while(!getColor)
            {
                boolean colorUsed = false;
                String currentColor = JOptionPane.showInputDialog(null, "Enter the color of Player " + i,
                        "Input blue,white,purple, or yellow", JOptionPane.QUESTION_MESSAGE);
                currentColor = currentColor.toUpperCase();
                if(currentColor.equals("BLUE") || currentColor.equals("WHITE") || currentColor.equals("PURPLE")
                || currentColor.equals("YELLOW"))
                {
                    if(i == 1)
                    {
                        players.add(new Player(Colors.valueOf(currentColor),name));
                        getColor = true;
                    }
                    else
                    {
                        for(int j = 0;j < players.size();j++)
                        {
                            if (Colors.valueOf(currentColor.toUpperCase()).equals(players.get(j).getColor()))
                            {
                                colorUsed = true;
                            }
                        }
                        if(!colorUsed)
                        {
                            Colors color = Colors.valueOf(currentColor.toUpperCase());
                            players.add(new Player(color,name));
                            getColor = true;
                        }
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
        edges.add(new Edges("Lincoln Center","Central Park",Colors.ORANGE,2,102,38,250,28));
        edges.add(new Edges("Lincoln Center","Midtown West",Colors.RED,2,102,38,82,178));
        
        edges.add(new Edges("Lincoln Center","Times Square",Colors.GREEN,2,102,38,187,156));
        edges.add(new Edges("Lincoln Center","Times Square",Colors.BLUE,2,102,38,187,156));

        edges.add(new Edges("Central Park","Times Square",Colors.BLACK,2,250,28,187,156));
        edges.add(new Edges("Central Park","Times Square",Colors.RED,2,250,28,187,156));
        edges.add(new Edges("Central Park","United Nations",Colors.PINK,3,250,28,381,148));

        edges.add(new Edges("Midtown West","Chelsea",Colors.BLUE,2,82,178,120,320));
        edges.add(new Edges("Midtown West","Times Square",Colors.NONE,1,82,178,187,156));
        edges.add(new Edges("Midtown West","Empire State Building",Colors.GREEN,2,82,178,245,240));

        edges.add(new Edges("Times Square","Empire State Building",Colors.PINK,1,187,156,245,240));
        edges.add(new Edges("Times Square","Empire State Building",Colors.ORANGE,1,187,156,245,240));
        edges.add(new Edges("Times Square","United Nations",Colors.NONE,2,187,156,381,148));

        edges.add(new Edges("United Nations","Empire State Building",Colors.BLACK,2,381,148,245,240));
        edges.add(new Edges("United Nations","Gramercy Park",Colors.GREEN,3,381,148,307,312));

        edges.add(new Edges("Empire State Building", "Gramercy Park",Colors.RED,1,245,240,307,312));
        edges.add(new Edges("Empire State Building", "Gramercy Park",Colors.BLUE,1,245,240,307,312));

        edges.add(new Edges("Chelsea","Soho",Colors.PINK,4,120,320,190,563));
        edges.add(new Edges("Chelsea","Empire State Building",Colors.NONE,2,120,320,245,240));
        edges.add(new Edges("Chelsea","Empire State Building",Colors.NONE,2,120,320,245,240));
        edges.add(new Edges("Chelsea","Gramercy Park",Colors.ORANGE,2,120,320,307,312));
        edges.add(new Edges("Chelsea","Greenwich Village",Colors.GREEN,3,120,320,278,443));
        edges.add(new Edges("Chelsea","Greenwich Village",Colors.RED,3,120,320,278,443));

        edges.add(new Edges("Gramercy Park","Greenwich Village",Colors.BLACK,2,307,312,278,443));
        edges.add(new Edges("Gramercy Park","Greenwich Village",Colors.PINK,2,307,312,278,443));
        edges.add(new Edges("Gramercy Park","East Village",Colors.NONE,2,307,312,428,433));

        edges.add(new Edges("Greenwich Village","Soho",Colors.ORANGE,2,278,443,190,563));
        edges.add(new Edges("Greenwich Village","Chinatown",Colors.NONE,2,278,443,318,580));
        edges.add(new Edges("Greenwich Village","Chinatown",Colors.NONE,2,278,443,318,580));
        edges.add(new Edges("Greenwich Village","Lower East Side",Colors.NONE,2,278,443,412,526));
        edges.add(new Edges("Greenwich Village","East Village",Colors.BLUE,2,278,443,428,433));

        edges.add(new Edges("East Village","Lower East Side",Colors.BLACK,1,428,433,412,526));

        edges.add(new Edges("Lower East Side","Chinatown",Colors.BLUE,1,412,526,318,580));
        edges.add(new Edges("Lower East Side","Brooklyn",Colors.NONE,3,412,526,479,695));

        edges.add(new Edges("Soho","Wall Street",Colors.NONE,2,190,563,272,682));

        edges.add(new Edges("Chinatown","Wall Street",Colors.GREEN,1,318,580,272,682));
        edges.add(new Edges("Chinatown","Wall Street",Colors.PINK,1,318,580,272,682));
        edges.add(new Edges("Chinatown","Brooklyn",Colors.RED,3,318,580,479,695));
        edges.add(new Edges("Chinatown","Brooklyn",Colors.ORANGE,3,318,580,479,695));

        edges.add(new Edges("Wall Street","Brooklyn",Colors.BLUE,3,272,682,479,695));
        edges.add(new Edges("Wall Street","Brooklyn",Colors.BLACK,3,272,682,479,695));
        DealDestCards();
    }

    private void DealDestCards()
    {
        for(int i = 0;i < players.size();i++)
        {
            players.get(i).DestHand.add(destDeck.draw());
            players.get(i).DestHand.add(destDeck.draw());
        }
    }

    private void game()
    {
        boolean gameOver = false;
        boolean turnOver = false;
        int turn = 0;
    }
}
