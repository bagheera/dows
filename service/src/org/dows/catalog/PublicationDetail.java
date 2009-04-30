package org.dows.catalog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicationDetail {
    Date publicationDate;
    int pageCount;
    Publisher publisher;
    public static final SimpleDateFormat MM_DD_YYYY = new SimpleDateFormat("mm/dd/yyyy");

    public PublicationDetail(Date publicationDate, int pageCount, Publisher publisher) {
        this.publicationDate = publicationDate;
        this.pageCount = pageCount;
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Publisher publisher() {
        return publisher;
    }

    public String publicationDateString() {
        return MM_DD_YYYY.format(publicationDate);
    }
}
