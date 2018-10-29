import bsh.Interpreter;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class GraphingCalculator extends javax.swing.JFrame {

    private boolean graphOn = false;
    
    private Thread t, t2;
    
    private double x = 0;
    private double y = 0;
    
    private double xscale = 1;
    private double yscale = 1;
            
    private String whichNumber = "firstNumber";
    private String buttonClick = "number";
    private String operation = "";
    
    private double firstNumber;
    private double secondNumber;
    private double result;
    
    private String graphing = "";
    
    private boolean operationSelected;
    
    private JLabel bglabel;

    /**
     * Creates new form Calculator
     */
    public GraphingCalculator() {

        initComponents();

        this.setTitle("Graphing Calculator");
        
        this.setPreferredSize(new Dimension(440, 440));
        
        jtxtDisplay.setEnabled(true);

        setResizable(false);
        
        try {
            bglabel = new JLabel();
            bglabel.setText("");
            URL url = getClass().getResource("bg.gif");
            bglabel.setIcon(new ImageIcon(url));
            add(bglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, this.getHeight()));
            bglabel.setBounds(0, 0, 440, this.getHeight());
        } catch(Exception e) {
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    Thread.sleep(1000);
                } catch(Exception e) {
                }

                setGraph();
            }
        }).start();
        
        pack();
        
        
    }
    
    public void setGraph() {
        if(t != null)
            if(t.isAlive())
                try {
                    t.join();
                } catch(Exception e) {
                }
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Graphics g = graph.getGraphics();
                    
                    g.setColor(new Color(200, 240, 200));
                    g.fillRect(0, 0, 360, 260);
                    
                    g.setColor(Color.LIGHT_GRAY);
                    
                    for(int yy=0; yy<260; yy+=10) {
                        if(yy%30==0) {
                            g.drawLine(0, yy, 360, yy);
                        }
                    }
                    for(int xx=0; xx<360; xx+=10) {
                        if(xx%30==0) {
                            g.drawLine(xx, 0, xx, 260);
                        }
                    }

                    g.setColor(Color.BLACK);
                    g.drawLine(0, 130 + (int)y, 360, 130 + (int)y);
                    g.drawLine(180 + (int)x, 0, 180 + (int)x, 260);

                    for(int xx=-800; xx<800; xx++) {

                        double yy;
                        Interpreter interpreter = new Interpreter();

                        interpreter.set("x", xx);
                        interpreter.eval("y=" + graphing);

                        try {
                            yy = -1 * ((double) interpreter.get("y") / yscale) + 130;
                        } catch(Exception e) {
                            yy = -1 * ((int) interpreter.get("y") / yscale) + 130;
                        }
                        int currX = (int)(xx/xscale) + 180 + (int)x;
                        int currY = (int) yy + (int)y;
                        
                        if(xx%30==0) {
                            g.setFont(new Font("arial", Font.BOLD, 9));
                            g.setColor(Color.DARK_GRAY);
                            g.drawString("" +  1*xx*(xscale), xx+180+(int)x, 130+(int)y);
                            ///if(!graphing.contains("Math.sin(x)") && !graphing.contains("Math.cos(x)") && !graphing.contains("Math.tan(x)"))
                                ///g.drawString("" + -1*xx*(yscale/xscale), 180+(int)x, xx+130+(int)y);
                        }
                        
                        interpreter.set("x", xx - 1);
                        interpreter.eval("y=" + graphing);

                        try {
                            yy = -1 * ((double) interpreter.get("y") / yscale) + 130;
                        } catch(Exception e) {
                            yy = -1 * ((int) interpreter.get("y") / yscale) + 130;
                        }

                        int prevX = (int)((xx-1)/xscale) + 180 + (int)x;
                        int prevY = (int) yy + (int)y;

                        g.setColor(Color.RED);

                        g.drawLine(prevX, prevY, currX, currY);
                    }
                } catch(Exception e) {
                }
            }
        });
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtDisplay = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        graph = new javax.swing.JPanel();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OkelyKodely's Calculator");
        setBackground(java.awt.Color.red);
        setMinimumSize(new java.awt.Dimension(300, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtDisplay.setBackground(new java.awt.Color(245, 245, 245));
        jtxtDisplay.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jtxtDisplay.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        getContentPane().add(jtxtDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 50));

        jButton1.setBackground(java.awt.Color.darkGray);
        jButton1.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 60, 50));

        jButton2.setBackground(java.awt.Color.red);
        jButton2.setFont(new java.awt.Font("Wingdings", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 50));

        jButton3.setBackground(java.awt.Color.yellow);
        jButton3.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("C");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, 50));

        jButton4.setBackground(java.awt.Color.darkGray);
        jButton4.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("%");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 60, 50));

        jButton5.setBackground(java.awt.Color.blue);
        jButton5.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("7");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 60, 50));

        jButton6.setBackground(java.awt.Color.blue);
        jButton6.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("8");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 60, 50));

        jButton7.setBackground(java.awt.Color.blue);
        jButton7.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("9");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 60, 50));

        jButton8.setBackground(java.awt.Color.darkGray);
        jButton8.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("-");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 60, 50));

        jButton9.setBackground(java.awt.Color.blue);
        jButton9.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("4");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 50));

        jButton10.setBackground(java.awt.Color.blue);
        jButton10.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("5");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 60, 50));

        jButton11.setBackground(java.awt.Color.blue);
        jButton11.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("6");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 60, 50));

        jButton12.setBackground(java.awt.Color.darkGray);
        jButton12.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("*");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 60, 50));

        jButton13.setBackground(java.awt.Color.blue);
        jButton13.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("1");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 50));

        jButton14.setBackground(java.awt.Color.blue);
        jButton14.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("2");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 60, 50));

        jButton15.setBackground(java.awt.Color.blue);
        jButton15.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("3");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 60, 50));

        jButton16.setBackground(java.awt.Color.darkGray);
        jButton16.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("/");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 60, 50));

        jButton17.setBackground(java.awt.Color.blue);
        jButton17.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("0");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 60, 50));

        jButton18.setBackground(java.awt.Color.blue);
        jButton18.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText(".");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 60, 50));

        jButton19.setBackground(java.awt.Color.blue);
        jButton19.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("±");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 60, 50));

        jButton20.setBackground(new java.awt.Color(0, 255, 153));
        jButton20.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jButton20.setText("graph");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 90, 40));

        jButton21.setBackground(java.awt.Color.darkGray);
        jButton21.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("sin");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 60, 50));

        jButton22.setBackground(java.awt.Color.darkGray);
        jButton22.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("asin");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 60, 50));

        jButton23.setBackground(java.awt.Color.darkGray);
        jButton23.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("tan");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 60, 50));

        jButton24.setBackground(java.awt.Color.darkGray);
        jButton24.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("cos");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 60, 50));

        jButton25.setBackground(java.awt.Color.darkGray);
        jButton25.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("atan");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 60, 50));

        jButton26.setBackground(java.awt.Color.darkGray);
        jButton26.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setText("x^y");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 60, 50));

        jButton27.setBackground(java.awt.Color.darkGray);
        jButton27.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("√x");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 60, 50));

        jButton28.setBackground(java.awt.Color.darkGray);
        jButton28.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("acos");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 60, 50));

        jButton29.setBackground(java.awt.Color.darkGray);
        jButton29.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("1/x");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 60, 50));

        jButton30.setBackground(java.awt.Color.orange);
        jButton30.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jButton30.setForeground(new java.awt.Color(51, 51, 51));
        jButton30.setText("graph");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 60, 50));

        graph.setBackground(new java.awt.Color(0, 0, 0));
        graph.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 360, 260));

        jButton31.setBackground(java.awt.Color.green);
        jButton31.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        jButton31.setText("=");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 60, 50));

        jButton32.setBackground(new java.awt.Color(0, 255, 153));
        jButton32.setText("zoom out");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, -1, -1));

        jButton33.setBackground(new java.awt.Color(0, 255, 153));
        jButton33.setText("zoom in");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        jButton34.setBackground(new java.awt.Color(0, 255, 153));
        jButton34.setText("v");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 50, 20));

        jButton35.setBackground(new java.awt.Color(0, 255, 153));
        jButton35.setText("<");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 50, 20));

        jButton36.setBackground(new java.awt.Color(0, 255, 153));
        jButton36.setText(">");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 50, 20));

        jButton37.setBackground(new java.awt.Color(0, 255, 153));
        jButton37.setText("^");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 50, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        firstNumber = 0;
        secondNumber = 0;
        result = 0;

        operation = "";
        operationSelected = false;
        
        jtxtDisplay.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void getNumber(String num) {

        if(!operationSelected) {
            buttonClick = "number";
            jtxtDisplay.setText(jtxtDisplay.getText() + num);
            whichNumber = "firstNumber";
            try {
                firstNumber = Double.parseDouble(jtxtDisplay.getText());
            } catch(Exception e) {
            }
        } else {
            if(buttonClick.equals("number")) {
                jtxtDisplay.setText(jtxtDisplay.getText() + num);
                whichNumber = "secondNumber";
                try {
                    secondNumber = Double.parseDouble(jtxtDisplay.getText());
                } catch(Exception e) {
                }
            }
            if(buttonClick.equals("operation")) {
                buttonClick = "number";
                jtxtDisplay.setText(num);
                whichNumber = "secondNumber";
                try {
                    secondNumber = Double.parseDouble(jtxtDisplay.getText());
                } catch(Exception e) {
                }
            }
        }
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        getNumber("7");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "plus";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed

        this.x = 0;
        this.y = 0;
        
        xscale = 1;
        yscale = 1;
        
        String g = jtxtDisplay.getText();
        
        if(g.contains("sin x") || g.contains("cos x") || g.contains("tan x")) {
            xscale /= 12;
            yscale /= 12;
        }
        
        int charPos = 0;
        int strLength = g.length();
        
        do {
            strLength = g.length();
            try {
                if(g.substring(charPos,charPos+1).equals("x")) {
                    if(g.substring(charPos+1,charPos+2).equals("^")) {
                        int cPos = charPos;
                        int sLen = strLength;
                        boolean fallout = false;
                        do {
                            try {
                                if(g.substring(cPos+2,cPos+3).equals(" ")) {
                                    if(Integer.parseInt(g.substring(charPos+2,cPos+2)) > 1) {
                                        int v = Integer.parseInt(g.substring(charPos+2,cPos+2));
                                        yscale = (int) Math.pow(1.7*v,1.7*v);
                                    }
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")" + g.substring(cPos+2,g.length());
                                    fallout = true;
                                }
                            } catch(Exception e1) {
                                try {
                                    if(Integer.parseInt(g.substring(charPos+2,cPos+2)) > 1) {
                                        int v = Integer.parseInt(g.substring(charPos+2,cPos+2));
                                        yscale = (int) Math.pow(1.7*v,1.7*v);
                                    }
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")";
                                    fallout = true;
                                } catch(Exception e2) {
                                }
                            }
                            cPos++;
                        } while(cPos < sLen && !fallout);
                    }
                }
                try {
                    if(g.substring(charPos,charPos+5).equals("sin x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.sin(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.sin(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("cos x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.cos(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.cos(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("tan x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.tan(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.tan(x)";
                        }
                    }
                } catch(Exception e) {
                }
            } catch(Exception e) {
            }
            charPos++;
        } while(charPos < strLength);
        
        graphing = g;

        setGraph();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed

        if(!operationSelected) {
            buttonClick = "number";
            if(jtxtDisplay.getText().length() >= 1) {
                if(!jtxtDisplay.getText().contains(".")) {
                    jtxtDisplay.setText(jtxtDisplay.getText() + ".");
                }
            } else {
                jtxtDisplay.setText("0.");
            }
            whichNumber = "firstNumber";
            try {
                firstNumber = Double.parseDouble(jtxtDisplay.getText());
            } catch(Exception e) {
            }
        } else {
            if(buttonClick.equals("number")) {
                if(!jtxtDisplay.getText().contains(".")) {
                    jtxtDisplay.setText(jtxtDisplay.getText() + ".");
                }
                whichNumber = "secondNumber";
                try {
                    secondNumber = Double.parseDouble(jtxtDisplay.getText());
                } catch(Exception e) {
                }
            }
            if(buttonClick.equals("operation")) {
                buttonClick = "number";
                jtxtDisplay.setText("0.");
                whichNumber = "secondNumber";
                try {
                    secondNumber = Double.parseDouble(jtxtDisplay.getText());
                } catch(Exception e) {
                }
            }
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            jtxtDisplay.setText(jtxtDisplay.getText().substring(0, jtxtDisplay.getText().length() - 1));
            if(whichNumber.equals("firstNumber")) {
                firstNumber = Double.parseDouble(jtxtDisplay.getText());
            } else if(whichNumber.equals("secondNumber")) {
                secondNumber = Double.parseDouble(jtxtDisplay.getText());
            }
        } catch(Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "minus";
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        getNumber("8");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        getNumber("9");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        getNumber("4");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        getNumber("5");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        getNumber("6");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        getNumber("1");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

        getNumber("2");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        getNumber("3");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed

        getNumber("0");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "times";
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "divide";
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "percent";
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed

        if(whichNumber.equals("firstNumber")) {
            firstNumber *= -1;
            jtxtDisplay.setText("" + firstNumber);
        } else if(whichNumber.equals("secondNumber")) {
            secondNumber *= -1;
            jtxtDisplay.setText("" + secondNumber);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "sin";

        if(operationSelected) {
            if(operation.equals("sin")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.sin(Math.toRadians(firstNumber));
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "asin";

        if(operationSelected) {
            if(operation.equals("asin")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.toDegrees(Math.asin(firstNumber));
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "tan";

        if(operationSelected) {
            if(operation.equals("tan")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.tan(Math.toRadians(firstNumber));
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "cos";

        if(operationSelected) {
            if(operation.equals("cos")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.cos(Math.toRadians(firstNumber));
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "atan";

        if(operationSelected) {
            if(operation.equals("atan")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.toDegrees(Math.atan(firstNumber));
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "xtothey";
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "rootx";

        if(operationSelected) {
            if(operation.equals("rootx")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.sqrt(firstNumber);
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "acos";

        if(operationSelected) {
            if(operation.equals("acos")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.toDegrees(Math.acos(firstNumber));
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed

        buttonClick = "operation";

        operationSelected = true;
        operation = "1overx";

        if(operationSelected) {
            if(operation.equals("1overx")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = 1/firstNumber;
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        
        if(!graphOn) {
            setPreferredSize(new Dimension(840, 440));
            pack();
            
            graph.show();
            
            Graphics g = graph.getGraphics();

            g.setColor(new Color(200, 240, 200));
            g.fillRect(0, 0, 360, 260);
            
            for(int yy=0; yy<260; yy+=10) {
                if(yy%30==0) {
                    g.drawLine(0, yy, 360, yy);
                }
            }
            for(int xx=0; xx<360; xx+=10) {
                if(xx%30==0) {
                    g.drawLine(xx, 0, xx, 260);
                }
            }

            graphOn = true;

        } else {
            setPreferredSize(new Dimension(440, 440));
            pack();
            
            graphOn = false;
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed

        if(operationSelected) {
            if(operation.equals("plus")) {
                buttonClick = "equals";
                operation = "";
                operationSelected = false;
                result = firstNumber + secondNumber;
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            } else if(operation.equals("minus")) {
                buttonClick = "equals";
                operation = "";
                operationSelected = false;
                result = firstNumber - secondNumber;
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            } else if(operation.equals("times")) {
                buttonClick = "equals";
                operation = "";
                operationSelected = false;
                result = firstNumber * secondNumber;
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            } else if(operation.equals("divide")) {
                buttonClick = "equals";
                operation = "";
                operationSelected = false;
                result = firstNumber / secondNumber;
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            } else if(operation.equals("percent")) {
                buttonClick = "equals";
                operation = "";
                operationSelected = false;
                result = firstNumber * (secondNumber / 100);
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            } else if(operation.equals("xtothey")) {
                buttonClick = "operation";
                operation = "";
                operationSelected = false;
                result = Math.pow(firstNumber, secondNumber);
                jtxtDisplay.setText("" + result);
                whichNumber = "firstNumber";
                firstNumber = result;
                secondNumber = 0;
            }
        }
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed

        xscale /= 2;
        yscale /= 2;
        
        String g = jtxtDisplay.getText();
        
        int charPos = 0;
        int strLength = g.length();
        
        do {
            strLength = g.length();
            try {
                if(g.substring(charPos,charPos+1).equals("x")) {
                    if(g.substring(charPos+1,charPos+2).equals("^")) {
                        int cPos = charPos;
                        int sLen = strLength;
                        boolean fallout = false;
                        do {
                            try {
                                if(g.substring(cPos+2,cPos+3).equals(" ")) {
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")" + g.substring(cPos+2,g.length());
                                    fallout = true;
                                }
                            } catch(Exception e1) {
                                try {
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")";
                                    fallout = true;
                                } catch(Exception e2) {
                                }
                            }
                            cPos++;
                        } while(cPos < sLen && !fallout);
                    }
                }
                try {
                    if(g.substring(charPos,charPos+5).equals("sin x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.sin(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.sin(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("cos x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.cos(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.cos(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("tan x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.tan(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.tan(x)";
                        }
                    }
                } catch(Exception e) {
                }
            } catch(Exception e) {
            }
            charPos++;
        } while(charPos < strLength);
        
        graphing = g;

        setGraph();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        
        xscale *= 2;
        yscale *= 2;
        
        String g = jtxtDisplay.getText();
        
        int charPos = 0;
        int strLength = g.length();
        
        do {
            strLength = g.length();
            try {
                if(g.substring(charPos,charPos+1).equals("x")) {
                    if(g.substring(charPos+1,charPos+2).equals("^")) {
                        int cPos = charPos;
                        int sLen = strLength;
                        boolean fallout = false;
                        do {
                            try {
                                if(g.substring(cPos+2,cPos+3).equals(" ")) {
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")" + g.substring(cPos+2,g.length());
                                    fallout = true;
                                }
                            } catch(Exception e1) {
                                try {
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")";
                                    fallout = true;
                                } catch(Exception e2) {
                                }
                            }
                            cPos++;
                        } while(cPos < sLen && !fallout);
                    }
                }
                try {
                    if(g.substring(charPos,charPos+5).equals("sin x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.sin(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.sin(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("cos x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.cos(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.cos(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("tan x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.tan(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.tan(x)";
                        }
                    }
                } catch(Exception e) {
                }
            } catch(Exception e) {
            }
            charPos++;
        } while(charPos < strLength);
        
        graphing = g;

        setGraph();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed

        if(t2 != null)
            if(t2.isAlive())
                try {
                    t2.join();
                } catch(Exception e) {
                }
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y += 35;
                dograph();
            }
        });
        t2.start();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed

        if(t2 != null)
            if(t2.isAlive())
                try {
                    t2.join();
                } catch(Exception e) {
                }
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                y -= 35;
                dograph();
            }
        });
        t2.start();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed

        if(t2 != null)
            if(t2.isAlive())
                try {
                    t2.join();
                } catch(Exception e) {
                }
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                x += 35;
                dograph();
            }
        });
        t2.start();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed

        if(t2 != null)
            if(t2.isAlive())
                try {
                    t2.join();
                } catch(Exception e) {
                }
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                x -= 35;
                dograph();
            }
        });
        t2.start();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void dograph() {

        String g = jtxtDisplay.getText();
        
        int charPos = 0;
        int strLength = g.length();
        
        do {
            strLength = g.length();
            try {
                if(g.substring(charPos,charPos+1).equals("x")) {
                    if(g.substring(charPos+1,charPos+2).equals("^")) {
                        int cPos = charPos;
                        int sLen = strLength;
                        boolean fallout = false;
                        do {
                            try {
                                if(g.substring(cPos+2,cPos+3).equals(" ")) {
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")" + g.substring(cPos+2,g.length());
                                    fallout = true;
                                }
                            } catch(Exception e1) {
                                try {
                                    g = g.substring(0,charPos) + "Math.pow(x," + g.substring(charPos+2,cPos+2) + ")";
                                    fallout = true;
                                } catch(Exception e2) {
                                }
                            }
                            cPos++;
                        } while(cPos < sLen && !fallout);
                    }
                }
                try {
                    if(g.substring(charPos,charPos+5).equals("sin x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.sin(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.sin(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("cos x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.cos(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.cos(x)";
                        }
                    }
                    if(g.substring(charPos,charPos+5).equals("tan x")) {
                        try {
                            g = g.substring(0,charPos) + "Math.tan(x)" + g.substring(charPos+11,g.length());
                        } catch(Exception e) {
                            g = g.substring(0,charPos) + "Math.tan(x)";
                        }
                    }
                } catch(Exception e) {
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            charPos++;
        } while(charPos < strLength);
        
        graphing = g;

        setGraph();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphingCalculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graph;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextField jtxtDisplay;
    // End of variables declaration//GEN-END:variables
}