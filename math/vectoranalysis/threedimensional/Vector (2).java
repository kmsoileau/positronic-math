package positronic.math.vectoranalysis.threedimensional;

import java.util.Arrays;

public class Vector extends positronic.math.vectoranalysis.Vector 
																implements Comparable<Vector>
{
	private static Vector X=new Vector(1.,0.,0.);
	private static Vector Z=new Vector(0.,0.,1.);
	
	public static void main(String[] args)
	{
		Vector[] v=new Vector[]{
				new Vector(3.,2.,0.),
				new Vector(-3.,6.,0.),
				new Vector(3.,-6.,0.),
				new Vector(2.,-3.,0.)};
		for(Vector a : v)
			System.out.println(a);
		Vector.sort(v);
		for(Vector a : v)
			System.out.println(a);
		for(Vector a : v)
			System.out.println(a.argument());
		System.out.println(Vector.span(v));
	}
	
	public static void sort(Vector[] v)
	{
		Arrays.sort(v);
	}
	
	public Vector()
	{
		super(3);
	}
	
	public Vector(double x, double y, double z)
	{
		this(new double[]{x,y,z});
	}
	
	public Vector(double[] data)
	{
		super(3);
		for(int i=0;i<3;i++)
			this.set(i,data[i]);
	}
	
	public Vector(Vector v)
	{
		this();
		for(int i=0;i<3;i++)
			this.set(i,v.get(i));
	}

	public double argument()
	{
		double d=-this.cross(Vector.X).dot(Vector.Z);
		if(d==0.)
			return 0.;
		double arc=Math.acos(this.unitize().dot(Vector.X));
		if(d>0.)
			return arc;
		return 2.*Math.PI-arc;
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
	
	public Vector cross(Vector v)
	{
		Vector ret=new Vector();
		ret.set(0, this.get(1)*v.get(2)-this.get(2)*v.get(1));
		ret.set(1, -this.get(0)*v.get(2)+this.get(2)*v.get(0));
		ret.set(2, this.get(0)*v.get(1)-this.get(1)*v.get(0));
		return ret;
	}
	
	public static double span(Vector[] v)
	{
		Vector.sort(v);
		return v[v.length-1].argument()-v[0].argument();
	}
}
