package positronic.math.gametheory.julia;

import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

public class JuliaGame
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
		JuliaGame g=new JuliaGame();
		IMove a1=new Move("Blue51");
		IMove a2=new Move("Blue42");
		IMove a3=new Move("Blue33");
		IMove a4=new Move("Blue24");
		IMove a5=new Move("Blue15");
		IMove b1=new Move("Red41");
		IMove b2=new Move("Red32");
		IMove b3=new Move("Red23");
		IMove b4=new Move("Red14");
		
		g.bluemoves.add(a1);
		g.bluemoves.add(a2);
		g.bluemoves.add(a3);
		g.bluemoves.add(a4);
		g.bluemoves.add(a5);
		g.redmoves.add(b1);
		g.redmoves.add(b2);
		g.redmoves.add(b3);
		g.redmoves.add(b4);
		
		g.setPayoff(a1,b1,new Double(4.));
		g.setPayoff(a1,b2,new Double(2.));
		g.setPayoff(a1,b3,new Double(1.));
		g.setPayoff(a1,b4,new Double(0.));
		g.setPayoff(a2,b1,new Double(1.));
		g.setPayoff(a2,b2,new Double(3.));
		g.setPayoff(a2,b3,new Double(0.));
		g.setPayoff(a2,b4,new Double(-1.));
		g.setPayoff(a3,b1,new Double(-2.));
		g.setPayoff(a3,b2,new Double(2.));
		g.setPayoff(a3,b3,new Double(2.));
		g.setPayoff(a3,b4,new Double(-2.));
		g.setPayoff(a4,b1,new Double(-1.));
		g.setPayoff(a4,b2,new Double(0.));
		g.setPayoff(a4,b3,new Double(3.));
		g.setPayoff(a4,b4,new Double(1.));
		g.setPayoff(a5,b1,new Double(0.));
		g.setPayoff(a5,b2,new Double(1.));
		g.setPayoff(a5,b3,new Double(2.));
		g.setPayoff(a5,b4,new Double(4.));
		
		/**
		 *  Blue51	0.44523
		 *  Blue42	5.9744E-4
				Blue33	0.10917
				Blue24	8.3976E-4
				Blue15	0.44415
				Red41	  0.049357
				Red32	  0.47595
				Red23	  0.40968
				Red14	  0.065008
		 */
		
		/*
Blue24	0.0016124503630018851
Blue15	0.4478761381412699
Blue51	0.44726645541695076
Blue33	0.10209778990012434
Blue42	0.0011471661786530826
Red32	0.4753160698241561
Red14	0.06322198690797073
Red23	0.41330541650622515
Red41	0.048156526761648055
		 */
		
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
	
	protected Vector<IMove> bluemoves;
	protected Vector<IMove> redmoves;
	private HashMap<IMove,HashMap<IMove,Double>> payoff;
	
	public JuliaGame()
	{
		bluemoves=new Vector<IMove>();
		redmoves=new Vector<IMove>();
	}
	
	public IMove getBestAMove(Vector<IMove> amoves, History bhistory)
	{
		double abest=Double.NEGATIVE_INFINITY;
		IMove abestmove=null;
		for(IMove amove:amoves)
		{
			if(abest<this.value(amove,bhistory))
			{
				abest=this.value(amove,bhistory);
				abestmove=amove;
			}
		}
		return abestmove;
	}
	
	public IMove getBestBMove(Vector<IMove> bmoves, History ahistory)
	{
		double bbest=Double.POSITIVE_INFINITY;
		IMove bbestmove=null;
		for(IMove bmove:bmoves)
		{
			if(bbest>this.value(ahistory,bmove))
			{
				bbest=this.value(ahistory,bmove);
				bbestmove=bmove;
			}
		}
		return bbestmove;
	}
	
	public double getPayoff(IMove a, IMove b)
	{
		HashMap<IMove,Double> row=this.payoff.get(a);
		return row.get(b);
	}
	
	public IMove selectAInitialMove()
	{
		return this.bluemoves.firstElement();
	}
	
	public IMove selectBInitialMove()
	{
		return this.redmoves.firstElement();
	}
	
	public void setPayoff(IMove a, IMove b, Double pay)
	{
		if(this.payoff==null)
			this.payoff=new HashMap<IMove,HashMap<IMove,Double>>();
			
		if(this.payoff.get(a)==null)
			this.payoff.put(a,new HashMap<IMove,Double>());
			
		((HashMap<IMove,Double>)(this.payoff.get(a))).put(b,pay);
	}
	
	public double value(Collection<IMove> h,IMove b)
	{
		double ret=0.;
		for(IMove a:h)
			ret+=this.getPayoff(a,b);
		return ret/h.size();
	}

	public double value(IMove a,Collection<IMove> h)
	{
		double ret=0.;
		for(IMove b:h)
			ret+=this.getPayoff(a,b);
		return ret/h.size();
	}
}

