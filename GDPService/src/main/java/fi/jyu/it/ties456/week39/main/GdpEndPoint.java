package fi.jyu.it.ties456.week39.main;

import javax.jws.WebService;

import fi.jyu.miselico.GDP;

//Service Endpoint Interface
@WebService(endpointInterface = "fi.jyu.it.ties456.week39.main.IGdp")
public class GdpEndPoint implements IGdp {
	GDP gdp;
	double gdpValue;

	public double getGdpValue(String countryCode) {
		try {
			gdp = new GDP();
			gdpValue = gdp.getGDP(countryCode);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return gdpValue;
	}
}