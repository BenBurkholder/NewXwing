package XWing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.*;
import java.text.*;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Write a description of class XWingGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class XWingGUI extends JFrame //implements ActionListener
{
    GameBoard gb;
    private ShipDatabase game;
    
    private JPanel panel;
    private JTextField textField;
    private JButton s1;
    private JButton s2;
    private JButton s3;
    private JButton s4;
    private JButton s5;
    private JButton rt1;
    private JButton rt2;
    private JButton rt3;
    private JButton lt1;
    private JButton lt2;
    private JButton lt3;
    private JButton rb1;
    private JButton rb2;
    private JButton rb3;
    private JButton lb1;
    private JButton lb2;
    private JButton lb3;
    private JButton stop;
    private JButton ut1, ut2, ut3, ut4, ut5;
    private JButton brl0, brl1, brlneg1, brr0, brr1, brrneg1;
    private JButton beginFiring, nextFire;
    private JButton removeShip;
    private JButton nextTurn;
    private JButton nextShip;
    private JButton drawMap;
    private JButton PS;
    // private JButton undoMove;
    // private JButton openFile;
    // private ArrayList currentState;
    // private int numberOfShips;


    private double CM = 11.81;
    //11.81
    private int BUTTON_COL_1 = (int)(100 * CM);
    private final int BUTTON_COL_2 = (int)(108 * CM);
    private final int BUTTON_COL_3 = (int)(116 * CM);
    private final int BUTTON_COL_4 = (int)(124 * CM);
    private final int BUTTON_COL_5 = (int)(132 * CM);
    private final int BUTTON_COL_6 = (int)(140 * CM);
    private final int BUTTON_COL_7 = (int)(148 * CM);
    
    private final int BUTTON_ROW_0 = (int) (60 * CM);
    private final int BUTTON_ROW_1 = (int)(55 * CM);
    private final int BUTTON_ROW_2 = (int)(50 * CM);
    private final int BUTTON_ROW_3 = (int)(45* CM);
    private final int BUTTON_ROW_4 = (int)(40 * CM);
    private final int BUTTON_ROW_5 = (int)(35 * CM);
    private final int BUTTON_ROW_6 = (int)(30 * CM);
    private final int BUTTON_ROW_8 = (int)(70 * CM);
    private final int BUTTON_ROW_9 = (int)(75 * CM);
    private final int BUTTON_ROW_10 = (int)(80 * CM);
    
    int[] NEW_ROWS = new int[]{BUTTON_ROW_8,BUTTON_ROW_8,BUTTON_ROW_8,BUTTON_ROW_8,BUTTON_ROW_8,BUTTON_ROW_8,BUTTON_ROW_8,BUTTON_ROW_9,BUTTON_ROW_9,BUTTON_ROW_9,BUTTON_ROW_9,BUTTON_ROW_9,BUTTON_ROW_9,BUTTON_ROW_9,BUTTON_ROW_10,BUTTON_ROW_10,BUTTON_ROW_10,BUTTON_ROW_10,BUTTON_ROW_10,BUTTON_ROW_10,BUTTON_ROW_10};
    int[] NEW_COLS = new int[]{BUTTON_COL_1,BUTTON_COL_2,BUTTON_COL_3,BUTTON_COL_4,BUTTON_COL_5,BUTTON_COL_6,BUTTON_COL_7,BUTTON_COL_1,BUTTON_COL_2,BUTTON_COL_3,BUTTON_COL_4,BUTTON_COL_5,BUTTON_COL_6,BUTTON_COL_7,BUTTON_COL_1,BUTTON_COL_2,BUTTON_COL_3,BUTTON_COL_4,BUTTON_COL_5,BUTTON_COL_6,BUTTON_COL_7};

    private final int BUTTON_HIGHT = 40;
    private final int BUTTON_WIDTH = (int)(7 * CM);



    
    
    
    private JLabel message;
    private JLabel turn;
        
    private JMenuBar menus;
    private JMenu fileMenu;
    private JMenuItem open;
    private JMenuItem exit;
    private boolean arcStatus = false;
    
    
    //private ShipObject moves;
    
    //private ShipDatabase SD;
    // private JLayeredPane lpane = new JLayeredPane();
    // private JPanel board = new JPanel();
    // private JPanel control = new JPanel();
    
    
    
    
    public static void main(String args[]) {
        XWingGUI gui = new XWingGUI();
        gui.setUndecorated(true);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("X-Wing");
        gui.pack();
        gui.setSize((int)( 162 * 11.81), (int)(91 * 11.81));
    
    }


    public double getCM() {
        return CM;
    }

    public void setCM(double CM) {
        this.CM = CM;
    }
    
    public XWingGUI(){
        // SD = new ShipDatabase();
        // game.readSheet("ship_list.csv");
        
        setSize((int)( 162 * CM), (int)(91 * CM));
        setLocationRelativeTo(null);
        panel = new JPanel();
        add(panel);
        panel.setLayout(null);
                
        game = new ShipDatabase();
        // game.readSheet("ship_list.csv");
        // game.print();
        
        gb = new GameBoard();
        //CM = gb.getPixelToCM();
        gb.setBounds((int)(1 * CM),(int)(1 * CM), (int)( 96 * CM), (int)( 89 * CM));
        panel.add(gb);
        //moves = new ShipObject;
        
        
        
        
        // setLayout(new GridBagLayout());
        // GridBagConstraints position = new GridBagConstraints();
        
//        JMenuBar menus = new JMenuBar();
//        setJMenuBar(menus);
//
//        JMenu fileMenu = new JMenu("File");
//        menus.add(fileMenu);
//        open = new JMenuItem("Open");
//        open.addActionListener(new ButtonListener());
//        fileMenu.add(open);
//        exit = new JMenuItem("Exit");
//        exit.addActionListener(new ButtonListener());
//        fileMenu.add(exit);
//


        
        message = new JLabel(game.getGameText());
        message.setBounds((int)(17 * CM), (int)(102 * CM), (int)(57.5 * CM), (int)(4 * CM));
        panel.add(message);
        
        turn = new JLabel(game.turn());
        turn.setBounds((int)(100 * CM), (int)( 25 * CM), (int)(91 * CM), (int)(4 * CM));
        panel.add(turn);
        
        JButton PS = new JButton("Print");
        PS.setBounds(BUTTON_COL_1, BUTTON_ROW_4, BUTTON_WIDTH, BUTTON_HIGHT);
//        panel.add(PS);
        PS.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.print();
            }
        });

        Icon st = new ImageIcon("images/Load.png");
        JButton openFile = new JButton(st);
        openFile.setBounds(BUTTON_COL_1, BUTTON_ROW_6, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(openFile);
        openFile.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                openFile();

                
                for(int i=0; i<game.listLength(); i++){
                    JButton button = new JButton(game.getShip(i));
                    button.setBounds(NEW_COLS[i], NEW_ROWS[i], BUTTON_WIDTH, BUTTON_HIGHT);
                    panel.add(button);
                    int tempNumber = i;
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                            System.out.println("yay");                            
                            System.out.println(Integer.toString(tempNumber));
                            game.setTurn(tempNumber);
                            turn.setText("Current Ship: " + game.getShip());
                            plot(arcStatus);
                        }
                    });
                    
        
                }
            }
        });

        st = new ImageIcon("images/Refresh.png");
        JButton drawMap = new JButton(st);
        drawMap.setBounds(BUTTON_COL_2, BUTTON_ROW_6, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(drawMap);
        drawMap.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/S1.png");
        JButton s1 = new JButton(st);
        s1.setBounds(BUTTON_COL_3, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s1);
        s1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(0,1);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/S2.png");
        JButton s2 = new JButton(st);
        s2.setBounds(BUTTON_COL_3, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s2); 
        s2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 2);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/S3.png");
        JButton s3 = new JButton(st);
        s3.setBounds(BUTTON_COL_3, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s3);
        s3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 3);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/S4.png");
        JButton s4 = new JButton(st);
        s4.setBounds(BUTTON_COL_3, BUTTON_ROW_4, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s4); 
        s4.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 4);;
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/S5.png");
        JButton s5 = new JButton(st);
        s5.setBounds(BUTTON_COL_3, BUTTON_ROW_5, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(s5);
        s5.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.stepMoveShip(0, 5);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/RB1.png");
        JButton rb1 = new JButton(st);
        rb1.setBounds(BUTTON_COL_4, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rb1);
        rb1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(2, 1);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/RB2.png");
        JButton rb2 = new JButton(st);
        rb2.setBounds(BUTTON_COL_4, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rb2); 
        rb2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(2, 2);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/RB3.png");
        JButton rb3 = new JButton(st);
        rb3.setBounds(BUTTON_COL_4, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rb3);
        rb3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(2, 3);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/LB1.png");
        JButton lb1 = new JButton(st);
        lb1.setBounds(BUTTON_COL_2, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lb1);
        lb1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(1, 1);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/LB2.png");
        JButton lb2 = new JButton(st);
        lb2.setBounds(BUTTON_COL_2, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lb2); 
        lb2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(1, 2);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/LB3.png");
        JButton lb3 = new JButton(st);
        lb3.setBounds(BUTTON_COL_2, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lb3);
        lb3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(1, 3);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/RT1.png");
        JButton rt1 = new JButton(st);
        rt1.setBounds(BUTTON_COL_5, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rt1);
        rt1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(4, 1);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/RT2.png");
        JButton rt2 = new JButton(st);
        rt2.setBounds(BUTTON_COL_5, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rt2); 
        rt2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(4, 2);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/RT3.png");
        JButton rt3 = new JButton(st);
        rt3.setBounds(BUTTON_COL_5, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(rt3);
        rt3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(4, 3);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/LT1.png");
        JButton lt1 = new JButton(st);
        lt1.setBounds(BUTTON_COL_1, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lt1);
        lt1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(3, 1);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/Lt2.png");
        lt2 = new JButton(st);
        lt2.setBounds(BUTTON_COL_1, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lt2); 
        lt2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(3, 2);
                plot(arcStatus);
            }
        });
        st = new ImageIcon("images/Lt3.png");
        JButton lt3 = new JButton(st);
        lt3.setBounds(BUTTON_COL_1, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(lt3);
        lt3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.stepMoveShip(3, 3);
                plot(arcStatus);
            }
        });
        // st = new ImageIcon("images/NewRound.png");
        // JButton nextTurn = new JButton(st);
        // nextTurn.setBounds(BUTTON_COL_7, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        // panel.add(nextTurn);
        // nextTurn.addActionListener(new ActionListener() {
        //     public void actionPerformed(final ActionEvent e) {
        //        game.nextTurn();
        //        turn.setText("Current Ship: " + game.getShip());
        //        plot(arcStatus);
        //     }
        // });

        // st = new ImageIcon("images/NextMove.png");
        // JButton nextShip = new JButton(st);
        // nextShip.setBounds(BUTTON_COL_7, BUTTON_ROW_5, BUTTON_WIDTH, BUTTON_HIGHT);
        // panel.add(nextShip);
        // nextShip.addActionListener(new ActionListener() {
        //     public void actionPerformed(final ActionEvent e) {
        //        try {
        //            game.nextShip();
        //            turn.setText("Current Ship: " + game.getShip());
        //            plot(arcStatus);
        //        } catch (IndexOutOfBoundsException e1) {
        //            turn.setText("End of Round: Select Next Turn");
        //        }
        //     }
        // });

        // st = new ImageIcon("images/Attacks.png");
        // JButton beginFiring = new JButton(st);
        // beginFiring.setBounds(BUTTON_COL_7, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        // panel.add(beginFiring);
        // beginFiring.addActionListener(new ActionListener() {
        //     public void actionPerformed(final ActionEvent e) {
        //         try {
        //             game.beginFiring();
        //             turn.setText("Current Ship: " + game.getShip());
        //             plot(arcStatus);
        //         } catch (IndexOutOfBoundsException e1) {
        //             turn.setText("End of Round: Select Next Turn");
        //         }
        //     }
        // });

        // st = new ImageIcon("images/NextShot.png");
        // JButton nextShot = new JButton(st);
        // nextShot.setBounds(BUTTON_COL_7, BUTTON_ROW_4, BUTTON_WIDTH, BUTTON_HIGHT);
        // panel.add(nextShot);
        // nextShot.addActionListener(new ActionListener() {
        //     public void actionPerformed(final ActionEvent e) {
        //         try {
        //             game.nextShot();
        //             turn.setText("Current Ship: " + game.getShip());
        //             plot(arcStatus);
        //         } catch (IndexOutOfBoundsException e1) {
        //             turn.setText("End of Round: Select Next Turn");
        //         }
        //     }
        // });

        st = new ImageIcon("images/Undo.png");
        JButton undoMove = new JButton(st);
        undoMove.setBounds(BUTTON_COL_3, BUTTON_ROW_6, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(undoMove);
        undoMove.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                game.undo();
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/Remove.png");
        JButton removeShip = new JButton(st);
        removeShip.setBounds(BUTTON_COL_4, BUTTON_ROW_6, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(removeShip);
        removeShip.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
               game.removeShip();
               plot(arcStatus);
            }
        });

        st = new ImageIcon("images/U1.png");
        JButton ut1 = new JButton(st);
        ut1.setBounds(BUTTON_COL_6, BUTTON_ROW_1, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(ut1);
        ut1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(5,1);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/u2.png");
        JButton ut2 = new JButton(st);
        ut2.setBounds(BUTTON_COL_6, BUTTON_ROW_2, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(ut2);
        ut2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(5,2);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/U3.png");
        JButton ut3 = new JButton(st);
        ut3.setBounds(BUTTON_COL_6, BUTTON_ROW_3, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(ut3);
        ut3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(5,3);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/U4.png");
        JButton ut4 = new JButton(st);
        ut4.setBounds(BUTTON_COL_6, BUTTON_ROW_4, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(ut4);
        ut4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(5,4);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/U5.png");
        JButton ut5 = new JButton(st);
        ut5.setBounds(BUTTON_COL_6, BUTTON_ROW_5, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(ut5);
        ut5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(5,5);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/90R.png");
        JButton R90 = new JButton(st);
        R90.setBounds(BUTTON_COL_4, BUTTON_ROW_0, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(R90);
        R90.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(9,1);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/90L.png");
        JButton L90 = new JButton(st);
        L90.setBounds(BUTTON_COL_3, BUTTON_ROW_0, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(L90);
        L90.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(8,1);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/RL.png");
        JButton brl0 = new JButton(st);
        brl0.setBounds(BUTTON_COL_1, BUTTON_ROW_0, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(brl0);
        brl0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(6,1);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/BF.png");
        JButton bumpF = new JButton(st);
        bumpF.setBounds(BUTTON_COL_5, BUTTON_ROW_0, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(bumpF);
        bumpF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(10,1);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/BR.png");
        JButton bumpR = new JButton(st);
        bumpR.setBounds(BUTTON_COL_6, BUTTON_ROW_0, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(bumpR);
        bumpR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(11,1);
                plot(arcStatus);
            }
        });

        st = new ImageIcon("images/RR.png");
        JButton brr0 = new JButton(st);
        brr0.setBounds(BUTTON_COL_2, BUTTON_ROW_0, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(brr0);
        brr0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.stepMoveShip(7,1);
                plot(arcStatus);
            }
        });

        Icon newbst = new ImageIcon("images/AttackButtonOff.png");
        JButton attackToggle = new JButton(newbst);
        attackToggle.setBounds(BUTTON_COL_5, BUTTON_ROW_6, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(attackToggle);
        attackToggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Icon newbst;
                if (arcStatus == true) {
                    arcStatus = false;
                    newbst = new ImageIcon("images/AttackButtonOff.png");
                } else {
                    arcStatus = true;
                    newbst = new ImageIcon("images/AttackButtonOn.png");
                }
                plot(arcStatus);              

                attackToggle.setIcon(newbst);
            }
        });

        Icon bst = new ImageIcon("images/TurretOff2.png");
        JButton turret = new JButton(bst);
        turret.setBounds(BUTTON_COL_6, BUTTON_ROW_6, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(turret);
        turret.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gb.turretToggle();
                plot(arcStatus);
                Icon bst;
                if(gb.getTurret()) {
                    bst = new ImageIcon("images/TurretOn2.png");
                } else {
                    bst = new ImageIcon("images/TurretOff2.png");
                }
                turret.setIcon(bst);
            }
        });
        st = new ImageIcon("images/BEOff.png");
        JButton bullseye = new JButton(st);
        bullseye.setBounds(BUTTON_COL_7, BUTTON_ROW_6, BUTTON_WIDTH, BUTTON_HIGHT);
        panel.add(bullseye);
        bullseye.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gb.bullseyeToggle();
                plot(arcStatus);
                Icon bst;
                if(gb.getBullseye()) {
                    bst = new ImageIcon("images/BEOn.png");
                } else {
                    bst = new ImageIcon("images/BEOff.png");
                }
                bullseye.setIcon(bst);
            }
        });



        Font currentFont = s1.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * .8F);
        Font newFont2 = currentFont.deriveFont(currentFont.getSize() * .7F);
        s1.setFont(newFont);
        s2.setFont(newFont);
        s3.setFont(newFont);
        s4.setFont(newFont);
        s5.setFont(newFont);
        brr0.setFont(newFont);
        brl0.setFont(newFont);
        rb1.setFont(newFont);
        rb2.setFont(newFont);
        rb3.setFont(newFont);
        lb1.setFont(newFont);
        lb2.setFont(newFont);
        lb3.setFont(newFont);
        // nextShip.setFont(newFont2);
        // nextTurn.setFont(newFont2);
        // beginFiring.setFont(newFont);
        // nextShot.setFont(newFont);
        R90.setFont(newFont);
        L90.setFont(newFont);




    }
    private void openFile(){

        // create File Chooser so that it starts at the current directory
        String userDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(userDir);

        // show File Chooser and wait for user selection
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            // FIX ME: use your database object
            game.readSheet(filename);

            plot(arcStatus);

        }
    }
    
    private void plot(boolean arc)
    {
        gb.drawMap(game.getAL(), game.getT(), arc);
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == exit) {
                System.exit(0);
            }
            if (event.getSource() == PS) {
                game.print();
            }
            if (event.getSource() == open) {
                openFile();
                turn.setText("Current Ship: " + game.getShip());
            }
             if (event.getSource() == drawMap) {

             }
            // gb.drawMap(game.getAL());
            // gb.repaint();
            // }
//             if (event.getSource() == s1) {
//             System.out.println("yay");
//             game.stepMoveShip(0, 1);
//             }
            // if(event.getSource() == s2) {
            // game.straight2();
            // }
            // if(event.getSource() == s3) {
            // game.straight3();
            // }
            // if(event.getSource() == s4) {
            // game.straight4();
            // }
            // if(event.getSource() == s5) {
            // game.straight5();
            // }
            // if(event.getSource() == rb1) {
            // game.bankRight1();
            // }
            // if(event.getSource() == rb2) {
            // game.bankRight2();
            // }
            // if(event.getSource() == rb3) {
            // game.bankRight3();
            // }
            // if(event.getSource() == lb1) {
            // game.bankLeft1();
            // }
            // if(event.getSource() == lb2) {
            // game.bankLeft2();
            // }
            // if(event.getSource() == lb3) {
            // game.bankLeft3();
            // }
            // if(event.getSource() == rt1) {
            // game.turnRight1();
            // }
            // if(event.getSource() == rt2) {
            // game.turnRight2();
            // }
            // if(event.getSource() == rt3) {
            // game.turnRight3();
            // }
            // if(event.getSource() == lt1) {
            // game.turnLeft1();
            // }
            // if(event.getSource() == lt2) {
            // game.turnLeft2();
            // }
            // if(event.getSource() == lt3) {
            // game.turnLeft3();
            // System.out.print("Now a lot");
            // }
            if (event.getSource() == removeShip) {
                game.removeShip();
            }
            if (event.getSource() == nextShip) {
                game.nextShip();
            }
            if (event.getSource() == nextTurn) {
                game.nextTurn();
            }
            turn.setText("Current Ship: " + game.getShip());
            message.setText(game.getMessage());
            repaint();

        }
    }


}
