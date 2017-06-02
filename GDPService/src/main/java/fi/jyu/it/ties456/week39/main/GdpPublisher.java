package fi.jyu.it.ties456.week39.main;



import javax.xml.ws.Endpoint;


import fi.jyu.it.ties456.week39.main.GdpEndPoint;

public class GdpPublisher {
 public static void main(String[] args)  throws Exception{
	Endpoint.publish("http://localhost:9999/ws/gdp", new GdpEndPoint());
}
}
