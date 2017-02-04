package positronic.math.gametheory.shapleydivision;

public class Claimant implements Comparable<Object>
{
	private String name;
	private double claim;
	private double award;
	
	public Claimant(String name, double claim)
	{
		this.setName(name);
		this.setClaim(claim);
	}

	public int compareTo(Object arg0) 
	{
		if(!(arg0 instanceof Claimant))
			return -1;
		Claimant c=(Claimant)arg0;
		return this.name.compareTo(c.name);
	}

	public double getAward()
	{
		return award;
	}

	public double getClaim()
	{
		return claim;
	}

	public String getName()
	{
		return name;
	}

	public void setAward(double award)
	{
		this.award = award;
	}

	public void setClaim(double claim)
	{
		this.claim = claim;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}