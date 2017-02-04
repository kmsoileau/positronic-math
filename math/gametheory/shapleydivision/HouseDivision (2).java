package positronic.math.gametheory.shapleydivision;

public class HouseDivision extends ShapleyAnalysis
{
	public static void main(String[] args)
	{
		Claimant[] claimants=new Claimant[]
		{
		 	new Claimant("Kerry",1./3),
		 	new Claimant("John",1./3),
		 	new Claimant("Steve",1./5),
		 	new Claimant("Julie",1./3),
		 	new Claimant("Donna",1./5)
		 };
		ShapleyAnalysis.TOLERANCE=.000001;
		performDivision(1.,claimants);
		
		System.out.println("Name\tClaimed\t\t\tAwarded");
		for(Claimant c:claimants)
			System.out.println(c.getName()+"\t"+c.getClaim()+"\t"+c.getAward());
	}                         	                  	
}