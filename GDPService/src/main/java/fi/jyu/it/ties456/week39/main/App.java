package fi.jyu.it.ties456.week39.main;

import java.util.Scanner;

import fi.jyu.miselico.GDP;

public class App {
	public static void main(String[] args) {
		try {
			GDP gdp = new GDP();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter country code: ");
			String countryCode = scanner.nextLine();
			scanner.close();
			double gdpValue = gdp.getGDP(countryCode);
						
			System.out.println("GDP value: " + gdpValue);
			
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
		}
	}

}
