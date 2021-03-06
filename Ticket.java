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
 * Class object to contain data for each transit card.
 *
 * @author Austin Gage, Mark Eliseo, Cheryl McClean, Rose Wilson,
 * Derek McPhail
 * @version 4/29/2019
 */
public class Ticket
{
    private Image image;
    private Colors color;
    
    /**
     * Constructor to create the transit card object.
     * 
     * 
     * @param image The image of the card type.
     * @param color The color of the card.
     */
    public Ticket(Image image, Colors color)
    {
        this.image = image;
        this.color = color;
    }
    
    /**
     * Accessor to retrieve the image of the ticket.
     * 
     *
     * @return The image of the card.
     */
    public Image getImage()
    {
        return image;
    }
    
    /**
     * Accessor to retrieve the color of the ticket.
    
     * @return The color of the card.
     */
    public Colors color()
    {
        return color;
    }
    
    /**
     * Mutator to replace the image of the card.
     * 
     * @param image to set the image of the ticket to
     */
    public void setImage(Image image)
    {
        this.image = image;
    }
}
