package positronic.math.gametheory.schedulenegotiation.case1;

import java.util.Vector;

import positronic.math.gametheory.schedulenegotiation.core.IBossPlay;
import positronic.math.gametheory.schedulenegotiation.core.IOutcome;
import positronic.math.gametheory.schedulenegotiation.core.IPayoff;
import positronic.math.gametheory.schedulenegotiation.core.IWorkerPlay;

public class Outcome implements IOutcome
{
	private static DatePair extractDatePair(DatePair worker, DatePair boss)
	{
		int[] ret=extractDatePair(worker.getEarlier(),worker.getLater(),boss.getEarlier(),boss.getLater());
		return new DatePair(ret[0],ret[1]);
	}
	
	private static int[] extractDatePair(int w1,int w2,int b1,int b2)
	{
		Vector<Integer>chalk=new Vector<Integer>();
		chalk.add(new Integer(w1));
		chalk.add(new Integer(b1));
		chalk.add(new Integer(w2));
		chalk.add(new Integer(b2));
		int s1=Math.min(w1, Math.min(b1, Math.min(w2, b2)));
		int s2=Math.max(w1, Math.max(b1, Math.max(w2, b2)));
		chalk.remove(new Integer(s1));
		chalk.remove(new Integer(s2));
		return new int[]{chalk.get(0),chalk.get(1)};
	}

	public static DatePair outcome(IWorkerPlay w, IBossPlay b)
	{
		return Outcome.extractDatePair(w.getDates(),b.getDates());
	}
	
	private DatePair dp;
	
	public Outcome(DatePair dd) 
	{
		this(dd.getEarlier(), dd.getLater());
	}
	
	public Outcome(int earlier, int later) 
	{
		dp=new DatePair(earlier, later);
	}
	
	public IPayoff utility()
	{
		return new Payoff(
				((IWorkerPlay)new WorkerPlay(dp)).totalUtility(),
				((IBossPlay)new BossPlay(dp)).totalUtility());
	}
}
