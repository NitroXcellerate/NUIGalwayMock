package nuig;


import java.util.ArrayList;

import org.joda.time.DateTime;

import entities.Course;
import entities.Module;
import entities.Student;

public class MockUni {

	public static void main(String[] args) {
		Student s1 = new Student("John Smith", new DateTime(1997, 11, 2, 0, 0), 15479985);
		Student s2 = new Student("Arnold Jamenson", new DateTime(1998, 1, 14, 0, 0), 54826571);
		Student s3 = new Student("Mary Mac", new DateTime(1997, 7, 11, 0, 0), 75321598);
		Student s4 = new Student("Finlay Mazillius", new DateTime(1995, 5, 17, 0, 0), 54875321);
		Student s5 = new Student("Nichol Eastes", new DateTime(1998, 5, 14, 0, 0), 56487952);
		Student s6 = new Student("Rosalynd Dilliway", new DateTime(1997, 7, 11, 0, 0), 12547862);
		Student s7 = new Student("Brandon Coonihan", new DateTime(1996, 12, 24, 0, 0), 12547896);
		Student s8 = new Student("Erda Bucklee", new DateTime(1998,8, 10, 0, 0), 35741587);
		Student s9 = new Student("Tab Walker", new DateTime(1997, 9, 16, 0, 0), 46582159);

		Module maths = new Module("Mathematical Methods", "MA385");             
		Module telecomms = new Module("Telecommunication Software Application", "EE453");         
		Module softEng = new Module("Software Engineering III", "CT417", new ArrayList<Student>(), new ArrayList<Course>());   
		Module physics = new Module("Physics", "PH140", new ArrayList<Student>(), new ArrayList<Course>());             
		Module machLearn = new Module("Machine Learning and Data Mining I", "CT475", new ArrayList<Student>(), new ArrayList<Course>());         
		Module socd1 = new Module("System on Chip Design 1", "EE451", new ArrayList<Student>(), new ArrayList<Course>());   
		
		Course ece = new Course("4BP2", new DateTime(2018, 9, 1, 0, 0), new DateTime(2019, 6, 24, 0, 0));
		Course csit = new Course("CSIT", new DateTime(2018, 9, 2, 0, 0), new DateTime(2019, 6, 25, 0, 0));
		
		// Add students to modules
		maths.addStudent(s1);
		maths.addStudent(s2);
		maths.addStudent(s6);
		
		telecomms.addStudent(s1);
		telecomms.addStudent(s3);
		telecomms.addStudent(s4);
		
		socd1.addStudent(s3);
		socd1.addStudent(s2);
		socd1.addStudent(s4);
		
		softEng.addStudent(s1);
		softEng.addStudent(s3);
		softEng.addStudent(s5);
		softEng.addStudent(s6);
		
		physics.addStudent(s7);
		physics.addStudent(s8);
		physics.addStudent(s9);
		
		machLearn.addStudent(s7);
		machLearn.addStudent(s9);
		machLearn.addStudent(s1);
		
		// Add modules to courses
		ece.addModule(maths);
		ece.addModule(telecomms);
		ece.addModule(socd1);
		ece.addModule(softEng);
		
		csit.addModule(softEng);
		csit.addModule(machLearn);
		csit.addModule(physics);
		
		// Add students to courses
		ece.addStudent(s1);
		ece.addStudent(s2);
		ece.addStudent(s3);
		ece.addStudent(s4);
		ece.addStudent(s6);
		
		csit.addStudent(s5);
		csit.addStudent(s7);
		csit.addStudent(s8);
		csit.addStudent(s9);
		
		// Add courses to modules
		maths.addCourse(ece);
		telecomms.addCourse(ece);
		socd1.addCourse(ece);
		softEng.addCourse(ece);
		
		physics.addCourse(csit);
		softEng.addCourse(csit);
		machLearn.addCourse(csit);
		
		// Add course to students
		s1.setCourse(ece);
		s2.setCourse(ece);
		s3.setCourse(ece);
		s4.setCourse(ece);
		s6.setCourse(ece);
		
		s5.setCourse(csit);
		s7.setCourse(csit);
		s8.setCourse(csit);
		s9.setCourse(csit);
		
		// Add modules to students
		s1.addModule(maths);
		s1.addModule(telecomms);
		s1.addModule(softEng);
		
		s2.addModule(maths);
		s2.addModule(socd1);
		
		s3.addModule(telecomms);
		s3.addModule(socd1);
		s3.addModule(softEng);
		
		s4.addModule(telecomms);
		s4.addModule(socd1);
		
		s6.addModule(maths);
		s6.addModule(softEng);
		
		s5.addModule(softEng);
		s5.addModule(machLearn);
		
		s7.addModule(physics);
		s7.addModule(machLearn);
		
		s8.addModule(physics);
		
		s9.addModule(physics);
		s9.addModule(machLearn);
		
		// Prints
		ArrayList<Course> courseList = new ArrayList<Course>();
		courseList.add(ece);
		courseList.add(csit);
		
		for (Course course : courseList) {
			System.out.println("Course: " + course.getName());
			System.out.println("    Respective Modules: ");
			for (Module module : course.getModules()) {
				System.out.println("        " + module.getName());
			}
		}
		
		for (Course course: courseList) {
			for  (Student student : course.getStudents()) {
				System.out.println("Student: " + student.getName());
				System.out.println("    Username: " + student.getUsername());
				System.out.println("    Modules Registered: ");
				for (Module module : student.getModules()) {
					System.out.println("        " + module.getName());
				}
				System.out.println("    Course: " + student.getCourse().getName());
			}
		}
		
		
				
		
	}

}
