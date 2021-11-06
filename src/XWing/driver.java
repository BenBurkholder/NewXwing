package XWing;
/**
 * Write a description of class driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;

public class driver
{
   public static void main(String[] args) {
        XWingGUI gui = new XWingGUI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Benjamin Burkholder's Board");
        gui.pack();
        
        ShipDatabase game = new ShipDatabase();
        
        GameBoard GB = new GameBoard();
        GB.setVisible(true);
        
    }
}
