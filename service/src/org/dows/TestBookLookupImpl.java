
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.dows;

import java.util.logging.Logger;

import org.dows.repository.Repository;

/**
 * This class was generated by Apache CXF 2.1.3
 * Tue Feb 24 15:28:21 IST 2009
 * Generated source version: 2.1.3
 * 
 */

@javax.jws.WebService(
                      serviceName = "BookLookup",
                      portName = "TestBookLookupPort",
                      targetNamespace = "http://www.doc-oriented-ws.org/BookLookup/",
                      wsdlLocation = "file:src/BookLookup.wsdl",
                      endpointInterface = "org.dows.TestBookLookup")
                      
public class TestBookLookupImpl implements TestBookLookup {

    private static final Logger LOG = Logger.getLogger(TestBookLookupImpl.class.getName());

    /* (non-Javadoc)
     * @see org.dows.TestBookLookup#setupBooks(java.lang.String  dBcsvpart )*
     */
    public void setupBooks(java.lang.String dBcsvpart) { 
        LOG.info("Executing operation setupBooks");
        System.out.println(dBcsvpart);
        Repository.instance().setupBooks(dBcsvpart);
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
