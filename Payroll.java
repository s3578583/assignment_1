
public class Payroll
{
	//variable for staff ID.
	private String staffID;
	private double startTime;
	private double finishTime;
	private double totalHours;
	private double wage;
	private double totalPay;

	//constructor 
	public Payroll(String staffID, double startTime, double finishTime, double wage)
	{
		this.staffID = staffID;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.wage = wage;
	}

	public String getstaffID()
	{
		return staffID;
	}

	public double getStartTime()
	{
		return startTime;
	}

	public double getFinishTime()
	{
		return finishTime;
	}

	public double getWage()
	{
		return wage;
	}

	public void addHours(double startTime, double finishTime, double wage)
	{

		//variable to round hours to even number
		int roundHours = (int) ((finishTime - startTime) / 100);
		//variable to get the rounded minutes from the variable above 
		double hours = (((finishTime - startTime) / 100) - roundHours) * 100;
		//variable to calculate those minutes in a 60 scale
		double percentage = hours / 60;

		//variable to store rounded hours and percentage 
		totalHours = roundHours + percentage;
		
		if (totalHours >= 0)
		{
			//calculate wages
			totalPay = wage * totalHours;

		}

	}

	@Override
	public String toString()
	{
		//print out the total hours, wage and page of inputted record.
		return String.format("\nHours: %.02f Wage: $%.02f Total Pay: $%.02f ", totalHours, wage, totalPay);
	}
}
