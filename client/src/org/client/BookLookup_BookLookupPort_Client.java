
package org.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.1.3
 * Tue Feb 24 15:36:28 IST 2009
 * Generated source version: 2.1.3
 * 
 */

public final class BookLookup_BookLookupPort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.doc-oriented-ws.org/BookLookup/", "BookLookup");

    private BookLookup_BookLookupPort_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = BookLookup_Service.WSDL_LOCATION;
        if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        BookLookup_Service ss = new BookLookup_Service(wsdlURL, SERVICE_NAME);
        BookLookup port = ss.getBookLookupPort();  
        
        {
        System.out.println("Invoking process...");
        org.client.LookupRequest _process_lookupRequest = new org.client.LookupRequest();
        org.client.LookupResponse _process__return = port.process(_process_lookupRequest);
        System.out.println("process.result=" + _process__return);


        }

        System.exit(0);
    }

}