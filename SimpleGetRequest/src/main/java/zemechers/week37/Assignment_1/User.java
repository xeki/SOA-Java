package zemechers.week37.Assignment_1;



public class User {
	private String dateOfBirth;
	private String displayName;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;

	public User() {

	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
	 this.dateOfBirth = dateOfBirth;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [dateOfBirth=" + dateOfBirth + ", displayName="
				+ displayName + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + "]";
	}
}
