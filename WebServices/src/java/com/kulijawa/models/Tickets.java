    package com.kulijawa.models;

    import java.awt.image.BufferedImage;
    import java.io.*;
    import java.sql.PreparedStatement;
    import java.sql.Statement;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.Base64;
    import javax.imageio.ImageIO;
    import java.sql.Date;
    import java.sql.Timestamp;
    import java.time.LocalDate;
    import java.time.LocalDateTime;

    //Server
    public class Tickets extends MyModel {

        public LocalDateTime getConcertdate() {
            return concertdate;
        }

        public void setConcertdate(LocalDateTime concertdate) {
            this.concertdate = concertdate;
        }

        public int getStockflashsale() {
            return stockflashsale;
        }

        public void setStockflashsale(int stockflashsale) {
            this.stockflashsale = stockflashsale;
        }

        public LocalDateTime getFlashSaleStart() {
            return flashSaleStart;
        }

        public void setFlashSaleStart(LocalDateTime flashSaleStart) {
            this.flashSaleStart = flashSaleStart;
        }

        public LocalDateTime getFlashSaleEnd() {
            return flashSaleEnd;
        }

        public void setFlashSaleEnd(LocalDateTime flashSaleEnd) {
            this.flashSaleEnd = flashSaleEnd;
        }

        private int stock;
        private Double price;
        private LocalDate createdDate, updatedDate;
        private int id;
        private String title, imagePath, description;
        private double discount;
        private int stockflashsale;
        private int creator;
        private LocalDateTime concertdate;
        private LocalDateTime flashSaleStart;
        private LocalDateTime flashSaleEnd;

        // <editor-fold defaultstate="collapsed" desc="Properties">
        // <editor-fold defaultstate="collapsed" desc="ID">
        public int getID() {
            return id;
        }

        public void setID(int id) {
            this.id = id;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Title">
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Price">
        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Discount">
        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Stock">
        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Creator">
        public int getCreator() {
            return creator;
        }

        public void setCreator(int creator) {
            this.creator = creator;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ImagePath">
        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = setImagePathToByte(imagePath);
            //this.imagePath = imagePath;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Description">
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CreatedDate">
        public LocalDate getCreatedDate() {
            return createdDate;
        }

        private void setCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="UpdatedDate">
        public LocalDate getUpdatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(LocalDate updatedDate) {
            this.updatedDate = updatedDate;
        }
        // </editor-fold>
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Constructor">
        public Tickets() {
            setID(0);
            setTitle(null);
            setPrice(0.0);
            setDiscount(0);
            setStock(0);
            setCreator(0);
            setImagePath(null);
            setDescription(null);
            setCreatedDate(LocalDate.now());
            setUpdatedDate(LocalDate.now());
        }

        /*public Ticket(String id, String title, Double price, int stock, int creator, String imagePath, String description, double discount,int stockflashsale, LocalDateTime flashSaleStart, LocalDateTime flashSaleEnd) {
            setID(id);
            setTitle(title);
            setPrice(price);
            setDiscount(discount);
            setStock(stock);
            setCreator(creator);
            setDescription(description);
            if (imagePath != null && !imagePath.isEmpty()) {
                setImagePath(imagePath);
            } else {
                setImagePath(getImagePathFromTitle());
            }
            setStockflashsale(stockflashsale);
            setCreatedDate(LocalDate.now());
            setUpdatedDate(LocalDate.now());
            if (flashSaleStart == null || flashSaleEnd == null) {
                setFlashSaleStart(null);
                setFlashSaleEnd(null);
            } else {
                setFlashSaleStart(flashSaleStart);
                setFlashSaleEnd(flashSaleEnd);
            }
        }*/
        public Tickets(int id, String title, Double price, int stock, int creator, String imagePath, String description,
                double discount, int flashsalestock, LocalDateTime flashSaleStart, LocalDateTime flashSaleEnd,
                LocalDateTime createdDate, LocalDateTime updatedDate, LocalDateTime condate) {
            setID(id);
            setTitle(title);
            setPrice(price);
            setDiscount(discount);
            setStock(stock);
            setCreator(creator);
            setDescription(description);
            if (imagePath != null && !imagePath.isEmpty()) {
                setImagePath(imagePath);
            } else {
                setImagePath(getImagePathFromTitle());
            }
            setStockflashsale(flashsalestock);
            setFlashSaleStart(flashSaleStart);
            setFlashSaleEnd(flashSaleEnd);
            setCreatedDate(createdDate != null ? createdDate.toLocalDate() : LocalDate.now());
            setUpdatedDate(updatedDate != null ? updatedDate.toLocalDate() : LocalDate.now());
            setConcertdate(condate);
        }
        // </editor-fold>

        public void updatestock(int qty) {
            setStock(this.stock - qty);
            setUpdatedDate(LocalDate.now());
        }

        public void updatestockFS(int qty) {
            setStockflashsale(this.stockflashsale - qty);
            setUpdatedDate(LocalDate.now());
        }

        private String getImagePathFromTitle() {
            if (this.title == null || this.title.isEmpty()) {
                return "/Picture/default.jpg"; // fallback kalau title null
            }
            return "/Picture/" + this.title.replace(" ", "") + ".jpg";
        }

        private String setImagePathToByte(String imagePath) {
            try {
                if (imagePath == null || imagePath.isEmpty()) {
                    //System.out.println("Image path is null or empty, using default.");
                    imagePath = "/Picture/default.jpg"; // fallback default
                }

                InputStream inputStream = getClass().getResourceAsStream("/Picture/" + new File(imagePath).getName());
                if (inputStream == null) {
                    System.out.println("Image not found for path: " + imagePath + ", using default.");
                    inputStream = getClass().getResourceAsStream("/Picture/default.jpg");
                }

                BufferedImage bufferedImage = ImageIO.read(inputStream);
                ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

                ImageIO.write(bufferedImage, "jpg", byteOutputStream);
                byte[] imageBytes = byteOutputStream.toByteArray();

                return Base64.getEncoder().encodeToString(imageBytes);
            } catch (IOException e) {
                System.out.println("Error when converting image to byte: " + e.getMessage());
            }
            return null;
        }

        //@Override
        /*public void insertData() {
            try {
                if (!MyModel.conn.isClosed()) {
                    PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                            "INSERT INTO ticket(number_plate, brand, vehicle_class, color) "
                            + "VALUES (?,?,?,?)");
                    sql.setString(1, this.number_plate);
                    sql.setString(2, this.brand);
                    sql.setInt(3, this.vehicle_class);
                    sql.setString(4, this.color);
                    sql.executeUpdate();
                    sql.close();
                }
            } catch (Exception e) {
                System.out.println("Error di insert data " + e);
            }
        }*/
        
        public void updateStock() {
            // langsung simpan
            try {
                if (!MyModel.conn.isClosed()) {
                    String query = "UPDATE tickets SET stock = ?, update_date = ? WHERE id = ?";
                    PreparedStatement sql = MyModel.conn.prepareStatement(query);

                    sql.setInt(1, this.stock);
                    sql.setDate(2, Date.valueOf(this.updatedDate));
                    sql.setInt(3, this.id);

                    sql.executeUpdate();
                    sql.close();
                }
            } catch (Exception e) {
                System.out.println("Error update stock: " + e.getMessage());
            }
        }

//        public void updateData() {
//            try {
//                if (!MyModel.conn.isClosed()) {
//                    System.out.println("Updating stock for ticket ID: " + this.id);
//                    String query = "UPDATE tickets SET "
//                            + "title = ?, creator = ?, image_path = ?, description = ?, "
//                            + "stock = ?, price = ?, discount = ?, stockflashsale = ?, "
//                            + "flash_sale_start = ?, flash_sale_end = ?, "
//                            + "createddate = ?, updateddate = ?, concert_date = ? "
//                            + "WHERE id = ?";
//
//                    PreparedStatement sql = MyModel.conn.prepareStatement(query);
//
//                    sql.setString(1, this.title);
//                    sql.setInt(2, this.creator);
//                    sql.setString(3, this.imagePath);
//                    sql.setString(4, this.description);
//                    sql.setInt(5, this.stock);
//                    sql.setDouble(6, this.price);
//                    sql.setDouble(7, this.discount);
//                    sql.setInt(8, this.stockflashsale);
//                    sql.setTimestamp(9, Timestamp.valueOf(this.flashSaleStart));
//                    sql.setTimestamp(10, Timestamp.valueOf(this.flashSaleEnd));
//                    sql.setDate(11, Date.valueOf(this.createdDate));
//                    sql.setDate(12, Date.valueOf(this.updatedDate));
//                    //sql.setDate(14, );
//                    sql.setString(14, this.id);
//
//                    sql.executeUpdate();
//                    sql.close();
//                }
//            } catch (Exception e) {
//                System.out.println("Error di update data: " + e.getMessage());
//            }
//        }


        @Override
        public ArrayList<Object> viewListData() {
            ArrayList<Object> collections = new ArrayList<>();
            try {
                this.statement = MyModel.conn.createStatement();
                this.result = this.statement.executeQuery("SELECT * FROM tickets");

                while (this.result.next()) {
                    Tickets tick = new Tickets(
                            this.result.getInt("id"),
                            this.result.getString("title"),
                            this.result.getDouble("price"),
                            this.result.getInt("stock"),
                            this.result.getInt("creator"),
                            this.result.getString("image_path"),
                            this.result.getString("description"),
                            this.result.getDouble("discount"),
                            this.result.getInt("stockflashsale"),
                            this.result.getTimestamp("flashSale_start") != null ? this.result.getTimestamp("flashSale_Start").toLocalDateTime() : null,
                            this.result.getTimestamp("flashSale_end") != null ? this.result.getTimestamp("flashSale_End").toLocalDateTime() : null,
                            this.result.getTimestamp("create_date").toLocalDateTime(),
                            this.result.getTimestamp("update_date").toLocalDateTime(),
                            this.result.getTimestamp("concert_date").toLocalDateTime()
                    );
                    collections.add(tick);
                }

            } catch (Exception e) {
                System.out.println("Error di viewListData :" + e);
            }
            return collections;
        }

        

        

        public void updateStockFS() {
            try {
                if (!MyModel.conn.isClosed()) {
                    String query = "UPDATE tickets SET stockflashsale = ?, update_date = ? WHERE id = ?";
                    PreparedStatement sql = MyModel.conn.prepareStatement(query);

                    sql.setInt(1, this.stockflashsale);
                    sql.setDate(2, Date.valueOf(this.updatedDate));
                    sql.setInt(3, this.id);

                    sql.executeUpdate();
                    sql.close();
                }
            } catch (Exception e) {
                System.out.println("Error update stock: " + e.getMessage());
            }
        }

    @Override
    public Boolean insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<String> viewListDataString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean updateData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    }
