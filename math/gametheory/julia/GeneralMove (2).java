package positronic.math.gametheory.julia;

public class GeneralMove implements IMove
{
	int front1;
	int front2;
	int front3;
	
	private String title;
	
	public GeneralMove(String name,int front1,int front2,int front3) 
	{
		this.title=name;
		this.front1=front1;
		this.front2=front2;
		this.front3=front3;
	}

	public int getFront1() 
	{
		return front1;
	}

	public int getFront2() 
	{
		return front2;
	}

	public int getFront3() 
	{
		return front3;
	}

	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
}
