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
 * Write a description of class DestCard here.
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

}
