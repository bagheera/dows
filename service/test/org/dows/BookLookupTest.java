package org.dows;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.dows.catalog.Book;
import org.dows.catalog.BookReview;
import org.dows.catalog.Rating;
import org.dows.catalog.Reviewer;
import org.dows.command.RequestProcessor;
import org.dows.command.ResponseBuilder;
import org.dows.repository.Repository;
import org.junit.Assert;
import org.junit.Test;

public class BookLookupTest {
    @Test
    public void testMappingOfABookToALookupResponse() throws ParseException {
        String authorName = "taleb";
        String bookTitle = "fooled by randomness";
        String isbnString = "978-0-141-03148-4";
        String pubDateStr = "04/01/2000";
        String publisherName = "Penguin";
        int numberOfPages = 334;
        Book b = Repository.createSingleAuthorBook(authorName, bookTitle, isbnString, pubDateStr, publisherName, numberOfPages, getReviews());
        LookupResponse response = new ResponseBuilder().build(b);
        List<Detail> details = response.getDetail();
        Detail detail = details.get(0);
        assertEquals(authorName, detail.getAuthor().get(0));
        assertEquals(bookTitle, detail.getTitle());
        assertEquals(isbnString, detail.getIsbn());
        assertEquals(pubDateStr, detail.getDateOfPublication());
        assertEquals(publisherName, detail.getPublisher());
        assertEquals(2, detail.getReview().size());
    }

    private List<BookReview> getReviews() {
        BookReview r1 = new BookReview(new Reviewer("gladwell"), "wall street's principal dissident", Rating.FOUR);
        BookReview r2 = new BookReview(new Reviewer("kay"), "brilliant", Rating.FIVE);
        List<BookReview> list = new ArrayList<BookReview>();
        list.add(r1);
        list.add(r2);
        return list;
    }

    @Test
    public void test_should_return_detail_for_matching_isbn(){
    	LookupRequest request = new LookupRequest();
    	String dBcsv =
    		"howard spinn,people's history of united states, 123-0-456-12345-6, 11/11/1980, Pearson, 475\n" +
    		"bashme,the glory that was india, 132-0-456-12345-6, 11/01/1970, Picador India, 412\n" +
    		"peterz,the fifth discipline, 321-0-456-12345-6, 21/11/1976, Harper Lee, 362";        	
    	request.getIsbn().add("321-0-456-12345-6");
    	Repository.instance().setupBooks(dBcsv);
    	LookupResponse response = new RequestProcessor(request).process();
    	Assert.assertEquals(1, response.detail.size());
    	Assert.assertEquals("the fifth discipline", response.detail.get(0).getTitle());
    	Assert.assertEquals(0, response.summary.size());
    	
    }
}
