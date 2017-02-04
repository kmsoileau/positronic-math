package positronic.math.gametheory.schedulenegotiation.case1;

import positronic.math.gametheory.schedulenegotiation.core.Game;
import positronic.math.gametheory.schedulenegotiation.core.IBossPlay;
import positronic.math.gametheory.schedulenegotiation.core.IWorkerPlay;

public class SchedDemo1 
{
	public static void main(String[] args) 
	{
		IWorkerPlay wp=new WorkerPlay(new int[]{1,3,5,7,9,11});
		IBossPlay bp=new BossPlay(new int[]{2,4,6,8,10,12});
		
		Reports r=new Reports(wp,bp);
		r.generate2DOutcomeTable(wp,bp);
		r.generatePayoffTable();
		r.generateNetPayoffTable();
		r.generate2DNetPayoffTable(wp,bp);
		r.generate2DPayoffTable(wp,bp);
		Game g=new Game(wp,bp);
		System.out.println("\n"+g);
	}
}
