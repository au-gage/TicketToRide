
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
 * Needs more instance variables, start location, end location, point value
 * etc -Austin
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DestCard
{
    private Image image;
    
    public DestCard(Image image)
    {
        this.image = image;

    }

    public Image getImage()
    {
        return image;
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
            route.getIsCaptured("Chelsea", "Central Park")) && card.getImage().toString() == "CPtoC"){
            value = 5;
            return value;
        } 
        else if((!route.getIsCaptured("Central Park", "Chelsea") || !route.getIsCaptured("Chelsea", "Central Park")) && card.getImage().toString() == "CPtoC"){
            value = -5;
            return value;
        }
        
        if((route.getIsCaptured("Central Park", "Chinatown") || route.getIsCaptured("Chinatown", "Central Park")) && card.getImage().toString() == "CPtoCT"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Central Park", "Chinatown") || !route.getIsCaptured("Chinatown", "Central Park")) && card.getImage().toString() == "CPtoCT"){
            value = -8;
            return value;
        }
        
        if((route.getIsCaptured("Central Park", "Gramercy Park") || route.getIsCaptured("Gramercy Park", "Central Park")) && card.getImage().toString() == "CPtoGP"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("Central Park", "Gramercy Park") || !route.getIsCaptured("Gramercy Park", "Central Park")) && card.getImage().toString() ==
        "CPtoGP"){
            value = -4;
            return value;
        }
        
        if((route.getIsCaptured("Central Park", "Midtown West") || route.getIsCaptured("Midtown West", "Central Park"))  && card.getImage().toString() == "CPtoMW"){
            value = 3;
            return value;
        }
        else if((!route.getIsCaptured("Central Park", "Midtown West") || !route.getIsCaptured("Midtown West", "Central Park")) && card.getImage().toString() ==
        "CPtoMW"){
            value = -3;
            return value;
        }
        
        if((route.getIsCaptured("Chelsea", "Brooklyn") || route.getIsCaptured("Brooklyn", "Chelsea"))  && card.getImage().toString() == "CtoB"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Chelsea", "Brooklyn") || !route.getIsCaptured("Brooklyn", "Chelsea")) && card.getImage().toString() == "CtoB"){
            value = -8;
            return value;
        }
        
        if((route.getIsCaptured("Chelsea", "Wall Street") || route.getIsCaptured("Wall Street", "Chelsea")) && card.getImage().toString() == "CtoWS"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Chelsea", "Wall Street") || route.getIsCaptured("Wall Street", "Chelsea")) && card.getImage().toString() == "CtoWS"){
            value = -8;
            return value;
        }
        
        if((route.getIsCaptured("Empire State Building", "Brooklyn") || route.getIsCaptured("Brooklyn", "Empire State Building")) && card.getImage().toString() == 
        "ESBtoB"){
            value = 6;
            return value;
        }
        else if((!route.getIsCaptured("Empire State Building", "Brooklyn") || !route.getIsCaptured("Brooklyn", "Empire State Building")) 
        && card.getImage().toString() == "ESBtoB"){
            value = -6;
            return value;
        }
        
        if((route.getIsCaptured("Empire State Building", "Greenwich Village") || route.getIsCaptured("Greenwich Village", "Empire State Building")) && 
        card.getImage().toString() == "ESBtoGV"){
            value = 3;
            return value;
        }
        else if((!route.getIsCaptured("Empire State Building", "Greenwich Village") || !route.getIsCaptured("Greenwich Village", "Empire State Building")) && 
        card.getImage().toString() == "ESBtoGV"){
            value = -3;
            return value;
        }
        
        if((route.getIsCaptured("East Village", "Soho") || route.getIsCaptured("Soho", "East Village")) && card.getImage().toString() == "EVtoS"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("East Village", "Soho") || !route.getIsCaptured("Soho", "East Village")) && card.getImage().toString() == "EVtoS"){
            value = -4;
            return value;
        }
       
        if((route.getIsCaptured("Gramercy Park", "Chinatown") || route.getIsCaptured("Chinatown", "Gramercy Park")) && card.getImage().toString() == "GPtoCT"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("Gramercy Park", "Chinatown") || !route.getIsCaptured("Chinatown", "Gramercy Park")) && card.getImage().toString() 
        == "GPtoCT"){
            value = -4;
            return value;
        }
        
        if((route.getIsCaptured("Lincoln Center", "Empire State Building") || route.getIsCaptured("Empire State Building", "Lincoln Center")) 
        && card.getImage().toString() == "LCtoESB"){
            value = 3;
            return value;
        }
        else if ((!route.getIsCaptured("Lincoln Center", "Empire State Building") || !route.getIsCaptured("Empire State Building", "Lincoln Center")) 
        && card.getImage().toString() == "LCtoESB"){
            value = -3;
            return value;
        }
        
        if((route.getIsCaptured("Lincoln Center", "Greenwich Village") || route.getIsCaptured("Greenwich Village", "Lincoln Center")) 
        && card.getImage().toString() == "LCtoGV"){
            value = 6;
            return value;
        }
        else if((!route.getIsCaptured("Lincoln Center", "Greenwich Village") || !route.getIsCaptured("Greenwich Village", "Lincoln Center")) 
        && card.getImage().toString() == "LCtoGV"){
            value = -6;
            return value;
        }
        
        if((route.getIsCaptured("Lower East Side", "Wall Street") || route.getIsCaptured("Wall Street", "Lower East Side")) 
        && card.getImage().toString() == "LEStoWS"){
            value = 2;
            return value;
        }
        else if((!route.getIsCaptured("Lower East Side", "Wall Street") || !route.getIsCaptured("Wall Street", "Lower East Side"))
        && card.getImage().toString() == "LEStoWS"){
            value = -2;
            return value;
        }
        
        if((route.getIsCaptured("Times Square", "Brooklyn") || route.getIsCaptured("Brooklyn", "Times Square")) 
        && card.getImage().toString() == "TStoB"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("Times Square", "Brooklyn") || !route.getIsCaptured("Brooklyn", "Times Square")) && card.getImage().toString() == "TStoB"){
            value = -8;
            return value;
        }
        
        if((route.getIsCaptured("Times Square", "East Village") || route.getIsCaptured("East Village", "Times Square"))
        && card.getImage().toString() == "TStoEV"){
            value = 4;
            return value;
        }
        else if((!route.getIsCaptured("Times Square", "East Village") || !route.getIsCaptured("East Village", "Times Square")) 
        && card.getImage().toString() == "TStoEV"){
            value = -4;
            return value;
        }
        
        if((route.getIsCaptured("Times Square", "Soho") || route.getIsCaptured("Soho", "Times Square")) && card.getImage().toString() == "TStoS"){
            value = 6;
            return value;
        }
        else if((!route.getIsCaptured("Times Square", "Soho") || !route.getIsCaptured("Soho", "Times Square")) && card.getImage().toString() == "TStoS"){
            value = -6;
            return value;
        }
        
        if((route.getIsCaptured("United Nations", "Midtown West") || route.getIsCaptured("Midtown West", "United Nations")) && card.getImage().toString() == "UNtoMW"
        ){
            value = 3;
            return value;
        }
        else if((!route.getIsCaptured("United Nations", "Midtown West") || !route.getIsCaptured("Midtown West", "United Nations")) && card.getImage().toString() == 
        "UNtoMW"){
            value = -3;
            return value;
        }
        
        if((route.getIsCaptured("United Nations", "Wall Street") || route.getIsCaptured("Wall Street", "United Nations")) && card.getImage().toString() == "UNtoWS"){
            value = 8;
            return value;
        }
        else if((!route.getIsCaptured("United Nations", "Wall Street") || !route.getIsCaptured("Wall Street", "United Nations")) && card.getImage().toString() == 
        "UNtoWS"){
            value = -8;
            return value;
        }      

        return value;
    }
    

    public boolean destCardCompleted(Path route, DestCard card){
        
        
        return false;
    }
}
