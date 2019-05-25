
/**
 * instances of each pathway
 * start and end
 * what color
 * length of path
 * if captured
 * Who Captured
 *
 * @author Austin Gage, Rose Wilson, Cheryl McClean, Derek McPhail,
 * Mark Eliseo
 * Austin Coded this whole class
 * @version 4/12/2019
 */
public class Edges
{
    private String start,end;
    protected int x1, y1, x2, y2;
    private Player whoCaptured;
    private Colors color;
    protected int length;
    private boolean isCaptured;
    private boolean connectsTourist;
    /**
     * constructor for uncaptured Edges class
     * 
     * @param start of edge
     * @param end of edge
     * @param color of edge
     * @parma length of edge
     * @param x1,y1,x2,y2 pixel position
     * 
     */
    public Edges(String start, String end,Colors color, int length,int x1, 
        int y1,int x2, int y2)
    {
        this.start = start;
        this.end = end;
        this.color = color;
        this.length = length;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        isCaptured = false;
        whoCaptured = null;
    }

    /**
     * constructor for captured Edges class
     * 
     * @param start of edge
     * @param end of edge
     * @param color of edge
     * @parma length of edge
     * @param x1,y1,x2,y2 pixel position
     * @param isCaptured signifying edge is captured
     */
    public Edges(String start, String end,Colors color, int length,int x1,
        int y1,int x2, int y2,boolean isCaptured)
    {
        this.start = start;
        this.end = end;
        this.color = color;
        this.length = length;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        isCaptured = true;
        whoCaptured = null;
    }

    /**
     * Called when a path is attempted to be captured when it is 
     * already captured
     * 
     * @return boolean isCaptured
     */
    public boolean getIsCaptured()
    {
        return isCaptured;
    }
    /**
     * sets value of isCaptured to true
     * 
     */
    public void setIsCaptured()
    {
        isCaptured = true;
    }
    /**
     * returns whether edge is captured
     * 
     * @param start and end
     * @return boolean
     */
    public boolean getIsCaptured(String start, String end)
    {
        return false;
    }
    /**
     * accessor to whoCaptured
     */
    public Player getWhoCaptured()
    {
        return whoCaptured;
    }
    /**
     * accessor to start
     */
    public String getStart(){
        return start;
    }
    /**
     * accessor to color
     */
    public Colors getColor()
    {
        return color;
    }
    /**
     * accessor to length
     */
    public int getLength()
    {
        return length;
    }

    /**
     * accessor to end
     */
    public String getEnd(){
        return end;
    }
    /**
     * accessor to is Captured and whoCaptured
     */
    public void Captured(boolean isCaptured,Player whoCaptured)
    {
        this.isCaptured = isCaptured;
        this.whoCaptured = whoCaptured;
    }
}
