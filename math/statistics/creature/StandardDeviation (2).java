package positronic.math.statistics.creature;


public class StandardDeviation implements Measurable 
{
	private double value;
	
	public StandardDeviation(double x)
	{
		this.value=x;
	}
	
	public double measure() 
	{
		return value;
	}
}