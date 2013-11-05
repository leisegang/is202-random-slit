/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is202.hrms.web;

import is202.hrms.ejb.FileEJB;
import is202.hrms.entity.StoredFile;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This servlet will serve any type of file for downloading.
 * The primary key of the file is specified with the paramaeter id.
 *
 * @author even
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/download"})
public class FileDownloadServlet extends HttpServlet {
    @EJB FileEJB fileEjb;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = parseLong(request.getParameter("id"), -1);
        if (id > 0) {
            StoredFile file = fileEjb.find(id);

            if (null != file) {
                response.setContentType(file.getContentType());
                response.setContentLength(file.getFileSize());
                OutputStream out = response.getOutputStream();
                out.write(fileEjb.getFileContents(id));
                out.flush();
            }
            else {
                PrintWriter out = response.getWriter();
                response.setContentType("text/plain");
                out.println("Requested file does not exist!");
            }
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "File download servlet";
    }// </editor-fold>

    public static long parseLong(String s, long def) {
        if (s == null || s.equals("")) {
            return def;

        }
        try {
            return Long.valueOf(s);
        } catch (NumberFormatException e) {
            return def;
        }
    }

}
