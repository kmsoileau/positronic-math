package positronic.math.gametheory.shapleydivision;

public class ShapleyValue extends ShapleyAnalysis
{
	public static void main(String[] args)
	{
		Claimant[] claimants=new Claimant[]
				{
		 				new Claimant("A",8.),
		 				new Claimant("B",11.),
		 				new Claimant("C",17.),
		 				new Claimant("D",19.),
		 		};
		
		ShapleyAnalysis.TOLERANCE=.001;
		performDivision(19.,claimants);
		for(Claimant c:claimants)
			System.out.println(c.getName()+"\t"+c.getClaim()+"\t"+c.getAward());
	}                         	
}
