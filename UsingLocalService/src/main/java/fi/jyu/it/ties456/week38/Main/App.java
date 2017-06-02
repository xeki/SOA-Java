package fi.jyu.it.ties456.week38.Main;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fi.jyu.it.ties456.week38.services.course.CreateCourse;
import fi.jyu.it.ties456.week38.services.course.NoSuchTeacherException_Exception;
import fi.jyu.it.ties456.week38.services.teacher.TeacherType;

public class App {
	private static Scanner scanner; 
	public static void main(String[] args)
			throws NoSuchTeacherException_Exception {
		try
		{
			handleOptions();
		}
		catch(NoSuchTeacherException_Exception e)
		{
			System.out.println("Wrong Teacher Id: " + e.getMessage());
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}

	public static void handleOptions() throws NoSuchTeacherException_Exception {
		try {
			scanner = new Scanner(System.in);
		String choice = setUserOptions();
		if (choice.compareTo("s")==0) {
			searchForTeacher();
		} else if (choice.compareTo("c")==0) {
			createCourse();
		} else if (choice.compareTo("q")==0) {
			Runtime.getRuntime().halt(0);
		} else {
			System.out.println("Please type your choice again: ");
		}
		
		}
		catch(NoSuchTeacherException_Exception e)
		{
			throw(e);
			
		}
		handleOptions();
	}

	public static void createCourse() throws NoSuchTeacherException_Exception {
		String result = "";

		try {
			CreateCourse course = new CreateCourse();
			System.out.print("Enter course Name: ");
			course.setName(scanner.nextLine());
			System.out.print("Enter Teacher Id: ");
			course.setTeacherID(scanner.nextLine().toLowerCase());
			System.out.print("Enter course credits: ");
			course.setNumberOfCredits(Integer.valueOf(scanner.nextLine()));
			System.out.print("Enter course Description: ");
			course.setDescription(scanner.nextLine());
			

			result = ImportedServices.createCourse(course.getName(),
					course.getTeacherID(), course.getNumberOfCredits(),
					course.getDescription());

			System.out.println(result);
		} catch (NoSuchTeacherException_Exception e) {
			throw(e);
		} catch (Exception e) {
			System.out.println("Runtime Exception: " + e.getMessage());
		}
	}

	public static void searchForTeacher() {

		String resultString;
		String serarchString;
		List<TeacherType> personList = new ArrayList<TeacherType>();
		System.out.print("Type the search string: ");
		serarchString = scanner.nextLine();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<TeacherType>>() {
		}.getType();

		resultString = ImportedServices.searchTeacher(serarchString);
		// usually if there is no teacher the resultString is square brackets
		if (resultString.length() < 5) {
			System.out.println("No teacher data has been found");
		} else {
			try {
				personList = gson.fromJson(resultString, listType);
				if (personList != null) {
					for (TeacherType temp : personList) {
						System.out.println("ID :" + temp.getID()
								+ " First Name: " + temp.getFirstname()
								+ " Email: " + temp.getEmail());

					}
				}

			} catch (Exception e) {
				System.out.println("Error :" + e.getMessage());
			}
		}

	}

	public static String setUserOptions() {
		String userChoice = "";
		System.out.println("******Enter your choice********");
		System.out.println("To search for a course type C: ");
		System.out.println("To serach for a teacher type S: ");
		System.out.println("To quit the program type Q: ");
		userChoice = scanner.nextLine();

		return userChoice.toLowerCase().trim();

	}
}
