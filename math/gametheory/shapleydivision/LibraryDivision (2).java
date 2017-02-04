package positronic.math.gametheory.shapleydivision;

public class LibraryDivision extends ShapleyAnalysis
{
	public static void main(String[] args)
	{
		Claimant[] claimants=new Claimant[]
		{
				new Claimant("A",60),
		 		new Claimant("B",30),
		 		new Claimant("C",10),
		 		new Claimant("D",60),
		 		new Claimant("E",30),
		 		new Claimant("F",10),
		 		new Claimant("G",60),
		 		new Claimant("H",30),
		 		new Claimant("I",10),
		 		new Claimant("J",60),
		 };
		ShapleyAnalysis.TOLERANCE=.000001;
		performDivision(100,claimants);
		
		System.out.println("Name\tClaimed\t\t\tAwarded");
		for(Claimant c:claimants)
			System.out.println(c.getName()+"\t"+c.getClaim()+"\t"+c.getAward());
	}                         	                  	
}
