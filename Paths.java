package TicketToRide;


/**
 * instances of each pathway
 * start and end
 * what color
 * length of path
 * if captured
 * Who Captured
 *
 * @author Austin Gage
 * @version 4/12/2019
 */
public class Paths
{
    private String start,end;
    private Player whoCaptured;
    private Colors color;
    protected int length;
    private boolean isCaptured;
    
    public Paths(String start, String end,Colors color, int length)
    {
        this.start = start;
        this.end = end;
        this.color = color;
        this.length = length;
        isCaptured = false;
        whoCaptured = null;
    }
    
    /**
     * Called when a path is attempted to be captured when it is already captured
     * 
     */
    public boolean getIsCaptured()
    {
        return isCaptured;
    }
    
    
    public void Captured(boolean isCaptured,Player whoCaptured)
    {
        this.isCaptured = isCaptured;
        this.whoCaptured = whoCaptured;
    }
}
