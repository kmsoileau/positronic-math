package positronic.math.gametheory.schedulenegotiation.core;

import java.util.HashMap;
import java.util.Vector;

import positronic.math.gametheory.schedulenegotiation.case1.Outcome;

public class Game implements IGame
{
	private HashMap<IWorkerPlay,HashMap<IBossPlay,IPayoff>> gameMap;

	public Game(IWorkerPlay wp, IBossPlay bp) 
	{
		this.gameMap=new HashMap<IWorkerPlay,HashMap<IBossPlay,IPayoff>>();
		Vector<IWorkerPlay> wv=wp.generateWorkerPlays();
		Vector<IBossPlay> bv=bp.generateBossPlays();
		
		for(IWorkerPlay workerplay : wv)
			for(IBossPlay bossplay : bv)
				this.setOutcome(workerplay, bossplay, new Outcome(Outcome.outcome(workerplay, bossplay)).utility());
	}
	
	public IPayoff getOutcome(IWorkerPlay w, IBossPlay b)
	{
		return this.gameMap.get(w).get(b);
	}
	
	public void setOutcome(IWorkerPlay w, IBossPlay b, IPayoff o) {
		HashMap<IBossPlay,IPayoff> h1=this.gameMap.get(w);
		if(h1==null)
		{
			this.gameMap.put(w,new HashMap<IBossPlay,IPayoff>());
			h1=this.gameMap.get(w);
		}	
		h1.put(b,o);
	}
	
	public String toString()
	{
		String ret="";
		for(IWorkerPlay w : this.gameMap.keySet())
			for(IBossPlay b : this.gameMap.get(w).keySet())
				ret+=("\n"+w+" X "+b+" --> "+getOutcome(w,b));
		return ret;
	}
}
