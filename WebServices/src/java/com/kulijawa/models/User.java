package com.kulijawa.models;

import java.sql.*;
import java.util.ArrayList;

public class User extends MyModel {

    // <editor-fold defaultstate="collapsed" desc="Data Member">
    int id;
    String fullname, username, email, password, role;
    Timestamp dob, create_date, update_date;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
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
    public User() {
    }

    public User(String _fullname, String _username, String _email, String _password, String _role, Timestamp _dob) {
        setFullname(_fullname);
        setUsername(_username);
        setEmail(_email);
        setPassword(_password);
        setRole(_role);
        setDob(_dob);
        this._getConnection();
    }

    public User(int _id, String _fullname, String _username, String _email, String _password, String _role, Timestamp _dob, Timestamp _create_date, Timestamp _update_date) {
        setId(_id);
        setFullname(_fullname);
        setUsername(_username);
        setEmail(_email);
        setPassword(_password);
        setRole(_role);
        setDob(_dob);
        setCreate_date(_create_date);
        setUpdate_date(_update_date);
        this._getConnection();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Query">
    @Override
    public Boolean insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                try (PreparedStatement sql = MyModel.conn.prepareStatement("INSERT INTO users (fullname, username, email, password, role, dob) VALUES (?, ?, ?, ?, ?, ?)")) {
                    sql.setString(1, getFullname());
                    sql.setString(2, getUsername());
                    sql.setString(3, getEmail());
                    sql.setString(4, getPassword());
                    sql.setString(5, getRole());
                    sql.setTimestamp(6, getDob());
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
                try (PreparedStatement sql = MyModel.conn.prepareStatement("UPDATE users SET fullname = ?, username = ?, email = ?, password = ?, role = ?, update_date = CURRENT_TIMESTAMP WHERE id = ?")) {
                    sql.setString(1, getFullname());
                    sql.setString(2, getUsername());
                    sql.setString(3, getEmail());
                    sql.setString(4, getPassword());
                    sql.setString(5, getRole());
                    sql.setInt(6, getId());
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
                try (PreparedStatement sql = MyModel.conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
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
            this.result = this.statement.executeQuery("SELECT * FROM users");
            while (this.result.next()) {
                User u = new User(
                        this.result.getInt("id"),
                        this.result.getString("fullname"),
                        this.result.getString("username"),
                        this.result.getString("email"),
                        this.result.getString("password"),
                        this.result.getString("role"),
                        this.result.getTimestamp("dob"),
                        this.result.getTimestamp("create_date"),
                        this.result.getTimestamp("update_date")
                );
                collections.add(u);
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
            this.result = this.statement.executeQuery("SELECT * FROM users");
            while (this.result.next()) {
                User u = new User(
                        this.result.getInt("id"),
                        this.result.getString("fullname"),
                        this.result.getString("username"),
                        this.result.getString("email"),
                        this.result.getString("password"),
                        this.result.getString("role"),
                        this.result.getTimestamp("dob"),
                        this.result.getTimestamp("create_date"),
                        this.result.getTimestamp("update_date")
                );
                collections.add(
                        u.getFullname() + "~"
                        + u.getUsername() + "~"
                        + u.getEmail() + "~"
                        + u.getRole() + "~"
                        + u.getDob()
                );
            }
        } catch (SQLException e) {

        }
        return collections;
    }
    // </editor-fold>

    public ArrayList<String> checkLogin() {
        ArrayList<String> collections = new ArrayList<>();
        try {
            if (!MyModel.conn.isClosed()) {
                try (PreparedStatement sql = MyModel.conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
                    sql.setString(1, getUsername());
                    sql.setString(2, getPassword());
                    this.result = sql.executeQuery();
                    if (this.result.next()) {
                        collections.add(this.result.getString("fullname") + "~" + this.result.getString("username") + "~" + this.result.getString("email") + "~" + this.result.getString("role") + "~" + this.result.getTimestamp("dob"));
                    }
                }
            }
        } catch (SQLException e) {

        }
        return collections;
    }

    public Boolean checkEmail() {
        try {
            if (!MyModel.conn.isClosed()) {
                try (PreparedStatement sql = MyModel.conn.prepareStatement("SELECT * FROM users WHERE email = ?")) {
                    sql.setString(1, getEmail());
                    result = sql.executeQuery();
                    if (result.next()) {
                        setId(result.getInt("id"));
                        return false;
                    }
                }
            }
        } catch (SQLException e) {

        }
        return true;
    }
}
