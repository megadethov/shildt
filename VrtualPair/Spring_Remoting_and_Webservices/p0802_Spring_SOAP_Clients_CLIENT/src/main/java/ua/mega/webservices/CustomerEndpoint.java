
package ua.mega.webservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerEndpoint", targetNamespace = "http://webservices.mega.ua/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerEndpoint {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "newCustomer", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.NewCustomer")
    @ResponseWrapper(localName = "newCustomerResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.NewCustomerResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/newCustomerRequest", output = "http://webservices.mega.ua/CustomerEndpoint/newCustomerResponse")
    public void newCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        Customer arg0);

    /**
     * 
     * @param arg0
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateCustomer", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.UpdateCustomer")
    @ResponseWrapper(localName = "updateCustomerResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.UpdateCustomerResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/updateCustomerRequest", output = "http://webservices.mega.ua/CustomerEndpoint/updateCustomerResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.mega.ua/CustomerEndpoint/updateCustomer/Fault/CustomerNotFoundException")
    })
    public void updateCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        Customer arg0)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteCustomer", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.DeleteCustomer")
    @ResponseWrapper(localName = "deleteCustomerResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.DeleteCustomerResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/deleteCustomerRequest", output = "http://webservices.mega.ua/CustomerEndpoint/deleteCustomerResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.mega.ua/CustomerEndpoint/deleteCustomer/Fault/CustomerNotFoundException")
    })
    public void deleteCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        Customer arg0)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns ua.mega.webservices.Customer
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerById", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.FindCustomerById")
    @ResponseWrapper(localName = "findCustomerByIdResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.FindCustomerByIdResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/findCustomerByIdRequest", output = "http://webservices.mega.ua/CustomerEndpoint/findCustomerByIdResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.mega.ua/CustomerEndpoint/findCustomerById/Fault/CustomerNotFoundException")
    })
    public Customer findCustomerById(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<ua.mega.webservices.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomersByName", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.FindCustomersByName")
    @ResponseWrapper(localName = "findCustomersByNameResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.FindCustomersByNameResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/findCustomersByNameRequest", output = "http://webservices.mega.ua/CustomerEndpoint/findCustomersByNameResponse")
    public List<Customer> findCustomersByName(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "recordCall", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.RecordCall")
    @ResponseWrapper(localName = "recordCallResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.RecordCallResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/recordCallRequest", output = "http://webservices.mega.ua/CustomerEndpoint/recordCallResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.mega.ua/CustomerEndpoint/recordCall/Fault/CustomerNotFoundException")
    })
    public void recordCall(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Call arg1)
        throws CustomerNotFoundException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<ua.mega.webservices.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllCustomers", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.GetAllCustomers")
    @ResponseWrapper(localName = "getAllCustomersResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.GetAllCustomersResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/getAllCustomersRequest", output = "http://webservices.mega.ua/CustomerEndpoint/getAllCustomersResponse")
    public List<Customer> getAllCustomers();

    /**
     * 
     * @param arg0
     * @return
     *     returns ua.mega.webservices.Customer
     * @throws CustomerNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFullCustomerDetail", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.GetFullCustomerDetail")
    @ResponseWrapper(localName = "getFullCustomerDetailResponse", targetNamespace = "http://webservices.mega.ua/", className = "ua.mega.webservices.GetFullCustomerDetailResponse")
    @Action(input = "http://webservices.mega.ua/CustomerEndpoint/getFullCustomerDetailRequest", output = "http://webservices.mega.ua/CustomerEndpoint/getFullCustomerDetailResponse", fault = {
        @FaultAction(className = CustomerNotFoundException_Exception.class, value = "http://webservices.mega.ua/CustomerEndpoint/getFullCustomerDetail/Fault/CustomerNotFoundException")
    })
    public Customer getFullCustomerDetail(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0)
        throws CustomerNotFoundException_Exception
    ;

}