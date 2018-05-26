
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
// Muhammad Hamza
// 2016-UET-NML-CS-28
public class Functions {
	private DirectoryOfStudent[] ArrayStudents,SortedStudent;
	private int SIZE,Key,PrimeNo;



	public Functions() throws IOException {
		setSIZE(CalculateRecordinFile());         // Call the CalculateRecordinFile and set the SIZE...
		setPrimeNo(getMaxPrimeNo());             // Get the Maximum Prime No and set to PrimeNo of this Class Attribute...
		System.out.println(getMaxPrimeNo()); 
		System.out.println(SIZE); 

		ArrayStudents=new DirectoryOfStudent[SIZE];		
		for(int i=0; i<getSIZE(); i++) {
			ArrayStudents[i]=new DirectoryOfStudent();
			ArrayStudents[i]=null;
		}
	}

	public void Display() {
		for(int i=0; i<getSIZE(); i++) {
			if(ArrayStudents[i]==null) {
				System.out.println(i+" Null");
			}
			else {
				System.out.print(i+" ");				
				System.out.println(ArrayStudents[i].getFirstName()+";"+ArrayStudents[i].getLastName()+";"+
						ArrayStudents[i].getStudentID()+";"+ArrayStudents[i].getYear()+";"+
						ArrayStudents[i].getEmail()+";"+ArrayStudents[i].getFirstPhonNo()+";"+
						ArrayStudents[i].getSecondPhonNo());	
			}
		}
	}

	public void DisplaySortedArray() {
		this.SortingData();
		for(int i=0; i<getSIZE(); i++) {
			if(SortedStudent[i]!=null) {
				System.out.print(i+" ");				
				System.out.println(SortedStudent[i].getFirstName()+";"+SortedStudent[i].getLastName()+";"+
						SortedStudent[i].getStudentID()+";"+SortedStudent[i].getYear()+";"+
						SortedStudent[i].getEmail()+";"+SortedStudent[i].getFirstPhonNo()+";"+
						SortedStudent[i].getSecondPhonNo());
			}
		}
	}

	// This Function first sort the Data on the BAse of ID then Display on the 
	// Screen and Also Store this Sorted record in Original File...
	public void WriteRecordInOriginallFile() throws IOException {
		this.SortingData();
		this.DisplaySortedArray();
		File TextFile = new File("namal.txt");
		PrintWriter fw=new PrintWriter(TextFile);
		String str=null;
		int i=0;
		while(i<SortedStudent.length) {
			if(SortedStudent[i]==null) {
				i++;
				continue;
			}
			str=(SortedStudent[i].getLastName()+","+SortedStudent[i].getFirstName()+";"+
					SortedStudent[i].getStudentID()+";"+SortedStudent[i].getDepartment()+";"+
					SortedStudent[i].getYear()+";"+SortedStudent[i].getEmail()+";"+
					SortedStudent[i].getFirstPhonNo()+";"+SortedStudent[i].getSecondPhonNo());
			fw.println(str);
			i++;
		}
		fw.close();
		System.err.println("The Sorted Data is Write into the Original File Please Check it...");
	}
	//  This Function Change or Update the Complete record, Corresponding key 
	//   from Record it work when you choose I or i...
	public boolean ChangeAllData(String str,String[] Data) {
		int ind=0;
		int key=this.HashFunction(this.ConvertStringToASCII(str));
		int index=this.Search(key);
		if(index>=0 && ArrayStudents[index].getLastName().equals(str)) {
			ArrayStudents[index].SetData(ArrayStudents[index].getFirstName(), ArrayStudents[index].getLastName(),
					Data[0], Data[1],Data[2], Data[3], Data[4], Data[5]);
			System.err.println("Data is Changed See Index "+index);
			return true;
		}
		else {
			System.err.println(str+" Record is not Found");
		}
		return false;
	}


	// This Function Search the Data Corresponding key and Display it on the Screen...
	public boolean SearchData(String str) {
		int key=this.HashFunction(this.ConvertStringToASCII(str));
		int index=this.Search(key);
		if(index>=0 && ArrayStudents[index].getLastName().equals(str)) {
			System.err.println("Complete Record of "+str+" on  Index is "+index);
			System.err.println(ArrayStudents[index].getFirstName()+";"+ArrayStudents[index].getLastName()+";"+
					ArrayStudents[index].getStudentID()+";"+ArrayStudents[index].getYear()+";"+
					ArrayStudents[index].getEmail()+";"+ArrayStudents[index].getFirstPhonNo()+";"+
					ArrayStudents[index].getSecondPhonNo());
			return true;
		}
		else {
			System.err.println(str+" Record is not Found.");
		}
		return false;
	}

	//  This Function Change or Update the Work Phone No, Corresponding key 
	//   from Record it work when you choose W or w...
	public boolean ChangeWorkPhoneNo(String str,String Workph) {
		int key=this.HashFunction(this.ConvertStringToASCII(str));
		int index=this.Search(key);
		System.out.println(index);
		if(index>=0 && ArrayStudents[index].getLastName().equals(str)) {
			ArrayStudents[index].setSecondPhonNo(Workph);
			System.err.println("Work Phone No is Changed See Index "+index);
			return true;
		}
		else {
			System.err.println(str+" Record is not Found");
		}
		return false;
	}

	//  This Function Change or Update the Home Phone No, Corresponding key 
	//   from Record it work when you choose H or h...
	public boolean ChangeHomePhoneNo(String str,String Homeph) {
		int key=this.HashFunction(this.ConvertStringToASCII(str));
		int index=this.Search(key);
		if(index>=0 && ArrayStudents[index].getLastName().equals(str)) {
			ArrayStudents[index].setFirstPhonNo(Homeph);
			System.err.println("Home Phone is Changed See Index "+index);
			return true;
		}
		else {
			System.err.println(str+" Record is not Found");
		}
		return false;
	}	

	//  This Function Change or Update the E-mail, Corresponding key 
	//   from Record it work when you choose E or e...
	public boolean ChangeEmail(String str,String email) {
		int key=this.HashFunction(this.ConvertStringToASCII(str));
		int index=this.Search(key);
		if(index>=0 && ArrayStudents[index].getLastName().equals(str)) {
			ArrayStudents[index].setEmail(email);
			System.err.println("Email is Changed See Index "+index);
			return true;
		}
		else {
			System.err.println(str+" Record is not Found");
		}
		return false;
	}	

	// Delete Record Function It will call when choose D or d
	public boolean Delete(String  str){
		int key=this.HashFunction(this.ConvertStringToASCII(str));
		int index=this.Search(key);
		System.err.println(index);
		if(index>=0 && ArrayStudents[index].getLastName().equals(str)) {
			ArrayStudents[index]=null;
			System.err.println("Complete Record of "+str+" is Delete "+index);
			return true;
		}
		else {
			System.err.println(str+" Record is not Found.");
		}
		return false;
	}

	// This is Initial Function First time Must be call it load the Data from file to Hash Table... 
	public void LoadDataFromFile() throws IOException {
		File TextFile = new File("namal.txt");
		FileReader fr=new FileReader(TextFile);
		BufferedReader fw = new BufferedReader(fr);

		String str=null;           // Read From File String 
		String[] SpliterStr=null;  // Split the Above string and Store every filed on the ";"
		String[] str1=null;        // It will store the First and Second Name from Zero index of Splitter String
		while ((str = fw.readLine()) != null) {
			SpliterStr=str.split(";");
			str1=SpliterStr[0].split(",");
			DirectoryOfStudent temp=new DirectoryOfStudent();
			temp.setLastName(str1[0]);
			temp.setFirstName(str1[1]);
			temp.setStudentID(SpliterStr[1]);
			temp.setDepartment(SpliterStr[2]);
			temp.setYear(SpliterStr[3]);
			temp.setEmail(SpliterStr[4]);
			temp.setFirstPhonNo(SpliterStr[5]);
			temp.setSecondPhonNo(SpliterStr[6]);
			this.Insert(temp);
		}
	}

	// This is Insert Function It accept the Object and Find its position or index 
	// According to the Hash Function and place or put in Hash Table...
	public void Insert(DirectoryOfStudent obj){
		obj.setKey(this.ConvertStringToASCII(obj.getLastName()));
		int key=this.HashFunction(obj.getKey());
		int ind=0;
		while(true){
			if(key==this.SIZE-1 || (key+(ind*ind))>getSIZE()-1){
				key=0;
			}
			if(ArrayStudents[key+(ind*ind)]==null){
				ArrayStudents[key+(ind*ind)]=obj;
				break;
			}
			else{
				ind++;
			}
		}
		return;
	}


	/// *****Private Function For Internal Purpose of the Directory Student*****

	// This Function Accept a string and convert it into Integer....
	public int ConvertStringToInt(String str) {
		int sum=0,i=0,temp;
		while(i<str.length()) {
			temp=str.charAt(i)-48;
			sum=sum*10;
			sum+=temp;
			i++;
		}
		//System.out.println(sum);
		return sum;
	}
	
	// This Function Sort the Hash Table Data and Store it in Other Array in Sorted Form
	public void SortingData() {
		DirectoryOfStudent[] temp=ArrayStudents;
		for(int i=0; i<temp.length; i++) {

			if(temp[i]==null) {
				continue;
			}
			for(int j=0; j<i; j++){
				if(temp[j]==null) {
					continue;
				}			
				if(this.ConvertStringToInt(temp[i].getStudentID())<this.ConvertStringToInt(temp[j].getStudentID())) {
					DirectoryOfStudent temp1=temp[i];
					temp[i]=temp[j];
					temp[j]=temp1;
				}
			}
			System.out.println(temp[i].getLastName());
		}
		this.setSortedStudent(temp);
	}

	// This Function accept the String and Return its ASCII Value...
	private int ConvertStringToASCII(String str) {
		int counter=0;
		for(int i=0; i<str.length(); i++) {
			counter+=(int)str.charAt(i);
		}
		return counter;
	}

	// Hash Function return the Key...
	private int HashFunction(int key) {
		int Hx=key%PrimeNo;
		setKey(Hx);
		return Hx;
	}

	// This Function for Internal Purpose Searching Function it accept key 
	// and return the Index of the corresponding to key otherwise return -1 ... 
	private int Search(int key) {
		int ind=0;
		while(true){
			if((key+(ind*ind))<this.SIZE) {
				if( ArrayStudents[key+(ind*ind)]==null){
					//System.out.println("Record not Found...");
					return -1;
				}
				else if(this.HashFunction(ConvertStringToASCII(ArrayStudents[key+(ind*ind)].getLastName()))==key ){
					return key+(ind*ind);
				}
				else{
					if(key==SIZE-1){
						key=0;
					}
					ind++;
				}	
			}
			else {
				return -1;
			}

		}
	}

	//  This Function calculate the No of Rows or Record in the File and return it...
	private int CalculateRecordinFile() throws IOException {
		File TextFile = new File("namal.txt");
		FileReader fr=new FileReader(TextFile);
		BufferedReader fw = new BufferedReader(fr);
		String str=null;
		int counter=0;
		while ((str = fw.readLine()) != null) {
			counter++;
		}
		System.out.println(counter);
		fw.close();
		return counter;
	}

	// Private Function For Internal Purpose of the Directory Student 
	//  This Function Find greatest Prime from the Total SIZE of Record...
	private int getMaxPrimeNo() {
		int flage=0;
		for(int i=this.SIZE; i>=1; i--) {
			flage=0;
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					flage=1;
					break;
				}
			}
			if(flage==0) {
				return i;
			}
		}
		return 1;
	}
	// THhis FUnction Return first Prime No Upward of SIZE...
	@SuppressWarnings("unused")
	private int getSmallestPrimeNo() {
		int flage=0;
		for(int i=SIZE; i<2*SIZE; i++) {
			flage=0;
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					flage=1;
					break;
				}
			}
			if(flage==0) {
				return i;
			}
		}
		return 1;		
	}

	//  Setter Getter Functions
	public int getKey() {
		return Key;
	}
	public void setKey(int key) {
		Key = key;
	}
	public void setSIZE(int size) throws IOException {
		this.SIZE=2*size;
	}

	public DirectoryOfStudent[] getArrayStudents() {
		return ArrayStudents;
	}

	public void setArrayStudents(DirectoryOfStudent[] arrayStudents) {
		ArrayStudents = arrayStudents;
	}

	public DirectoryOfStudent[] getSortedStudent() {
		return SortedStudent;
	}

	public void setSortedStudent(DirectoryOfStudent[] sortedStudent) {
		SortedStudent = sortedStudent;
	}

	public int getSIZE() {
		return SIZE;
	}
	public void setPrimeNo(int key) {
		this.PrimeNo=key;
	}
	public int getPrimeNo() {
		return PrimeNo;
	}

}