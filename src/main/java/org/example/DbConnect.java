package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnect {

    public Connection connectionToDb(String dbName, String user, String pass){
        Connection connection = null;

        try{

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName,user,pass);
            if(connection!=null){
                System.out.println("Connection Established");
            }
            else {
                System.out.println("Connection Failed");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return connection;

    }

    public void createTable(Connection connection, String tableName){
        Statement statement;
        String query = "CREATE TABLE if not exists " + tableName + " (phy_id UUID primary key, " +
                "phy_title text, " +
                "phy_first_name text, " +
                "phy_last_name text);";
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + tableName + " was created!");
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void createTableVisit(Connection connection, String tableName){
        Statement statement;
        String query = "CREATE TABLE if not exists " + tableName + " (vis_id uuid primary key," +
                "    phy_id UUID, " +
                "    date_visit timestamp," +
                "    time_visit timestamp," +
                "    foreign key (phy_id) references phisician(phy_id));";
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table " + tableName + " was created!");
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
