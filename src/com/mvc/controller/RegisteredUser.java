package com.mvc.controller;
import java.io.PrintWriter;
import java.sql.*;
import java.lang.String;

public class RegisteredUser {

    private static final String TEST = "jdbc:mysql://127.0.01:3306/e-booking?user=root&password=password";//change this to appropriate url/user/pass
    //Reference from MYSQL
    /* 1 uid: int
     * 2 Email: string
     * 3 Password: string // should not print password out anyway
     * 4 First name: string
     * 5 Last name: string
     * 6 Address: string
     * 7 Phone: int
     * 8 Payment: string
     * 9 Promo sub: bool
     * 10 status: enum*/

    //data stuff
    private int UID;
    private String EMAIL;
    private String PASSWORD;
    private String FNAME;
    private String LNAME;
    private String ADDRESS;
    private String PHONE;
    private String PAYMENT; //fix this later, should be credit card information, should switch to table I think or class
    private int PROMO;//change this to boolean?
    private int USERTYPE;
    private int STATUS;
    public String registrationStatus = null;
    //private enum STATUS; //fix this later

    //container for stuff related to queries
    static Statement stmt = null;
    static ResultSet rs = null;
    static Connection con = null;
    static PreparedStatement pstmt = null;

    // Constructor for com.mvc.controller.RegisteredUser();
    // Initializes variables to NULL/0 as placeholder.
    // Probably best used for debugging purpose?
    public RegisteredUser() {
        this.UID = 0;
        this.EMAIL = null;
        this.PASSWORD = null;
        this.FNAME = null;
        this.LNAME = null;
        this.ADDRESS = null;
        this.PHONE = null;
        this.PAYMENT = null;
        this.PROMO = 0;
        //this.STATUS = ??? //I am not sure how to convert enum crap to something usable?
    }

    // Overloaded constructor for com.mvc.controller.RegisteredUser();
    // Initializes variables to values set by user.
    public RegisteredUser(String first, String last,String email, String pass, String phone, String address, int status, int subscription, int userType) {
        this.UID = 0;
        this.EMAIL = email;
        this.PASSWORD = pass;
        this.FNAME = first;
        this.LNAME = last;
        this.ADDRESS = address;
        this.PHONE = phone;
        this.PAYMENT = null;//Not sure how to implement this
        this.PROMO = subscription;
        this.STATUS = status;
        this.USERTYPE = userType;

    }

    //Retrieve user's data from database using email
    public String retrieveUsersData(String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);
            String query = "SELECT userID, firstName, lastName, password, phone, address, status, promoSub, userType FROM Users WHERE email = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,  email);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                this.UID = rs.getInt("userID");
                this.EMAIL = email;
                this.PASSWORD = rs.getString("password");
                this.FNAME = rs.getString("firstName");
                this.LNAME = rs.getString("lastName");
                this.ADDRESS = rs.getString("address");
                this.PHONE = rs.getString("phone");
                this.PROMO = rs.getInt("promoSub");
            }
            if(rs != null) return "USER EXISTS";

            rs.close();
            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return "USER DOES NOT EXIST";
    }//retrieveUsersData(String email)

    //should return false or true if password match
    //this need to be updated to more secure way of testing than loading the data from other functions
    //this will be changed to string email, string password with connector for security
    public boolean checkPassword(String password) {
        return this.PASSWORD.equals(password);
    }

    //secure function, use in future once everything is set up to use MD5() hashing
    public boolean checkPassword(String email, String password) /*throws SQLException*/ {

        String pw_test = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);

            String query = "SELECT password FROM users WHERE email = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            while(rs.next())
                pw_test = rs.getString("password");

            rs.close();
            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }

        return pw_test.equals(password);
    }

    boolean login(String email, String password) {
        if(checkPassword(email, password)) {
            retrieveUsersData(email);
            return true;
        }
        else
            return false;
    }


    //Adds user to database EX: user.addRegUserToDB();
    public String addRegUserToDB() {
        String registrationStatus = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);//change later to different URL if needed
            String query = "INSERT into users(userID, firstName, lastName, email, password, phone, address, status, promoSub, userType) values(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);

            pstmt.setString(1,  this.FNAME);
            pstmt.setString(2,  this.LNAME);
            pstmt.setString(3,  this.EMAIL);
            pstmt.setString(4,  this.PASSWORD);
            pstmt.setString(5,  this.PHONE);
            pstmt.setString(6,  this.ADDRESS);
            pstmt.setInt(7,this.STATUS);
            pstmt.setInt(8, this.PROMO);
            pstmt.setInt(9,  this.USERTYPE);

            int i= pstmt.executeUpdate();

            //test if executeUpdate == 1
            if (i!=0) return "SUCCESS";

            pstmt.close();
            con.close();
            //Just to ensure data has been inserted into the database

        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return "Something went wrong!";
    }//addRegUserToDB

    //Deletes user from database EX: user.deleteRegUserFromDB();
    public void deleteRegUserFromDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);
            String query = "DELETE FROM users WHERE Email = ?";
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, EMAIL);
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        //clears the attributes to allow same object to be used.
        reset();

    }//deleteRegUserFromDB

    public void reset() {
        this.UID = 0;
        this.EMAIL = null;
        this.PASSWORD = null;
        this.FNAME = null;
        this.LNAME = null;
        this.ADDRESS = null;
        this.PHONE = null;
        this.PAYMENT = null;
        this.PROMO = 0;
        //this.STATUS = ??? //I am not sure how to convert enum crap to something usable?
    }

    public void logout() {
        //for now, just reset to clear user crap
        reset();
    }

    //updates database with updated info using array crap
    public void updateUserInfo(String email, String infoType, String update) {
        //update where email = ?//DO NOT ALLOW EMAIL BE CHANGED!
        //the following variables should not be touched by reg-users
        //email, status, and usertype
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);//change later to different URL if needed

            String type = "";
            switch(infoType) {
                case "PW": type = "password"; break;
                case "FN": type = "firstName"; break;
                case "LN": type = "lastName"; break;
                case "PN": type = "phone"; break;
                case "PS": type = "promoSub"; break;
            }

            String query = new StringBuilder().append("UPDATE users SET ").append(type).append(" = ? WHERE email = ? ").toString();


            pstmt = con.prepareStatement(query);
            int num = 0;

            switch(type) {
                case "password": pstmt.setString(1,  update); break;
                case "firstName": pstmt.setString(1,  update); break;
                case "lastName": pstmt.setString(1,  update); break;
                case "phone":  pstmt.setString(1, update); break;
                case "promosub": num = Integer.parseInt(update); pstmt.setInt(1, num); break;
            }

            pstmt.setString(2,  email);

            pstmt.executeUpdate();
            pstmt.close();
            con.close();

        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public int getIDNum(String email) {
        int idtoReturn = 0;//invalid if 0

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);

            String query = "SELECT userID FROM users WHERE email = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            while(rs.next())
                idtoReturn = rs.getInt("userID");

            rs.close();
            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return idtoReturn;
    }

    //Deletes entire Registered Users table, IRREVERSIBLE
    //can be used in conjunction with timer to clear database but not necessary for this class
    //Next revision, add opt of 1 or 2? 1 for delete which starts off at last digit once cleared? 2 for trunc, etc...



    //Deletes entire Registered User table, IRREVERSIBLE
    //can be used in conjunction with timer to clear database but not necessary for this class
    //Next revision, add opt of 1 or 2? 1 for delete which starts off at last digit once cleared? 2 for trunc, etc....
    public void deleteUsersTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(TEST);
            String query = "TRUNCATE TABLE RegisteredUser";//Truncate resets AUTO_INCREMENT to 1 unlike DELETE which does not reset AUTO_INCREMENT and will resume at last digit.
            pstmt = con.prepareStatement(query);

            pstmt.executeUpdate();

            pstmt.close();
            con.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt!=null)
                    pstmt.close();
            }catch(SQLException se2) {
            }
            try {
                if(con!=null)
                    con.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Current User data:\n"
                + "UID: \t" + UID + "\n"
                + "EMAIL: \t" + EMAIL + "\n"
                + "FULL NAME:\t" + FNAME + " " + LNAME + "\n"
                + "ADDRESS: \t" + ADDRESS + "\n"
                + "PHONE #\t" + PHONE + "\n"
                + "PROMOTION SUBSCRIPTION:\t" + (PROMO==0 ? "YES\n":"NO\n");
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
/*
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
*/
    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public String getFNAME() {
        return FNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
    }

    public String getLNAME() {
        return LNAME;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setADDRESS(String ADDRESS){
        this.ADDRESS = ADDRESS;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public int getPROMO(){
        return PROMO;
    }

    public void setPROMO(int PROMO){
        this.PROMO = PROMO;
    }

    public String getStatus(){
        return registrationStatus;
    }
}//com.mvc.controller.RegisteredUser