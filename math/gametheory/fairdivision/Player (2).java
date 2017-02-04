package positronic.math.gametheory.fairdivision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player
{
	private List<Good> goods;
	private String name;
	public List<Good> owned;
	
	public Player(String name, List<Good> goods)
	{
		this.goods=new ArrayList<Good>(goods);
		this.name=name;
		arrangeAccordingToPreference();
		this.owned=new ArrayList<Good>();
	}
	
	public void arrangeAccordingToPreference()
	{
		Collections.shuffle(goods);
	}

	public String getName()
	{
		return name;
	}
	
	public int getPreference(Good g)
	{
		return this.goods.indexOf(g);
	}
}
