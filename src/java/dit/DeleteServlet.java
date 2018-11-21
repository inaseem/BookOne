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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Naseem
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

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
        ArrayList<Book> books = getBooks();
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
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
                    + "      <a class=\"nav-item nav-link\" href=\"InsertServlet\">Insert</a>\n"
                    + "      <a class=\"nav-item nav-link\" href=\"#\">Update</a>\n"
                    + "      <a class=\"nav-item nav-link active\" href=\"DeleteServlet\">Delete</a>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</nav>"
                    + "        <div class=\"container-fluid\">\n"
                    + "            <div class=\"row\">\n"
                    + "             <div class=\"col-sm-6\">\n"
                    + "                    <div class=\"item table-responsive card-body\">\n"
                    + "                        <table class=\"table table-bordered \">\n"
                    + "                            <caption>List of books</caption>\n"
                    + "                            <thead>\n"
                    + "                                <tr>\n"
                    + "                                    <th scope=\"col\">Title</th>\n"
                    + "                                    <th scope=\"col\">Author</th>\n"
                    + "                                    <th scope=\"col\">ISBN</th>\n"
                    + "                                    <th scope=\"col\">Description</th>\n"
                    +"<th scope=\"col\">Operation</th>\n"
                    + "                                </tr>\n"
                    + "                            <thead>\n"
                    + "                            <tbody>\n";
            for (Book book : books) {
                html += "                                <tr>\n"
                        + "                                    <td scope=\"col\">" + book.getTitle() + "</th>\n"
                        + "                                    <td scope=\"col\">" + book.getAuthor() + "</th>\n"
                        + "                                    <td scope=\"col\">" + book.getIsbn() + "</th>\n"
                        + "                                    <td scope=\"col\">" + book.getDescription() + "</th>\n"
                        + "                                    <td scope=\"col\"><a class=\"btn btn-primary\" href=\"DeleterServlet?title="+book.getTitle()+"\"/>Delete</a></th>\n"
                        + "                                </tr>\n";
            }
            html
                    += "                            </tbody>\n"
                    + "                        </table>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "\n"
                    + "        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "";
            out.println(html);
        }

    }

    private ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onebook", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select *  from book");
            while (rs.next()) {
                books.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {

        }
        return books;
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
