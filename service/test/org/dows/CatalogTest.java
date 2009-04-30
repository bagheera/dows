package org.dows;

import static org.junit.Assert.assertTrue;

import org.dows.catalog.Author;
import org.dows.catalog.Book;
import org.junit.Test;

public class CatalogTest {
    @Test
    public void shouldMatchPartialTitlesIgnoringCase(){
        Book b = new Book(null,null,"a quick brown fox",null,null,null);
        assertTrue(b.hasTitleLike("brown FOX"));
    }

    @Test
    public void shouldMatchWithBothAuthors(){
        Author author = new Author("howard zinn");
        Book b = new Book(author,null,"a quick brown fox",null,null,null);
        assertTrue(author.matches("Zinn"));
        assertTrue(b.authoredBy("Howard"));
    }
}
