package positronic.math.gametheory.shapleydivision;

import java.util.Collections;

public class ShapleyAnalysis 
{
	public static double TOLERANCE=.00001;
	
	public static void performDivision(double toBeDivided, Claimant[] claimants)
	{
		double delta=Double.MAX_VALUE;
		int count=0;
		while(delta>TOLERANCE)
		{
			count++;
			double resourcesRemaining=toBeDivided;
			java.util.Collections.shuffle(java.util.Arrays.asList(claimants));
			delta=0.;
			for(Claimant c:claimants)
			{
				if(resourcesRemaining==0.)
					break;
				double x=(c.getClaim()>resourcesRemaining?resourcesRemaining : c.getClaim());
				resourcesRemaining-=x;
				c.setAward(c.getAward()+x);
				delta+=x/c.getAward();
			}
			Collections.sort(java.util.Arrays.asList(claimants));
		}
		for(Claimant c:claimants)
			c.setAward(c.getAward()/count);
	}
}
