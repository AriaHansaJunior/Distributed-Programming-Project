package com.kulijawa.models;

import java.sql.*;
import java.util.ArrayList;

public class Notification extends MyModel {

    // <editor-fold defaultstate="collapsed" desc="Data Member">
    int id;
    String message, status;
    User users, admin;
    Timestamp create_date, update_date;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }

    public Timestamp getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Timestamp update_date) {
        this.update_date = update_date;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public Notification() {
    }

    public Notification(String _message, String _status, User _users, User _admin) {
        setMessage(_message);
        setStatus(_status);
        setUsers(_users);
        setAdmin(_admin);
        this._getConnection();
    }

    public Notification(int _id, String _message, String _status, Timestamp _create_date, Timestamp _update_date, User _users, User _admin) {
        setId(_id);
        setMessage(_message);
        setStatus(_status);
        setCreate_date(_create_date);
        setUpdate_date(_update_date);
        setUsers(_users);
        setAdmin(_admin);
        this._getConnection();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Query">
    @Override
    public Boolean insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                try (PreparedStatement sql = MyModel.conn.prepareStatement(
                        "INSERT INTO notifications (message, status,users, admin) VALUES (?, ?, ?, ?)")) {
                    sql.setString(1, getMessage());
                    sql.setString(2, getStatus());
                    sql.setInt(3, getUsers().getId());
                    sql.setInt(4, getAdmin().getId());
                    sql.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {

        }
        return false;
    }

    @Override
    public Boolean updateData() {
        try {
            if (!MyModel.conn.isClosed()) {
                try (PreparedStatement sql = MyModel.conn.prepareStatement(
                        "UPDATE notifications SET users = ?, admin = ?, message = ?, status = ?, update_date = CURRENT_TIMESTAMP WHERE id = ?")) {
                    sql.setInt(1, getUsers().getId());
                    sql.setInt(2, getAdmin().getId());
                    sql.setString(3, getMessage());
                    sql.setString(4, getStatus());
                    sql.setInt(5, getId());
                    sql.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {

        }
        return false;
    }

    @Override
    public Boolean deleteData() {
        try {
            if (!MyModel.conn.isClosed()) {
                try (PreparedStatement sql = MyModel.conn.prepareStatement("DELETE FROM notifications WHERE id = ?")) {
                    sql.setInt(1, getId());
                    sql.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException e) {

        }
        return false;
    }

    @Override
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collections = new ArrayList<>();
        try {
            this.statement = MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM notifications");
            while (this.result.next()) {
                User u = new User();
                u.setId(this.result.getInt("users"));

                User a = new User();
                a.setId(this.result.getInt("admin"));

                Notification n = new Notification(
                        this.result.getInt("id"),
                        this.result.getString("message"),
                        this.result.getString("status"),
                        this.result.getTimestamp("create_date"),
                        this.result.getTimestamp("update_date"),
                        u,
                        a
                );
                collections.add(n);
            }
        } catch (SQLException e) {

        }
        return collections;
    }

    @Override
    public ArrayList<String> viewListDataString() {
        ArrayList<String> collections = new ArrayList<>();
        try {
            this.statement = MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM notifications");
            while (this.result.next()) {
                User u = new User();
                u.setId(this.result.getInt("users"));

                User a = new User();
                a.setId(this.result.getInt("admin"));

                Notification n = new Notification(
                        this.result.getInt("id"),
                        this.result.getString("message"),
                        this.result.getString("status"),
                        this.result.getTimestamp("create_date"),
                        this.result.getTimestamp("update_date"),
                        u,
                        a
                );
                collections.add(
                        n.getMessage() + "~"
                        + n.getStatus() + "~"
                        + n.getUsers().getId() + "~"
                        + n.getAdmin().getId() + "~"
                        + n.getCreate_date()
                );
            }
        } catch (SQLException e) {

        }
        return collections;
    }
    // </editor-fold>

    public ArrayList<String> viewLogNotifications() {
        ArrayList<String> collections = new ArrayList<>();
        try {
            try (PreparedStatement sql = MyModel.conn.prepareStatement("SELECT * FROM notifications WHERE status = ? AND users = ?")) {
                sql.setString(1, getStatus());
                sql.setInt(2, getUsers().getId());
                this.result = sql.executeQuery();
                while (this.result.next()) {
                    setMessage(this.result.getString("message"));
                    setCreate_date(this.result.getTimestamp("create_date"));

                    collections.add(
                            getMessage() + "~"
                            + getCreate_date()
                    );
                }
            }
        } catch (SQLException e) {

        }
        return collections;
    }
}
