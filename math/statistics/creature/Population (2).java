package positronic.math.statistics.creature;

import java.util.ArrayList;


public class Population extends ArrayList<Creature>
{
	private static final long serialVersionUID = -4029917176059154275L;

	public Population()
	{
	}
	
	public boolean add(Creature e)
	{
		return super.add(e);
	}
	
	public boolean remove(Measurable e)
	{
		return super.remove(e);
	}

	public Creature sample()
	{
		if(super.size()==1)
			return this.get(0);
		return this.get((int)(Math.random()*this.size()));
	}
	
	public String toString()
	{
		String ret="";
		for(Creature e:this)
			ret+="\n"+e.getMean().measure()+"\t\t"+e.getSd().measure();
		return ret;
	}
}
