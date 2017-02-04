package positronic.math.gametheory.soileau;

import java.util.ArrayList;
import java.util.HashSet;

public class Coalition 
{
	public static ArrayList<Coalition> generateCoalitions(HashSet<Player> players)
	{
		if(players.size()==0)
			return null;
		if(players.size()==1)
		{
			ArrayList<Coalition> ret=new ArrayList<Coalition>();
			Coalition q=new Coalition();
			q.p.add(players.iterator().next());
			ret.add(q);
			return ret;
		}
		Player refer=players.iterator().next();
		players.remove(refer);
		ArrayList<Coalition> z = generateCoalitions(players);
		ArrayList<Coalition> ret = new ArrayList<Coalition>();
		for(Coalition c : z )
		{
			Coalition zret=new Coalition();
			zret.addAll(c);
			zret.add(refer);
			ret.add(zret);
		}
		return ret;
	}
	
	public static void main(String[] args)
	{
		HashSet<Player> players=new HashSet<Player>();
		Player p1=new Player("Kerry");
		Player p2=new Player("John");
		Player p3=new Player("Steve");
		players.add(p1);
		players.add(p2);
		players.add(p3);
		ArrayList<Coalition> coal=generateCoalitions(players);
		for(Coalition c : coal)
			System.out.println(c);
	}
	
	HashSet<Player> p;

	public Coalition() 
	{
		this.p=new HashSet<Player>();
	}

	public void add(Player refer) 
	{
		this.p.add(refer);
	}
	
	public void addAll(Coalition c) 
	{
		this.p.addAll(c.p);
	}
	
	public String toString()
	{
		String ret="{";
		for(Player p : this.p)
		{
			ret+=p+",";
		}
		return ret;
	}
}
