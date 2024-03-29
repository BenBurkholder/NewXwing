package XWing;
/**
 * Write a description of class ShipDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

public class ShipDatabase
{
    // instance variables - replace the example below with your own
    public static ArrayList<ShipObject> shipList;
    public static ArrayList<coor> coorList;
    private int t = 0;
    private double STEPS = 100.0;
    private final double CM = 7;
    //11.81
    public ShipObject undoShip;
    private String curShipName;
    private String curMessage;
    // private GameBoard boardOne;



    /**
     * Constructor for objects of class ShipDatabase
     */
    public ShipDatabase()
    {
        shipList  = new ArrayList<ShipObject>();
        coorList = new ArrayList<coor>();
        curShipName = "Lowest Pilot Skill";
        curMessage = "Good Luck";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @return    the sum of x and y
     */
    // public GameBoard getGameBoard() {
        // return this.boardOne;
    // }
    
    public void print()
    {
        for(ShipObject ship : shipList) {
            System.out.println(ship.getName()+ "\t\t" + ship.getXLoc() + 
            "\t\t" + ship.getYLoc() + "\t\t" + ship.getBearing());
        }
    }

    public int getT() {
        return t;
    }

    public int listLength()
    {
        return shipList.size();
    }
    
    public double curX()
    {
        return shipList.get(t).getXLoc();
    }
    
    public double curY()
    {
        return shipList.get(t).getYLoc();
    }
    
    public void addShip(ShipObject e)
    {
        // put your code here
        shipList.add(e);
    }
    
    public void addCoor(coor e)
    {
        coorList.add(e);
    }
    
    public void nextShip()
    {
        t++;
        setUndoShip(shipList.get(t));
        curShipName = shipList.get(t).getName();

    }
    public void beginFiring()
    {
        t = shipList.size() - 1;
        curShipName = shipList.get(t).getName();
    }

    public void nextShot()
    {
        t--;
        curShipName = shipList.get(t).getName();
    }
    
    public void removeShip()
    {
        // shipList.remove(t);
        shipList.get(t).updateShipLocation(999,999,0);
    }
    
    public void nextTurn()
    {
        t = 0;
        setUndoShip(shipList.get(t));
        curShipName = shipList.get(t).getName();
    }

    public void setTurn(int passedValue)
    {
        t = passedValue;
        setUndoShip(shipList.get(t));
        curShipName = shipList.get(t).getName();
    }

    public void undo(){
        shipList.get(t).updateShipLocation(getUndoShip());
    }

    public void setUndoShip(ShipObject undoShip) {
        this.undoShip = new ShipObject(shipList.get(t).getName(), shipList.get(t).getXLoc(), shipList.get(t).getYLoc(),
                shipList.get(t).getBearing(), shipList.get(t).getBase(), shipList.get(t).getTeam());
    }
  
    public ShipObject getUndoShip() {
        return undoShip;
    }

    public ArrayList<ShipObject> getAL()
    {
        return shipList;
    }
    
    public ArrayList<coor> getCL()
    {
        return coorList;
    }
    
    public String getMessage()
    {
        return curMessage;
    }
    
    public String getShip()
    {
        return curShipName;
    }

    public String getShip(int shipNumber)
    {
        return shipList.get(shipNumber).getName();
    }
    
    // public void updateCoor()
    // {
        // double x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0;
        // double y1 = 0, y2 = 0, y3 = 0, y4 = 0, y5 = 0;
        // for(ShipObject s : shipList) {
            // if (s.getSize() == 0) {
                // x1 = s.getXLoc();
                // x2 = s.getXLoc() + .5 * 4 * Math.sin(d2R(s.getBearing()));
                // x3 = s.getXLoc() - .5 * 4 * Math.cos(d2R(s.getBearing()));
                // x4 = s.getXLoc() - .5 * 4 * Math.sin(d2R(s.getBearing()));
                // x5 = s.getXLoc() + .5 * 4 * Math.cos(d2R(s.getBearing()));
                // y1 = s.getYLoc();
                // y2 = s.getYLoc() + .5 * 4 * Math.cos(d2R(s.getBearing()));
                // y3 = s.getYLoc() + .5 * 4 * Math.sin(d2R(s.getBearing()));
                // y4 = s.getYLoc() - .5 * 4 * Math.cos(d2R(s.getBearing()));
                // y5 = s.getYLoc() - .5 * 4 * Math.sin(d2R(s.getBearing()));
            // } else if (s.getSize() == 1) {
                // x1 = s.getXLoc();
                // x2 = s.getXLoc() + .5 * 8 * Math.sin(d2R(s.getBearing()));
                // x3 = s.getXLoc() - .5 * 8 * Math.cos(d2R(s.getBearing()));
                // x4 = s.getXLoc() - .5 * 8 * Math.sin(d2R(s.getBearing()));
                // x5 = s.getXLoc() + .5 * 8 * Math.cos(d2R(s.getBearing()));
                // y1 = s.getYLoc();
                // y2 = s.getYLoc() + .5 * 8 * Math.cos(d2R(s.getBearing()));
                // y3 = s.getYLoc() + .5 * 8 * Math.sin(d2R(s.getBearing()));
                // y4 = s.getYLoc() - .5 * 8 * Math.cos(d2R(s.getBearing()));
                // y5 = s.getYLoc() - .5 * 8 * Math.sin(d2R(s.getBearing()));
            // }
        // }
        // coor c1 = new coor (x1, y1);
        // coor c2 = new coor (x2, y2);
        // coor c3 = new coor (x3, y3);
        // coor c4 = new coor (x4, y4);
        // coor c5 = new coor (x5, y5);
        // coorList.add(c1);
        // coorList.add(c2);
        // coorList.add(c3);
        // coorList.add(c4);
        // coorList.add(c5);
    // }
        
    
    public void readSheet(String filename) 
    {
        Scanner inFS = null;
        FileInputStream fileByteStream = null;
        
        try{
            fileByteStream = new FileInputStream(filename);
            inFS = new Scanner(fileByteStream);
            inFS.useDelimiter ("[,\r\n]+");
            String unused = inFS.nextLine();
            while(inFS.hasNext()) {                                
                String SN = inFS.next();
                double XL = inFS.nextDouble();
                double YL = inFS.nextDouble();
                double B = inFS.nextDouble();
                int S = inFS.nextInt();
                int T = inFS.nextInt();
                ShipObject currentShip = new ShipObject(SN, XL, YL, B, S, T);
                shipList.add(currentShip);
                            }
            fileByteStream.close();
            
        } catch(IOException error1) {
            System.out.println("Oops! Error related to: " + filename);
        }
    }
        
    public String getGameText()
    {
        String x = "Game prompts will go here";
        return x;
    }
    
    public String turn()
    {
        String x = "Active Ship";
        return x;
    }
        
    public void updateShip(ShipObject ship, double xl, double yl, double b)
    {
        ship.setXLoc(xl);
        ship.setYLoc(yl);
        ship.setBearing(b);
    }
    
    
    
    //movetype = { Straight = 0, bank left = 1, bank right = 2, turn left = 3, turn right = 4, Uturn = 5, Barrel
    // Roll Left =}
    //distance = {1, 2, 3, 4, 5}
    
    public void stepMoveShip( int moveType, int distance) 
    {
        ShipObject l_curShip = shipList.get(t);//GetCurrentShip();
        for (int i = 0; i < STEPS; ++i)
        {
            // Start at the last / final position, and work backwards
            int l_curStep =(int) STEPS - i;
            ShipObject proposedMove;
            if(moveType == 0) {
                proposedMove = l_curShip.straight(distance, l_curStep);
            } else if(moveType == 1) {
                proposedMove = l_curShip.bank(distance, 0, l_curStep);
            } else if(moveType == 2) {
                proposedMove = l_curShip.bank(distance, 1, l_curStep);
            } else if(moveType == 3) {
                proposedMove = l_curShip.turn(distance, 0, l_curStep);
            } else if(moveType == 4) {
                proposedMove = l_curShip.turn(distance, 1, l_curStep);
            } else if(moveType == 5) {
                proposedMove = l_curShip.uturn(distance, l_curStep);
            } else if(moveType == 6) {
                proposedMove = l_curShip.barrelRoll(0,l_curStep,0);
            } else if(moveType == 7) {
                proposedMove = l_curShip.barrelRoll(1,l_curStep,0);
            } else if(moveType == 8) {
                proposedMove = l_curShip.rotate(0);
            } else if(moveType == 9) {
                proposedMove = l_curShip.rotate(1);
            } else if(moveType == 10) {
                proposedMove = l_curShip.bump(0, l_curStep);
            } else if(moveType == 11) {
                proposedMove = l_curShip.bump(1, l_curStep);
            } else {
                proposedMove = l_curShip.straight(1,0);
            }
            
            // if(proxCheck(proposedMove) == true) {
                // shipList.get(t).updateShipLocation(proposedMove);
                // break;
            // } else 
            
            // remove first if
            if (collisionCheck(proposedMove) == false) {
                System.out.println("collision" + i);
                // shipList.get(t).updateShipLocation(proposedMove);
                // break;
            }
            if (collisionCheck(proposedMove) == true) {
                shipList.get(t).updateShipLocation(proposedMove);
                System.out.println(l_curStep);
                break;
            }            
        }        
    }
    
    public boolean proxCheck(ShipObject testShip) {
        double X = testShip.getXLoc();
        double Y = testShip.getYLoc();
        double S = testShip.getBase();
        
        for(int i = 0; i < shipList.size(); i++) {
            if(i != t) {
                if(S == 4 && shipList.get(i).getBase() == 4) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 5.657) {
                       return false;
                   }
                }
                if(S == 4 && shipList.get(i).getBase() == 8) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 8.485) {
                       return false;
                   }
                }
                if(S == 8 && shipList.get(i).getBase() == 4) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 8.485) {
                       return false;
                   }
                }
                if(S == 8 && shipList.get(i).getBase() == 8) {
                   if( Math.abs(X - shipList.get(i).getXLoc()) + 
                   Math.abs(Y - shipList.get(i).getYLoc()) < 11.314) {
                       return false;
                   }
                }
            }
        }
        return true;
    }
    
    public boolean collisionCheck(ShipObject testShip) {
        //get corners of attempted move
        double l_x1 = testShip.getCorner1X();
        double l_x2 = testShip.getCorner2X();
        double l_x3 = testShip.getCorner3X();
        double l_x4 = testShip.getCorner4X();
        double l_y1 = testShip.getCorner1Y();
        double l_y2 = testShip.getCorner2Y();
        double l_y3 = testShip.getCorner3Y();
        double l_y4 = testShip.getCorner4Y();
        double l_b = testShip.getBearing();
        
        //rotate around (0,0) for new corners with bearing 0
        double rotatedl_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
        double rotatedl_x2 = l_x2 * Math.cos(d2R(l_b)) - l_y2 * Math.sin(d2R(l_b));
        double rotatedl_x3 = l_x3 * Math.cos(d2R(l_b)) - l_y3 * Math.sin(d2R(l_b));
        double rotatedl_x4 = l_x4 * Math.cos(d2R(l_b)) - l_y4 * Math.sin(d2R(l_b));
        double rotatedl_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
        double rotatedl_y2 = l_y2 * Math.cos(d2R(l_b)) + l_x2 * Math.sin(d2R(l_b));
        double rotatedl_y3 = l_y3 * Math.cos(d2R(l_b)) + l_x3 * Math.sin(d2R(l_b));
        double rotatedl_y4 = l_y4 * Math.cos(d2R(l_b)) + l_x4 * Math.sin(d2R(l_b));

        double l_x5, l_y5, rotatedl_x5, rotatedl_y5;

        //get collision area
        double upperX = rotatedl_x1;
        if(rotatedl_x2 > upperX) {
            upperX = rotatedl_x2;
        }
        if (rotatedl_x3 > upperX) {
            upperX = rotatedl_x3;
        }
        if (rotatedl_x4 > upperX) {
            upperX = rotatedl_x4;
        }
        double lowerX = rotatedl_x1;
        if(rotatedl_x2 < lowerX) {
            lowerX = rotatedl_x2;
        }
        if (rotatedl_x3 < lowerX) {
            lowerX = rotatedl_x3;
        }
        if (rotatedl_x4 < lowerX) {
            lowerX = rotatedl_x4;
        }

        double upperY = rotatedl_y1;
        if(rotatedl_y2 > upperY) {
            upperY = rotatedl_y2;
        }
        if (rotatedl_y3 > upperY) {
            upperY = rotatedl_y3;
        }
        if (rotatedl_y4 > upperY) {
            upperY = rotatedl_y4;
        }
        double lowerY = rotatedl_y1;
        if(rotatedl_y2 < lowerY) {
            lowerY = rotatedl_y2;
        }
        if (rotatedl_y3 < lowerY) {
            lowerY = rotatedl_y3;
        }
        if (rotatedl_y4 < lowerY) {
            lowerY = rotatedl_y4;
        }
        System.out.println(lowerX + " " + upperX + " " +  lowerY + " " +  upperY);

        //transform all ships corners the same amount as attempted moves bearing, check for corners
        //within transformed attempted move.
        for(int i = 0; i < shipList.size(); i++) {
            if (i != t) {
                ShipObject l_ship = shipList.get(i);
                l_x1 = l_ship.getCorner1X();
                l_x2 = l_ship.getCorner2X();
                l_x3 = l_ship.getCorner3X();
                l_x4 = l_ship.getCorner4X();
                l_y1 = l_ship.getCorner1Y();
                l_y2 = l_ship.getCorner2Y();
                l_y3 = l_ship.getCorner3Y();
                l_y4 = l_ship.getCorner4Y();
                l_x5 = l_ship.getXLoc();
                l_y5 = l_ship.getYLoc();
                //l_b = l_ship.getBearing();

                rotatedl_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                rotatedl_x2 = l_x2 * Math.cos(d2R(l_b)) - l_y2 * Math.sin(d2R(l_b));
                rotatedl_x3 = l_x3 * Math.cos(d2R(l_b)) - l_y3 * Math.sin(d2R(l_b));
                rotatedl_x4 = l_x4 * Math.cos(d2R(l_b)) - l_y4 * Math.sin(d2R(l_b));
                rotatedl_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                rotatedl_y2 = l_y2 * Math.cos(d2R(l_b)) + l_x2 * Math.sin(d2R(l_b));
                rotatedl_y3 = l_y3 * Math.cos(d2R(l_b)) + l_x3 * Math.sin(d2R(l_b));
                rotatedl_y4 = l_y4 * Math.cos(d2R(l_b)) + l_x4 * Math.sin(d2R(l_b));
                rotatedl_x5 = l_x5 * Math.cos(d2R(l_b)) - l_y5 * Math.sin(d2R(l_b));
                rotatedl_y5 = l_y5 * Math.cos(d2R(l_b)) + l_x5 * Math.sin(d2R(l_b));

                if(rotatedl_x1 >= lowerX && rotatedl_x1 <= upperX && rotatedl_y1 >= lowerY && rotatedl_y1 <= upperY) {
                    
                    System.out.println("corner 1, x=" + l_x1 + "y=" + l_y1 );
                    return false;
                }
                if(rotatedl_x2 >= lowerX && rotatedl_x2 <= upperX && rotatedl_y2 >= lowerY && rotatedl_y2 <= upperY) {
                    System.out.println("corner 2, x=" + l_x2 + "y=" + l_y2 );
                    return false;
                }
                if(rotatedl_x3 >= lowerX && rotatedl_x3 <= upperX && rotatedl_y3 >= lowerY && rotatedl_y3 <= upperY) {
                    System.out.println("corner 3, x=" + l_x3 + "y=" + l_y3 );
                    return false;
                }
                if(rotatedl_x4 >= lowerX && rotatedl_x4 <= upperX && rotatedl_y4 >= lowerY && rotatedl_y4 <= upperY) {
                    System.out.println("corner 4, x=" + l_x4 + "y=" + l_y4 );
                    return false;
                }
                if(rotatedl_x5 >= lowerX && rotatedl_x5 <= upperX && rotatedl_y5 >= lowerY && rotatedl_y5 <= upperY) {
                    return false;
                }
            }
        }
        // check if any corners of attempted move are in other ships.
        for(int i = 0; i < shipList.size(); i++) {
            if(i != t) {
                ShipObject l_newTestShip = shipList.get(i);

                l_x1 = l_newTestShip.getCorner1X();
                l_x2 = l_newTestShip.getCorner2X();
                l_x3 = l_newTestShip.getCorner3X();
                l_x4 = l_newTestShip.getCorner4X();
                l_y1 = l_newTestShip.getCorner1Y();
                l_y2 = l_newTestShip.getCorner2Y();
                l_y3 = l_newTestShip.getCorner3Y();
                l_y4 = l_newTestShip.getCorner4Y();
                l_b = l_newTestShip.getBearing();

                rotatedl_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                rotatedl_x2 = l_x2 * Math.cos(d2R(l_b)) - l_y2 * Math.sin(d2R(l_b));
                rotatedl_x3 = l_x3 * Math.cos(d2R(l_b)) - l_y3 * Math.sin(d2R(l_b));
                rotatedl_x4 = l_x4 * Math.cos(d2R(l_b)) - l_y4 * Math.sin(d2R(l_b));
                rotatedl_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                rotatedl_y2 = l_y2 * Math.cos(d2R(l_b)) + l_x2 * Math.sin(d2R(l_b));
                rotatedl_y3 = l_y3 * Math.cos(d2R(l_b)) + l_x3 * Math.sin(d2R(l_b));
                rotatedl_y4 = l_y4 * Math.cos(d2R(l_b)) + l_x4 * Math.sin(d2R(l_b));



                upperX = rotatedl_x1;
                if(rotatedl_x2 > upperX) {
                    upperX = rotatedl_x2;
                }
                if (rotatedl_x3 > upperX) {
                    upperX = rotatedl_x3;
                }
                if (rotatedl_x4 > upperX) {
                    upperX = rotatedl_x4;
                }
                lowerX = rotatedl_x1;
                if(rotatedl_x2 < lowerX) {
                    lowerX = rotatedl_x2;
                }
                if (rotatedl_x3 < lowerX) {
                    lowerX = rotatedl_x3;
                }
                if (rotatedl_x4 < lowerX) {
                    lowerX = rotatedl_x4;
                }

                upperY = rotatedl_y1;
                if(rotatedl_y2 > upperY) {
                    upperY = rotatedl_y2;
                }
                if (rotatedl_y3 > upperY) {
                    upperY = rotatedl_y3;
                }
                if (rotatedl_y4 > upperY) {
                    upperY = rotatedl_y4;
                }
                lowerY = rotatedl_y1;
                if(rotatedl_y2 < lowerY) {
                    lowerY = rotatedl_y2;
                }
                if (rotatedl_y3 < lowerY) {
                    lowerY = rotatedl_y3;
                }
                if (rotatedl_y4 < lowerY) {
                    lowerY = rotatedl_y4;
                }

                ShipObject l_ship = testShip;
                l_x1 = l_ship.getCorner1X();
                l_x2 = l_ship.getCorner2X();
                l_x3 = l_ship.getCorner3X();
                l_x4 = l_ship.getCorner4X();
                l_y1 = l_ship.getCorner1Y();
                l_y2 = l_ship.getCorner2Y();
                l_y3 = l_ship.getCorner3Y();
                l_y4 = l_ship.getCorner4Y();
                l_x5 = l_ship.getXLoc();
                l_y5 = l_ship.getYLoc();
                //l_b = l_ship.getBearing();

                rotatedl_x1 = l_x1 * Math.cos(d2R(l_b)) - l_y1 * Math.sin(d2R(l_b));
                rotatedl_x2 = l_x2 * Math.cos(d2R(l_b)) - l_y2 * Math.sin(d2R(l_b));
                rotatedl_x3 = l_x3 * Math.cos(d2R(l_b)) - l_y3 * Math.sin(d2R(l_b));
                rotatedl_x4 = l_x4 * Math.cos(d2R(l_b)) - l_y4 * Math.sin(d2R(l_b));
                rotatedl_y1 = l_y1 * Math.cos(d2R(l_b)) + l_x1 * Math.sin(d2R(l_b));
                rotatedl_y2 = l_y2 * Math.cos(d2R(l_b)) + l_x2 * Math.sin(d2R(l_b));
                rotatedl_y3 = l_y3 * Math.cos(d2R(l_b)) + l_x3 * Math.sin(d2R(l_b));
                rotatedl_y4 = l_y4 * Math.cos(d2R(l_b)) + l_x4 * Math.sin(d2R(l_b));
                rotatedl_x5 = l_x5 * Math.cos(d2R(l_b)) - l_y5 * Math.sin(d2R(l_b));
                rotatedl_y5 = l_y5 * Math.cos(d2R(l_b)) + l_x5 * Math.sin(d2R(l_b));

                if(rotatedl_x1 >= lowerX && rotatedl_x1 <= upperX && rotatedl_y1 >= lowerY && rotatedl_y1 <= upperY) {
                    return false;
                }
                if(rotatedl_x2 >= lowerX && rotatedl_x2 <= upperX && rotatedl_y2 >= lowerY && rotatedl_y2 <= upperY) {
                    return false;
                }
                if(rotatedl_x3 >= lowerX && rotatedl_x3 <= upperX && rotatedl_y3 >= lowerY && rotatedl_y3 <= upperY) {
                    return false;
                }
                if(rotatedl_x4 >= lowerX && rotatedl_x4 <= upperX && rotatedl_y4 >= lowerY && rotatedl_y4 <= upperY) {
                    return false;
                }
                if(rotatedl_x5 >= lowerX && rotatedl_x5 <= upperX && rotatedl_y5 >= lowerY && rotatedl_y5 <= upperY) {
                    return false;
                }

            }
        }
        return true;      
    }
            
    public double d2R(double deg)
    {
        double rad = deg * Math.PI/180;
        return rad;
    }
}
