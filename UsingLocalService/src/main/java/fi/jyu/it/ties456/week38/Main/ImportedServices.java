package fi.jyu.it.ties456.week38.Main;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import fi.jyu.it.ties456.week38.services.course.CourseIS;
import fi.jyu.it.ties456.week38.services.course.CourseISService;
import fi.jyu.it.ties456.week38.services.course.NoSuchTeacherException_Exception;
import fi.jyu.it.ties456.week38.services.teacher.TeacherRegistry;
import fi.jyu.it.ties456.week38.services.teacher.TeacherRegistryService;
import fi.jyu.it.ties456.week38.services.teacher.TeacherType;

public class ImportedServices {
	
	public static String createCourse(String courseName, String TeacherId,
			int credits, String Description)
			throws NoSuchTeacherException_Exception {
		Gson gson = new Gson();
		String result = "";
		try {

			CourseISService courseService = new CourseISService();
			CourseIS courseIs = courseService.getCourseISPort();
			result = courseIs.createCourse(courseName, TeacherId, credits,
					Description);
			result = "The course has been added sucessfully, courseId: "+ result;
		} catch (NoSuchTeacherException_Exception e) {
			result = "No such teacher exception, Wrong Teacher Id ";
		} catch (Exception e) {
			result = "Runtime Exception: " + e.getMessage();
		}
		return gson.toJson(result,String.class);
	}

	public static String searchTeacher(String searchString) {
		String result = "";
		Gson gson = new Gson();
		List<TeacherType> personList = new ArrayList<TeacherType>();
		TeacherRegistryService teacherService = new TeacherRegistryService();
		TeacherRegistry registry = teacherService.getTeacherRegistryPort();
		personList = registry.searchForPerson(searchString);

		result = gson.toJson(personList);

		return result;
	}

}
