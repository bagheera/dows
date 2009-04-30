package org.dows.catalog;

public class BookReview {
    private Reviewer reviewer;
    private String reviewText;
    private Rating rating;

    public BookReview(Reviewer reviewer, String reviewText, Rating rating) {
        this.reviewer = reviewer;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Reviewer reviewer() {
        return reviewer;
    }

    public String reviewText() {
        return reviewText;
    }

    public Rating rating() {
        return rating;
    }
}
