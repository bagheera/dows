package org.dows.command;

import java.util.List;

import org.dows.Detail;
import org.dows.LookupResponse;
import org.dows.Review;
import org.dows.Summary;
import org.dows.catalog.Book;
import org.dows.catalog.BookReview;

public class ResponseBuilder {

	public LookupResponse build(List<Book> detailList, List<Book> summaryList) {
		LookupResponse response = new LookupResponse();
		List<Detail> details = response.getDetail();
		if(null != detailList)
			for (Book book : detailList) {
				Detail detail = toDetail(book);
				details.add(detail);
			}
		
		List<Summary> shorts = response.getSummary();
		if(null != summaryList)
			for (Book book : summaryList) {
				Summary summary = toSummary(book);
				shorts.add(summary);
			}
		return response;
	}

	private Summary toSummary(Book book) {
		Summary summary = new  Summary();
		summary.setIsbn(book.isbn().value());
		summary.setTitle(book.title());
		summary.getAuthor().add(book.author1().name());
		summary.getAuthor().add(book.author2().name());
		return summary;
	}

	private Detail toDetail(Book book) {
		Detail detail = new Detail();
		detail.setDateOfPublication(book.publicationDetail()
				.publicationDateString());
		detail.setIsbn(book.isbn().value());
		detail.setPublisher(book.publicationDetail().publisher().name());
		detail.setTitle(book.title());
		List<String> authors = detail.getAuthor();
		authors.add(book.author1().name());
		if (book.hasSecondAuthor())
			authors.add(book.author2().name());
		List<Review> reviews = detail.getReview();
		List<BookReview> bookReviews = book.reviews();
		if (null != bookReviews)
			for (BookReview bookReview : bookReviews) {
				Review review = new Review();
				review.setRating(bookReview.rating().value());
				review.setReviewer(bookReview.reviewer().name());
				review.setReviewText(bookReview.reviewText());
				reviews.add(review);
			}
		return detail;
	}

	public LookupResponse build(Book book) {
		LookupResponse response = new LookupResponse();
		List<Detail> details = response.getDetail();
		details.add(toDetail(book));
		return response;
	}
}
