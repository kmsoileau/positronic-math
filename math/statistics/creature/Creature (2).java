package positronic.math.statistics.creature;


public class Creature
{
	private Mean mean;
	private StandardDeviation sd;

	public Creature(double mean, double sd)
	{
		this.mean=new Mean(mean);
		this.sd=new StandardDeviation(sd);
	}
	
	public Mean getMean() 
	{
		return mean;
	}

	public StandardDeviation getSd() 
	{
		return sd;
	}
}