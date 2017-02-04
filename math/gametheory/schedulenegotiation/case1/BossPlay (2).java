package positronic.math.gametheory.schedulenegotiation.case1;

import java.util.Vector;

import positronic.math.gametheory.schedulenegotiation.core.IBossPlay;

public class BossPlay implements IBossPlay
{
	private int[] bossdates;
	private DatePair dates;
	
	public BossPlay(DatePair dp)
	{
		this(dp.getEarlier(),dp.getLater());
	}
	
	public BossPlay(int earlier, int later) 
	{
		this.setDates(new DatePair(earlier,later));
	}

	public BossPlay(int[] dates) {
		super();
		this.bossdates = dates;
	}
	
	public Vector<IBossPlay> generateBossPlays()
	{
		Vector<IBossPlay> ret=new Vector<IBossPlay>();
		for(int w1 : this.bossdates)
			for(int w2 : this.bossdates)
				if(w1<w2)
					ret.add((IBossPlay)new BossPlay(w1,w2));
				
		return ret;
	}
	
	public int[] getBossdates() {
		return this.bossdates;
	}
	
	public DatePair getDates() 
	{
		return dates;
	}

	public int numberPlays()
	{
		return this.getBossdates().length*(this.getBossdates().length-1)/2;
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
				return 12;
			case 2:
				return 11;
			case 3:
				return 10;
			case 4:
				return 9;
			case 5:
				return 8;
			case 6:
				return 7;
			case 7:
				return 6;
			case 8:
				return 5;
			case 9:
				return 4;
			case 10:
				return 3;
			case 11:
				return 2;
			case 12:
				return 1;
		}
		return 0;
	}
}
