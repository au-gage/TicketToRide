
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
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DestCard
{
    private Image image;
    private String start;
    private String end;
    public DestCard(Image image,String start, String end)
    {
        this.image = image;
        this.start = start;
        this.end = end;
    }

    public Image getImage()
    {
        return image;
    }

    public String getStart()
    {
        return start;
    }

    public String getEnd()
    {
        return end;
    }

    /**
     * Will do once we have the players delt cards
     */
    public void returnCard(){

    }

    /**
     * Returns the value of a destination card 
     */
    public static int destCardValues(Edges route, DestCard card){
        int value = 0; 

        if((route.getIsCaptured("Central Park", "Chelsea") || 
            route.getIsCaptured("Chelsea", "Central Park")) && card.getImage().toString() == "fwdboardandtransport\\CPtoC.jpg"){
            value = 5;
            return value;
        } 
        else if((!route.getIsCaptured("Central Park", "Chelsea") || !route.getIsCaptured("Chelsea", "Central Park")) && card.getImage().toString() == 
        "fwdboardandtransport\\CPtoC.jpg"){
            value = -5;
            return value;
        }

        if((route.getIsCaptured("Central Park", "Chinatown") || route.getIsCaptured("Chinatown", "Central Park")) && card.getImage().toString() == 
        "fwdboardandtransport\\CPtoCT.jpg"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Central Park", "Chinatown") || !route.getIsCaptured("Chinatown", "Central Park")) && card.getImage().toString() == 
        "fwdboardandtransport\\CPtoCT.jpg"){
            value = -8;
            return value;
        }

        if((route.getIsCaptured("Central Park", "Gramercy Park") || route.getIsCaptured("Gramercy Park", "Central Park")) && card.getImage().toString() == 
        "fwdboardandtransport\\CPtoGP.jpg"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("Central Park", "Gramercy Park") || !route.getIsCaptured("Gramercy Park", "Central Park")) && card.getImage().toString() ==
        "fwdboardandtransport\\CPtoGP.jpg"){
            value = -4;
            return value;
        }

        if((route.getIsCaptured("Central Park", "Midtown West") || route.getIsCaptured("Midtown West", "Central Park"))  && card.getImage().toString() == 
        "fwdboardandtransport\\CPtoMW.jpg"){
            value = 3;
            return value;
        }
        else if((!route.getIsCaptured("Central Park", "Midtown West") || !route.getIsCaptured("Midtown West", "Central Park")) && card.getImage().toString() ==
        "fwdboardandtransport\\CPtoMW.jpg"){
            value = -3;
            return value;
        }

        if((route.getIsCaptured("Chelsea", "Brooklyn") || route.getIsCaptured("Brooklyn", "Chelsea"))  && card.getImage().toString() == 
        "fwdboardandtransport\\CtoB.jpg"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Chelsea", "Brooklyn") || !route.getIsCaptured("Brooklyn", "Chelsea")) && card.getImage().toString() == 
        "fwdboardandtransport\\CtoB.jpg"){
            value = -8;
            return value;
        }

        if((route.getIsCaptured("Chelsea", "Wall Street") || route.getIsCaptured("Wall Street", "Chelsea")) && card.getImage().toString() == 
        "fwdboardandtransport\\CtoWS.jpg"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Chelsea", "Wall Street") || route.getIsCaptured("Wall Street", "Chelsea")) && card.getImage().toString() == 
        "fwdboardandtransport\\CtoWS.jpg"){
            value = -8;
            return value;
        }

        if((route.getIsCaptured("Empire State Building", "Brooklyn") || route.getIsCaptured("Brooklyn", "Empire State Building")) && card.getImage().toString() == 
        "fwdboardandtransport\\ESBtoB.jpg"){
            value = 6;
            return value;
        }
        else if((!route.getIsCaptured("Empire State Building", "Brooklyn") || !route.getIsCaptured("Brooklyn", "Empire State Building")) 
        && card.getImage().toString() == "fwdboardandtransport\\ESBtoB.jpg"){
            value = -6;
            return value;
        }

        if((route.getIsCaptured("Empire State Building", "Greenwich Village") || route.getIsCaptured("Greenwich Village", "Empire State Building")) && 
        card.getImage().toString() == "fwdboardandtransport\\ESBtoGV.jpg"){
            value = 3;
            return value;
        }
        else if((!route.getIsCaptured("Empire State Building", "Greenwich Village") || !route.getIsCaptured("Greenwich Village", "Empire State Building")) && 
        card.getImage().toString() == "fwdboardandtransport\\ESBtoGV.jpg"){
            value = -3;
            return value;
        }

        if((route.getIsCaptured("East Village", "Soho") || route.getIsCaptured("Soho", "East Village")) && card.getImage().toString() == 
        "fwdboardandtransport\\EVtoS.jpg"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("East Village", "Soho") || !route.getIsCaptured("Soho", "East Village")) && card.getImage().toString() == 
        "fwdboardandtransport\\EVtoS.jpg"){
            value = -4;
            return value;
        }

        if((route.getIsCaptured("Gramercy Park", "Chinatown") || route.getIsCaptured("Chinatown", "Gramercy Park")) && card.getImage().toString() == 
        "fwdboardandtransport\\GPtoCT.jpg"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("Gramercy Park", "Chinatown") || !route.getIsCaptured("Chinatown", "Gramercy Park")) && card.getImage().toString() 
        == "fwdboardandtransport\\GPtoCT.jpg"){
            value = -4;
            return value;
        }

        if((route.getIsCaptured("Lincoln Center", "Empire State Building") || route.getIsCaptured("Empire State Building", "Lincoln Center")) 
        && card.getImage().toString() == "fwdboardandtransport\\LCtoESB.jpg"){
            value = 3;
            return value;
        }
        else if ((!route.getIsCaptured("Lincoln Center", "Empire State Building") || !route.getIsCaptured("Empire State Building", "Lincoln Center")) 
        && card.getImage().toString() == "fwdboardandtransport\\LCtoESB.jpg"){
            value = -3;
            return value;
        }

        if((route.getIsCaptured("Lincoln Center", "Greenwich Village") || route.getIsCaptured("Greenwich Village", "Lincoln Center")) 
        && card.getImage().toString() == "fwdboardandtransport\\LCtoGV.jpg"){
            value = 6;
            return value;
        }
        else if((!route.getIsCaptured("Lincoln Center", "Greenwich Village") || !route.getIsCaptured("Greenwich Village", "Lincoln Center")) 
        && card.getImage().toString() == "fwdboardandtransport\\LCtoGV.jpg"){
            value = -6;
            return value;
        }

        if((route.getIsCaptured("Lower East Side", "Wall Street") || route.getIsCaptured("Wall Street", "Lower East Side")) 
        && card.getImage().toString() == "fwdboardandtransport\\LEStoWS.jpg"){
            value = 2;
            return value;
        }
        else if((!route.getIsCaptured("Lower East Side", "Wall Street") || !route.getIsCaptured("Wall Street", "Lower East Side"))
        && card.getImage().toString() == "fwdboardandtransport\\LEStoWS.jpg"){
            value = -2;
            return value;
        }

        if((route.getIsCaptured("Times Square", "Brooklyn") || route.getIsCaptured("Brooklyn", "Times Square")) 
        && card.getImage().toString() == "fwdboardandtransport\\TStoB.jpg"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Times Square", "Brooklyn") || !route.getIsCaptured("Brooklyn", "Times Square")) && card.getImage().toString() == 
        "fwdboardandtransport\\TStoB.jpg"){
            value = -8;
            return value;
        }

        if((route.getIsCaptured("Times Square", "East Village") || route.getIsCaptured("East Village", "Times Square"))
        && card.getImage().toString() == "fwdboardandtransport\\TStoEV.jpg"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("Times Square", "East Village") || !route.getIsCaptured("East Village", "Times Square")) 
        && card.getImage().toString() == "fwdboardandtransport\\TStoEV.jpg"){
            value = -4;
            return value;
        }

        if((route.getIsCaptured("Times Square", "Soho") || route.getIsCaptured("Soho", "Times Square")) && card.getImage().toString() == 
        "fwdboardandtransport\\TStoS.jpg"){
            value = 6;
            return value;
        }
        else if((!route.getIsCaptured("Times Square", "Soho") || !route.getIsCaptured("Soho", "Times Square")) && card.getImage().toString() == 
        "fwdboardandtransport\\TStoS.jpg"){
            value = -6;
            return value;
        }

        if((route.getIsCaptured("United Nations", "Midtown West") || route.getIsCaptured("Midtown West", "United Nations")) && card.getImage().toString() == 
        "fwdboardandtransport\\UNtoMW.jpg"
        ){
            value = 3;
            return value;
        }
        else if((!route.getIsCaptured("United Nations", "Midtown West") || !route.getIsCaptured("Midtown West", "United Nations")) && card.getImage().toString() == 
        "fwdboardandtransport\\UNtoMW.jpg"){
            value = -3;
            return value;
        }

        if((route.getIsCaptured("United Nations", "Wall Street") || route.getIsCaptured("Wall Street", "United Nations")) && card.getImage().toString() == 
        "fwdboardandtransport\\UNtoWS.jpg"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("United Nations", "Wall Street") || !route.getIsCaptured("Wall Street", "United Nations")) && card.getImage().toString() == 
        "fwdboardandtransport\\UNtoWS.jpg"){
            value = -8;
            return value;
        }      

        return value;
    }

    public boolean destCardCompleted(ArrayList<Edges> edges, String start, String end) {
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
    
    public static void main(String[] args) {
        Player player = new Player(Colors.BLUE, "Kevin");
        
        player.capturedEdges.add(new Edges("plum", "banana", Colors.BLACK, 4, 0, 0, 0, 0));
        player.capturedEdges.add(new Edges("pineapple", "pear", Colors.BLACK, 4, 0, 0, 0, 0));
        player.capturedEdges.add(new Edges("peach", "plum", Colors.BLACK, 4, 0, 0, 0, 0));
        player.capturedEdges.add(new Edges("banana", "orange", Colors.BLACK, 4, 0, 0, 0, 0));
        player.capturedEdges.add(new Edges("pear", "strawberry", Colors.BLACK, 4, 0, 0, 0, 0));
        player.capturedEdges.add(new Edges("apple", "pineapple", Colors.BLACK, 4, 0, 0, 0, 0));
        player.capturedEdges.add(new Edges("strawberry", "peach", Colors.BLACK, 4, 0, 0, 0, 0));
        player.capturedEdges.add(new Edges("orange", "cactus", Colors.BLACK, 4, 0, 0, 0, 0));
        
        ArrayList<Edges> edgy = new ArrayList<>();
        for (int i = 0; i < player.capturedEdges.size(); i++) {
            edgy.add(player.capturedEdges.get(i));
        }
        
        
        DestCard card = new DestCard(null, "apple", "cactus");
        
        System.out.println(card.destCardCompleted(edgy, card.getStart(), card.getEnd()));
    }
}
