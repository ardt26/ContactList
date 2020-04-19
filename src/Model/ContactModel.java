package Model;

import javax.swing.*;
import java.sql.*;

public class ContactModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbcontact";
    static final String USER = "root";
    static final String PASS = "";

    Connection connection;
    Statement statement;

    public ContactModel(){
        try{
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void insertContact(String sNama, String sNoHP, String sUmur ,String sEmail) {
        try {
            String query = "INSERT INTO `contact` (`nama`,`no_hp`,`umur`,`email`) VALUES ('" + sNama + "','" + sNoHP + "','" + sUmur + "','" + sEmail +"')";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public void editContact(String sNama, String sNoHP, String sUmur ,String sEmail) {
        try {
            String query = "UPDATE `contact` SET `nama` = '" + sNama + "', `umur` = '" + sUmur + "', `email` = '" + sEmail +"' WHERE `no_hp` = '" + sNoHP +"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit");
        }catch (Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    public String[][] readContact(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][4];

            String query = "Select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("no_hp");
                data[jmlData][2] = resultSet.getString("umur");
                data[jmlData][3] = resultSet.getString("email");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = connection.createStatement();
            String query = "Select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteContact (String sNoHP) {
        try{
            String query = "DELETE FROM `contact` WHERE `no_hp` = '"+ sNoHP +"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
