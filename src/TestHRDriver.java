import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHRDriver
{

	public static void main(String[] args)
	{
		// login boolean value
		boolean login = false;
		do
		{
			// scanner to get user input
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter your username:");
			// variable for username
			String userName = input.nextLine();
			System.out.print("Please enter your password:");
			// variable for password
			String password = input.nextLine();

			// variable for file location
			// please change the path to your specific path of the temp.txt file
			String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//users.txt";

			try
			{
				// filereader to read the fileName variable above
				FileReader filereader = new FileReader(fileName);

				BufferedReader bufferedReader = new BufferedReader(filereader);
				// variable for lines in the file
				String lineInput;
				// set user to null once they have logged out
				String user = null;
				// set password to null once they have logged out
				String pass = null;

				List<String> list = new ArrayList<String>();
				// read through document while there is a new line in the file
				while ((lineInput = bufferedReader.readLine()) != null)
				{
					list.add(lineInput);
					// array to split text on line to get username and password
					String[] checkCredentials = lineInput.split(" ");
					user = checkCredentials[0];
					pass = checkCredentials[1];

					// condition to check if user exists in the file
					if (userName.equals(user) && password.equals(pass))
					{
						System.out.println("Successfully logged in as: " + user);
						login = true;
						break;
					}

				}
				// not equal condition to display message to user
				if (!userName.equals(user) && !password.equals(pass))
				{
					System.out.println("\nIncorrect password for " + userName + " user please try again");

				}
				// close buffered reader
				bufferedReader.close();

				// catch exception if file not found
			} catch (FileNotFoundException ex)
			{
				System.out.println("Unable to open file '" + fileName + "'");
			}
			// catch exception if IOException
			catch (IOException ex)
			{
				System.out.println("Error reading file '" + fileName + "'");

			}
			// variable to get user selection
			int selection;

			// menu options for an admin user
			if (userName.equals("admin")&& login == true)
			{
				do
				{
					System.out.println("\nPlease enter your selection:");
					System.out.println("1 - Add new Staff member:");
					System.out.println("2 - Add staff hours:");
					System.out.println("\n3 - Logout");
					selection = input.nextInt();

					// switch, depending on option do certain action
					switch (selection)
					{

					case 1:
						// if a 1, add new admin object.
						Admin a1 = new Admin("ad001", "dave", "english", "1 lake street", "dave@gmail.com",
								"0400000000", 1111111);
						// use admin object to call on admin only tasks
						// call hirestaff from the admin class
						a1.hireStaff();
						// call printstaff from the admin class
						a1.printStaff();
						break;

					case 2:
						System.out.print("Enter staff ID: ");
						// variable for staff id
						String staffID = input.next();
						// if a 1, add new payroll object.
						Payroll pay1 = new Payroll(staffID,null, null,null,0);
						//call on add hours method
						pay1.addHours();
						// print out result
						System.out.println(pay1);
						break;

					case 3:
						// logout the user and result values
						userName = null;
						password = null;
						System.out.print("You have been logged out\n");
						// set variable to logout
						login = false;

					}

				} while (selection != 3);
			}
		} while (login == false);

	}

}
