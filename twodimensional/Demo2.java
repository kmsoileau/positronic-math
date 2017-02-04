package positronic.math.vectoranalysis.twodimensional;

import javax.swing.JFrame;

public class Demo2 extends JFrame
{
	private static final long serialVersionUID = 7198180108623276849L;

	public static void main(String[] args)
	{
		Vector p=new Vector(-4.,-3.);
		Vector[] v=new Vector[]{
				new Vector(3.,-2.),
				new Vector(-3.,-6.),
				new Vector(3.,-6.),
				new Vector(-2.,-3.)};
		for(Vector a : v)
			System.out.println(a);
		Vector[] vt = Vector.translateOrigin(p, v);
		System.out.println("------------$");
		for(Vector a : vt)
			System.out.println(a);
		System.out.println("------------$");
		Vector.sort(vt);
		for(Vector a : vt)
			System.out.println(a);
		System.out.println("------------$");
		Vector[] vtt = Vector.translateOrigin(p.multiply(-1.), vt);
		for(Vector a : vtt)
			System.out.println(a);
	}
}