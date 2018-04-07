import java.io.FileNotFoundException;
import java.util.Scanner;

public class Admin extends AbstractRMITStaff
{
	public Admin(String staffID, String firstName, String lastName, String address, String email, String phone, int tfn)
	{
		super(staffID, firstName, lastName, address, email, phone, tfn);

	}

	private int counter = 1;
	CasualStaff staff[] = new CasualStaff[counter];

	
	//inserting new staff details
	public void hireStaff()
	{ 

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter staff ID:");
		String id = scan.nextLine();
		System.out.println("Enter first name:");
		String firstName = scan.nextLine();
		System.out.println("Enter last name:");
		String lastName = scan.nextLine();
		System.out.println("Enter address:");
		String address = scan.nextLine();
		System.out.println("Enter email address:");
		String email = scan.nextLine();

		System.out.println("Enter phone number:");
		String phone = scan.nextLine();

		System.out.println("Enter tax file number:");
		int tfn = scan.nextInt();
		
        //creates new staff 
		staff[counter - 1] = new CasualStaff(id, firstName, lastName, address, email, phone, tfn);
		System.out.println("New staff member successfully added");
		counter++;

	}

	public void viewApproval()
	{
	
	}
    
	//prints staff details 
	public void printStaff()
	{

		for (int i = 0; i < staff.length; i++)
		{
			System.out.println(staff[i]);

		}

	}

}
