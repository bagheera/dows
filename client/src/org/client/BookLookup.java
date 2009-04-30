package org.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.1.3
 * Tue Feb 24 15:36:28 IST 2009
 * Generated source version: 2.1.3
 * 
 */
 
@WebService(targetNamespace = "http://www.doc-oriented-ws.org/BookLookup/", name = "BookLookup")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface BookLookup {

    @WebResult(name = "LookupResponse", targetNamespace = "http://www.doc-oriented-ws.org/BookLookup/", partName = "LookupResponse")
    @WebMethod(action = "http://www.doc-oriented-ws.org/BookLookup/process")
    public LookupResponse process(
        @WebParam(partName = "LookupRequest", name = "LookupRequest", targetNamespace = "http://www.doc-oriented-ws.org/BookLookup/")
        LookupRequest lookupRequest
    );
}
