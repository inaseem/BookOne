<%-- 
    Document   : Dashboard
    Created on : 29 Oct, 2018, 10:31:05 AM
    Author     : Naseem
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="dit.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>One Book</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            .item{
                margin: 16px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-primary">
            <a class="navbar-brand" href="#">One Book</a>

        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-4">
                    <div class="item">
                        <div class=""><h3>New Books Details</h3></div>
                        <form action="ReaderServlet">
                            <div class="form-group">
                                <label for="bookName">Book name</label>
                                <input type="text" class="form-control" name="bookName" placeholder="Enter book name">
                            </div>
                            <div class="form-group">
                                <label for="authorName">Author name</label>
                                <input type="text" class="form-control" name="authorName" placeholder="Author name">
                            </div>
                            <div class="form-group">
                                <label for="isbn">ISBN</label>
                                <input type="text" class="form-control" name="isbn" placeholder="ISBN">
                            </div>
                            <div class="form-group">
                                <label for="description">Description</label>
                                <textarea type="text" class="form-control" name="description" placeholder="Description"></textarea>
                            </div>
                            <input type="hidden" name="magic" value="do" hidden="">
                            <button type="submit" class="btn btn-primary">Add New Book</button>
                        </form>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="item table-responsive card-body">
                        <table class="table table-bordered ">
                            <caption>List of books</caption>
                            <thead>
                                <tr>
                                    <th scope="col">Title</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">ISBN</th>
                                    <th scope="col">Description</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${booksList}" var="book">
                                    <tr>
                                        <td>${book.title}</td>
                                        <td>${book.author}</td>
                                        <td>${book.isbn}</td>
                                        <td>${book.description}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
