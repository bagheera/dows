
package org.dows;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dows package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DBcsvee_QNAME = new QName("http://www.doc-oriented-ws.org/BookLookup/", "DBcsvee");
    private final static QName _LookupRequest_QNAME = new QName("http://www.doc-oriented-ws.org/BookLookup/", "LookupRequest");
    private final static QName _LookupResponse_QNAME = new QName("http://www.doc-oriented-ws.org/BookLookup/", "LookupResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dows
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Summary }
     * 
     */
    public Summary createSummary() {
        return new Summary();
    }

    /**
     * Create an instance of {@link LookupResponse }
     * 
     */
    public LookupResponse createLookupResponse() {
        return new LookupResponse();
    }

    /**
     * Create an instance of {@link LookupRequest }
     * 
     */
    public LookupRequest createLookupRequest() {
        return new LookupRequest();
    }

    /**
     * Create an instance of {@link Review }
     * 
     */
    public Review createReview() {
        return new Review();
    }

    /**
     * Create an instance of {@link Detail }
     * 
     */
    public Detail createDetail() {
        return new Detail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.doc-oriented-ws.org/BookLookup/", name = "DBcsvee")
    public JAXBElement<String> createDBcsvee(String value) {
        return new JAXBElement<String>(_DBcsvee_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.doc-oriented-ws.org/BookLookup/", name = "LookupRequest")
    public JAXBElement<LookupRequest> createLookupRequest(LookupRequest value) {
        return new JAXBElement<LookupRequest>(_LookupRequest_QNAME, LookupRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.doc-oriented-ws.org/BookLookup/", name = "LookupResponse")
    public JAXBElement<LookupResponse> createLookupResponse(LookupResponse value) {
        return new JAXBElement<LookupResponse>(_LookupResponse_QNAME, LookupResponse.class, null, value);
    }

}
