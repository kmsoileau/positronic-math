package positronic.math.vectoranalysis;

public class Vector
{
	public static void main(String[] args)
	{
		
	}
	
	private int dimension;
	private double[] data;
	
	public Vector(double[] data)
	{
		this(data.length);
		for(int i=0;i<this.dimension();i++)
			this.set(i,data[i]);
	}
	
	public Vector(int n)
	{
		this.dimension=n;
		this.data=new double[n];
	}
	
	public Vector(Vector v)
	{
		this(v.dimension());
		for(int i=0;i<v.dimension();i++)
			this.set(i,v.get(i));
	}
	
	public String toString()
	{
		String ret="(";
		for(int i=0;i<this.dimension()-1;i++)
			ret+=(this.get(i)+",");
		ret+=(this.get(this.dimension()-1));
		ret+=")";
		return ret;
	}
	
	public int dimension()
	{
		return this.dimension;
	}
	
	public double dot(Vector v)
	{
		double ret=0.;
		for(int i=0;i<this.dimension();i++)
			ret+=this.get(i)*v.get(i);
		return ret;
	}
	
	public Vector plus(Vector v)
	{
		Vector ret=new Vector(v);
		for(int i=0;i<ret.dimension();i++)
			ret.set(i, ret.get(i)+this.get(i));
		return ret;
	}
	
	public Vector minus(Vector v)
	{
		return this.plus(v.multiply(-1.));
	}
	
	public double get(int n)
	{
		return this.data[n];
	}

	public double magnitude()
	{
		return(Math.sqrt(this.dot(this)));
	}
	
	public Vector multiply(double s)
	{
		Vector ret=new Vector(this.dimension());
		for(int i=0;i<this.dimension();i++)
			ret.set(i,s*this.get(i));
		return ret;
	}
	
	public void set(int n, double x)
	{
		this.data[n]=x;
	}
	
	public double subtendedAngle(Vector v)
	{
		return Math.acos(this.dot(v));
	}
	
	public Vector unitize()
	{
		return this.multiply(1./this.magnitude());
	}
}
