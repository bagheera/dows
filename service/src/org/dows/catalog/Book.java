package org.dows.catalog;

import java.util.List;

public class Book {
    private Author author1;
    private Author author2;
    private String title;
    private Isbn isbn;
    private PublicationDetail publicationDetail;
    private List<BookReview> reviews;

    public Book(Author author1, Author author2, String title, Isbn isbn, PublicationDetail publicationDetail, List<BookReview> reviews) {
        this.author1 = author1;
        this.author2 = author2;
        if(null == this.author1) this.author1 = Author.NONE;
        if(null == this.author2) this.author2 = Author.NONE;
        this.title = title;
        this.isbn = isbn;
        this.publicationDetail = publicationDetail;
        this.reviews = reviews;
    }

    public Author author1() {
        return author1;
    }

    public Author author2() {
        return author2;
    }

    public String title() {
        return title;
    }

    public Isbn isbn() {
        return isbn;
    }

    public PublicationDetail publicationDetail() {
        return publicationDetail;
    }

    public List<BookReview> reviews() {
        return reviews;
    }

    public boolean hasSecondAuthor() {
        return author2 != null && Author.NONE != author2;
    }

    public boolean matchesIsbn(String isbnString) {
        return isbn.matches(isbnString);
    }

    public boolean authoredBy(String authorName) {
        return author1.matches(authorName) || author2.matches(authorName);
    }

    public boolean hasTitleLike(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}
