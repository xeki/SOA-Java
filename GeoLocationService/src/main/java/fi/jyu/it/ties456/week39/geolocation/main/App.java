package fi.jyu.it.ties456.week39.geolocation.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;



public class App {
	
	Server server = new Server(8888);
	ServletHandler handler = new ServletHandler();
	// add all servlets you want to use to the handler, the second
	// argument is the path
//	handler.
//	// make the SearchTeacher Servlet accessible from
//	// http://localhost:8080/search
//	handler.addServletWithMapping(SearchTeacherAPI.class,
//			"/searchTeacher");
//	
//	handler.addServletWithMapping(CourseDetailAPI.class,
//			"/courseDetail");
//	// Create a new Server, add the handler to it and start
//	server.setHandler(handler);
//	server.start();
//	// this dumps a lot of debug output to the console.
//	server.dumpStdErr();
//	server.join();

//	
//	public double countryGDP(String countryCode){
//		// call to SOAP GDP web service;
//		//same as assignment 2
//		return 45.45;
//	}
//	
//	// do all cachings
//	
//	public static void main(String[] args) {
//		//getCountryCode("a", "b");
//	}
}

