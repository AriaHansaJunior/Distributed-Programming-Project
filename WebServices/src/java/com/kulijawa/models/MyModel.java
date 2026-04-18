package com.kulijawa.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// <editor-fold defaultstate="collapsed" desc="Empty-Fold">
// </editor-fold>
/**
 *
 * @author Vi
 */
public abstract class MyModel {

    protected static Connection conn;
    protected Statement statement;
    protected ResultSet result;

    public MyModel() {
        this.conn = this._getConnection();
        this.statement = null;
        this.result = null;
    }

    public Connection _getConnection() {
        if (MyModel.conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost/kulijawaws", "root", "");
            } catch (Exception e) {
                System.out.println("Error di getConnection " + e);
            }
        }
        return MyModel.conn;
    }

    public abstract Boolean insertData();

    public abstract Boolean updateData();

    public abstract Boolean deleteData();

    public abstract ArrayList<Object> viewListData();

    public abstract ArrayList<String> viewListDataString();
}
