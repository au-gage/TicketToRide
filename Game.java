package TicketToRide;

import java.util.ArrayList;
/**
 * determines who is playing and win conditions
 * Will also incorporate all the paths and prob captures
 * how many players
 * what color
 * what name
 * implements player, board, paths, and run the playing of the game
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    private ArrayList<Paths> paths = new ArrayList<>();
    
    /**
     * Adds all Path objects into an ArrayList
     * 
     */
    private void makePaths()
    {
        paths.add(new Paths("Lincoln Center","Central Park",Colors.ORANGE,2));
        paths.add(new Paths("Lincoln Center","Midtown West",Colors.RED,2));
        paths.add(new Paths("Lincoln Center","Times Square",Colors.GREEN,2));
        paths.add(new Paths("Lincoln Center","Times Square",Colors.BLUE,2));
        
        paths.add(new Paths("Central Park","Times Square",Colors.BLACK,2));
        paths.add(new Paths("Central Park","Times Square",Colors.RED,2));
        paths.add(new Paths("Central Park","United Nations",Colors.PINK,3));
        
        paths.add(new Paths("Midtown West","Chelsea",Colors.BLUE,2));
        paths.add(new Paths("Midtown West","Times Square",Colors.NONE,1));
        paths.add(new Paths("Midtown West","Empire State Building",Colors.GREEN,2));
        
        paths.add(new Paths("Times Square","Empire State Building",Colors.PINK,1));
        paths.add(new Paths("Times Square","Empire State Building",Colors.ORANGE,1));
        paths.add(new Paths("Times Square","United Nations",Colors.NONE,2));
        
        paths.add(new Paths("United Nations","Empire State Building",Colors.BLACK,2));
        paths.add(new Paths("United Nations","Gramercy Park",Colors.GREEN,3));
        
        paths.add(new Paths("Empire State Building", "Gramercy Park",Colors.RED,1));
        paths.add(new Paths("Empire State Building", "Gramercy Park",Colors.BLUE,1));
        
        paths.add(new Paths("Chelsea","Soho",Colors.PINK,4));
        paths.add(new Paths("Chelsea","Empire State Building",Colors.NONE,2));
        paths.add(new Paths("Chelsea","Empire State Building",Colors.NONE,2));
        paths.add(new Paths("Chelsea","Gramercy Park",Colors.ORANGE,2));
        paths.add(new Paths("Chelsea","Greenwich Village",Colors.GREEN,3));
        paths.add(new Paths("Chelsea","Greenwich Village",Colors.RED,3));
        
        paths.add(new Paths("Gramercy Park","Greenwich Village",Colors.BLACK,2));
        paths.add(new Paths("Gramercy Park","Greenwich Village",Colors.PINK,2));
        paths.add(new Paths("Gramercy Park","East Village",Colors.NONE,2));
        
        paths.add(new Paths("Greenwich Village","Soho",Colors.ORANGE,2));
        paths.add(new Paths("Greenwich Village","Chinatown",Colors.NONE,2));
        paths.add(new Paths("Greenwich Village","Chinatown",Colors.NONE,2));
        paths.add(new Paths("Greenwich Village","Lower East Side",Colors.NONE,2));
        paths.add(new Paths("Greenwich Village","East Village",Colors.BLUE,2));
        
        paths.add(new Paths("East Village","Lower East Side",Colors.BLACK,1));
        
        paths.add(new Paths("Lower East Side","Chinatown",Colors.BLUE,1));
        paths.add(new Paths("Lower East Side","Brooklyn",Colors.NONE,3));
        
        paths.add(new Paths("Soho","Wall Street",Colors.NONE,2));
        
        paths.add(new Paths("Chinatown","Wall Street",Colors.GREEN,1));
        paths.add(new Paths("Chinatown","Wall Street",Colors.PINK,1));
        paths.add(new Paths("Chinatown","Brooklyn",Colors.RED,3));
        paths.add(new Paths("Chinatown","Brooklyn",Colors.ORANGE,3));
        
        paths.add(new Paths("Wall Street","Brooklyn",Colors.BLUE,3));
        paths.add(new Paths("Wall Street","Brooklyn",Colors.BLACK,3));
    }
}
