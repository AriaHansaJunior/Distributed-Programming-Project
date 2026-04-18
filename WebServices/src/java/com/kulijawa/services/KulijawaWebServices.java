package com.kulijawa.services;

import com.kulijawa.models.*;
import java.util.ArrayList;
import java.util.HashSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Vi
 */
@WebService(serviceName = "KulijawaWebServices")
public class KulijawaWebServices {

    // <editor-fold defaultstate="collapsed" desc="User">
    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkLogin")
    public String checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        ArrayList<String> datas = user.checkLogin();
        if (!datas.isEmpty()) {
            return "\n" + datas;
        } else {
            return "Login failed";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "checkEmail")
    public Boolean checkEmail(@WebParam(name = "email") String email) {
        User user = new User();
        user.setEmail(email);
        return user.checkEmail();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registerUser")
    public Boolean registerUser(@WebParam(name = "fullname") String fullname, @WebParam(name = "username") String username, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "dob") String dob) {
        User user = new User();
        user.setEmail(email);
        if (!user.checkEmail()) {
            return false;
        }

        java.time.LocalDate localDate = java.time.LocalDate.parse(dob);
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(localDate.atStartOfDay());

        user.setFullname(fullname);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("buyer");
        user.setDob(timestamp);
        return user.insertData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateUser")
    public Boolean updateUser(@WebParam(name = "fullname") String fullname, @WebParam(name = "username") String username, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "role") String role) {
        User user = new User();
        user.setEmail(email);
        if (user.checkEmail()) {
            return false;
        }
        user.setFullname(fullname);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        return user.updateData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUser")
    public Boolean deleteUser(@WebParam(name = "email") String email) {
        User user = new User();
        user.setEmail(email);
        if (user.checkEmail()) {
            return false;
        }
        return user.deleteData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewUsers")
    public String viewUsers() {
        User u = new User();
        ArrayList<String> listUsers = u.viewListDataString();
        return "\n" + listUsers;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Purchase">
    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewPurchases")
    public ArrayList<String> viewPurchases() {
        Purchase p = new Purchase();
        ArrayList<String> listPurchases = p.viewListDataString();
        return listPurchases;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Notification">
    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewNotifications")
    public ArrayList<String> viewNotifications(@WebParam(name = "email") String email, @WebParam(name = "request") String request) {
        Notification n = new Notification();
        User u = new User();
        u.setEmail(email);
        if (!u.checkEmail()) {
            if (request.contains("admin")) {
                return n.viewListDataString();
            }
            n.setStatus(request);
            n.setUsers(u);
        }
        return n.viewLogNotifications();
    }

     /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertData")
    public void InsertData(@WebParam(name = "qty") int qty, @WebParam(name = "totaldiscount") double totaldiscount, @WebParam(name = "totalprice") double totalprice, @WebParam(name = "status") String status, @WebParam(name = "userid") int userid, @WebParam(name = "ticketid") int ticketid) {
        Purchase p = new Purchase();
        p.setQty(qty);
        p.setTotal_discount(totaldiscount);
        p.setTotal_price(totalprice);
        p.setStatus(status);
        User u = new User();
        u.setId(userid);
        Tickets t = new Tickets();
        t.setID(ticketid);
        p.setUsers(u);
        p.setTickets(t);
        p.insertData();
        //return null;
    }
    
    @WebMethod(operationName = "buy")
    public Boolean buy(@WebParam(name = "qty") int qty, @WebParam(name = "total_discount") double total_discount, @WebParam(name = "total_price") double total_price, @WebParam(name = "status") String status, @WebParam(name = "users_id") int users_id, @WebParam(name = "tickets_id") int tickets_id) {

        User u = new User();
        u.setId(users_id);

        Tickets t = new Tickets();
        t.setID(tickets_id);

        Purchase p = new Purchase();
        p.setQty(qty);
        p.setTotal_discount(total_discount);
        p.setTotal_price(total_price);
        p.setStatus(status);
        p.setUsers(u);
        p.setTickets(t);

        return p.insertData();
    }
    // <editor-fold defaultstate="collapsed" desc="Notification">
    /**
     * Web service operation
     */
    @WebMethod(operationName = "broadcast")
    public Boolean broadcast(@WebParam(name = "email") String email, @WebParam(name = "message") String message) {
        try {
            User admin = new User();
            admin.setEmail(email);

            if (!admin.checkEmail()) {
                Boolean statement = true;
                ArrayList<Object> userList = admin.viewListData();
                for (Object obj : userList) {
                    User user = (User) obj;
                    Notification n = new Notification();
                    n.setMessage(message);
                    n.setStatus("unread");
                    n.setUsers(user);
                    n.setAdmin(admin);

                    statement = n.insertData();
                }
                return statement;
            }

        } catch (Exception e) {

        }

        return false;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Ticket">
    // </editor-fold>
}
