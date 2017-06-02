package fi.jyu.it.ties456.week39.geolocation.main;

import java.rmi.ServerError;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import fi.jyu.it.ties456.week39.gdpsoap.service.GdpEndPointService;
import fi.jyu.it.ties456.week39.gdpsoap.service.IGdp;

@Path("/gdp")
public class LocalGDPService {

	@GET
	@Produces("text/plain")
	public Response getGDP(@QueryParam("long") String longitude,
			@QueryParam("lat") String latitude) {
		double gdpValue=0.0;
		try {
			GeoClient geoClient = new GeoClient();
			String countryCode = geoClient.getCountryCode(longitude, latitude);
			GdpEndPointService service = new GdpEndPointService();
			IGdp endPoint = service.getGdpEndPointPort();
			gdpValue = endPoint.getGdpValue(countryCode);
			return Response.status(200).entity(gdpValue).build();
		} catch (Exception ex) {
			return Response.status(501).entity(ex.getStackTrace()).build();
		}
	}
}