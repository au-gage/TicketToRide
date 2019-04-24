
 

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.*;

/**
 * methods to implement graphics
 *
 * @author Austin Gage
 * @version 4/16/2019
 */
public class Visuals extends JPanel implements  MouseListener
{
    private Game ticketToRide = new Game();
    private Image board;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Image background;
    public Visuals()
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
                }
                if(file.toString().equals("fwdboardandtransport\\background.jpg"))
                {
                    background = toolkit.getImage(file.toString());
                    background = background.getScaledInstance(1280, 900, Image.SCALE_DEFAULT);
                }
            }
        }
        catch(Exception e)
        {
            System.exit(0);
        }
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
            g.drawImage(ticketToRide.ticketDeck.faceups[i].getImage(),700,100*i,this);
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

        Visuals label = new Visuals();
        frame.add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {

        createAndShowGUI();
    }
}
