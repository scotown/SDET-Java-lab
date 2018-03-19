package lab;

import java.util.*;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		// create test Student
		Student stud1 = new Student("Paul McCartney","999887777");
		stud1.setCity("Liverpool");
		stud1.setPhone("011 26262626");
		stud1.setState("");
		
		//stud1.addExpense(200.00);
		stud1.enroll(-2500.00);
		stud1.pay(239.00);
		
		System.out.println("Student 1: " + stud1.toString());
		System.out.println("Current Enrollment: " + stud1.showCourses());
		
		Student stud2 = new Student("George Harrison", "998887776");
		System.out.println("Student 2: " + stud2.toString());
		System.out.println("Current Enrollment: " + stud2.showCourses());
		
	}
}

class Student{
	// static /class level id counter
	private static int iD = 990001;
	
	// default email domain 
	private String emailDomain = "testlab.org";
	
	// private variables
	private String SSN;
	private String name;
	private String userId;
	private String email;
	private double balance;
	private String phone;
	private String city;
	private String state;
	private HashMap<String,String> courses = new HashMap();
	
	// constructors
	public Student(String newName, String newSSN) {
		this.name = newName;
		this.SSN = newSSN;
		this.email = genEmail() + "@" + emailDomain;
		this.userId = genUserId();
		
		iD++;
	}
	
	// overridden methods
	@Override
	public String toString() {
		return "[Name: " + name + "]\n[UserId: " + userId + "]\n[SSN: " + SSN + "]\n[Email: " + email +
				"]\n[Phone: " + phone + "]\n[Balance: " + balance + "]";
	}
	
	// utility methods
	private String genEmail() {
		String email = name.substring(0, 5) + "" + SSN.substring(SSN.length() - 2);
		return email;
	}

	private String genUserId() {
		String uid = iD + "" + ((int)((Math.random() * 8000) + 1000)) + SSN.substring(SSN.length() - 4);
		return uid;
	}

	public void enroll(double tuition) {
		balance = balance + tuition;
		courses.put("psc101", "Physical Science 101");
		courses.put("eng104", "English Literature 104");
	}

	public void pay(double payment) {
		balance = balance + payment;
	}
	
	public String checkBalance() {
		return "Current Balance: " + balance;
	}
	
	public String showCourses() {
		String classList = "";
		
		for (String key : courses.keySet()) {
			if (classList.length() > 0) {
				classList = classList + ", ";
			}
			classList = classList + (String)courses.get(key);
		}
		
		return classList;
	}
	
	// getters and setters
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}

