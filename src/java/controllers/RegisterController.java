/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RoleDAO;
import daos.UserDAO;
import dtos.RoleDTO;
import dtos.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CommonUtil;

/**
 *
 * @author Administrator
 */
public class RegisterController extends HttpServlet {

    private final String ERROR = "register.jsp";
    private final String SUCCESS = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        try {
            String userID = request.getParameter("txtUserID");
            String username = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtRePassword");

            if (userID.isEmpty()) {
                request.setAttribute("USERID_EMPTY", "UserID must required");
                check = false;
            }
            if (username.isEmpty()) {
                request.setAttribute("USERNAME_EMPTY", "Username must required");
                check = false;

            }
            if (password.isEmpty()) {
                request.setAttribute("PASSWORD_EMPTY", "Password must required");
                check = false;
            }

            if (!password.equals(rePassword)) {
                request.setAttribute("PASSWORD_NOT_SAME", "Password must the same!!");
                check = false;
            }

            if (check) {
                UserDAO userDAO = new UserDAO();
                RoleDAO roleDAO = new RoleDAO();
                RoleDTO roleDTO = roleDAO.getRoleDTOByName("user");
                UserDTO dto = new UserDTO(userID, username, roleDTO, password, true);
                userDAO.createAUser(dto);
                request.setAttribute("REGISTRATION_SUCCESS", "Registration success!! hihi=)))");
                url = SUCCESS;

            } else {
                request.setAttribute("REGISTRATION_ERROR", "ERROR");
            }
        } catch (Exception e) {
            CommonUtil.logFile(e.toString());
            if (e.toString().contains("duplicate")) {
                request.setAttribute("DUPLICATE_ID", "User ID existed!");
            }
            url = ERROR;
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
