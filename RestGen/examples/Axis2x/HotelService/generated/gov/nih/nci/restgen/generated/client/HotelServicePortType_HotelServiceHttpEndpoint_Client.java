/*L
 *  Copyright Ekagra Software Technologies Ltd.
 *  Copyright SAIC, SAIC-Frederick
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/cacore-sdk/LICENSE.txt for details.
 */

package gov.nih.nci.restgen.generated.client;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.2
 * 2013-02-22T09:22:25.933-05:00
 * Generated source version: 2.7.2
 * 
 */
public final class HotelServicePortType_HotelServiceHttpEndpoint_Client {

    private static final QName SERVICE_NAME = new QName("http://hotel.example.com", "HotelService");

    private HotelServicePortType_HotelServiceHttpEndpoint_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HotelService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
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
      
        HotelService ss = new HotelService(wsdlURL, SERVICE_NAME);
        HotelServicePortType port = ss.getHotelServiceHttpEndpoint();  
        
        {
        System.out.println("Invoking getRestaurantChef...");
        java.lang.String _getRestaurantChef_restaurantName = "";
        java.lang.String _getRestaurantChef_chefName = "";
        gov.nih.nci.restgen.generated.client.Chef _getRestaurantChef__return = port.getRestaurantChef(_getRestaurantChef_restaurantName, _getRestaurantChef_chefName);
        System.out.println("getRestaurantChef.result=" + _getRestaurantChef__return);


        }
        {
        System.out.println("Invoking fireChef...");
        java.lang.Integer _fireChef_chefId = null;
        java.lang.Integer _fireChef_restaurantId = null;
        port.fireChef(_fireChef_chefId, _fireChef_restaurantId);


        }
        {
        System.out.println("Invoking getHotel...");
        java.lang.String _getHotel_name = "";
        gov.nih.nci.restgen.generated.client.Hotel _getHotel__return = port.getHotel(_getHotel_name);
        System.out.println("getHotel.result=" + _getHotel__return);


        }
        {
        System.out.println("Invoking getRestaurants...");
        java.lang.String _getRestaurants_hotelName = "";
        java.util.List<gov.nih.nci.restgen.generated.client.Restaurant> _getRestaurants__return = port.getRestaurants(_getRestaurants_hotelName);
        System.out.println("getRestaurants.result=" + _getRestaurants__return);


        }
        {
        System.out.println("Invoking hireChef...");
        gov.nih.nci.restgen.generated.client.Chef _hireChef_chef = null;
        java.lang.Integer _hireChef_restaurantId = null;
        port.hireChef(_hireChef_chef, _hireChef_restaurantId);


        }

        System.exit(0);
    }

}
