/*L
 *  Copyright Ekagra Software Technologies Ltd.
 *  Copyright SAIC, SAIC-Frederick
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/cacore-sdk/LICENSE.txt for details.
 */

package gov.nih.nci.restgen.generated.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.2
 * 2013-02-21T12:51:05.045-05:00
 * Generated source version: 2.7.2
 * 
 */
@WebService(targetNamespace = "http://customerservice.example.com/", name = "CustomerService")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerService {

    @RequestWrapper(localName = "updateCustomer", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.UpdateCustomer")
    @WebMethod
    @ResponseWrapper(localName = "updateCustomerResponse", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.UpdateCustomerResponse")
    public void updateCustomer(
        @WebParam(name = "customer", targetNamespace = "")
        gov.nih.nci.restgen.generated.client.Customer customer
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getCustomerByName", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.GetCustomerByName")
    @WebMethod
    @ResponseWrapper(localName = "getCustomerByNameResponse", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.GetCustomerByNameResponse")
    public gov.nih.nci.restgen.generated.client.Customer getCustomerByName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    ) throws NoSuchCustomer_Exception;

    @RequestWrapper(localName = "addCustomer", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.AddCustomer")
    @WebMethod
    @ResponseWrapper(localName = "addCustomerResponse", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.AddCustomerResponse")
    public void addCustomer(
        @WebParam(name = "customer", targetNamespace = "")
        gov.nih.nci.restgen.generated.client.Customer customer
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getCustomers", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.GetCustomers")
    @WebMethod
    @ResponseWrapper(localName = "getCustomersResponse", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.GetCustomersResponse")
    public java.util.List<gov.nih.nci.restgen.generated.client.Customer> getCustomers();

    @RequestWrapper(localName = "deleteCustomerById", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.DeleteCustomerById")
    @WebMethod
    @ResponseWrapper(localName = "deleteCustomerByIdResponse", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.DeleteCustomerByIdResponse")
    public void deleteCustomerById(
        @WebParam(name = "id", targetNamespace = "")
        int id
    );

    @RequestWrapper(localName = "deleteCustomer", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.DeleteCustomer")
    @WebMethod
    @ResponseWrapper(localName = "deleteCustomerResponse", targetNamespace = "http://customerservice.example.com/", className = "gov.nih.nci.restgen.generated.client.DeleteCustomerResponse")
    public void deleteCustomer(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );
}
