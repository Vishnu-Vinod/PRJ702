/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnect;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import videointegirtyverification.UserPanel;

/**
 *
 * @author Vishnu
 */
public class Dbconnect {

    Connection con;
    Statement st;
    public static final String FailedIndicator = "------------------> ";

    public Dbconnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VideoIntegirtyVerification", "root", "KL05t8523");
            System.out.println("Connected to VideoIntegirtyVerification Database");
            st = con.createStatement();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public ResultSet UserLogincheck(String email, char[] pass) {

        String sql = "select * from userdetails "
                + "where email=? and password=?";
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, String.valueOf(pass));
            rs = ps.executeQuery();
            if (rs.next()) {
                rs.previous();
                System.out.println("UserLogincheck Executed");

            } else {
                System.out.println(FailedIndicator + "Operation Failed : UserLogincheck");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int UserInsert(String Nametext, String Emailtext, String Phonetext, char[] password,InputStream f) {

        int ins = 0;
        String sql = "insert into userdetails (name,email,phone,password,image)"
                + "values(?,?,?,?,?)";
        try {
//            System.out.println(f.length());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Nametext);
            ps.setString(2, Emailtext);
            ps.setString(3, Phonetext);
            ps.setString(4, String.valueOf(password));
            ps.setBlob(5, f);
            System.out.println(ps);

            ins = ps.executeUpdate();
            if (ins > 0) {
                System.out.println("UserDetails Inserted");
            } else {
                System.out.println(FailedIndicator + "Operation Failed : UserInsert");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ins;
    }

    public ResultSet viewProfileDetails(int id) {
        ResultSet rs = null;
        int i = 0;
        String sel = "select * from userdetails "
                + "where userid =" + id + "";
        try {
            rs = st.executeQuery(sel);
            if (rs.next()) {
                String bal = rs.getString(2);
                rs.previous();
                System.out.println("viewProfileDetails Executed ");
            } else {
                System.out.println(FailedIndicator + "Operation Failed : viewProfileDetails");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet Blockcheck() {
        String sql = "SELECT videoid FROM videoproperties "
                + "where videoid =(SELECT MAX(videoid) FROM videoproperties)";
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public int checkForFileName(String videoname, UserPanel up) {
        up.setjProgressBar1(20);
        String sql = "SELECT videoproperties.videoid,\n"
                + "videoproperties.filename\n"
                + "FROM VideoIntegirtyVerification.videoproperties\n"
                + "where filename = ?";
        PreparedStatement ps;
        int videoid = 0;
        ResultSet rs = null;
        up.setjProgressBar1(25);
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, videoname);
            rs = ps.executeQuery();
            up.setjProgressBar1(35);
            if (rs.next()) {
                videoid = rs.getInt(1);
                rs.previous();
            } else {
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return videoid;
    }

    public int getVideoInfo(String videoname) {

        String sql = "SELECT videoproperties.videoid,\n"
                + "videoproperties.filename\n"
                + "FROM VideoIntegirtyVerification.videoproperties\n"
                + "where filename = ?";
        PreparedStatement ps;
        int videoid = 0;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, videoname);
            rs = ps.executeQuery();
            if (rs.next()) {
                videoid = rs.getInt(1);
                rs.previous();
                System.out.println("Get VideoInfo Executed");
            } else {
                System.err.println("Operation Failed : Get VideoInfo");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return videoid;
    }
}
