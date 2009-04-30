package org.dows;

import java.util.List;

import junit.framework.Assert;

import org.dows.catalog.Book;
import org.dows.repository.Repository;
import org.junit.Test;

public class RepositoryTest {
	@Test
	public void testSetupBooks(){
		String csv = 
			"howard spinn,people's history of united states, 123-0-456-12345-6, 11/11/1980, Pearson, 475\n" +
			"bashme,the glory that was india, 132-0-456-12345-6, 11/01/1970, Picador India, 412\n" +
			"peterz,the fifth discipline, 321-0-456-12345-6, 21/11/1976, Harper Lee, 362";
		Repository.instance().setupBooks(csv);
		List<Book> bashme = Repository.instance().findByAuthorName("bashme");
		Assert.assertEquals(1, bashme.size());
		Assert.assertEquals("bashme", bashme.get(0).author1().name());
	}
}
