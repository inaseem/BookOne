/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Naseem
 */
@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
public class InsertServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        
        String html = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <meta charset=\"utf-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                + "        <title>One Book</title>\n"
                + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n"
                + "        <style>\n"
                + "            .item{\n"
                + "                margin: 16px;\n"
                + "            }\n"
                + "        </style>\n"
                + "    </head>\n"
                + "    <body>\n"
                + "<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\n"
                + "  <a class=\"navbar-brand\" href=\"#\">Book One</a>\n"
                + "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNavAltMarkup\" aria-controls=\"navbarNavAltMarkup\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                + "    <span class=\"navbar-toggler-icon\"></span>\n"
                + "  </button>\n"
                + "  <div class=\"collapse navbar-collapse\" id=\"navbarNavAltMarkup\">\n"
                + "    <div class=\"navbar-nav\">\n"
                + "      <a class=\"nav-item nav-link\" href=\"HomeServlet\">Home <span class=\"sr-only\">(current)</span></a>\n"
                + "      <a class=\"nav-item nav-link active\" href=\"InsertServlet\">Insert</a>\n"
                + "      <a class=\"nav-item nav-link\" href=\"#\">Update</a>\n"
                + "      <a class=\"nav-item nav-link\" href=\"DeleteServlet\">Delete</a>\n"
                + "    </div>\n"
                + "  </div>\n"
                + "</nav>"
                + "        <div class=\"container-fluid\">\n"
                + "            <div class=\"row\">\n"
                + "                <div class=\"col-sm-4\">\n"
                + "                    <div class=\"item\">\n"
                + "                        <div class=\"\"><h3>New Book Details</h3></div>\n"
                + "                        <form action=\"WriterServlet\">\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label for=\"bookName\">Book name</label>\n"
                + "                                <input type=\"text\" class=\"form-control\" name=\"bookName\" placeholder=\"Enter book name\">\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label for=\"authorName\">Author name</label>\n"
                + "                                <input type=\"text\" class=\"form-control\" name=\"authorName\" placeholder=\"Author name\">\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label for=\"isbn\">ISBN</label>\n"
                + "                                <input type=\"text\" class=\"form-control\" name=\"isbn\" placeholder=\"ISBN\">\n"
                + "                            </div>\n"
                + "                            <div class=\"form-group\">\n"
                + "                                <label for=\"description\">Description</label>\n"
                + "                                <textarea type=\"text\" class=\"form-control\" name=\"description\" placeholder=\"Description\"></textarea>\n"
                + "                            </div>\n"
                + "                            <input type=\"hidden\" name=\"magic\" value=\"do\" hidden=\"\">\n"
                + "                            <button type=\"submit\" class=\"btn btn-primary\">Add New Book</button>\n"
                + "                        </form>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "</div>\n"
                + "</div>\n"
                + "</div>\n"
                + "</body>\n"
                + "</html>\n";
        out.println(html);

//        out.println(insertBook(new Book("Hey", "hey", "hey", "Hey")).toString());
    }

    private Object insertBook(Book book) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO book values(?,?,?,?)");
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3,book.getIsbn());
            ps.setString(4, book.getDescription());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            return e;
        }
        return false;
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
