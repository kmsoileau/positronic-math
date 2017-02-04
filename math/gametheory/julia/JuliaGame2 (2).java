package positronic.math.gametheory.julia;

import java.util.HashMap;

public class JuliaGame2 extends JuliaGame
{
	public static void main(String[] args)
	{
		/**
		 * In the '50's Julia Robinson published an iterative method for 
		 * solving a two-person zero-sum game. Players A and B both make
		 * initial plays (probably at random). Each notes the other's
		 * play and calculates the best second play assuming the opponent
		 * makes the same play as at first. Now each player has a two
		 * member history of the other person's play. The third move of
		 * each is the optimal play assuming the opponent will select a
		 * move from the opponents current history of play, each move
		 * being equally likely. If play continues like this over larger 
		 * and larger histories, the play will converge to an optimal
		 * strategy for that game.
		 * 
		 * see Julia Robinson, An Iterative Method of Solving a Game, 
		 * The Annals of Mathematics, 2nd Ser., Vol. 54, No. 2 (Sep., 1951), 
		 * pp. 296-301
		 */
		JuliaGame2 g=new JuliaGame2();
		IMove Blue1=new Move("Blue1");
		IMove Blue2=new Move("Blue2");
		IMove Blue3=new Move("Blue3");
		IMove Blue12=new Move("Blue12");
		IMove Blue13=new Move("Blue13");
		IMove Blue23=new Move("Blue23");
		IMove Red1=new Move("Red1");
		IMove Red2=new Move("Red2");
		IMove Red3=new Move("Red3");
		IMove Red12=new Move("Red12");
		IMove Red13=new Move("Red13");
		IMove Red23=new Move("Red23");
		
		g.bluemoves.add(Blue1);
		g.bluemoves.add(Blue2);
		g.bluemoves.add(Blue3);
		g.bluemoves.add(Blue12);
		g.bluemoves.add(Blue13);
		g.bluemoves.add(Blue23);
		g.redmoves.add(Red1);
		g.redmoves.add(Red2);
		g.redmoves.add(Red3);
		g.redmoves.add(Red12);
		g.redmoves.add(Red13);
		g.redmoves.add(Red23);
		
		IMove ainit=g.selectAInitialMove();
		IMove binit=g.selectBInitialMove();
		History ahistory=new History();
		History bhistory=new History();
		ahistory.recordMove(ainit);
		bhistory.recordMove(binit);
		while(true)
		{
			IMove abestmove=g.getBestAMove(g.bluemoves,bhistory);
			IMove bbestmove=g.getBestBMove(g.redmoves,ahistory);
			ahistory.recordMove(abestmove);
			bhistory.recordMove(bbestmove);
			
			HashMap<IMove,Integer> astats=new HashMap<IMove,Integer>();
			for(IMove m:ahistory)
			{
				if(!astats.keySet().contains(m))
					astats.put(m,new Integer(0));
				else
					astats.put(m,astats.get(m)+1);
			}
			HashMap<IMove,Integer> bstats=new HashMap<IMove,Integer>();
			for(IMove m:bhistory)
			{
				if(!bstats.keySet().contains(m))
					bstats.put(m,new Integer(0));
				else
					bstats.put(m,bstats.get(m)+1);
			}
			System.out.println("*****************");
			int atotal=0;
			for(IMove m:astats.keySet())
				atotal+=astats.get(m).intValue();
			for(IMove m:astats.keySet())
			{
				System.out.println(m.getTitle()+"\t"+1.*astats.get(m).intValue()/atotal);
			}
			int btotal=0;
			for(IMove m:bstats.keySet())
				btotal+=bstats.get(m).intValue();
			for(IMove m:bstats.keySet())
			{
				System.out.println(m.getTitle()+"\t"+1.*bstats.get(m).intValue()/btotal);
			}
		}
	}
	
	public JuliaGame2()
	{
	}
	
	public double getPayoff(IMove a, IMove b)
	{
		boolean aisright=false;
		boolean bisright=false;
		int whereis=(int)(Math.random()*3.)+1;
		if(a.getTitle().contains(whereis+""))
			aisright=true;
		if(b.getTitle().contains(whereis+""))
			bisright=true;
		if(!aisright && !bisright)
			return 0.;
		if(aisright && !bisright)
			return 1.;
		if(!aisright && bisright)
			return -1.;
		int aspread=-1;
		int bspread=-1;
		{
			if(a.getTitle().contains("12")
					||a.getTitle().contains("13")
					||a.getTitle().contains("23"))
				aspread=2;
			else aspread=1;
			if(b.getTitle().contains("12")
					||b.getTitle().contains("13")
					||b.getTitle().contains("23"))
				bspread=2;
			else bspread=1;
		}
		if(aspread<bspread)
			return 1./aspread;
		if(bspread<aspread)
			return -1./bspread;
		return 0.;
	}
}

class Move implements IMove
{
	int front1;
	int front2;
	int front3;
	
	private String title;
	
	public Move(String name) 
	{
		this.title=name;
	}

	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
}

