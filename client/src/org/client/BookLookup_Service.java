
/*
 * 
 */

package org.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.1.3
 * Tue Feb 24 15:36:28 IST 2009
 * Generated source version: 2.1.3
 * 
 */


@WebServiceClient(name = "BookLookup", 
                  wsdlLocation = "http://localhost:9009/cxf/book_lookup/?wsdl",
                  targetNamespace = "http://www.doc-oriented-ws.org/BookLookup/") 
public class BookLookup_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://www.doc-oriented-ws.org/BookLookup/", "BookLookup");
    public final static QName BookLookupPort = new QName("http://www.doc-oriented-ws.org/BookLookup/", "BookLookupPort");
    public final static QName TestBookLookupPort = new QName("http://www.doc-oriented-ws.org/BookLookup/", "TestBookLookupPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9009/cxf/book_lookup/?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:9009/cxf/book_lookup/?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public BookLookup_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BookLookup_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookLookup_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns BookLookup
     */
    @WebEndpoint(name = "BookLookupPort")
    public BookLookup getBookLookupPort() {
        return super.getPort(BookLookupPort, BookLookup.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookLookup
     */
    @WebEndpoint(name = "BookLookupPort")
    public BookLookup getBookLookupPort(WebServiceFeature... features) {
        return super.getPort(BookLookupPort, BookLookup.class, features);
    }
    /**
     * 
     * @return
     *     returns TestBookLookup
     */
    @WebEndpoint(name = "TestBookLookupPort")
    public TestBookLookup getTestBookLookupPort() {
        return super.getPort(TestBookLookupPort, TestBookLookup.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestBookLookup
     */
    @WebEndpoint(name = "TestBookLookupPort")
    public TestBookLookup getTestBookLookupPort(WebServiceFeature... features) {
        return super.getPort(TestBookLookupPort, TestBookLookup.class, features);
    }

}
