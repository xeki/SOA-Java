
package fi.jyu.it.ties456.week39.gdpsoap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IGdp", targetNamespace = "http://main.week39.ties456.it.jyu.fi/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IGdp {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://main.week39.ties456.it.jyu.fi/IGdp/getGdpValueRequest", output = "http://main.week39.ties456.it.jyu.fi/IGdp/getGdpValueResponse")
    public double getGdpValue(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
