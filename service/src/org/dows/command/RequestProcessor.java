package org.dows.command;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.dows.LookupRequest;
import org.dows.LookupResponse;
import org.dows.catalog.Book;
import org.dows.repository.Repository;

public class RequestProcessor {
    private final LookupRequest request;
    private static final Logger LOG = Logger.getLogger(RequestProcessor.class.getName());

    public RequestProcessor(LookupRequest request) {
        this.request = request;
    }

    public LookupResponse process() {
        List<Book> summaryList = new ArrayList<Book>();
        List<Book> detailList = new ArrayList<Book>();
        if(request.getAuthor().size() > 0){
            for(String author : request.getAuthor()){
                LOG.info("find author "+ author);
                summaryList.addAll(Repository.instance().findByAuthorName(author));
                LOG.info("num results = "+ summaryList.size());
            }
        }
        if(request.getTitle().size() >0){
            for(String title : request.getTitle()){
                LOG.info("find title "+ title);
                summaryList.addAll(Repository.instance().findByTitle(title));
                LOG.info("num results = "+ summaryList.size());
            }
        }
        if(request.getIsbn().size() > 0){
            for(String isbn : request.getIsbn()){
                LOG.info("find isbn "+ isbn);
                Book exactMatch = Repository.instance().findByIsbn(isbn);
                if(exactMatch != null) detailList.add(exactMatch);
                LOG.info("num results = "+ detailList.size());
           }
        }
        return new ResponseBuilder().build(detailList, summaryList);
    }
}
