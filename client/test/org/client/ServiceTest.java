package org.client;

import java.net.URL;

import javax.xml.namespace.QName;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest {
	
    private static final QName SERVICE_NAME = new QName("http://www.doc-oriented-ws.org/BookLookup/", "BookLookup");
    private BookLookup port;
    private TestBookLookup test_port;

    @Before
    public void setup(){
        URL wsdlURL = BookLookup_Service.WSDL_LOCATION;
        BookLookup_Service ss = new BookLookup_Service(wsdlURL, SERVICE_NAME);
        port = ss.getBookLookupPort();
        test_port = ss.getTestBookLookupPort();
    }
    
    @Test
    public void test_should_return_summary_only_for_matching_authors(){
        LookupRequest request = new LookupRequest();
        request.getAuthor().add("peterz");
        String dBcsv =
			"howard spinn,people's history of united states, 123-0-456-12345-6, 11/11/1980, Pearson, 475\n" +
			"bashme,the glory that was india, 132-0-456-12345-6, 11/01/1970, Picador India, 412\n" +
			"peterz,the fifth discipline, 321-0-456-12345-6, 21/11/1976, Harper Lee, 362";        	
		test_port.setupBooks(dBcsv);
        LookupResponse response = port.process(request);
        Assert.assertEquals(1, response.summary.size());
        Assert.assertNull(response.detail);
        Assert.assertEquals("the fifth discipline", response.summary.get(0).getTitle());

    }

    @Test
    public void test_should_return_summary_only_for_matching_title(){
    	LookupRequest request = new LookupRequest();
    	request.getTitle().add("fifth");
    	String dBcsv =
    		"howard spinn,people's history of united states, 123-0-456-12345-6, 11/11/1980, Pearson, 475\n" +
    		"bashme,the glory that was india, 132-0-456-12345-6, 11/01/1970, Picador India, 412\n" +
    		"peterz,the fifth discipline, 321-0-456-12345-6, 21/11/1976, Harper Lee, 362";        	
    	test_port.setupBooks(dBcsv);
    	LookupResponse response = port.process(request);
    	Assert.assertEquals(1, response.summary.size());
    	Assert.assertNull(response.detail);
    	Assert.assertEquals("the fifth discipline", response.summary.get(0).getTitle());
    	
    }

    @Test
    public void test_should_return_detail_for_matching_isbn(){
    	LookupRequest request = new LookupRequest();
    	String dBcsv =
    		"howard spinn,people's history of united states, 123-0-456-12345-6, 11/11/1980, Pearson, 475\n" +
    		"bashme,the glory that was india, 132-0-456-12345-6, 11/01/1970, Picador India, 412\n" +
    		"peterz,the fifth discipline, 321-0-456-12345-6, 21/11/1976, Harper Lee, 362";        	
    	request.getIsbn().add("321-0-456-12345-6");
    	test_port.setupBooks(dBcsv);
    	LookupResponse response = port.process(request);
    	Assert.assertEquals(1, response.detail.size());
    	Assert.assertEquals("the fifth discipline", response.detail.get(0).getTitle());
    	Assert.assertNull(response.summary);
    	
    }
    
}

/*
 * minoccurs 0 max occurs unbounded everywhere (almost) - ok for response to be tighter than request?
 * xsd string everywhere
 * single operation
 * document literal
 * wsdl first (understand wsdl)
 * message types (documents) different from domain types
 * flat message structures mostly
 * switch off runtime schema validation
 * 
 * use classcycle to ensure that dows.catalog (domain) is not aware of dows.document (message)
 */