// Muhammad Hamza
// 2016-UET-NML-CS-28
public class DirectoryOfStudent {
	private String FirstName,LastName,
	               StudentID,Department,Year;
	private String Email,HomePhoneNo,WorkPhonNo;
	private int Key;
	
	
	
	public int getKey() {
		return Key;
	}

	public void setKey(int key) {
		Key = key;
	}

	// This is a By default Constructor  
	public DirectoryOfStudent() {
		super();
	}
	
	// These are all Setter getter functions of this Class fields or attributes...
	public void SetData(String firstName, String lastName, String studentID, String department,String year,
			String email, String firstPhonNo, String secondPhonNo) {
		FirstName = firstName;
		LastName = lastName;
		StudentID = studentID;
		Department = department;
		Year = year;
		Email = email;
		HomePhoneNo = firstPhonNo;
		WorkPhonNo = secondPhonNo;
	}

	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getStudentID() {
		return StudentID;
	}
	public void setStudentID(String studentID) {
		StudentID = studentID;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getFirstPhonNo() {
		return HomePhoneNo;
	}
	public void setFirstPhonNo(String firstPhonNo) {
		HomePhoneNo = firstPhonNo;
	}
	public String getSecondPhonNo() {
		return WorkPhonNo;
	}
	public void setSecondPhonNo(String secondPhonNo) {
		WorkPhonNo = secondPhonNo;
	}

}
