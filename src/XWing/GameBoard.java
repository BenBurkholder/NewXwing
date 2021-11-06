package XWing;
/**
 * Write a description of class GameBoard here.
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
import java.awt.event.*;
import java.awt.geom.*;

public class GameBoard extends JPanel
{
    // instance variables - replace the example below with your own
    private final double CM = 13.5;
    //11.81
    ArrayList<ShipObject> currentBoard = new ArrayList<ShipObject>();
    ArrayList<coor> CL;
    int turn = 0;
    boolean arcVis = false;
    int x = 5;
    int y = 5;

    public boolean bullseye;
    public boolean turret;

    public void bullseyeToggle(){
        if(bullseye)
            bullseye = false;
        else
            bullseye = true;
    }

    public void turretToggle(){
        if(turret)
            turret = false;
        else
            turret = true;
    }
    public boolean getBullseye(){
        return bullseye;
    }
    public boolean getTurret(){
        return turret;
    }
    
    // private ShipDatabase SL = new ShipDatabase();
    // private int y = (int) SL.getY(1);

    public static void main(String[] args) {
        JFrame f = new JFrame();
        GameBoard l_game = new GameBoard();
        f.setContentPane(l_game);
        f.setSize((int)(91 * 7), (int)(91 * 7));
        f.setVisible(true);    
        l_game.currentBoard = new ArrayList <ShipObject>();
        ShipObject sample = new ShipObject("Sample", 12.0, 10.0, 180.0, 0 , 1);
        l_game.currentBoard.add(sample);
        sample = new ShipObject("X-Wing", 15.5, 5.0, 0.0, 0 , 0);
        l_game.currentBoard.add(sample);
        ArrayList<coor> CL = new ArrayList <coor>();
        
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *
     * @return    the sum of x and y
     */
    public void paintComponent(Graphics g)    
    {
        
        super.paintComponent(g);
        
        setBackground(Color.BLACK);
        Image image = new ImageIcon("images/Stars2.jpg").getImage();
        g.drawImage(image, 0, 0, this);
        
        // if(currentBoard.size() > 0) {
            // for(ShipObject ship : currentBoard) {
                // if(ship.getBase() == 4 && ship.getTeam() == 0) {
                    // // Graphics2D g2d = (Graphics2D)g;
                    // // g2d.setColor(Color.RED);
                    // // Rectangle ("rect" +i) = new Rectangle ((int)((ship.getXLoc() - 2)* CM), 
                     // // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
                     // // g2d.rotate(Math.toRadians(ship.getBearing()));
                     // // g2d.draw(rect2);
                     // // g2d.fill(rect2);
                     
                    // g.setColor(Color.RED);
                    // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                    // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
                    
                // }
                // if(ship.getBase() == 8 && ship.getTeam() == 0) {
                    // g.setColor(Color.RED);
                    // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                    // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
                // }
                // if(ship.getBase() == 4 && ship.getTeam() == 1) {
                    // g.setColor(Color.BLUE);
                    // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                    // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
                // }
                // if(ship.getBase() == 8 && ship.getTeam() == 1) {
                    // g.setColor(Color.BLUE);
                    // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                    // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
                // }
            // }
        // }
        if(currentBoard.size() > 0) {
            if(arcVis == true) {
                ShipObject fireShip = currentBoard.get(turn);
                int l_ydist = 1025;
                double smallBaseArc3 = 60 + (4 * 1.414);
                double largeBaseArc3 = 60 + (8 * 1.414);
                double smallBaseArc2 = 40 + (4 * 1.414);
                double largeBaseArc2 = 40 + (8 * 1.414);
                double smallBaseArc1 = 20 + (4 * 1.414);
                double largeBaseArc1 = 20 + (8 * 1.414);

                double l_b = fireShip.getBearing();
                double l_x = fireShip.getXLoc() * CM;
                double l_y = fireShip.getYLoc() * CM;
                int l_x1 = (int) (fireShip.getCorner1X() * CM);
                int l_x2 = (int) (fireShip.getCorner2X() * CM);
                int l_x3 = (int) (fireShip.getCorner3X() * CM);
                int l_x4 = (int) (fireShip.getCorner4X() * CM);
                int l_y1 = (int) (fireShip.getCorner1Y() * CM);
                int l_y2 = (int) (fireShip.getCorner2Y() * CM);
                int l_y3 = (int) (fireShip.getCorner3Y() * CM);
                int l_y4 = (int) (fireShip.getCorner4Y() * CM);

//                corner1X = xLoc - halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
//                corner1Y = yLoc + halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
//                corner2X = xLoc + halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
//                corner2Y = yLoc - halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
//                corner3X = xLoc + halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
//                corner3Y = yLoc - halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));
//                corner4X = xLoc - halfBase * Math.cos(d2R(bearing)) - halfBase * Math.sin(d2R(bearing));
//                corner4Y = yLoc + halfBase * Math.sin(d2R(bearing)) - halfBase * Math.cos(d2R(bearing));

                if (fireShip.getBase() == 4) {
                    g.setColor(Color.GREEN);
//                    g.drawOval((int) ((fireShip.getXLoc() - (smallBaseArc3 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + smallBaseArc3 * .5) * CM),
//                            (int) (smallBaseArc3 * CM), (int) (smallBaseArc3 * CM));
                    g.drawArc((int)(l_x1-(30 * CM)), (int)(l_ydist - l_y1 - (30 * CM)), (int)(60 * CM), (int)(60 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-30*CM),(int)(l_ydist - l_y2 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-30*CM),(int)(l_ydist - l_y3 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-30*CM),(int)(l_ydist - l_y4 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 2 * Math.cos(d2R(fireShip.getBearing())) + 32 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 2 * Math.sin(d2R(fireShip.getBearing())) + 32 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 2 * Math.cos(d2R(fireShip.getBearing())) + 32 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 2 * Math.sin(d2R(fireShip.getBearing())) + 32 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 32 * Math.cos(d2R(fireShip.getBearing())) + 2 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 32 * Math.sin(d2R(fireShip.getBearing())) + 2 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 32 * Math.cos(d2R(fireShip.getBearing())) - 2 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 32 * Math.sin(d2R(fireShip.getBearing())) - 2 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 2 * Math.cos(d2R(fireShip.getBearing())) - 32 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 2 * Math.sin(d2R(fireShip.getBearing())) - 32 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 2 * Math.cos(d2R(fireShip.getBearing())) - 32 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 2 * Math.sin(d2R(fireShip.getBearing())) - 32 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 32 * Math.cos(d2R(fireShip.getBearing())) - 2 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 32 * Math.sin(d2R(fireShip.getBearing())) - 2 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 32 * Math.cos(d2R(fireShip.getBearing())) + 2 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 32 * Math.sin(d2R(fireShip.getBearing())) + 2 * Math.cos(d2R(fireShip.getBearing())))*CM)));


                    g.setColor(Color.YELLOW);
//                    g.drawOval((int) ((fireShip.getXLoc() - (smallBaseArc2 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + smallBaseArc2 * .5) * CM),
//                            (int) (smallBaseArc2 * CM), (int) (smallBaseArc2 * CM));
                    g.drawArc((int)(l_x1-(20 * CM)), (int)(l_ydist - l_y1 - (20 * CM)), (int)(40 * CM), (int)(40 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-20*CM),(int)(l_ydist - l_y2 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-20*CM),(int)(l_ydist - l_y3 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-20*CM),(int)(l_ydist - l_y4 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 2 * Math.cos(d2R(fireShip.getBearing())) + 22 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 2 * Math.sin(d2R(fireShip.getBearing())) + 22 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 2 * Math.cos(d2R(fireShip.getBearing())) + 22 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 2 * Math.sin(d2R(fireShip.getBearing())) + 22 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 22 * Math.cos(d2R(fireShip.getBearing())) + 2 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 22 * Math.sin(d2R(fireShip.getBearing())) + 2 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 22 * Math.cos(d2R(fireShip.getBearing())) - 2 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 22 * Math.sin(d2R(fireShip.getBearing())) - 2 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 2 * Math.cos(d2R(fireShip.getBearing())) - 22 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 2 * Math.sin(d2R(fireShip.getBearing())) - 22 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 2 * Math.cos(d2R(fireShip.getBearing())) - 22 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 2 * Math.sin(d2R(fireShip.getBearing())) - 22 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 22 * Math.cos(d2R(fireShip.getBearing())) - 2 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 22 * Math.sin(d2R(fireShip.getBearing())) - 2 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 22 * Math.cos(d2R(fireShip.getBearing())) + 2 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 22 * Math.sin(d2R(fireShip.getBearing())) + 2 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.setColor(Color.RED);
//                    g.drawOval((int) ((fireShip.getXLoc() - (smallBaseArc1 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + smallBaseArc1 * .5) * CM),
//                            (int) (smallBaseArc1 * CM), (int) (smallBaseArc1 * CM));
                    g.drawArc((int)(l_x1-(10 * CM)), (int)(l_ydist - l_y1 - (10 * CM)), (int)(20 * CM), (int)(20 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-10*CM),(int)(l_ydist - l_y2 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-10*CM),(int)(l_ydist - l_y3 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-10*CM),(int)(l_ydist - l_y4 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 2 * Math.cos(d2R(fireShip.getBearing())) + 12 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 2 * Math.sin(d2R(fireShip.getBearing())) + 12 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 2 * Math.cos(d2R(fireShip.getBearing())) + 12 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 2 * Math.sin(d2R(fireShip.getBearing())) + 12 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 12 * Math.cos(d2R(fireShip.getBearing())) + 2 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 12 * Math.sin(d2R(fireShip.getBearing())) + 2 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 12 * Math.cos(d2R(fireShip.getBearing())) - 2 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 12 * Math.sin(d2R(fireShip.getBearing())) - 2 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 2 * Math.cos(d2R(fireShip.getBearing())) - 12 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 2 * Math.sin(d2R(fireShip.getBearing())) - 12 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 2 * Math.cos(d2R(fireShip.getBearing())) - 12 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 2 * Math.sin(d2R(fireShip.getBearing())) - 12 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 12 * Math.cos(d2R(fireShip.getBearing())) - 2 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 12 * Math.sin(d2R(fireShip.getBearing())) - 2 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 12 * Math.cos(d2R(fireShip.getBearing())) + 2 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 12 * Math.sin(d2R(fireShip.getBearing())) + 2 * Math.cos(d2R(fireShip.getBearing())))*CM)));

                    g.drawLine(l_x1,l_ydist -l_y1,(int)(l_x1 - (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int)(l_ydist - (l_y1 + (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                    g.drawLine(l_x2,l_ydist -l_y2,(int)(l_x2 + (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int)(l_ydist - (l_y2 - (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));

                    if(turret) {
                        g.drawLine(l_x4, l_ydist - l_y4, (int) (l_x4 - (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int) (l_ydist - (l_y4 + (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                        g.drawLine(l_x3, l_ydist - l_y3, (int) (l_x3 + (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int) (l_ydist - (l_y3 - (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                    }

                    if(bullseye) {
                        g.drawLine((int) (l_x - (.75 * CM) * Math.cos(d2R(l_b)) + (2 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (.75 * CM) * Math.sin(d2R(l_b)) + (2 * CM) * Math.cos(d2R(l_b)))),
                                (int) (l_x - (.75 * CM) * Math.cos(d2R(l_b)) + (32 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (.75 * CM) * Math.sin(d2R(l_b)) + (32 * CM) * Math.cos(d2R(l_b)))));
                        g.drawLine((int) (l_x - (-.75 * CM) * Math.cos(d2R(l_b)) + (2 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (-.75 * CM) * Math.sin(d2R(l_b)) + (2 * CM) * Math.cos(d2R(l_b)))),
                                (int) (l_x - (-.75 * CM) * Math.cos(d2R(l_b)) + (32 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (-.75 * CM) * Math.sin(d2R(l_b)) + (32 * CM) * Math.cos(d2R(l_b)))));
                    }
                }


//                corner1X = xLoc - halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
//                corner1Y = yLoc + halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));
//                corner2X = xLoc + halfBase * Math.cos(d2R(bearing)) + halfBase * Math.sin(d2R(bearing));
//                corner2Y = yLoc - halfBase * Math.sin(d2R(bearing)) + halfBase * Math.cos(d2R(bearing));




                if (fireShip.getBase() == 6) {
                    g.setColor(Color.GREEN);
//                    g.drawOval((int) ((fireShip.getXLoc() - (largeBaseArc3 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + largeBaseArc3 * .5) * CM),
//                            (int) (largeBaseArc3 * CM), (int) (largeBaseArc3 * CM));
                    g.drawArc((int)(l_x1-(30 * CM)), (int)(l_ydist - l_y1 - (30 * CM)), (int)(60 * CM), (int)(60 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-30*CM),(int)(l_ydist - l_y2 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-30*CM),(int)(l_ydist - l_y3 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-30*CM),(int)(l_ydist - l_y4 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 3 * Math.cos(d2R(fireShip.getBearing())) + 33 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 3 * Math.sin(d2R(fireShip.getBearing())) + 33 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 3 * Math.cos(d2R(fireShip.getBearing())) + 33 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 3 * Math.sin(d2R(fireShip.getBearing())) + 33 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 33 * Math.cos(d2R(fireShip.getBearing())) + 3 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 33 * Math.sin(d2R(fireShip.getBearing())) + 3 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 33 * Math.cos(d2R(fireShip.getBearing())) - 3 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 33 * Math.sin(d2R(fireShip.getBearing())) - 3 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 3 * Math.cos(d2R(fireShip.getBearing())) - 33 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 3 * Math.sin(d2R(fireShip.getBearing())) - 33 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 3 * Math.cos(d2R(fireShip.getBearing())) - 33 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 3 * Math.sin(d2R(fireShip.getBearing())) - 33 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 33 * Math.cos(d2R(fireShip.getBearing())) - 3 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 33 * Math.sin(d2R(fireShip.getBearing())) - 3 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 33 * Math.cos(d2R(fireShip.getBearing())) + 3 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 33 * Math.sin(d2R(fireShip.getBearing())) + 3 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.setColor(Color.YELLOW);
//                    g.drawOval((int) ((fireShip.getXLoc() - (largeBaseArc2 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + largeBaseArc2 * .5) * CM),
//                            (int) (largeBaseArc2 * CM), (int) (largeBaseArc2 * CM));
                    g.drawArc((int)(l_x1-(20 * CM)), (int)(l_ydist - l_y1 - (20 * CM)), (int)(40 * CM), (int)(40 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-20*CM),(int)(l_ydist - l_y2 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-20*CM),(int)(l_ydist - l_y3 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-20*CM),(int)(l_ydist - l_y4 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 3 * Math.cos(d2R(fireShip.getBearing())) + 23 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 3 * Math.sin(d2R(fireShip.getBearing())) + 23 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 3 * Math.cos(d2R(fireShip.getBearing())) + 23 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 3 * Math.sin(d2R(fireShip.getBearing())) + 23 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 23 * Math.cos(d2R(fireShip.getBearing())) + 3 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 23 * Math.sin(d2R(fireShip.getBearing())) + 3 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 23 * Math.cos(d2R(fireShip.getBearing())) - 3 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 23 * Math.sin(d2R(fireShip.getBearing())) - 3 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 3 * Math.cos(d2R(fireShip.getBearing())) - 23 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 3 * Math.sin(d2R(fireShip.getBearing())) - 23 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 3 * Math.cos(d2R(fireShip.getBearing())) - 23 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 3 * Math.sin(d2R(fireShip.getBearing())) - 23 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 23 * Math.cos(d2R(fireShip.getBearing())) - 3 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 23 * Math.sin(d2R(fireShip.getBearing())) - 3 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 23 * Math.cos(d2R(fireShip.getBearing())) + 3 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 23 * Math.sin(d2R(fireShip.getBearing())) + 3 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.setColor(Color.RED);
//                    g.drawOval((int) ((fireShip.getXLoc() - (largeBaseArc1 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + largeBaseArc1 * .5) * CM),
//                            (int) (largeBaseArc1 * CM), (int) (largeBaseArc1 * CM));
                    g.drawArc((int)(l_x1-(10 * CM)), (int)(l_ydist - l_y1 - (10 * CM)), (int)(20 * CM), (int)(20 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-10*CM),(int)(l_ydist - l_y2 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-10*CM),(int)(l_ydist - l_y3 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-10*CM),(int)(l_ydist - l_y4 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 3 * Math.cos(d2R(fireShip.getBearing())) + 13 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 3 * Math.sin(d2R(fireShip.getBearing())) + 13 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 3 * Math.cos(d2R(fireShip.getBearing())) + 13 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 3 * Math.sin(d2R(fireShip.getBearing())) + 13 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 13 * Math.cos(d2R(fireShip.getBearing())) + 3 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 13 * Math.sin(d2R(fireShip.getBearing())) + 3 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 13 * Math.cos(d2R(fireShip.getBearing())) - 3 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 13 * Math.sin(d2R(fireShip.getBearing())) - 3 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 3 * Math.cos(d2R(fireShip.getBearing())) - 13 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 3 * Math.sin(d2R(fireShip.getBearing())) - 13 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 3* Math.cos(d2R(fireShip.getBearing())) - 13 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 3 * Math.sin(d2R(fireShip.getBearing())) - 13 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 13 * Math.cos(d2R(fireShip.getBearing())) - 3 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 13 * Math.sin(d2R(fireShip.getBearing())) - 3 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 13 * Math.cos(d2R(fireShip.getBearing())) + 3 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 13 * Math.sin(d2R(fireShip.getBearing())) + 3 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine(l_x1,l_ydist -l_y1,(int)(l_x1 - (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int)(l_ydist - (l_y1 + (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                    g.drawLine(l_x2,l_ydist -l_y2,(int)(l_x2 + (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int)(l_ydist - (l_y2 - (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
//                    g.drawLine((int) (fireShip.getXLoc() * CM),(int)  ((l_ydist - fireShip.getYLoc() * CM)), (int)((fireShip.getXLoc()) * CM), (int)((l_ydist - (fireShip.getYLoc() -34) *CM)));


                    if(turret) {
                        g.drawLine(l_x4, l_ydist - l_y4, (int) (l_x4 - (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int) (l_ydist - (l_y4 + (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                        g.drawLine(l_x3, l_ydist - l_y3, (int) (l_x3 + (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int) (l_ydist - (l_y3 - (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                    }

                    if(bullseye) {
                        g.drawLine((int) (l_x - (.75 * CM) * Math.cos(d2R(l_b)) + (3 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (.75 * CM) * Math.sin(d2R(l_b)) + (3 * CM) * Math.cos(d2R(l_b)))),
                                (int) (l_x - (.75 * CM) * Math.cos(d2R(l_b)) + (33 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (.75 * CM) * Math.sin(d2R(l_b)) + (33 * CM) * Math.cos(d2R(l_b)))));
                        g.drawLine((int) (l_x - (-.75 * CM) * Math.cos(d2R(l_b)) + (3 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (-.75 * CM) * Math.sin(d2R(l_b)) + (3 * CM) * Math.cos(d2R(l_b)))),
                                (int) (l_x - (-.75 * CM) * Math.cos(d2R(l_b)) + (33 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (-.75 * CM) * Math.sin(d2R(l_b)) + (33 * CM) * Math.cos(d2R(l_b)))));
                    }
                }

                if (fireShip.getBase() == 8) {
                    g.setColor(Color.GREEN);
//                    g.drawOval((int) ((fireShip.getXLoc() - (largeBaseArc3 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + largeBaseArc3 * .5) * CM),
//                            (int) (largeBaseArc3 * CM), (int) (largeBaseArc3 * CM));
                    g.drawArc((int)(l_x1-(30 * CM)), (int)(l_ydist - l_y1 - (30 * CM)), (int)(60 * CM), (int)(60 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-30*CM),(int)(l_ydist - l_y2 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-30*CM),(int)(l_ydist - l_y3 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-30*CM),(int)(l_ydist - l_y4 - (30*CM)), (int)(60 * CM), (int)(60 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 4 * Math.cos(d2R(fireShip.getBearing())) + 34 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 4 * Math.sin(d2R(fireShip.getBearing())) + 34 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 4 * Math.cos(d2R(fireShip.getBearing())) + 34 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 4 * Math.sin(d2R(fireShip.getBearing())) + 34 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 34 * Math.cos(d2R(fireShip.getBearing())) + 4 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 34 * Math.sin(d2R(fireShip.getBearing())) + 4 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 34 * Math.cos(d2R(fireShip.getBearing())) - 4 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 34 * Math.sin(d2R(fireShip.getBearing())) - 4 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 4 * Math.cos(d2R(fireShip.getBearing())) - 34 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 4 * Math.sin(d2R(fireShip.getBearing())) - 34 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 4 * Math.cos(d2R(fireShip.getBearing())) - 34 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 4 * Math.sin(d2R(fireShip.getBearing())) - 34 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 34 * Math.cos(d2R(fireShip.getBearing())) - 4 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 34 * Math.sin(d2R(fireShip.getBearing())) - 4 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 34 * Math.cos(d2R(fireShip.getBearing())) + 4 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 34 * Math.sin(d2R(fireShip.getBearing())) + 4 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.setColor(Color.YELLOW);
//                    g.drawOval((int) ((fireShip.getXLoc() - (largeBaseArc2 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + largeBaseArc2 * .5) * CM),
//                            (int) (largeBaseArc2 * CM), (int) (largeBaseArc2 * CM));
                    g.drawArc((int)(l_x1-(20 * CM)), (int)(l_ydist - l_y1 - (20 * CM)), (int)(40 * CM), (int)(40 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-20*CM),(int)(l_ydist - l_y2 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-20*CM),(int)(l_ydist - l_y3 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-20*CM),(int)(l_ydist - l_y4 - (20*CM)), (int)(40 * CM), (int)(40 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 4 * Math.cos(d2R(fireShip.getBearing())) + 24 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 4 * Math.sin(d2R(fireShip.getBearing())) + 24 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 4 * Math.cos(d2R(fireShip.getBearing())) + 24 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 4 * Math.sin(d2R(fireShip.getBearing())) + 24 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 24 * Math.cos(d2R(fireShip.getBearing())) + 4 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 24 * Math.sin(d2R(fireShip.getBearing())) + 4 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 24 * Math.cos(d2R(fireShip.getBearing())) - 4 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 24 * Math.sin(d2R(fireShip.getBearing())) - 4 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 4 * Math.cos(d2R(fireShip.getBearing())) - 24 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 4 * Math.sin(d2R(fireShip.getBearing())) - 24 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 4 * Math.cos(d2R(fireShip.getBearing())) - 24 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 4 * Math.sin(d2R(fireShip.getBearing())) - 24 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 24 * Math.cos(d2R(fireShip.getBearing())) - 4 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 24 * Math.sin(d2R(fireShip.getBearing())) - 4 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 24 * Math.cos(d2R(fireShip.getBearing())) + 4 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 24 * Math.sin(d2R(fireShip.getBearing())) + 4 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.setColor(Color.RED);
//                    g.drawOval((int) ((fireShip.getXLoc() - (largeBaseArc1 * .5)) * CM),
//                            (int) (l_ydist - (fireShip.getYLoc() + largeBaseArc1 * .5) * CM),
//                            (int) (largeBaseArc1 * CM), (int) (largeBaseArc1 * CM));
                    g.drawArc((int)(l_x1-(10 * CM)), (int)(l_ydist - l_y1 - (10 * CM)), (int)(20 * CM), (int)(20 * CM), (int)((90.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x2-10*CM),(int)(l_ydist - l_y2 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((0.0 - fireShip.getBearing())-1), 92);
                    g.drawArc((int)(l_x3-10*CM),(int)(l_ydist - l_y3 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((270.0 - fireShip.getBearing()-1)), 92);
                    g.drawArc((int)(l_x4-10*CM),(int)(l_ydist - l_y4 - (10*CM)), (int)(20 * CM), (int)(20 * CM), (int)((180.0 - fireShip.getBearing())-1), 92);
                    g.drawLine((int)((fireShip.getXLoc() - 4 * Math.cos(d2R(fireShip.getBearing())) + 14 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 4 * Math.sin(d2R(fireShip.getBearing())) + 14 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 4 * Math.cos(d2R(fireShip.getBearing())) + 14 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 4 * Math.sin(d2R(fireShip.getBearing())) + 14 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 14 * Math.cos(d2R(fireShip.getBearing())) + 4 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 14 * Math.sin(d2R(fireShip.getBearing())) + 4 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() + 14 * Math.cos(d2R(fireShip.getBearing())) - 4 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() - 14 * Math.sin(d2R(fireShip.getBearing())) - 4 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() + 4 * Math.cos(d2R(fireShip.getBearing())) - 14 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() - 4 * Math.sin(d2R(fireShip.getBearing())) - 14 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 4 * Math.cos(d2R(fireShip.getBearing())) - 14 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 4 * Math.sin(d2R(fireShip.getBearing())) - 14 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine((int)((fireShip.getXLoc() - 14 * Math.cos(d2R(fireShip.getBearing())) - 4 * Math.sin(d2R(fireShip.getBearing()))) * CM),
                            (int)(l_ydist - ((fireShip.getYLoc() + 14 * Math.sin(d2R(fireShip.getBearing())) - 4 * Math.cos(d2R(fireShip.getBearing())))*CM)),
                            (int)((fireShip.getXLoc() - 14 * Math.cos(d2R(fireShip.getBearing())) + 4 * Math.sin(d2R(fireShip.getBearing())))*CM),
                            (int)(l_ydist-((fireShip.getYLoc() + 14 * Math.sin(d2R(fireShip.getBearing())) + 4 * Math.cos(d2R(fireShip.getBearing())))*CM)));
                    g.drawLine(l_x1,l_ydist -l_y1,(int)(l_x1 - (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int)(l_ydist - (l_y1 + (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                    g.drawLine(l_x2,l_ydist -l_y2,(int)(l_x2 + (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int)(l_ydist - (l_y2 - (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) +
                            (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
//                    g.drawLine((int) (fireShip.getXLoc() * CM),(int)  ((l_ydist - fireShip.getYLoc() * CM)), (int)((fireShip.getXLoc()) * CM), (int)((l_ydist - (fireShip.getYLoc() -34) *CM)));


                    if(turret) {
                        g.drawLine(l_x4, l_ydist - l_y4, (int) (l_x4 - (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int) (l_ydist - (l_y4 + (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                        g.drawLine(l_x3, l_ydist - l_y3, (int) (l_x3 + (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing()))), (int) (l_ydist - (l_y3 - (30 / Math.sqrt(2)) * CM * Math.sin(d2R(fireShip.getBearing())) -
                                (30 / Math.sqrt(2)) * CM * Math.cos(d2R(fireShip.getBearing())))));
                    }

                    if(bullseye) {
                        g.drawLine((int) (l_x - (.75 * CM) * Math.cos(d2R(l_b)) + (4 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (.75 * CM) * Math.sin(d2R(l_b)) + (4 * CM) * Math.cos(d2R(l_b)))),
                                (int) (l_x - (.75 * CM) * Math.cos(d2R(l_b)) + (34 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (.75 * CM) * Math.sin(d2R(l_b)) + (34 * CM) * Math.cos(d2R(l_b)))));
                        g.drawLine((int) (l_x - (-.75 * CM) * Math.cos(d2R(l_b)) + (4 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (-.75 * CM) * Math.sin(d2R(l_b)) + (4 * CM) * Math.cos(d2R(l_b)))),
                                (int) (l_x - (-.75 * CM) * Math.cos(d2R(l_b)) + (34 * CM) * Math.sin(d2R(l_b))),
                                (int) (l_ydist - (l_y + (-.75 * CM) * Math.sin(d2R(l_b)) + (34 * CM) * Math.cos(d2R(l_b)))));
                    }
                }


            }



        if(currentBoard.size() > 0) {
            for(ShipObject ship : currentBoard) {
                if(ship.getTeam() == 0) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLUE);
                }
                int l_x1 = (int) (ship.getCorner1X() * CM);
                int l_x2 = (int) (ship.getCorner2X() * CM);
                int l_x3 = (int) (ship.getCorner3X() * CM);
                int l_x4 = (int) (ship.getCorner4X() * CM);
                int l_y1 = (int) (ship.getCorner1Y() * CM);
                int l_y2 = (int) (ship.getCorner2Y() * CM);
                int l_y3 = (int) (ship.getCorner3Y() * CM);
                int l_y4 = (int) (ship.getCorner4Y() * CM);
                int l_xc = (int) (ship.getXLoc() * CM);
                int l_yc = (int) (ship.getYLoc() * CM);
                int l_ydist = 1025;  //637
//                g.fillOval(l_xc - 5, l_ydist -l_yc + 5, 10, 10);
//                g.fillOval(l_x1 - 5, l_ydist - l_y1 + 5, 10, 10);
//                g.fillOval(l_x2 - 5, l_ydist - l_y2 + 5, 10, 10);
//                g.fillOval(l_x3 - 5, l_ydist - l_y3 + 5, 10, 10);
//                g.fillOval(l_x4 - 5, l_ydist - l_y4 + 5, 10, 10);
                g.drawLine(l_x1, l_ydist - l_y1, l_x2, l_ydist - l_y2);
                g.drawLine(l_x2, l_ydist - l_y2, l_x3, l_ydist - l_y3);
                g.drawLine(l_x3, l_ydist - l_y3, l_x4, l_ydist - l_y4);
                g.drawLine(l_x4, l_ydist - l_y4, l_x1, l_ydist - l_y1);
                g.drawLine(l_x1, l_ydist - l_y1, l_xc, l_ydist - l_yc);
                g.drawLine(l_x2, l_ydist - l_y2, l_xc, l_ydist - l_yc);


            }
        }


        }
                    
        // for(int i = 0; i < game.listLength(); i++) {
            // g.setColor(Color.RED);
            // g.fillRect((int)((game.getX() - 2) * CM),
            // (int)((game.getY() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
        // }
        
        // x = x+2;
        // y = y +2;
        
        // g.setColor(Color.RED);
        // g.fillRect((int)((x - 2)* CM), 
                // (int)((y + 2) * CM), (int)(4 * CM), (int)(4 * CM));
        // g.fillRect((int)(List.get(0).getXLoc() * CM), 
            // (int)(List.get(0).getYLoc() * CM), (int)(4 * CM), (int)(4 * CM));
        
        
            
            
    }
    public void drawMap(ArrayList<ShipObject> curMap, int sentTurn, boolean vis)
    {
        currentBoard = curMap;
        turn = sentTurn;
        arcVis = vis;
        repaint();   
    }
    // public void paintShips(ArrayList<ShipObject> list)
    // {
        // super.paintComponent(g);
        
        
        // for(ShipObject ship : list) {
            // if(ship.getSize() == 0 && ship.getTeam() == 0) {
                // g.setColor(Color.RED);
                // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
            // }
            // if(ship.getSize() == 1 && ship.getTeam() == 0) {
                // g.setColor(Color.RED);
                // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
            // }
            // if(ship.getSize() == 0 && ship.getTeam() == 1) {
                // g.setColor(Color.BLUE);
                // g.fillRect((int)((ship.getXLoc() - 2)* CM), 
                // (int)((ship.getYLoc() + 2) * CM), (int)(4 * CM), (int)(4 * CM));
            // }
            // if(ship.getSize() == 1 && ship.getTeam() == 1) {
                // g.setColor(Color.BLUE);
                // g.fillRect((int)((ship.getXLoc() - 4)* CM), 
                // (int)((ship.getYLoc() + 4) * CM), (int)(8 * CM), (int)(8 * CM));
            // }
        // }
    //}
        public double d2R(double deg)
        {
            double rad = deg * Math.PI/180;
            return rad;
        }
       
}
