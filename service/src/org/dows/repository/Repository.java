package org.dows.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.dows.catalog.Author;
import org.dows.catalog.Book;
import org.dows.catalog.BookReview;
import org.dows.catalog.Isbn;
import org.dows.catalog.PublicationDetail;
import org.dows.catalog.Publisher;
import org.dows.catalog.Rating;
import org.dows.catalog.Reviewer;

public class Repository {
    List<Book> books = new ArrayList<Book>();
    private Repository(){
        try {
            books.add(createSingleAuthorBook("howard zinn","people's history of united states", "123-0-456-12345-6", "11/11/1980", "Pearson", 475, zinnReviews()));
            books.add(createSingleAuthorBook("bashm","the glory that was india", "132-0-456-12345-6", "11/01/1970", "Picador India", 412, bashmReviews()));
            books.add(createSingleAuthorBook("peter senge","the fifth discipline", "321-0-456-12345-6", "21/11/1976", "Harper Lee", 362, sengeReviews()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private List<BookReview> sengeReviews() {
        BookReview r1 = new BookReview(new Reviewer("senge-rvr1"), "mgmt speak", Rating.FOUR);
        BookReview r2 = new BookReview(new Reviewer("senge-rvr2"), "awesome", Rating.FIVE);
        List<BookReview> list = new ArrayList<BookReview>();
        list.add(r1);
        list.add(r2);
        return list;
    }

    private List<BookReview> bashmReviews() {
        BookReview r1 = new BookReview(new Reviewer("bashm-rvr1"), "hmmm", Rating.FOUR);
        List<BookReview> list = new ArrayList<BookReview>();
        list.add(r1);
        return list;
    }

    private List<BookReview> zinnReviews() {
        BookReview r1 = new BookReview(new Reviewer("chomsky"), "how true", Rating.THREE);
        BookReview r2 = new BookReview(new Reviewer("zinn-rvr2"), "comphrehensive", Rating.FOUR);
        List<BookReview> list = new ArrayList<BookReview>();
        list.add(r1);
        list.add(r2);
        return list;
    }

    private static final Repository singleton = new Repository();

    public static Repository instance(){
        return singleton;
    }

    public static Book createSingleAuthorBook(String authorName, String bookTitle, String isbnString, String pubDateStr, String publisherName, int numberOfPages, List<BookReview> reviews) throws ParseException {
        return new Book(
                new Author(authorName),
                Author.NONE,
                bookTitle,
                new Isbn(isbnString),
                new PublicationDetail(org.dows.catalog.PublicationDetail.MM_DD_YYYY.parse(pubDateStr), numberOfPages, new Publisher(publisherName)),
                reviews);

    }

    public Book findByIsbn(String isbnString){
        for (Book book : books) {
            if(book.matchesIsbn(isbnString))
                return book;
        }
        return null;
    }

    public List<Book> findByAuthorName(String authorName){
        List<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if(book.authoredBy(authorName)){
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByTitle(String title){
        List<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if(book.hasTitleLike(title)){
                result.add(book);
            }
        }
        return result;
    }

	public void setupBooks(String dBcsv) {
		books.clear();
		BufferedReader br = new BufferedReader(new StringReader(dBcsv));
		String bookString;
		try {
			while((bookString = br.readLine()) != null){
				String[] params = bookString.split(",");
				books.add(createSingleAuthorBook(params[0].trim(), params[1].trim(), params[2].trim(), params[3].trim(), params[4].trim(), Integer.parseInt(params[5].trim()), null));
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
