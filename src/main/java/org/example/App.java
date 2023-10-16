package org.example;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        org.example.DbConnect db = new org.example.DbConnect();
        Connection conn = db.connectionToDb( "postgres", "postgres", "1234");
        db.createTable(conn,"phisician");
        db.createTableVisit(conn,"visit");

    }
}
