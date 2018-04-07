import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHRDriver
{

	public static void main(String[] args)
	{
		boolean login = false;
		do
		{
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter your username:");
			String userName = input.nextLine();
			System.out.print("Please enter your password:");
			String password = input.nextLine();
			
			String fileName = "C://Users//Olly//eclipse-workspace//Software Assignment 1//src//temp.txt";

			try
			{

				FileReader filereader = new FileReader(fileName);

				BufferedReader bufferedReader = new BufferedReader(filereader);

				String lineInput;
				String user = null;

				String pass = null;

				List<String> list = new ArrayList<String>();
				while ((lineInput = bufferedReader.readLine()) != null)
				{
					list.add(lineInput);
					String[] checkCredentials = lineInput.split(" ");
					user = checkCredentials[0];
					pass = checkCredentials[1];

					if (userName.equals(user) && password.equals(pass))
					{
						System.out.println("Successfully logged in as: " + user);
						login = true;
						break;
					}

				}

				if (!userName.equals(user) && !password.equals(pass))
				{
					System.out.println("Could not find user " + userName + " please try again");

				}

				bufferedReader.close();
			} catch (FileNotFoundException ex)
			{
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex)
			{
				System.out.println("Error reading file '" + fileName + "'");

			}
		
		int selection;

		if (userName.equals("admin"))
		{
			do
			{
				System.out.println("\nPlease enter your selection:");
				System.out.println("1 - Add new Staff member:");
				System.out.println("2 - Add staff hours:");
				System.out.println("\n3 - Logout");
				selection = input.nextInt();

				switch (selection)
				{

				case 1:

					Admin a1 = new Admin("ad001", "dave", "english", "1 lake street", "dave@gmail.com", "0400000000",
							1111111);
					a1.hireStaff();
					a1.printStaff();
					break;

				case 2:
				
					System.out.print("Enter staff ID: ");
					String staffID = input.next();
					System.out.print("Start Time: ");
					double startTime = input.nextDouble();
					
					System.out.print("Finish Time: ");
					double finishTime = input.nextDouble();
					System.out.print("Hourly wage $: ");
					double wage = input.nextDouble();

					Payroll pay = new Payroll(staffID,startTime,finishTime, wage);
					pay.addHours(startTime, finishTime, wage);
					
					System.out.println(pay);
					break;

				case 3:
					userName = null;
					password =null;
					System.out.print("You have been logged out\n");
					login = false;
					
					
				}

			} while (selection != 3);
		}
		} while (login == false);
		
	}

}
