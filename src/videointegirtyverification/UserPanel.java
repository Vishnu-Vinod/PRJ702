/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videointegirtyverification;

import dbConnect.Dbconnect;
import java.awt.Color;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vishnu
 */
public class UserPanel extends javax.swing.JFrame {

    class MyCustomFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".mp4" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".mp4");
        }

        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Mp4 Videos (*.mp4)";
        }
    }
    private final int UserId;

    /**
     * * This method validates the input email address with EMAIL_REGEX pattern 
     *
     * * * @param email * @return boolean
     */
    /**
     * Creates new form Login
     *
     * @param UserId
     */
    public UserPanel(int UserId, String TextArea) {

        initComponents();
        setIcon();
        jProgressBar1.setStringPainted(false);
        this.UserId = UserId;
        String Name = null, Email = null, phone = null;
        System.out.println("UserId :" + UserId);
        setjjTextArea1(TextArea);
        Dbconnect db = new Dbconnect();
        ResultSet ProfileDetails = db.viewProfileDetails(UserId);
        byte[] image = null;
        try {
            while (ProfileDetails.next()) {
                Name = ProfileDetails.getString(2);
                Email = ProfileDetails.getString(3);
                phone = ProfileDetails.getString(5);
                image = ProfileDetails.getBytes(6);
                System.out.println(image.length);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        NameLabel.setText(Name);
        emailLabel.setText(Email);
        phoneLabel.setText(phone);
        ImageIcon i =new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(130, 140, SCALE_SMOOTH));
        jLabel2.setIcon(i);
        

    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Logout = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Block Chain-Video Integrity Verification");
        setLocation(new java.awt.Point(100, 10));
        setMinimumSize(new java.awt.Dimension(729, 602));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 130, 140));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Panel");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 180, 40));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setText("Verify Video");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 190, 30));

        jButton2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton2.setText("Video File Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 190, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Details");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 110, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 70, -1));

        NameLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 150, 20));

        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 150, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        phoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 120, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Your Videos");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 180, 50));

        jFileChooser1.setFileFilter(new MyCustomFilter());
        getContentPane().add(jFileChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 0, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 610, 300));

        Logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 90, 30));
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 270, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Progress");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 610, 120));

        jPanel1.setLayout(null);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/videointegirtyverification/bg.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 0, 729, 700);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 729, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ResetjjTextArea1("");
        JFrame f;
        f = new JFrame();
        int returnVal = jFileChooser1.showOpenDialog(this);
        jProgressBar1.setStringPainted(true);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            setjProgressBar1(1);
            File file = jFileChooser1.getSelectedFile();
            String VideoPath = file.getPath();
            System.out.println("---------------------------------------------------------------------"
                    + "----------");
            Dbconnect db = new Dbconnect();
            File files = new File(VideoPath);
            setjProgressBar1(10);

            String videoname = files.getName();
            long Size = files.length();

            String[] GeneratedKeys = new String[3];
            int index;
            String concatHMACprev = null;
            String BlockKey = "";
            ResultSet rs = db.Blockcheck();
            ResultSet HMACprev = null;
            boolean[] VideoChecking;

            int Original = db.checkForFileName(videoname, this);
            if (Original > 0) {

                int Videoid;
                Videoid = db.getVideoInfo(videoname);
                boolean[] VideoCheck = null;
                
//                if (VideoCheck[0]) {
//                    setjProgressBar1(95);
//                    JOptionPane.showMessageDialog(f, "VIC value of Video is Verified", "Message", JOptionPane.INFORMATION_MESSAGE);
//                    if (VideoCheck[1]) {
//                        setjProgressBar1(100);
//                        JOptionPane.showMessageDialog(f, "Video Integrity of input file Verified", "Message", JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        JOptionPane.showMessageDialog(f, "Video Integrity Verification Failed", "Error", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                } else {
//                    setjProgressBar1(0);
//                    JOptionPane.showMessageDialog(f, "Input Video is forged", "Error", JOptionPane.ERROR_MESSAGE);
//                }
            } else {
                setjProgressBar1(0);
                JOptionPane.showMessageDialog(f, "File not found for verificatin Blockchain", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setjProgressBar1(0);
            JOptionPane.showMessageDialog(f, "File access cancelled by user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setjjTextArea1(String val) {
        if (!val.equals("")) {
            this.jTextArea1.setText(jTextArea1.getText() + val + "\n");
            jTextArea1.update(jTextArea1.getGraphics());
        } else {
            ResetjjTextArea1(val);
        }
    }

    public void ResetjjTextArea1(String val) {
        this.jTextArea1.setText("");
        jTextArea1.update(jTextArea1.getGraphics());
    }

    public void setjProgressBar1(int val) {
        this.jProgressBar1.setValue(val);
        jProgressBar1.update(jProgressBar1.getGraphics());

        try {
            Thread.sleep(200);//1070 default
        } catch (InterruptedException ex) {
            Logger.getLogger(UserPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ResetjjTextArea1("");
        JFrame f;
        f = new JFrame();
        jProgressBar1.setStringPainted(true);
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            setjProgressBar1(1);
            File file = jFileChooser1.getSelectedFile();
            setjProgressBar1(5);

            String VideoPath = file.getPath();
            setjProgressBar1(10);
            System.out.println("---------------------------------------------------------------------"
                    + "----------");
            Dbconnect db = new Dbconnect();
            File files = new File(VideoPath);
            setjProgressBar1(15);

            String videoname = files.getName();
            int Original;
            Original = db.checkForFileName(videoname, this);
            setjProgressBar1(40);

            if (Original > 0) {
                setjProgressBar1(0);
                JOptionPane.showMessageDialog(f, "Insertion Failed : Same File Already in Blockchain!", "Error", JOptionPane.ERROR_MESSAGE);
                setjjTextArea1("Insertion Failed : Same File Already in Blockchain!");
            }
            else {
                System.out.println("File is adding");
            }
            
        } else {
            setjProgressBar1(0);
            JOptionPane.showMessageDialog(f, "File access cancelled by user.", "Error", JOptionPane.ERROR_MESSAGE);
            setjjTextArea1("File access cancelled by user");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogoutActionPerformed
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("CCTV.png"))));
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
            java.util.logging.Logger.getLogger(UserPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPanel.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        UIManager.put("jProgressBar1.repanitInterval", new Integer(250));
        UIManager.put("jProgressBar1.cycleTime", new Integer(250));

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserPanel up = new UserPanel(1, "");
                up.setVisible(true);

//                up.setjProgressBar1(50);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel phoneLabel;
    // End of variables declaration//GEN-END:variables
}
