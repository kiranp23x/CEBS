package Model;
import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.lang.StringBuilder;

public class DBConn {
    public static Connection conn;
    public static Statement stmt;
    /****************************************************************************************
     * establish's a connection with MySQL server and creates a statement
     */
    public static void connect()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinemaEBookingDB?serverTimezone=UTC", "root", "kiranpatel96");
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//connect
    public static int getEmailID(String email) {
        int result = 0;
        String str = "SELECT userID FROM Customer WHERE emailAddress = '" + email +"';";

        if(validQuery(str)) {
            try {
                connect();
                System.out.println("checking email");
                ResultSet rs = stmt.executeQuery(str);
                if(rs.next())
                    result = rs.getInt("userID");

                conn.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Error");
        }
        System.out.println("Email Check: " + result);
        return result;
    }//getEmailID
    public static int getUserID(String uname) {
        int result = 0;
        String str = "SELECT userID FROM User WHERE userName = '" + uname+"';";
        //checks if query has correct syntax
        if(validQuery(str)) {
            try {
                //connects to MySQL server
                connect();

                //executes query specified from user
                ResultSet rs = stmt.executeQuery(str);
                if(rs.next())
                    result = rs.getInt("userID");
                //closes connection from MySQL server after querying
                conn.close();
            }
            catch(Exception e) {
                System.out.print(e);
            }
        }
        //invalid query was passed in
        else {
            System.out.println("Query is invalid");
        }

        return result;
    }//getUserID

    public static String getStatus(String uname) {
        String result = "INACTIVE";
        String str = "SELECT status FROM User WHERE userName = '" + uname+"';";
        //checks if query has correct syntax
        if(validQuery(str)) {
            try {
                //connects to MySQL server
                connect();

                //executes query specified from user
                ResultSet rs = stmt.executeQuery(str);
                if(rs.next())
                    result = rs.getString("status");
                //closes connection from MySQL server after querying
                conn.close();
            }
            catch(Exception e) {
                System.out.print(e);
            }
        }
        //invalid query was passed in
        else {
            System.out.println("Query is invalid");
        }

        return result;
    }

    public static Customer getCustomerInfo(String uname, String pword) {
        int uid = DBConn.getUserID(uname);
        String status = DBConn.getStatus(uname);
        Customer c = new Customer(uid, uname, pword, status);
        c.setUname(uname);
        c.setPassword(pword);

        String str = "SELECT * FROM Customer, User WHERE user.userName = '" + uname+"' AND user.password = '" + pword + "' AND " +
                "User.userID = " + uid + " AND Customer.userID = " + uid+ ";";

        //checks if query has correct syntax
        if(validQuery(str)) {
            try {
                //connects to MySQL server
                connect();

                //executes query specified from user
                ResultSet rs = stmt.executeQuery(str);
                if(rs.next()) {
                    c.setFirstName(rs.getString("firstName"));
                    c.setLastName(rs.getString("lastName"));
                    c.setEmailAddress(rs.getString("emailAddress"));
                    c.setEmailPromo(rs.getString("emailPromo"));
                }
                System.out.println(c.getFirstName() + " " + c.getLastName());

                //closes connection from MySQL server after querying
                conn.close();
            }
            catch(Exception e) {
                System.out.print(e);
            }
        }
        //invalid query was passed in
        else {
            System.out.println("Query is invalid");
        }

        return c;
    }

    public static BillingAddress getBillingAddress(int uid) {
        BillingAddress billingAddr = new BillingAddress(uid);
        String str = "SELECT * FROM CreditCard, User WHERE user.userID = " + uid + ";";
        //checks if query has correct syntax
        if(validQuery(str)) {
            try {
                //connects to MySQL server
                connect();

                //executes query specified from user
                ResultSet rs = stmt.executeQuery(str);
                if(rs.next()) {
                    billingAddr.setStreet1(rs.getString("street1"));
                    billingAddr.setStreet2(rs.getString("street2"));
                    billingAddr.setCity(rs.getString("city"));
                    billingAddr.setState(rs.getString("state"));
                    billingAddr.setZipCode(rs.getString("zipCode"));
                    billingAddr.setCardNumber(rs.getString("cardNumber"));
                }

                //closes connection from MySQL server after querying
                conn.close();
            }
            catch(Exception e) {
                System.out.print(e);
            }
        }
        //invalid query was passed in
        else {
            System.out.println("Query is invalid");
        }

        return billingAddr;
    }

    /****************************************************************************************
     * validates query if it ends with ';'
     *
     * @param str query checked if it has correct syntax
     * @return boolean value if query ends with ';'
     */
    private static boolean validQuery(String str) {
        if(!str.endsWith(";")) {
            return false;
        }
        return true;
    }//validQuery
    /****************************************************************************************
     * updates Database if temporary tables are needed for the query
     *
     * @param str updates database from the specified query str
     *
     */
    public static void updateDB(String str) {

        String result = "no result";

        if(validQuery(str))
        {
            try {
                connect();
                stmt = conn.createStatement();
                //executes an update in the Database
                stmt.executeUpdate(str);
                System.out.println("executed");
            }catch(Exception e) {
                System.out.print(e);
            }
        }
        else
        {
            System.out.println("Query is invalid");
        }
    }//updateDB
    /*************************************************
     * Returns the password of the entered username
     * @param username
     * @return
     */
    public static String getUserPass(String username) {
        String password = null;
        String str = "SELECT password FROM User WHERE userName = '" + username + "';";

        if(validQuery(str)) {
            try {
                connect();
                System.out.println("Checking password");
                ResultSet rs = stmt.executeQuery(str);
                if(rs.next())
                    password = rs.getString("password");

                conn.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Error");
        }
        System.out.println("Password Check: " + password);
        return password;
    }//userPass

    /***********************************************************
     * updates the password to be encrypted using MD5 Hashing
     * @param password
     * @return
     */
    public static String encryptPassword(String password) {
        String newPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte[] bytes= md.digest();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            newPassword = sb.toString();
        } catch (Exception e) {
            System.out.println("Error with hashing");
        }
        return newPassword;
    }//encryptPassword
}

