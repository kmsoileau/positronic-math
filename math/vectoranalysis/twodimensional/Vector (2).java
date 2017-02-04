package positronic.math.vectoranalysis.twodimensional;

import java.util.Arrays;

public class Vector extends positronic.math.vectoranalysis.Vector 
																implements Comparable<Vector>
{
	public static Vector firstEncounter(Vector p, Vector q, Vector[] v)
	{
		Vector[] v1=translateOrigin(p,v);
		Arrays.sort(v1);
		double theta=q.argument();
		Vector ans=null;
		for(Vector a : v1)
		{
			if(a.argument()>=theta)
			{
				ans=a;
				break;
			}
		}
		if(ans==null)
			ans=v1[0];
		return new Vector(p.multiply(-1.));
	}
	
	public static void main(String[] args)
	{
		Vector[] v=new Vector[]{
				new Vector(3.,2.),
				new Vector(-3.,6.),
				new Vector(3.,-6.),
				new Vector(2.,-3.)};
		for(Vector a : v)
			System.out.println(a);
		Vector.sort(v);
		for(Vector a : v)
			System.out.println(a);
		for(Vector a : v)
			System.out.println(a.argument());
	}
	
	public static void sort(Vector[] v)
	{
		Arrays.sort(v);
	}
	
	public static double span(Vector[] v)
	{
		Vector.sort(v);
		return v[v.length-1].argument()-v[0].argument();
	}
	
	public static Vector[] translateOrigin(Vector p, Vector[] v)
	{
		Vector[] v1=new Vector[v.length];
		for(int i=0;i<v.length;i++)
			v1[i]=new Vector(v[i].minus(p));
		return v1;
	}
	
	public Vector()
	{
		super(2);
	}
	
	public Vector(double x, double y)
	{
		this(new double[]{x,y});
	}
	
	public Vector(double[] data)
	{
		super(2);
		for(int i=0;i<2;i++)
			this.set(i,data[i]);
	}

	public Vector(positronic.math.vectoranalysis.Vector vv) 
	{
		this(vv.get(0),vv.get(1));
	}
	
	public Vector(Vector v)
	{
		this();
		for(int i=0;i<2;i++)
			this.set(i,v.get(i));
	}
	
	public double argument()
	{
		if(this.get(1)==0.)
			if(this.get(0)>0.)
				return 0.;
			else
				return Math.PI;
		double arc=Math.acos(this.get(0)/this.magnitude());
		if(this.get(1)>0.)
			return arc;
		if(this.get(1)<0.)
			return 2.*Math.PI-arc;
		return 0.;
	}
	
	/*
	 * v1.compareTo(v2) 
	 * returns 1 if rotating v1 counterclockwise < pi radians takes it to v2,
	 * returns 0 if v1 is a nonnegative multiple of v2,
	 * returns -1 if rotating v1 counterclockwise takes it to v2,
	 * 
	 */
	public int compareTo(Vector o)
	{
		return (int)Math.signum(this.argument()-o.argument());
	}
	
	public Vector minus(Vector v)
	{
		Vector x = (Vector) v.multiply(-1.);
		
		return (Vector) this.plus(x);
	}

	public Vector multiply(double s)
	{
		return new Vector(s*this.get(0),s*this.get(1));
	}
	
	public Vector plus(Vector v)
	{
		return new Vector(v.get(0)+this.get(0),v.get(1)+this.get(1));
	}
}
