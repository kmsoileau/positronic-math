package positronic.math.statistics.creature;

import java.io.FileWriter;
import java.io.IOException;
import positronic.math.statistics.Random;

public class Darwin extends Population
{
	private static final long serialVersionUID = 5618659932597651477L;
	
	public static void main(String[] args) throws IOException
	{
		System.gc();
		Darwin d=new Darwin(100);
		FileWriter fw=new FileWriter("C:\\Users\\Kerry Soileau\\Desktop\\darwin.txt");
		while(d.size()<100000)
		{
			Creature x1=d.sample();
			Creature x2=d.sample();
			double mean=(x1.getMean().measure()+x2.getMean().measure())/2.;
			double sd=(x1.getSd().measure()+x2.getSd().measure())/2.*Random.normalDeviate()[0];
			Creature t=new Creature(mean,sd);
			d.add(t);
		}
		fw.write(d.toString()+"\n");
		fw.close();
	}
	
	public Darwin(int n)
	{
		int count=0;
		while(count<n)
		{
			if(count++<n)
				this.add(new Creature(Math.random(),Math.random()));
		}
	}
}
