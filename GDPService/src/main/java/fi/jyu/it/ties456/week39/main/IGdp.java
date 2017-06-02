package fi.jyu.it.ties456.week39.main;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)

public interface IGdp {
	
	@WebMethod double getGdpValue(String countyCode);
	

}
