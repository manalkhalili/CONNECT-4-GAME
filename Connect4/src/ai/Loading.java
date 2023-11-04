/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author arafa
 */
public class Loading extends javax.swing.JFrame {
    

   
    private Container cp;
    private OurThread ourthread=new OurThread();
    private  Game game= new Game("R", "Y", 6, 7);
     int rows=6;
    int columns=7;
    private ImageIcon iconEmpty = null;
    private ImageIcon iconRed = null;
    private ImageIcon iconYellow = null;
    private ImageIcon iconYellowsmallcircle = null;
    private ImageIcon iconRedsmallcircle = null;
   public static int secound=0;
    static int minute=0;
    static boolean stateForTimer=true;
    private JButton bb[];
    private boolean flag=false;
    private int hardflag=-1;
    private node root;
     private Thread n;
    private boolean player1turn;
    
    /**
     * Creates new form Loading
     */
    public Loading() {
        initComponents();
        String Emptyimg = "ai/empty.png";
        URL imgURL = getClass().getClassLoader().getResource(Emptyimg);
        if (imgURL != null)
        iconEmpty = new ImageIcon(imgURL);
        /////////////////////////////////////////////
        String Redimg = "ai/red.png";
        imgURL = getClass().getClassLoader().getResource(Redimg);
        if (imgURL != null)
       iconRed = new ImageIcon(imgURL);
        /////////////////////////////////////////////
        String Yellowimg = "ai/yellow.png";
        imgURL = getClass().getClassLoader().getResource(Yellowimg);
        if (imgURL != null) iconYellow = new ImageIcon(imgURL);
         /////////////////////////////////////////////
        String YellowSmall = "ai/yellow-removebg-preview.png";
         
        imgURL = getClass().getClassLoader().getResource(YellowSmall);
        if (imgURL != null) iconYellowsmallcircle = new ImageIcon(imgURL);
        else
            System.err.println("nmnmnm");
        /////////////////////////////////////////////
        String RedSmall = "ai/red-removebg-preview.png";
         
        imgURL = getClass().getClassLoader().getResource(RedSmall);
        if (imgURL != null) iconRedsmallcircle = new ImageIcon(imgURL);
        //JOptionPane.showMessageDialog(null, game.isIs1playing());
        

        //cp = getContentPane();
        //cp.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JButton b[][]={{jButton0,jButton1,jButton2,jButton3,jButton4,jButton5,jButton6},
        {jButton10,jButton11,jButton12,jButton13,jButton14,jButton15,jButton16},
        {jButton20,jButton21,jButton22,jButton23,jButton24,jButton25,jButton26},
        {jButton30,jButton31,jButton32,jButton33,jButton34,jButton35,jButton36},
        {jButton40,jButton41,jButton42,jButton43,jButton44,jButton45,jButton46},
        {jButton50,jButton51,jButton52,jButton53,jButton54,jButton55,jButton56}};
          bb=new JButton[42];
        int counter=0;
              for(int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                JButton button =b[row][col];
                // use setter to set text and icon

               button.setName(Integer.toString((row * 10 + col)));
             
                button.addActionListener(actionEvent -> ButtonClick(((JButton) (actionEvent.getSource()))));
                
             button.addMouseMotionListener(new MouseMotionAdapter(){
                 public void mouseMoved(MouseEvent e) {
                  
                     JButton b=(JButton) e.getSource();
                     int x = Integer.parseInt(b.getName());
                  if (x==0 || x==10 || x==20 || x==30 || x==40 || x==50)
                  {
                     COL1Label.setVisible(true);
                     Col2Label.setVisible(false);
                     Col3Label.setVisible(false);
                    Col4Label.setVisible(false);
                    COL5Label.setVisible(false);
                    Col6Label.setVisible(false);
                     Col7Label.setVisible(false);
                  }
                     if (x==1 || x==11 || x==21 || x==31 || x==41 || x==51)
                  {
                     COL1Label.setVisible(false);
                     Col2Label.setVisible(true);
                     Col3Label.setVisible(false);
                    Col4Label.setVisible(false);
                    COL5Label.setVisible(false);
                    Col6Label.setVisible(false);
                     Col7Label.setVisible(false);
                  }
                     if (x==2 || x==12 || x==22 || x==32 || x==42 || x==52)
                  {
                     COL1Label.setVisible(false);
                     Col2Label.setVisible(false);
                     Col3Label.setVisible(true);
                    Col4Label.setVisible(false);
                    COL5Label.setVisible(false);
                    Col6Label.setVisible(false);
                     Col7Label.setVisible(false);
                  }
                  if (x==3 || x==13 || x==23 || x==33 || x==43 || x==53)
                  {
                     COL1Label.setVisible(false);
                     Col2Label.setVisible(false);
                     Col3Label.setVisible(false);
                    Col4Label.setVisible(true);
                    COL5Label.setVisible(false);
                    Col6Label.setVisible(false);
                     Col7Label.setVisible(false);
                  }
                 if (x==4 || x==14 || x==24 || x==34 || x==44 || x==54)
                  {
                     COL1Label.setVisible(false);
                     Col2Label.setVisible(false);
                     Col3Label.setVisible(false);
                    Col4Label.setVisible(false);
                    COL5Label.setVisible(true);
                    Col6Label.setVisible(false);
                     Col7Label.setVisible(false);
                  }
                 if (x==5 || x==15 || x==25 || x==35 || x==45 || x==55)
                  {
                     COL1Label.setVisible(false);
                     Col2Label.setVisible(false);
                     Col3Label.setVisible(false);
                    Col4Label.setVisible(false);
                    COL5Label.setVisible(false);
                    Col6Label.setVisible(true);
                     Col7Label.setVisible(false);
                  }
                if (x==6 || x==16 || x==26 || x==36 || x==46 || x==56)
                  {
                     COL1Label.setVisible(false);
                     Col2Label.setVisible(false);
                     Col3Label.setVisible(false);
                    Col4Label.setVisible(false);
                    COL5Label.setVisible(false);
                    Col6Label.setVisible(false);
                     Col7Label.setVisible(true);
                  }
                 }
             });
     
                  bb[counter]=button;
                counter++;
            }
        }
    }
   private void ButtonClick(JButton button) {
        int row10plusCol = Integer.parseInt(button.getName());
        int col = row10plusCol % 10;
         player1turn = game.isIs1playing();
        int addedRow = game.PlayerTone(col);
       if(addedRow != -1) {
            if(flag==false){
               if(game.isIs1playing()) {
            	ourthread.add(iconEmpty, iconYellow,addedRow,rows,col,cp,columns,bb);
                  ToneLabel.setIcon(iconRedsmallcircle);
            	ourthread.start();
            }
                else {
            	ourthread.add(iconEmpty, iconRed,addedRow,rows,col,cp,columns,bb);
                  ToneLabel.setIcon(iconYellowsmallcircle);
            	ourthread.start();
            }
            }
            /////////////////////////////////////////////////////////
            else {
              if(hardflag==0){
                 if(game.isIs1playing()){
                ourthread.add(iconEmpty, iconRed,addedRow,rows,col,cp,columns,bb);
            	ourthread.start();
                    }
                }
                if(hardflag==1){
                         if(game.isIs1playing()){
                          
                       	ourthread.add(iconEmpty, iconRed,addedRow,rows,col,cp,columns,bb);
                ourthread.start();
                    }
                }
                if(hardflag==2){
                     if(game.isIs1playing()){
                       	ourthread.add(iconEmpty, iconRed,addedRow,rows,col,cp,columns,bb);
                ourthread.start();
                    }
                }
            }
                     /*    try {
                             n.sleep(900);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(Loading.class.getName()).log(Level.SEVERE, null, ex);
                         }*/
                checkforwin(col);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a valid position.");
        }
    }
           public void resetBoard() {
        for(int row = 0; row < rows; row++)
            for (int col = 0; col < columns; col++)
            {
                bb[col + columns * row].setIcon(iconEmpty);
            }
        
    }
   String imgEmptyFilename = "images/empty.png";
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StartPanel = new javax.swing.JPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        LoadingText = new javax.swing.JLabel();
        LoadingNum = new javax.swing.JLabel();
        StartLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BackImage = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        GameModePanel = new javax.swing.JPanel();
        OVOPael = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        OVPCmodePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BackGroundLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LeveldifficultyPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        HardLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        MediumLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EasyLabel = new javax.swing.JLabel();
        BackGroundLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Game = new javax.swing.JPanel();
        ToneLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        COL1Label = new javax.swing.JLabel();
        Col2Label = new javax.swing.JLabel();
        Col3Label = new javax.swing.JLabel();
        Col4Label = new javax.swing.JLabel();
        COL5Label = new javax.swing.JLabel();
        Col6Label = new javax.swing.JLabel();
        Col7Label = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        MinuteLbel = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        SecoundLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton0 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        BackGroundLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1010, 696));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        StartPanel.setBackground(new java.awt.Color(0, 153, 51));
        StartPanel.setForeground(new java.awt.Color(0, 0, 0));
        StartPanel.setPreferredSize(new java.awt.Dimension(920, 500));
        StartPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar2.setBackground(new java.awt.Color(255, 153, 153));
        jProgressBar2.setForeground(new java.awt.Color(0, 0, 102));
        StartPanel.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 990, 30));

        LoadingText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LoadingText.setText("Loading...");
        StartPanel.add(LoadingText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 180, 40));

        LoadingNum.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        LoadingNum.setText("0%");
        StartPanel.add(LoadingNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 580, 90, 40));

        StartLabel.setBackground(new java.awt.Color(255, 255, 255));
        StartLabel.setFont(new java.awt.Font("Kristen ITC", 0, 80)); // NOI18N
        StartLabel.setForeground(new java.awt.Color(255, 255, 255));
        StartLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/start_80px.png"))); // NOI18N
        StartLabel.setText("START");
        StartLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                StartLabelMouseMoved(evt);
            }
        });
        StartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StartLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StartLabelMousePressed(evt);
            }
        });
        StartPanel.add(StartLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 410, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/robot_2_96px.png"))); // NOI18N
        StartPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 170));

        BackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/backkk.jpg"))); // NOI18N
        BackImage.setText(" ");
        StartPanel.add(BackImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 540));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/complete.jpg"))); // NOI18N
        StartPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 990, 100));

        getContentPane().add(StartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 650));

        GameModePanel.setPreferredSize(new java.awt.Dimension(920, 504));
        GameModePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OVOPael.setBackground(new java.awt.Color(135, 68, 42));
        OVOPael.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0)));
        OVOPael.setPreferredSize(new java.awt.Dimension(350, 180));
        OVOPael.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                OVOPaelMouseMoved(evt);
            }
        });
        OVOPael.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OVOPaelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OVOPaelMouseExited(evt);
            }
        });
        OVOPael.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/person_80px.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        OVOPael.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 80, 140));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/vs_button_96px.png"))); // NOI18N
        OVOPael.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, 90));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/person_80px.png"))); // NOI18N
        OVOPael.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, 120));

        GameModePanel.add(OVOPael, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 390, 220));

        OVPCmodePanel.setBackground(new java.awt.Color(135, 68, 42));
        OVPCmodePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0), new java.awt.Color(102, 0, 0)));
        OVPCmodePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                OVPCmodePanelMouseMoved(evt);
            }
        });
        OVPCmodePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OVPCmodePanelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OVPCmodePanelMouseExited(evt);
            }
        });
        OVPCmodePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/person_80px.png"))); // NOI18N
        jLabel10.setText("jLabel2");
        OVPCmodePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 80, 120));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/vs_button_96px.png"))); // NOI18N
        OVPCmodePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 90, 80));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/test3-removebg-preview.png"))); // NOI18N
        OVPCmodePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 110, 100));

        GameModePanel.add(OVPCmodePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 380, 220));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MODE");
        jLabel3.setToolTipText("");
        GameModePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 270, 110));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CHOOSE GAME");
        GameModePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 620, 110));

        BackGroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/backGround1.jpg"))); // NOI18N
        BackGroundLabel.setMinimumSize(new java.awt.Dimension(920, 500));
        BackGroundLabel.setPreferredSize(new java.awt.Dimension(920, 500));
        GameModePanel.add(BackGroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 560));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CHOOSE GAME");
        GameModePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 620, 110));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 75)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MODE");
        jLabel7.setToolTipText("");
        GameModePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 270, 110));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/complete.jpg"))); // NOI18N
        GameModePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 990, -1));

        getContentPane().add(GameModePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 650));

        LeveldifficultyPanel.setMinimumSize(new java.awt.Dimension(920, 500));
        LeveldifficultyPanel.setPreferredSize(new java.awt.Dimension(920, 504));
        LeveldifficultyPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/mind_map_200px.png"))); // NOI18N
        LeveldifficultyPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 220, 180));

        HardLabel.setBackground(new java.awt.Color(255, 255, 255));
        HardLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 90)); // NOI18N
        HardLabel.setForeground(new java.awt.Color(255, 255, 255));
        HardLabel.setText("HARD");
        HardLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                HardLabelMouseMoved(evt);
            }
        });
        HardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HardLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HardLabelMouseExited(evt);
            }
        });
        LeveldifficultyPanel.add(HardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 300, 130));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/robot-vector-icon-png_281851-removebg-preview.png"))); // NOI18N
        LeveldifficultyPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 320, 310));

        MediumLabel.setBackground(new java.awt.Color(255, 255, 255));
        MediumLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 90)); // NOI18N
        MediumLabel.setForeground(new java.awt.Color(255, 255, 255));
        MediumLabel.setText("MEDIUM");
        MediumLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MediumLabelMouseMoved(evt);
            }
        });
        MediumLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MediumLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MediumLabelMouseExited(evt);
            }
        });
        LeveldifficultyPanel.add(MediumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 440, 110));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 80)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/broken_robot_100px.png"))); // NOI18N
        jLabel6.setText("Level difficulty:");
        LeveldifficultyPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 800, 110));

        EasyLabel.setBackground(new java.awt.Color(255, 255, 255));
        EasyLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 90)); // NOI18N
        EasyLabel.setForeground(new java.awt.Color(255, 255, 255));
        EasyLabel.setText("EASY");
        EasyLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                EasyLabelMouseMoved(evt);
            }
        });
        EasyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EasyLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EasyLabelMouseExited(evt);
            }
        });
        LeveldifficultyPanel.add(EasyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 230, 140));

        BackGroundLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/backGround1.jpg"))); // NOI18N
        BackGroundLabel2.setMinimumSize(new java.awt.Dimension(920, 500));
        BackGroundLabel2.setPreferredSize(new java.awt.Dimension(920, 500));
        LeveldifficultyPanel.add(BackGroundLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 560));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/complete.jpg"))); // NOI18N
        LeveldifficultyPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 990, -1));

        getContentPane().add(LeveldifficultyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 650));

        Game.setMinimumSize(new java.awt.Dimension(920, 500));
        Game.setPreferredSize(new java.awt.Dimension(920, 504));
        Game.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ToneLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/red-removebg-preview.png"))); // NOI18N
        ToneLabel.setText("jLabel21");
        Game.add(ToneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 100, 110));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        Game.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 101, 200, 3));

        COL1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/sort_down_100px.png"))); // NOI18N
        Game.add(COL1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 50));

        Col2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/sort_down_100px.png"))); // NOI18N
        Game.add(Col2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 100, 50));

        Col3Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/sort_down_100px.png"))); // NOI18N
        Game.add(Col3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 100, 50));

        Col4Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/sort_down_100px.png"))); // NOI18N
        Game.add(Col4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 100, 50));

        COL5Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/sort_down_100px.png"))); // NOI18N
        Game.add(COL5Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 100, 50));

        Col6Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/sort_down_100px.png"))); // NOI18N
        Game.add(Col6Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 100, 50));

        Col7Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/sort_down_100px.png"))); // NOI18N
        Game.add(Col7Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 100, 50));

        jLabel14.setBackground(new java.awt.Color(102, 102, 255));
        jLabel14.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/stopwatch_60px.png"))); // NOI18N
        jLabel14.setText("Timer:");
        Game.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 220, 80));

        jLabel15.setBackground(new java.awt.Color(102, 102, 255));
        jLabel15.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 255));
        jLabel15.setText("Player tone:");
        Game.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 220, -1));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        MinuteLbel.setBackground(new java.awt.Color(255, 255, 255));
        MinuteLbel.setFont(new java.awt.Font("Gadugi", 1, 64)); // NOI18N
        MinuteLbel.setForeground(new java.awt.Color(255, 255, 255));
        MinuteLbel.setText("00");
        jPanel5.add(MinuteLbel);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Gadugi", 1, 64)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(":");
        jPanel5.add(jLabel20);

        SecoundLabel.setBackground(new java.awt.Color(255, 255, 255));
        SecoundLabel.setFont(new java.awt.Font("Gadugi", 1, 64)); // NOI18N
        SecoundLabel.setForeground(new java.awt.Color(255, 255, 255));
        SecoundLabel.setText("00");
        jPanel5.add(SecoundLabel);

        Game.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 200, 100));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        Game.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, 190, 10));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton0.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton0.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton0.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton0MouseMoved(evt);
            }
        });
        jButton0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton0MouseExited(evt);
            }
        });
        jPanel2.add(jButton0, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton10.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton10.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 100, 100));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton20.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton20.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 100, 100));

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton21.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton21.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 100, 100));

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton22.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton22.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 100));

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton23.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton23.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 100, 100));

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton24.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton24.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 100, 100));

        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton25.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton25.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 100, 100));

        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton26.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton26.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 100, 100));

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton32.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton32.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 100, 100));

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton33.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton33.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 100, 100));

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton34.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton34.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 100, 100));

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton35.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton35.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 100, 100));

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton36.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton36.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 100, 100));

        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton46.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton46.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 100, 100));

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton40.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton40.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 100, 100));

        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton41.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton41.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 100, 100));

        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton42.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton42.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 100, 100));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton2.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 100, 100));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 100));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton3.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 100, 100));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton4.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 100, 100));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton5.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 100, 100));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton6.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 100));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton11.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton11.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 100, 100));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton12.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton12.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 100, 100));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton13.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton13.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 100, 100));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton14.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton14.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 100, 100));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton15.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton15.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 100, 100));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton16.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton16.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 100, 100));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton30.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton30.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 100, 100));

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton31.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton31.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 100, 100));

        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton43.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton43.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 100, 100));

        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton44.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton44.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 100, 100));

        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton45.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton45.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 100, 100));

        jButton53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton53.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton53.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, 100, 100));

        jButton51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton51.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton51.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 100, 100));

        jButton52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton52.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton52.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 100, 100));

        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton56.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton56.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, 100, 100));

        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton55.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton55.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 100, 100));

        jButton54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton54.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton54.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 100, 100));

        jButton50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/empty.png"))); // NOI18N
        jButton50.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton50.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel2.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 100, 100));

        Game.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 700, 600));

        BackGroundLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ai/hand-painted-watercolor-background-with-sky-clouds-shape.jpg"))); // NOI18N
        BackGroundLabel3.setMinimumSize(new java.awt.Dimension(920, 500));
        BackGroundLabel3.setPreferredSize(new java.awt.Dimension(920, 500));
        BackGroundLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BackGroundLabel3MouseMoved(evt);
            }
        });
        Game.add(BackGroundLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 650));

        getContentPane().add(Game, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void StartLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartLabelMouseMoved
        // TODO add your handling code here:
          StartLabel.setForeground(Color.black);
          
    }//GEN-LAST:event_StartLabelMouseMoved

    private void StartLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartLabelMouseExited
        // TODO add your handling code here:
         StartLabel.setForeground(Color.white);
    }//GEN-LAST:event_StartLabelMouseExited

    private void StartLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartLabelMousePressed
        // TODO add your handling code here:
         StartPanel.setVisible(false);
        GameModePanel.setVisible(true);
        LeveldifficultyPanel.setVisible(false);
        Game.setVisible(false);
    }//GEN-LAST:event_StartLabelMousePressed

    private void OVPCmodePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OVPCmodePanelMouseClicked
        // TODO add your handling code here:
          StartPanel.setVisible(false);
        GameModePanel.setVisible(false);
        LeveldifficultyPanel.setVisible(true);
        Game.setVisible(false);
        flag=true;
    }//GEN-LAST:event_OVPCmodePanelMouseClicked

    private void OVPCmodePanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OVPCmodePanelMouseMoved
        // TODO add your handling code here:
        OVPCmodePanel.setBackground(Color.black);
    }//GEN-LAST:event_OVPCmodePanelMouseMoved

    private void OVPCmodePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OVPCmodePanelMouseExited
        // TODO add your handling code here:
          OVPCmodePanel.setBackground(new Color(135, 68, 42));
    }//GEN-LAST:event_OVPCmodePanelMouseExited

    private void EasyLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EasyLabelMouseMoved
        // TODO add your handling code here:
          EasyLabel.setForeground(Color.black);
        
    }//GEN-LAST:event_EasyLabelMouseMoved

    private void EasyLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EasyLabelMouseExited
        // TODO add your handling code here:
          EasyLabel.setForeground(Color.white);
    }//GEN-LAST:event_EasyLabelMouseExited

    private void MediumLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MediumLabelMouseMoved
        // TODO add your handling code here:
          MediumLabel.setForeground(Color.black);
    }//GEN-LAST:event_MediumLabelMouseMoved

    private void MediumLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MediumLabelMouseExited
        // TODO add your handling code here:
          MediumLabel.setForeground(Color.white);
    }//GEN-LAST:event_MediumLabelMouseExited

    private void HardLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HardLabelMouseMoved
        // TODO add your handling code here:
          HardLabel.setForeground(Color.black);
    }//GEN-LAST:event_HardLabelMouseMoved

    private void HardLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HardLabelMouseExited
        // TODO add your handling code here:
          HardLabel.setForeground(Color.white);
    }//GEN-LAST:event_HardLabelMouseExited

    private void EasyLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EasyLabelMouseClicked
        // TODO add your handling code here:
         StartPanel.setVisible(false);
        GameModePanel.setVisible(false);
        LeveldifficultyPanel.setVisible(false);
        Game.setVisible(true);
       COL1Label.setVisible(false);
        Col2Label.setVisible(false);
        Col3Label.setVisible(false);
        Col4Label.setVisible(false);
        
        COL5Label.setVisible(false);
        Col6Label.setVisible(false);
        Col7Label.setVisible(false);
        timeStart();
        
        int matr[][]=new int[6][7];
        for(int r=0;r<6;r++)
        {
            for(int c=0;c<7;c++)
            {
             matr[r][c]=0;
            }
        }
         root=new node(matr);
        root.setColor(1);
        root.setCol(0);
        root=noderec(root,0);
        hardflag=0;
        root.setIndex((int)(Math.random() * 6));
         if(game.isIs1playing()){
             int y=game.PlayerTone(root.getIndex());
                  ourthread.add(iconEmpty, iconYellow,y,rows,root.getIndex(),cp,columns,bb);
            	ourthread.start();
                 checkforwin(root.getIndex());
              }
        
        
        
    }//GEN-LAST:event_EasyLabelMouseClicked

    private void jButton0MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton0MouseMoved
        // TODO add your handling code here:
       
      
    }//GEN-LAST:event_jButton0MouseMoved

    private void jButton0MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton0MouseExited
        // TODO add your handling code here:
        COL1Label.setVisible(false);
        Col2Label.setVisible(false);
        Col3Label.setVisible(false);
        Col4Label.setVisible(false);
        COL5Label.setVisible(false);
        Col6Label.setVisible(false);
        Col7Label.setVisible(false);
    }//GEN-LAST:event_jButton0MouseExited

    private void OVOPaelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OVOPaelMouseClicked
        // TODO add your handling code here:
        StartPanel.setVisible(false);
        GameModePanel.setVisible(false);
        LeveldifficultyPanel.setVisible(false);
        Game.setVisible(true);
       COL1Label.setVisible(false);
        Col2Label.setVisible(false);
        Col3Label.setVisible(false);
        Col4Label.setVisible(false);
        
        COL5Label.setVisible(false);
        Col6Label.setVisible(false);
        Col7Label.setVisible(false);
        timeStart();
    }//GEN-LAST:event_OVOPaelMouseClicked

    private void OVOPaelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OVOPaelMouseMoved
        // TODO add your handling code here:
       
        

        OVOPael.setBackground(Color.BLACK);
       
    }//GEN-LAST:event_OVOPaelMouseMoved

    private void BackGroundLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackGroundLabel3MouseMoved
        // TODO add your handling code here:
         COL1Label.setVisible(false);
                     Col2Label.setVisible(false);
                     Col3Label.setVisible(false);
                    Col4Label.setVisible(false);
                    COL5Label.setVisible(false);
                    Col6Label.setVisible(false);
                     Col7Label.setVisible(false);
    }//GEN-LAST:event_BackGroundLabel3MouseMoved
    
    private void HardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HardLabelMouseClicked
        // TODO add your handling code here:
        StartPanel.setVisible(false);
        GameModePanel.setVisible(false);
        LeveldifficultyPanel.setVisible(false);
        Game.setVisible(true);
       COL1Label.setVisible(false);
        Col2Label.setVisible(false);
        Col3Label.setVisible(false);
        Col4Label.setVisible(false);
        
        COL5Label.setVisible(false);
        Col6Label.setVisible(false);
        Col7Label.setVisible(false);
        timeStart();
        int matr[][]=new int[6][7];
        for(int r=0;r<6;r++)
        {
            for(int c=0;c<7;c++)
            {
             matr[r][c]=0;
            }
        }
         root=new node(matr);
        root.setColor(1);
        root.setCol(0);
        root=noderec(root,0);
       int x=alpha_beta_pruning(root,3,-1000000,1000000,true);
       //
       hardflag=2;
       //JOptionPane.showConfirmDialog(null, root.getIndex());
         if(game.isIs1playing()){
             int y=game.PlayerTone(root.getIndex());
                  ourthread.add(iconEmpty, iconYellow,y,rows,root.getIndex(),cp,columns,bb);
            	ourthread.start();
                 checkforwin(root.getIndex());
              }
        
       //JOptionPane.showMessageDialog(null, x);
        
    }//GEN-LAST:event_HardLabelMouseClicked

    private void MediumLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MediumLabelMouseClicked
        // TODO add your handling code here:
        
          StartPanel.setVisible(false);
        GameModePanel.setVisible(false);
        LeveldifficultyPanel.setVisible(false);
        Game.setVisible(true);
       COL1Label.setVisible(false);
        Col2Label.setVisible(false);
        Col3Label.setVisible(false);
        Col4Label.setVisible(false);
        
        COL5Label.setVisible(false);
        Col6Label.setVisible(false);
        Col7Label.setVisible(false);
        timeStart();
        int matr[][]=new int[6][7];
        for(int r=0;r<6;r++)
        {
            for(int c=0;c<7;c++)
            {
             matr[r][c]=0;
            }
        }
         root=new node(matr);
        root.setColor(1);
        root.setCol(0);
        root=noderec(root,0);
       int x=alpha_beta_pruning(root,1,-1000000,1000000,true);
       //
       hardflag=1;
       //JOptionPane.showConfirmDialog(null, root.getIndex());
         if(game.isIs1playing()){
             int y=game.PlayerTone(root.getIndex());
                  ourthread.add(iconEmpty, iconYellow,y,rows,root.getIndex(),cp,columns,bb);
            	ourthread.start();
                 checkforwin(root.getIndex());
              }
    
    }//GEN-LAST:event_MediumLabelMouseClicked

    private void OVOPaelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OVOPaelMouseExited
        // TODO add your handling code here:
         OVOPael.setBackground(new Color(135, 68, 42));
    }//GEN-LAST:event_OVOPaelMouseExited
    private node noderec(node n,int lvl){
        if(n==null){
            return n;
        }
        if(checkForWinner(n.getCol(),n.getMatrix(),n.getColor())){
       // if(lvl==4){
          
        return n;
        }
        for(int i=0;i<7;i++){
            nodeconstruc(n,i,lvl+1);
        }
        for(int i=0;i<7;i++){
        noderec(n.getArr()[i],lvl+1);
        }
        return n;
    }
    private void nodeconstruc(node a,int c,int level){
        if(a==null){
            return;
        }
        if(level==4){
            return;
        }
      int color=0;
      if(a.getColor()==1){
          color=2;
      }
      else if(a.getColor()==2){
          color=1;
      }
      
       int mat[][]=a.getMatrix();
       int matt[][]=new int[6][7];
          for(int i =0;i<6;i++){
        System.arraycopy(mat[i], 0, matt[i], 0, 7);
    }
      /////////////////////////////////////////
     /* for(int i =0;i<6;i++){
        for(int j=0;j<7;j++){
            System.out.print(matt[i][j]+",");
        }
        System.out.print("\n"); 
               }*/
      ////////////////////////////////////////////
       int r=0;
       while(r<6&& matt[r][c]!=1&& matt[r][c]!=2  ){
   
           r++;
       }
       if(r!=0)
       {
       matt[r-1][c]=color;
     /*
        for(int i =0;i<6;i++){
        for(int j=0;j<7;j++){
            System.out.print(matt[i][j]+",");
                            }
        System.out.print("\n"); 
                              }*/
       
       node n=new node(matt);
       n.setLvl(level);
       n.setColor(color);
       n.setCol(c);
       a.setArr(n, c);
       }
       else{
       a.setArr(null, c);
       }
    }  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
                
                Loading lo=new Loading();
                lo.setVisible(true);
                lo.StartLabel.setVisible(false);
              lo.StartPanel.setVisible(true);
        lo.GameModePanel.setVisible(false);
        lo.Game.setVisible(false);
        lo.LeveldifficultyPanel.setVisible(false);
                Thread th=new Thread();
                th.start();
                try {
                    for (int i=0;i<=100;i++)
                    {
                            th.sleep(10);
                            lo.LoadingNum.setText(i+"%");
                            if(i==50)
                            {
                                lo.LoadingText.setText("Connecting...");
                            }
                               if(i==100)
                            {
                                lo.LoadingText.setText("Start Now..!");
                            }
                    lo.jProgressBar2.setValue(i);
                    lo.setBackground(Color.BLACK);
             
                    }
                    lo.StartLabel.setVisible(true);

                } catch (Exception e) {
                }
            }
    ///////////////////////////////////////////////
    private boolean diagonalwin(int row, int col, boolean rightDiagonal,int ourmatrix[][],int color) {
        int winningStreak = 4;
        int reverser = rightDiagonal ? 1 : -1;
        int rows = 6;
        int columns = 7;
        

        for(int winRow = row - 3, winCol = col - (3 * reverser); winRow <= row + 3; winRow++, winCol += reverser) {
            if (!rightDiagonal) {
                if (winRow < 0 || winCol < 0) continue;
                if (winRow >= rows || winCol >= columns) break;
            } else {
                if(winRow < 0 || winCol >= columns) continue;
                if(winRow >= rows || winCol < 0) break;
            }

            if(ourmatrix[winRow][winCol] != 0 && ourmatrix[winRow][winCol]==color) {
                if (--winningStreak == 0) return true;
            } else winningStreak = 4;
        }
        return false;
    }
  //////////////////////////////////////////////////////////////////////////////////////
    public boolean checkForWinner(int col,int ourmatrix[][],int color) {
        int rows = 6;
        int columns = 7;
        

        for(int row = 0; row < rows; row++) {
            if(ourmatrix[row][col] != 0) {
                // if this reaches 0, we have won
                int winningStreak = 3;

                // check downwards
                for(int winRow = row + 1; winRow < rows; winRow++) {
                    if(ourmatrix[winRow][col]==color) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 3;
                }

                winningStreak = 4;
                // look at the horizontal
                for(int winCol = col - 3; winCol <= col + 3; winCol++) {
                    if(winCol < 0) continue;
                    if(winCol >= columns) break;

                    if(ourmatrix[row][winCol] != 0 && ourmatrix[row][winCol]==color) {
                        winningStreak--;
                        if(winningStreak == 0) return true;
                    } else winningStreak = 4;
                }
                if(diagonalwin(row, col, false,ourmatrix,color)) return true;
                if(diagonalwin(row, col, true,ourmatrix,color)) return true;

                return false;
            }
        }
        return false;
    }
    
    
    ////////////////////////////////////////
   
    public int alpha_beta_pruning(node node,int depth,int alpha,int beta,boolean min_max)
    {
      if(depth==0 || checkForWinner(node.getCol(),node.getMatrix(),node.getColor()))
        {
        return evalution_function(node);
        }
       if(min_max)
        {
            int v=Integer.MIN_VALUE;
           for(int i=0;i<node.getArr().length;i++)
            {
                int eval=alpha_beta_pruning(node.getArr()[i], depth-1, alpha, beta,false);
                v=Integer.max(v,eval);
                if(v>=eval){
                    if(v==eval){
                    node.setIndex(i);
                    }
                }
                alpha=Integer.max(alpha, v);
                node.setEvalfunction(alpha);
                if(beta<=alpha)
                    break;
            }
            return v;
        }
        else 
            if(!min_max)
        {
            int v=Integer.MAX_VALUE;
           for(int i=0;i<node.getArr().length;i++)
            {
                 int eval=alpha_beta_pruning(node.getArr()[i], depth-1, alpha, beta,true);
                v=Integer.min(v,eval);
                if(v>eval){
                    node.setIndex(i);
                }
                beta=Integer.min(beta, v);
                node.setEvalfunction(eval);

                if(beta<=alpha)
                    break;
            }
            return v;
        }
        return 0;
    } 
     ///////////////////////////////////////////////
     private int evalution_function(node node) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
   
    if(node==null){
        
       
        return -1;
    }   
            int ourmatrix[][];
           // JOptionPane.showMessageDialog(null, node.getColor());
            ourmatrix=node.getMatrix();
            int redcounter=0;
            int yellowcounter=0;
        for(int r=5;r>=0;r--){
            for(int c=0;c<=6;c++){
                int x=ourmatrix[r][c];
               // JOptionPane.showMessageDialog(null, x);
                if(x==1){
                    redcounter+=redeval(ourmatrix,r,c);
                }
                if(x==2){
                   // JOptionPane.showMessageDialog(null, "yellow");
                    yellowcounter+=yelloweval(ourmatrix,r,c);
                }
                else if(x==0){
                    yellowcounter+=yelloweval(ourmatrix,r,c);
                    redcounter+=redeval(ourmatrix,r,c);
                }
            }
        }
        return yellowcounter-redcounter;   
    }
     private int yelloweval(int[][] ourmatrix, int r, int c) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // horis
       
       int yellowR=0;
       int yellowC=0;
       int yellowRD=0;
       int yellowLD=0;
       int sum=0;
       if(c<4){
       for(int i=c;i<c+4;i++){
          
           if(ourmatrix[r][i]==1){
               yellowR=0;
               break; 
           }
           else if(ourmatrix[r][i]==2){
               yellowR++;
           }
           
       }
       }
       //JOptionPane.showMessageDialog(null, "yellowR="+yellowR+"r===="+r+"c==="+c);
       ////////////////////////////////////////
       ////vertical
       if(r>=3){
           //JOptionPane.showMessageDialog(null, "in yellowC if");
           for(int i=r;i>r-4;i--){
              // JOptionPane.showMessageDialog(null, "in yellowC loop");
               if(ourmatrix[i][c]==1){
                   yellowC=0;
                   break;
               }
               else if(ourmatrix[i][c]==2){
               //JOptionPane.showMessageDialog(null, "in loop yellow if");
                   
                   yellowC++;
               }
               
           }
       }
       //JOptionPane.showMessageDialog(null, "yellowC="+yellowC);
       ////////////////////////////////////////////
       ///// rightdiagonal
       
       int rr=r;
       int cc=c;
       if(r>2 && c<4){
       for(int i =0;i<4;i++){
           if(ourmatrix[rr][cc]==1){
               yellowRD=0;
               break;
           }
           else if(ourmatrix[rr][cc]==2){
                   yellowRD++;
               }
           if(i!=3){
           rr--;
           cc++;}
           
       }
       
       }
       //JOptionPane.showMessageDialog(null, "yellowRD="+yellowRD);
       //////////////////////////////////
       ////// leftdiagonal
       int rrr=r;
       int ccc=c;
       if(r>2 && c>2){
           for(int i=0;i<4;i++){
                if(ourmatrix[rrr][ccc]==1){
               yellowLD=0;
               break;
           }
            else if(ourmatrix[rrr][ccc]==2){
                   yellowRD++;
               }
           if(i!=3){     
           rrr--;
           ccc--;   }
           
           }
           
       }
       //JOptionPane.showMessageDialog(null, "yellowLD="+yellowLD);
       sum=(yellowR*yellowR*r)+(yellowC*yellowC*5)+(yellowRD*yellowRD*rr)+(yellowLD*yellowLD*rrr);
       //.showMessageDialog(null, "sum"+sum);
       
       return sum;
    }

    private int redeval(int ourmatrix[][], int r, int c) {
        
       int redR=0;
       int redC=0;
       int redRD=0;
       int redLD=0;
       int sum=0;
       if(c<4){
       for(int i=c;i<c+4;i++){
          
           if(ourmatrix[r][i]==2){
               redR=0;
               break; 
           }
           else if(ourmatrix[r][i]==1){
               redR++;
           }
           
       }
       }
       ////////////////////////////////////////
       ////vertical
       if(r>=3){
           for(int i=r;i<r-4;i--){
               if(ourmatrix[i][c]==2){
                   redC=0;
                   break;
               }
               else if(ourmatrix[i][c]==1){
                   redC++;
               }
               
           }
       }
       ////////////////////////////////////////////
       ///// rightdiagonal
       
       int rr=r;
       int cc=c;
       if(r>2 && c<4){
       for(int i =0;i<4;i++){
           if(ourmatrix[rr][cc]==2){
               redRD=0;
               break;
           }
           else if(ourmatrix[rr][cc]==1){
                   redRD++;
               }
           if(i!=3){
           rr--;
           cc++;}
           
       }
       
       }
       //////////////////////////////////
       ////// leftdiagonal
       int rrr=r;
       int ccc=c;
       if(r>2 && c>2){
           for(int i=0;i<4;i++){
                if(ourmatrix[rrr][ccc]==2){
               redLD=0;
               break;
           }
            else if(ourmatrix[rrr][ccc]==1){
                   redRD++;
               }
           if(i!=3){     
           rrr--;
           ccc--;   }
           
           }
           
       }
       sum=(redR*redR*r)+(redC*redC*5)+(redRD*redRD*rr)+(redLD*redLD*rrr);
       
       return sum;
    }
    public static void timeStart()
    {
        stateForTimer=true;
        Thread t = new Thread(){
            public void run()
        {
    for ( ; ; )
    {
        if (stateForTimer)
        {
            try {
                Thread.sleep(1000);
                secound++;
                if(secound<10)
                SecoundLabel.setText("0"+secound);
                else
                SecoundLabel.setText(""+secound);
                
                if(secound==60){
                    minute++;
                    secound=0;
                    SecoundLabel.setText("0"+secound);
                    if(minute<10)
                    MinuteLbel.setText("0"+minute);
                    else
                        MinuteLbel.setText(""+minute);
                    
                }
                
            } catch (Exception e) {
            }
        }
    }        
        }
        };
        t.start();
       }
        
    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGroundLabel;
    private javax.swing.JLabel BackGroundLabel2;
    private javax.swing.JLabel BackGroundLabel3;
    private javax.swing.JLabel BackImage;
    private javax.swing.JLabel COL1Label;
    private javax.swing.JLabel COL5Label;
    private javax.swing.JLabel Col2Label;
    private javax.swing.JLabel Col3Label;
    private javax.swing.JLabel Col4Label;
    private javax.swing.JLabel Col6Label;
    private javax.swing.JLabel Col7Label;
    private javax.swing.JLabel EasyLabel;
    private javax.swing.JPanel Game;
    private javax.swing.JPanel GameModePanel;
    private javax.swing.JLabel HardLabel;
    private javax.swing.JPanel LeveldifficultyPanel;
    private javax.swing.JLabel LoadingNum;
    private javax.swing.JLabel LoadingText;
    private javax.swing.JLabel MediumLabel;
    public static javax.swing.JLabel MinuteLbel;
    private javax.swing.JPanel OVOPael;
    private javax.swing.JPanel OVPCmodePanel;
    public static javax.swing.JLabel SecoundLabel;
    private javax.swing.JLabel StartLabel;
    private javax.swing.JPanel StartPanel;
    private javax.swing.JLabel ToneLabel;
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar2;
    // End of variables declaration//GEN-END:variables

    private void checkforwin(int col) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 if(game.checkForWinnerInGUI(col)) {
                  if(!game.isIs1playing())   
                JOptionPane.showMessageDialog(null, "Player one won!");
                  else
                JOptionPane.showMessageDialog(null, "Player two won!");
                        
                int reply;
                 reply = JOptionPane.showConfirmDialog(null, "Would you like to play again?", null, JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION) {
                    
                    game.reset(6, 7);
                    resetBoard();
                } else {
                    System.exit(0);
                }
            }
            else{
                         
                     if(hardflag==2){
                     
                  
                        if(game.isIs1playing()){
                            Circles [][] ourP=game.boar();
                            int [][] m=new int [6][7];
                            for(int i=0;i<6;i++){
                                for(int j=0;j<7;j++){
                                    if(ourP[i][j]==null){
                                        m[i][j]=0;
                                        
                                    }
                                    else if(ourP[i][j].getColor().equalsIgnoreCase("Y")){
                                        m[i][j]=2;
                                 //       ToneLabel.setIcon(iconYellowsmallcircle);
                                    }
                                     else if(ourP[i][j].getColor().equalsIgnoreCase("R")){
                                        m[i][j]=1;
                                         ToneLabel.setIcon(iconRedsmallcircle);
                                    }
                                }
                            }
                            root=new node(m);
                            root.setColor(1);
                            root.setCol(0);
                            root=noderec(root,0);
                           int x=alpha_beta_pruning(root,3,-1000000,1000000,true);
                            int y = game.PlayerTone(root.getIndex());
                                          //  JOptionPane.showMessageDialog(null, "in hard flag in if");
                                           

                  ourthread.add(iconEmpty, iconYellow,y,rows,root.getIndex(),cp,columns,bb);
            	ourthread.start();
                            checkforwin(root.getIndex());
              }
                     }
                     if(hardflag==1){
                     
                      
                        if(game.isIs1playing()){
                            Circles [][] ourP=game.boar();
                            int [][] m=new int [6][7];
                            for(int i=0;i<6;i++){
                                for(int j=0;j<7;j++){
                                    if(ourP[i][j]==null){
                                        m[i][j]=0;
                                        
                                    }
                                    else if(ourP[i][j].getColor().equalsIgnoreCase("Y")){
                                        m[i][j]=2;
                                 //            ToneLabel.setIcon(iconYellowsmallcircle);
                                   
                                    }
                                     else if(ourP[i][j].getColor().equalsIgnoreCase("R")){
                                        m[i][j]=1;
                                              ToneLabel.setIcon(iconRedsmallcircle);
                                   
                                    }
                                }
                            }
                            root=new node(m);
                            root.setColor(1);
                            root.setCol(0);
                            root=noderec(root,0);
                           int x=alpha_beta_pruning(root,1,-1000000,1000000,true);
                            int y = game.PlayerTone(root.getIndex());
                                          //  JOptionPane.showMessageDialog(null, "in hard flag in if");
                                           

                  ourthread.add(iconEmpty, iconYellow,y,rows,root.getIndex(),cp,columns,bb);
            	ourthread.start();
                            checkforwin(root.getIndex());
              }
            }
    ////////////////////////////////////////////////////////////////////////////////////////////////////                 
                     if(hardflag==0){
                       
                         if(game.isIs1playing()){
                            Circles [][] ourP=game.boar();
                            int [][] m=new int [6][7];
                            for(int i=0;i<6;i++){
                                for(int j=0;j<7;j++){
                                    if(ourP[i][j]==null){
                                        m[i][j]=0;
                                        
                                    }
                                    else if(ourP[i][j].getColor().equalsIgnoreCase("Y")){
                                        m[i][j]=2;
                                        ToneLabel.setIcon(iconYellowsmallcircle);
                                   
                                    }
                                     else if(ourP[i][j].getColor().equalsIgnoreCase("R")){
                                        m[i][j]=1;
                                              ToneLabel.setIcon(iconRedsmallcircle);
                                   
                                    }
                                }
                            }
                            root=new node(m);
                            root.setColor(1);
                            root.setCol(0);
                            root=noderec(root,0);
                           root.setIndex((int)(Math.random() * 6));
                            int y = game.PlayerTone(root.getIndex());
                                          //  JOptionPane.showMessageDialog(null, "in hard flag in if");
                                           

                  ourthread.add(iconEmpty, iconYellow,y,rows,root.getIndex(),cp,columns,bb);
            	ourthread.start();
                            checkforwin(root.getIndex());
                         
                         }
                     }
            }
    }

   
}
