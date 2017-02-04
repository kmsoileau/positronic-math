package positronic.math.gametheory.schedulenegotiation.case1;

import java.util.Vector;

import positronic.math.gametheory.schedulenegotiation.core.IWorkerPlay;

public class WorkerPlay implements IWorkerPlay
{
	private int[] workerdates;
	private DatePair dates;
	
	public WorkerPlay(DatePair dp)
	{
		this(dp.getEarlier(),dp.getLater());
	}
	
	public WorkerPlay(int earlier, int later) 
	{
		this.setDates(new DatePair(earlier,later));
	}

	public WorkerPlay(int[] dates) 
	{
		this.workerdates = dates;
	}
	
	public Vector<IWorkerPlay> generateWorkerPlays()
	{
		Vector<IWorkerPlay> ret=new Vector<IWorkerPlay>();
		for(int w1 : this.workerdates)
			for(int w2 : this.workerdates)
				if(w1<w2)
					ret.add(new WorkerPlay(w1,w2));
				
		return ret;
	}
	
	public DatePair getDates() 
	{
		return dates;
	}
	
	public int[] getWorkerdates() 
	{
		return this.workerdates;
	}
	
	public int numberPlays()
	{
		return this.getWorkerdates().length*(this.getWorkerdates().length-1)/2;
	}

	public void setDates(DatePair dates) 
	{
		this.dates = dates;
	}
	
	public String toString()
	{
		return this.getDates().toString();
	}

	public int totalUtility()
	{
		return this.utility(this.getDates().getEarlier())
			+this.utility(this.getDates().getLater());
	}

	public int utility(int date)
	{
		switch(date)
		{
			case 1:
				return 2;
			case 2:
				return 3;
			case 3:
				return 4;
			case 4:
				return 5;
			case 5:
				return 6;
			case 6:
				return 7;
			case 7:
				return 8;
			case 8:
				return 9;
			case 9:
				return 10;
			case 10:
				return 11;
			case 11:
				return 12;
			case 12:
				return 13;
		}
		return 0;
	}
}
