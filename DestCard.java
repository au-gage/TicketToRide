
 



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
    public int destCardValues(DestCard card){
        int value = 0; 
        if(card.getImage().toString() == "CPtoC"){
            value = 5;
        }   
        else if(card.getImage().toString() == "CPtoCT"){
            value = 8;
        }
        else if(card.getImage().toString() == "CPtoGP"){
            value = 4;
        }
        else if(card.getImage().toString() == "CPtoMW"){
            value = 3;
        }
        else if(card.getImage().toString() == "CtoB"){
            value = 8;
        }
        else if(card.getImage().toString() == "CtoWS"){
            value = 8;
        }
        else if(card.getImage().toString() == "ESBtoB"){
            value = 6;
        }
        else if(card.getImage().toString() == "ESBtoGV"){
            value = 3;
        }
        else if(card.getImage().toString() == "EVtoS"){
            value = 4;
        }
        else if(card.getImage().toString() == "GPtoCT"){
            value = 4;
        }
        else if(card.getImage().toString() == "LCtoESB"){
            value = 3;
        }
        else if(card.getImage().toString() == "LCtoGV"){
            value = 6;
        }
        else if(card.getImage().toString() == "LEStoWS"){
            value = 2;
        }
        else if(card.getImage().toString() == "TStoB"){
            value = 8;
        }
        else if(card.getImage().toString() == "TStoEV"){
            value = 4;
        }
        else if(card.getImage().toString() == "TStoS"){
            value = 6;
        }
        else if(card.getImage().toString() == "UNtoMW"){
            value = 3;
        }
        else if(card.getImage().toString() == "UNtoWS"){
            value = 8;
        }

        return value;

    }

}
