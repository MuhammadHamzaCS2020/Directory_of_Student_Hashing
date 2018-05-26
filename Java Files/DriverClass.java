import java.io.IOException;
import java.util.Scanner;
// Muhammad Hamza
// 2016-UET-NML-CS-28
public class DriverClass {

	public void Menu() {
		System.out.println("D or d Delete the Record Corresponding to Key.");
		System.out.println("E or e Changing email Address Corresponding to key.");
		System.out.println("F or f Writting Record in Original File inn Sorted Form.");
		System.out.println("H or h Change Home Phone No Corresponding to Key.");
		System.out.println("I or i Change Complete Info Corresponding to Key.");
		System.out.println("P or p Pull Record Corresponding to Key and Display.");
		System.out.println("S or s Show/Display All Record in Sorted Order.");
		System.out.println("W or w Change Work Phone No Corresponding to Key.");
		System.out.println("Q or q Quit the Program.");
		System.out.println("Please Select Your Choice: ");

	}

	public String[] GetData() {
		// Hash TAble SIZE will be double of your Records/Lines in file...
		Scanner input=new Scanner(System.in);
		String str1,str2,str3,str4,str5,str6;

		System.out.print("Enter New ID: ");
		str1=input.next();
		System.out.print("Enter New Department: ");
		str2=input.next();
		System.out.print("Enter Year: ");
		str3=input.next();
		System.out.print("Enter New Email: ");
		str4=input.next();
		System.out.print("Enter New Home Phone No: ");
		str5=input.next();
		System.out.print("Enter New Work Phone: ");
		str6=input.next();
		String[] CollectData={str1,str2,str3,str4,str5,str6};

		return CollectData;

	}

	public static void main(String[] args) throws IOException {

		DriverClass driver=new DriverClass();
		Functions obj=new Functions();

		char choice;
		String inputkey,inputOther;
		Scanner input=new Scanner(System.in);
		obj.LoadDataFromFile();   // this Function load the Data from file to Hash Function
		obj.Display();
		// This Infinite time loop Get the user choice,
		// perform the task according to input
		while(true) {
			driver.Menu();
			choice=input.next().charAt(0);
			switch(choice) {
			case 'D':
			case 'd':
				System.out.print("Enter key whos Record you want to Delete: ");
				inputkey=input.next();		
				obj.Delete(inputkey);
				break;
			case 'E':
			case 'e':
				System.out.print("Enter key whos Email you want to Change Email: ");
				inputkey=input.next();
				System.out.print("Enter New Email: ");
				inputOther=input.next();
				obj.ChangeEmail(inputkey,inputOther);
				break;			
			case 'F':
			case 'f':
				obj.WriteRecordInOriginallFile();
				break;
			case 'H':
			case 'h':
				System.out.print("Enter key whos Home Phone No you want to Change : ");
				inputkey=input.next();
				System.out.print("Enter New Home Phone No: ");
				inputOther=input.next();
				obj.ChangeHomePhoneNo(inputkey,inputOther);
				break;
			case 'I':
			case 'i':
				System.out.print("Enter key whos Data you want to Change : ");
				inputkey=input.next();
				obj.ChangeAllData(inputkey, driver.GetData());
				break;
			case 'P':
			case 'p':
				System.out.print("Enter key whos Data you want to See : ");
				inputkey=input.next();
				obj.SearchData(inputkey);
				break;
			case 'S':
			case 's':
				obj.DisplaySortedArray();
				break;
			case 'W':
			case 'w':
				System.out.print("Enter key whos Work Phone No you want to Change : ");
				inputkey=input.next();
				System.out.print("Enter New Work Phone No: ");
				inputOther=input.next();
				obj.ChangeWorkPhoneNo(inputkey,inputOther);
				break;
			default:
				System.out.println("      ");
			}
			if(choice=='Q' || choice=='q') {
				break;
			}
			obj.Display();
		}
	}
}
