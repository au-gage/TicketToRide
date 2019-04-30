
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
 *class object to contain data for each destination card.
 * @author (Mark Eliseo,Cheryl McClean, Rose Wilson, Austin Gage, 
 * Derek McPhail )
 * @version (4/29/19)
 */
public class DestCard
{
    //instance variables
    private Image image;
    protected String start;
    protected String end;
    protected int value;
    /**
     * constructor for DestCard
     * 
     * @param image to set the card to
     * @param start point of the card
     * @param end point of the card
     */
    public DestCard(Image image,String start, String end,int value)
    {
        this.image = image;
        this.start = start;
        this.end = end;
        this.value = value;
    }
    /**
     * accessor to get image
     * 
     * @return image of card
     */
    public Image getImage()
    {
        return image;
    }
    /**
     * accessor to get start point
     * 
     * @return start of card
     */
    public String getStart()
    {
        return start;
    }
    /**
     * accessor to get end
     * 
     * @return end of card
     */
    public String getEnd()
    {
        return end;
    }
    
  

    
    /**
     * determines if destcard is complete
     * 
     * @param edges current state of games egdes
     * @param start of dest card
     * @param end of dest card
     * 
     * @return boolean 
     */
    public boolean destCardCompleted(ArrayList<Edges> edges, 
    String start, String end) {
        if (start.equals(end)) return true;
        boolean boolStart = false;
        boolean boolEnd = false;
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getStart().equals(start)) {
                String edgeEnd = edges.get(i).getEnd();
                edges.remove(i);
                boolStart = destCardCompleted(edges, edgeEnd, end);
            } else if (edges.get(i).getEnd().equals(start)) {
                String edgeStart = edges.get(i).getStart();
                edges.remove(i);
                boolEnd = destCardCompleted(edges, edgeStart, end);
            }
            
            if (boolStart || boolEnd) return true;
        }
        return false;
    }

}
