package positronic.math.gametheory.bestordering;

import java.util.ArrayList;

import positronic.math.RandomPermutation;

public class BestOrdering
{
	public double bestScore=Double.NEGATIVE_INFINITY;
	public ArrayList<Object> bestLineup;
	public static int trials=10000;
	
	public static void main(String[] args)
	{
		OrderPreference s=new OrderPreference();
		BestOrdering.trials=10000;
		BestOrdering b=new BestOrdering(s);
		System.out.println("\n"+b.bestLineup+"\t"+b.bestScore);
	}

	public BestOrdering(OrderPreference s)
	{
		for(int trial=0;trial<BestOrdering.trials;trial++)
		{
			ArrayList<Object> list=new ArrayList<Object>();
			list.addAll(s.keySet());
			ArrayList<Object> r=new RandomPermutation(list);
			double totalScore=0.;
			for(int place=0;place<s.keySet().size();place++)
				totalScore+=s.getOrderPreference((String)r.get(place), place);
			if(totalScore>bestScore)
			{
				bestScore=totalScore;
				bestLineup=r;
			}
		}
	}

	public int getTrials()
	{
		return trials;
	}

	public void setTrials(int trials)
	{
		BestOrdering.trials = trials;
	}
}
