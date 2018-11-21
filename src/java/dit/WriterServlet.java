/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "WriterServlet", urlPatterns = {"/WriterServlet"})
public class WriterServlet extends HttpServlet {

    private File file;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        file = new File("C:\\Users\\hp\\Desktop\\books.txt");
    }

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
        ArrayList<Book> books = getData();

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
                    + "        <nav class=\"navbar navbar-dark bg-primary\">\n"
                    + "            <a class=\"navbar-brand\" href=\"#\">One Book</a>\n"
                    + "\n"
                    + "        </nav>\n"
                    + "        <div class=\"container-fluid\">\n"
                    + "            <div class=\"row\">\n"
                    + "                <div class=\"col-sm-4\">\n"
                    + "                    <div class=\"item\">\n"
                    + "                        <div class=\"\"><h3>New Books Details</h3></div>\n"
                    + "                        <form action=\"ReaderServlet\">\n"
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
                    + "                <div class=\"col-sm-6\">\n"
                    + "                    <div class=\"item table-responsive card-body\">\n"
                    + "                        <table class=\"table table-bordered \">\n"
                    + "                            <caption>List of books</caption>\n"
                    + "                            <thead>\n"
                    + "                                <tr>\n"
                    + "                                    <th scope=\"col\">Title</th>\n"
                    + "                                    <th scope=\"col\">Author</th>\n"
                    + "                                    <th scope=\"col\">ISBN</th>\n"
                    + "                                    <th scope=\"col\">Description</th>\n"
                    + "                                </tr>\n"
                    + "                            <thead>\n"
                    + "                            <tbody>\n";
            for (Book book : books) {
                html += "                                <tr>\n"
                        + "                                    <td scope=\"col\">" + book.getTitle() + "</th>\n"
                        + "                                    <td scope=\"col\">" + book.getAuthor() + "</th>\n"
                        + "                                    <td scope=\"col\">" + book.getIsbn() + "</th>\n"
                        + "                                    <td scope=\"col\">" + book.getDescription() + "</th>\n"
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

    private ArrayList<Book> getData() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().length() > 0) {
                    books.add(getBook(line));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    private Book getBook(String data) {
        String parts[] = data.split("#");
        return new Book(parts[0], parts[1], parts[2], parts[3]);
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
