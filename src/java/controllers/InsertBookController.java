/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.BookDAO;
import dtos.BookDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class InsertBookController extends HttpServlet {

    private final String SUCCESS = "ShowBookController";
    private final String UNSUCCESS = "insertBook.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SUCCESS;
        try {
            String image = request.getParameter("txtImage");
            if (image == null || image.isEmpty()) {
                url = UNSUCCESS;
                request.setAttribute("IMAGE_ERROR", "Image is required");
            } else {
//                int index = image.indexOf("image\\");
//                image = image.substring(index);
                image = "image\\" + image;
            }
            //     image="image/"+image;

            String title = request.getParameter("txtTitle");
            if (title.isEmpty() || title.length() == 0) {
                url = UNSUCCESS;
                request.setAttribute("TITLE_ERROR", "Title is required");
            }

            float price = 0;
            price = Float.parseFloat(request.getParameter("txtPrice"));
            if (price <= 0) {
                request.setAttribute("PRICE_ERROR", "Are you know what is price?");
                url = UNSUCCESS;
            }

            String description = "";
            description = request.getParameter("txtDescription");
            if (description.isEmpty() || description == null) {
                request.setAttribute("DESCRIPTION_ERROR", "Description is required");
                url = UNSUCCESS;
            }

            int totalAmount = 0;
            totalAmount = Integer.parseInt(request.getParameter("txtTotalAmount"));
            if (totalAmount <= 0) {
                request.setAttribute("TOTAL_AMOUNT_ERROR", "Total Amount is required");
                url = UNSUCCESS;
            }
            int availableMount = totalAmount;
            if (url != UNSUCCESS) {
                BookDTO bookDTO = new BookDTO(image, title, price, totalAmount, availableMount, description);
                BookDAO bookDAO = new BookDAO();
                bookDAO.insertABook(bookDTO);
            }

        } catch (Exception e) {
            log("Error at InsertBookController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
