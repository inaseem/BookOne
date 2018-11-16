/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dit;

/**
 *
 * @author Naseem
 */
public class Book {
 
    private String title;
    private String author;
    private String description;
    private String isbn;

    public Book(String title, String author, String isbn,String description) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn=isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(this.title).append("#").append(this.author).append("#").append(this.isbn).append("#").append(this.description);
        return sb.toString();
    } 
    
}
