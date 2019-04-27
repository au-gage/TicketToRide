
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
public class Edges
{
    private String start,end;
    protected int x1, y1, x2, y2;
    private Player whoCaptured;
    private Colors color;
    protected int length;
    private boolean isCaptured;

    public Edges(String start, String end,Colors color, int length,int x1, int y1,int x2, int y2)
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

    public Edges(String start, String end,Colors color, int length,int x1, int y1,int x2, int y2,boolean isCaptured)
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
     * Called when a path is attempted to be captured when it is already captured
     * 
     */
    public boolean getIsCaptured()
    {
        return isCaptured;
    }
    public void setIsCaptured()
    {
        isCaptured = true;
    }
    public boolean getIsCaptured(String start, String end)
    {
        return false;
    }

    public Player getWhoCaptured()
    {
        return whoCaptured;
    }

    public String getStart(){
         return start;
    }
    

    public Colors getColor()
    {
        return color;
    }

    public int getLength()
    {
        return length;
    }


    public String getEnd(){
        return end;
    }

    public void Captured(boolean isCaptured,Player whoCaptured)
    {
        this.isCaptured = isCaptured;
        this.whoCaptured = whoCaptured;
    }
}
