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
        gui.setUndecorated(true);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Benjamin Burkholder's Board");
        gui.pack();
        // gui.setSize((int)( 162 * 11.81), (int)(91 * 11.81));
        gui.setSize(1920,1080);
        
        ShipDatabase game = new ShipDatabase();
        
        GameBoard GB = new GameBoard();
        GB.setVisible(true);
        
    }
}
