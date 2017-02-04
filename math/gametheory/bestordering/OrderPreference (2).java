package positronic.math.gametheory.bestordering;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderPreference extends HashMap<String, ArrayList<Double>>
{
	private static final long serialVersionUID = -3764466235355466959L;

	public OrderPreference()
	{
		ArrayList<Double> memp=new ArrayList<Double>();
		memp.add(.42);
		memp.add(0.);
		memp.add(0.);
		memp.add(.58);
		ArrayList<Double> nash=new ArrayList<Double>();
		nash.add(.26);
		nash.add(.42);
		nash.add(.32);//This means 32% agree that Nashville should be in third place
		nash.add(0.);
		ArrayList<Double> chat=new ArrayList<Double>();
		chat.add(.15);
		chat.add(.43);
		chat.add(.42);
		chat.add(0.);
		ArrayList<Double> knox=new ArrayList<Double>();
		knox.add(.17);
		knox.add(.15);
		knox.add(.26);
		knox.add(.42);
		super.put("Memphis",memp);
		super.put("Nashville",nash);
		super.put("Chattanooga",chat);
		super.put("Knoxville",knox);
	}
	
	public double getOrderPreference(String s, int place)
	{
		return super.get(s).get(place);
	}
}
