
package ua.mega.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "customerService", targetNamespace = "http://webservices.mega.ua/", wsdlLocation = "http://localhost:8080/mywebapp/webservice?wsdl")
public class CustomerService
    extends Service
{

    private final static URL CUSTOMERSERVICE_WSDL_LOCATION;
    private final static WebServiceException CUSTOMERSERVICE_EXCEPTION;
    private final static QName CUSTOMERSERVICE_QNAME = new QName("http://webservices.mega.ua/", "customerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/mywebapp/webservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CUSTOMERSERVICE_WSDL_LOCATION = url;
        CUSTOMERSERVICE_EXCEPTION = e;
    }

    public CustomerService() {
        super(__getWsdlLocation(), CUSTOMERSERVICE_QNAME);
    }

    public CustomerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CUSTOMERSERVICE_QNAME, features);
    }

    public CustomerService(URL wsdlLocation) {
        super(wsdlLocation, CUSTOMERSERVICE_QNAME);
    }

    public CustomerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CUSTOMERSERVICE_QNAME, features);
    }

    public CustomerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CustomerEndpoint
     */
    @WebEndpoint(name = "CustomerEndpointPort")
    public CustomerEndpoint getCustomerEndpointPort() {
        return super.getPort(new QName("http://webservices.mega.ua/", "CustomerEndpointPort"), CustomerEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerEndpoint
     */
    @WebEndpoint(name = "CustomerEndpointPort")
    public CustomerEndpoint getCustomerEndpointPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservices.mega.ua/", "CustomerEndpointPort"), CustomerEndpoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CUSTOMERSERVICE_EXCEPTION!= null) {
            throw CUSTOMERSERVICE_EXCEPTION;
        }
        return CUSTOMERSERVICE_WSDL_LOCATION;
    }

}
