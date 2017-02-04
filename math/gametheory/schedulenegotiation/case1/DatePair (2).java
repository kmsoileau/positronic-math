package positronic.math.gametheory.schedulenegotiation.case1;

public class DatePair implements Comparable<Object>
{
	private int earlier;
	private int later;
	
	public DatePair(int earlier, int later) 
	{
		if(later<earlier)
		{
			int swap=earlier;
			earlier=later;
			later=swap;
		}
		this.setEarlier(earlier);
		this.setLater(later);
	}
	
	public int compareTo(Object o) 
	{
		DatePair dd=(DatePair)o;
		if(this.getEarlier()!=dd.getEarlier())
			return this.getEarlier()-dd.getEarlier();
		if(this.getLater()!=dd.getLater())
			return this.getLater()-dd.getLater();
		return 0;
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof DatePair))
			return false;
		DatePair dd=(DatePair)o;
		if(dd.getEarlier()!=this.getEarlier())
			return false;
		if(dd.getLater()!=this.getLater())
			return false;
		return true;
	}

	public String toString()
	{
		return "("+this.getEarlier()+","+this.getLater()+")";
	}

	public void setEarlier(int earlier) {
		this.earlier = earlier;
	}

	public int getEarlier() {
		return earlier;
	}

	public void setLater(int later) {
		this.later = later;
	}

	public int getLater() {
		return later;
	}
}

class DatePairTriple implements Comparable<Object>
{
	DatePair workerbid;
	DatePair bossbid;
	DatePair outcome;
	
	public DatePairTriple(DatePair workerbid,
	DatePair bossbid,
	DatePair outcome) 
	{
		this.workerbid = workerbid;
		this.bossbid = bossbid;
		this.outcome = outcome;
	}
	
	public int compareTo(Object o) 
	{
		DatePairTriple dd=(DatePairTriple)o;
		if(!this.workerbid.equals(dd.workerbid))
			return this.workerbid.compareTo(dd.workerbid);
		if(!this.bossbid.equals(dd.bossbid))
			return this.bossbid.compareTo(dd.bossbid);
		return 0;
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof DatePairTriple))
			return false;
		DatePairTriple dd=(DatePairTriple)o;
		if(!dd.workerbid.equals(this.workerbid))
			return false;
		if(!dd.bossbid.equals(this.bossbid))
			return false;
		return true;
	}

	public String toString()
	{
		return this.workerbid+" X "+this.bossbid+" --> "+this.outcome;
	}
}
