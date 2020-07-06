/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;

/**
 *
 * @author Administrator
 */
public class BookDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }

    public List<BookDTO> getAllBook(String bookName) throws SQLException {
        List<BookDTO> listBook = new ArrayList<>();;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID,description, image, title, price,  totalAmount, availableAmount, status FROM tblBooks WHERE availableAmount > 0 AND status = 'true' AND title LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + bookName + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    int bookID = rs.getInt("bookID");
                    String image = rs.getString("image");
                    String title = rs.getString("title");
                    String description = rs.getString("description");

                    float price = rs.getFloat("price");
                    int totalAmount = rs.getInt("totalAmount");
                    int availableAmount = rs.getInt("availableAmount");
                    boolean status = rs.getBoolean("status");
                    listBook.add(new BookDTO(bookID, image, title, price, totalAmount, availableAmount, description, status));
                }
            }
        } finally {
            closeConnection();
        }
        return listBook;
    }

    public List<BookDTO> getAllBook(String bookName, int priceFrom, int priceTo) throws SQLException {
        List<BookDTO> listBook = new ArrayList<>();;
        try {
            conn = MyConnection.getConnection();
            if (conn != null) {
                String sql = "SELECT bookID,description, image, title, price,  totalAmount, availableAmount, status FROM tblBooks WHERE availableAmount > 0 AND status = 'true' "
                        + "AND title LIKE ? AND Price >= ? AND Price <= ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + bookName + "%");
                ps.setInt(2, priceFrom);
                ps.setInt(3, priceTo);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int bookID = rs.getInt("bookID");
                    String image = rs.getString("image");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int totalAmount = rs.getInt("totalAmount");
                    int availableAmount = rs.getInt("availableAmount");
                    boolean status = rs.getBoolean("status");
                    listBook.add(new BookDTO(bookID, image, title, price, totalAmount, availableAmount, description, status));
                }
            }
        } finally {
            closeConnection();
        }
        return listBook;
    }

    public BookDTO getInfoABookByID(int bookID) throws SQLException {
        BookDTO bookDTO = null;
        conn = MyConnection.getConnection();
        try {
            if (conn != null) {
                String sql = "SELECT bookID, image, title, price, description, totalAmount, availableAmount, status FROM tblBooks WHERE status = 'true' AND bookID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, bookID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String image = rs.getString("image");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int totalAmount = rs.getInt("totalAmount");
                    int availableAmount = rs.getInt("availableAmount");
                    boolean status = rs.getBoolean("status");
                    bookDTO = new BookDTO(bookID, image, title, price, totalAmount, availableAmount, description, status);
                }
            }
        } finally {
            closeConnection();
        }
        return bookDTO;

    }

}
