
public class Payroll
{

	private String staffID;
	private double startTime;
	private double finishTime;
	private double totalHours;
	private double wage;
	private double totalPay;

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

		int roundHours = (int) ((finishTime - startTime) / 100);
		double hours = (((finishTime - startTime) / 100) - roundHours) * 100;
		double percentage = hours / 60;

		totalHours = roundHours + percentage;
		if (totalHours >= 0)
		{
			totalPay = wage * totalHours;

		}

	}

	@Override
	public String toString()
	{

		return String.format("\nHours: %.02f Wage: $%.02f Total Pay: $%.02f ", totalHours, wage, totalPay);
	}
}
