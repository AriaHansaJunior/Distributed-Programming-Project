package com.kulijawa.models;

import java.sql.*;
import java.util.ArrayList;

public class Purchase extends MyModel {

    // <editor-fold defaultstate="collapsed" desc="Data Member">
    int id, qty;
    double total_discount, total_price;
    String status;
    User users;
    Tickets tickets;
    Timestamp create_date;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Properties">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal_discount() {
        return total_discount;
    }

    public void setTotal_discount(double total_discount) {
        this.total_discount = total_discount;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
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

    public Tickets getTickets() {
        return tickets;
    }

    public void setTickets(Tickets tickets) {
        this.tickets = tickets;
    }

    public Timestamp getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date) {
        this.create_date = create_date;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public Purchase() {
    }

    public Purchase(int qty, double total_discount, double total_price, String status, User users, Tickets tickets) {
        setQty(qty);
        setTotal_discount(total_discount);
        setTotal_price(total_price);
        setStatus(status);
        setUsers(users);
        setTickets(tickets);
        this._getConnection();
    }

    public Purchase(int id, int qty, double total_discount, double total_price, String status, User users, Tickets tickets, Timestamp create_date) {
        setId(id);
        setQty(qty);
        setTotal_discount(total_discount);
        setTotal_price(total_price);
        setStatus(status);
        setUsers(users);
        setTickets(tickets);
        setCreate_date(create_date);
        this._getConnection();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Query">
    @Override
    public Boolean insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                try (PreparedStatement sql = MyModel.conn.prepareStatement( "INSERT INTO purchases (qty, total_discount, total_price, status, users_id, tickets_id) VALUES (?, ?, ?, ?, ?, ?)")) {
                    sql.setInt(1, getQty());
                    sql.setDouble(2, getTotal_discount());
                    sql.setDouble(3, getTotal_price());
                    sql.setString(4, getStatus());
                    sql.setInt(5, getUsers().getId());
                    sql.setInt(6, getTickets().getID());
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
                        "UPDATE purchases SET qty = ?, total_discount = ?, total_price = ?, status = ?, users_id = ?, tickets_id = ? WHERE id = ?")) {
                    sql.setInt(1, getQty());
                    sql.setDouble(2, getTotal_discount());
                    sql.setDouble(3, getTotal_price());
                    sql.setString(4, getStatus());
                    sql.setInt(5, getUsers().getId());
                    sql.setInt(6, getTickets().getID());
                    sql.setInt(7, getId());
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
                try (PreparedStatement sql = MyModel.conn.prepareStatement("DELETE FROM purchases WHERE id = ?")) {
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
            this.result = this.statement.executeQuery("SELECT * FROM purchases");
            while (this.result.next()) {
                User u = new User();
                u.setId(this.result.getInt("users_id"));

                Tickets t = new Tickets();
                t.setID(this.result.getInt("tickets_id"));

                Purchase p = new Purchase(
                        this.result.getInt("id"),
                        this.result.getInt("qty"),
                        this.result.getDouble("total_discount"),
                        this.result.getDouble("total_price"),
                        this.result.getString("status"),
                        u,
                        t,
                        this.result.getTimestamp("create_date")
                );
                collections.add(p);
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
            this.result = this.statement.executeQuery("SELECT * FROM purchases");
            while (this.result.next()) {
                User u = new User();
                u.setId(this.result.getInt("users_id"));

                Tickets t = new Tickets();
                t.setID(this.result.getInt("tickets_id"));

                Purchase p = new Purchase(
                        this.result.getInt("id"),
                        this.result.getInt("qty"),
                        this.result.getDouble("total_discount"),
                        this.result.getDouble("total_price"),
                        this.result.getString("status"),
                        u,
                        t,
                        this.result.getTimestamp("create_date")
                );
                collections.add(
                        p.getId() + "~"
                        + p.getQty() + "~"
                        + p.getTotal_discount() + "~"
                        + p.getTotal_price() + "~"
                        + p.getStatus() + "~"
                        + p.getUsers().getId() + "~"
                        + p.getTickets().getID() + "~"
                        + p.getCreate_date()
                );
            }
        } catch (SQLException e) {

        }
        return collections;
    }
    // </editor-fold>
}
