package positronic.math.gametheory.schedulenegotiation.case1;

import java.util.Collections;
import java.util.Vector;

import positronic.math.gametheory.schedulenegotiation.core.IBossPlay;
import positronic.math.gametheory.schedulenegotiation.core.IWorkerPlay;

public class Reports
{
	private Vector<DatePairTriple> data;
	
	public Reports(IWorkerPlay wp, IBossPlay bp)
	{
		this.data=new Vector<DatePairTriple>();
		for(IWorkerPlay w1 : wp.generateWorkerPlays())
			for(IBossPlay b1 : bp.generateBossPlays())
			{
				DatePairTriple t=new DatePairTriple(w1.getDates(),b1.getDates(),Outcome.outcome(w1, b1));
				if(!this.data.contains(t))
					this.data.add(t);
			}
		Collections.sort(this.data);
	}
	
	public void generate2DNetPayoffTable(IWorkerPlay wp,IBossPlay bp)
	{
		DatePair oldbossbid=null;
		int count=bp.numberPlays();
		
		System.out.print("\n");
		for(DatePairTriple d : this.data)
		{
			count--;
			if(oldbossbid==null || !oldbossbid.equals(d.bossbid))
			{
				System.out.print("\t"+d.bossbid);
				oldbossbid=d.bossbid;
			}
			if(count==0)
				break;
		}
		
		DatePair oldworkerbid=null;
		for(DatePairTriple d : this.data)
		{
			if(oldworkerbid==null || !oldworkerbid.equals(d.workerbid))
				System.out.print("\n"+d.workerbid);
			System.out.print("\t"+(new WorkerPlay(d.outcome).totalUtility()-new BossPlay(d.outcome).totalUtility()));
			oldworkerbid=d.workerbid;
		}
	}
	
	public void generate2DOutcomeTable(IWorkerPlay wp,IBossPlay bp)
	{
		DatePair oldbossbid=null;
		int count=bp.numberPlays();
		for(DatePairTriple d : this.data)
		{
			count--;
			if(oldbossbid==null || !oldbossbid.equals(d.bossbid))
			{
				System.out.print("\t"+d.bossbid);
				oldbossbid=d.bossbid;
			}
			if(count==0)
				break;
		}
		
		DatePair oldworkerbid=null;
		for(DatePairTriple d : this.data)
		{
			if(oldworkerbid==null || !oldworkerbid.equals(d.workerbid))
				System.out.print("\n"+d.workerbid);
			
			System.out.print("\t"+d.outcome);
			oldworkerbid=d.workerbid;
		}
	}
	
	public void generate2DPayoffTable(IWorkerPlay wp,IBossPlay bp)
	{
		DatePair oldbossbid=null;
		int count=bp.numberPlays();
		
		System.out.print("\n\n");
		for(DatePairTriple d : this.data)
		{
			count--;
			if(oldbossbid==null || !oldbossbid.equals(d.bossbid))
			{
				System.out.print("\t"+d.bossbid);
				oldbossbid=d.bossbid;
			}
			if(count==0)break;
		}
		
		DatePair oldworkerbid=null;
		for(DatePairTriple d : this.data)
		{
			if(oldworkerbid==null || !oldworkerbid.equals(d.workerbid))
				System.out.print("\n"+d.workerbid);
				
			System.out.print("\t"+"("
					+new WorkerPlay(d.outcome).totalUtility()
					+","
					+new BossPlay(d.outcome).totalUtility()
					+")");
			oldworkerbid=d.workerbid;
		}
	}
	
	public void generateNetPayoffTable()
	{
		System.out.println("\n");
		for(DatePairTriple d : this.data)
			System.out.println(d.workerbid+" X "+d.bossbid+" --> "
					+(new WorkerPlay(d.outcome).totalUtility()
					-new BossPlay(d.outcome).totalUtility()));
	}
	
	public void generatePayoffTable()
	{
		System.out.println("\n");
		for(DatePairTriple d : this.data)
			System.out.println(d.workerbid+" X "+d.bossbid+" --> "
					+"("
					+(new WorkerPlay(d.outcome).totalUtility())
					+","
					+(new BossPlay(d.outcome).totalUtility())+")");
	}
}
