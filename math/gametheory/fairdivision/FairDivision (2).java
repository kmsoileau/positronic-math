package positronic.math.gametheory.fairdivision;

import java.util.ArrayList;

import positronic.math.statistics.Random;

public class FairDivision
{
	public static int[] award(int[][] preferencesArray)
	{
		int[] ret=new int[preferencesArray[0].length];
		for(int item=0;item<preferencesArray[0].length;item++)
		{
			ArrayList<Object> candidates=new ArrayList<Object>();
			int bestpref=Integer.MAX_VALUE;
			for(int player=0;player<preferencesArray.length;player++)
				if(preferencesArray[player][item]<bestpref)
					bestpref=preferencesArray[player][item];
			for(int player=0;player<preferencesArray.length;player++)
				if(bestpref==preferencesArray[player][item])
					candidates.add(new Integer(player));
			ret[item]=((Integer)Random.chooseOneRandomly(candidates)).intValue();
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		Good T1=new Good("T1");
		Good T2=new Good("T2");
		Good T3=new Good("T3");
		Good T4=new Good("T4");
		Good T5=new Good("T5");
		Good T6=new Good("T6");
		Good T7=new Good("T7");
		Good T8=new Good("T8");
		Good T9=new Good("T9");
		Good T10=new Good("T10");
		Good T11=new Good("T11");
		Good T12=new Good("T12");
		Good T13=new Good("T13");
		Good T14=new Good("T14");
		
		ArrayList<Good> goods=new ArrayList<Good>();
		goods.add(T1);
		goods.add(T2);
		goods.add(T3);
		goods.add(T4);
		goods.add(T5);
		goods.add(T6);
		goods.add(T7);
		goods.add(T8);
		goods.add(T9);
		goods.add(T10);
		goods.add(T11);
		goods.add(T12);
		goods.add(T13);
		goods.add(T14);
		
		Player W1=new Player("W1",goods);
		Player W2=new Player("W2",goods);
		Player W3=new Player("W3",goods);
		Player W4=new Player("W4",goods);
		
		ArrayList<Player> players=new ArrayList<Player>();
		players.add(W1);
		players.add(W2);
		players.add(W3);
		players.add(W4);
		
		System.out.print("Good\t");
		for(Player p : players)
			System.out.print("\t"+p.getName());
		
		System.out.println();
		for(Good g : goods)
		{
			System.out.print(g.getName()+"\t");
			for(Player p : players)
				System.out.print("\t"+p.getPreference(g));
			System.out.println();
		}
		
		for(Good g : goods)
		{
			int bestpref=Integer.MAX_VALUE;
			
			for(Player p : players)
				if(p.getPreference(g)<bestpref)
					bestpref=p.getPreference(g);		
			
			for(Player p : players)
				if(p.getPreference(g)==bestpref)
					g.assigned.add(p);
		}
		
		for(Good g : goods)
		{
			Player chosen=(Player)Random.chooseOneRandomly(g.assigned);
			g.owner=chosen;
			chosen.owned.add(g);
			System.out.println(g.getName()+" is awarded to Player "+g.owner.getName()+" who ranked it "+g.owner.getPreference(g));
		}
		
		for(Player p : players)
		{
			System.out.println("Player "+p.getName()+" is awarded the following Goods:");
			for(Good g : p.owned)
				System.out.println("\t"+g.getName());
		}
		
		
		int[] alternative=award(new int[][]
		              		           {
				{6,10, 3, 8, 2, 5, 1, 4, 9,13, 7,12,11, 0},
				{4,10, 6,11, 2, 5, 0, 9, 8, 3, 1,12,13, 7},
				{6,12, 7, 4, 5, 3, 2,10,13, 1, 0, 9, 8,11},
				{5, 1,12, 9,11,13, 7, 4, 2,10, 0, 3, 8, 6}
			           });
		
		for(int i=0;i<alternative.length;i++)
			System.out.println("Item "+(i+1)+" was awarded to Player "+(alternative[i]+1));
	}
}