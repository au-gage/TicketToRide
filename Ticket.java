package TicketToRide;

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
 * Write a description of class Ticket here.
 *
 * @author Austin Gage
 * @version 4/23/2019
 */
public class Ticket
{
    private Image image;
    private Colors color;
    
    public Ticket(Image image, Colors color)
    {
        this.image = image;
        this.color = color;
    }
    
    public Image getImage()
    {
        return image;
    }
    
    public Colors color()
    {
        return color;
    }
    
    public void setImage(Image image)
    {
        this.image = image;
    }
}
