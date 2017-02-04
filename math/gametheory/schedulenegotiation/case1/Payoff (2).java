package positronic.math.gametheory.schedulenegotiation.case1;

import positronic.math.gametheory.schedulenegotiation.core.IPayoff;

public class Payoff implements IPayoff
{
	private int workerUtility;
	private int bossUtility;
	
	public Payoff(int workerUtility, int bossUtility) 
	{
		this.workerUtility = workerUtility;
		this.bossUtility = bossUtility;
	}
	
	public String toString()
	{
		return "("+this.workerUtility+","+this.bossUtility+")";
	}
}
