package positronic.math.gametheory.fairdivision;

import java.util.ArrayList;
import java.util.List;

public class Good
{
	public List<Object> assigned;
	private String name;
	public Player owner;
	
	public Good(String name)
	{
		this.name=name;
		this.assigned=new ArrayList<Object>();
	}

	public String getName()
	{
		return name;
	}
}