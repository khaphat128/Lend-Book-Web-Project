/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.BookDAO;
import dtos.BookDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CommonUtil;

/**
 *
 * @author Administrator
 */
public class ShowBookController extends HttpServlet {

    private final String SUCCESS = "shop.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {

            // Get Params
            String search = request.getParameter("txtSearch");
            String priceFromStr = request.getParameter("txtPriceFrom");
            String priceToStr = request.getParameter("txtPriceTo");

            //
            BookDAO bookDAO = new BookDAO();
            List<BookDTO> list = null;
            // Xu li dieu kien
            if (search == null) {
                search = "";
            }
            if (priceFromStr != null && priceToStr != null) {
                int priceFrom = CommonUtil.toInt(priceFromStr.substring(1));
                int priceTo = CommonUtil.toInt(priceToStr.substring(1));
                if (priceFrom <= priceTo) {
                    request.setAttribute("PRICE_FROM", priceFrom);
                    request.setAttribute("PRICE_TO", priceTo);
                    list = (List<BookDTO>) bookDAO.getAllBook(search, priceFrom, priceTo);
                }
            } else {
                list = (List<BookDTO>) bookDAO.getAllBook(search);
            }
            if (list != null) {
                request.setAttribute("SEARCH_VALUE", search);
                request.setAttribute("LIST_BOOK", list);
                request.setAttribute("SEARCH_VALUE", search);
           
            }
        } catch (Exception e) {
            log("error at showbookcontroller " + e.toString());
        } finally {
            request.getRequestDispatcher(SUCCESS).forward(request, response);
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
