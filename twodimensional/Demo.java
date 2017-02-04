package positronic.math.vectoranalysis.twodimensional;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import positronic.awt.plotting.RunnablePlotJPanel;

public class Demo extends JFrame
{
	private static final long serialVersionUID = 4140089311585674724L;

	public static void main(String[] args)
	{
		Vector[] v=new Vector[]{
				new Vector(3.,-2.),
				new Vector(-3.,-6.),
				new Vector(3.,-6.),
				new Vector(-2.,-3.)};
		new Demo(v);
		for(Vector a : v)
			System.out.println(a);
		Vector.sort(v);
		for(Vector a : v)
			System.out.println(a);
		for(Vector a : v)
			System.out.println(a.argument());
	}
	
	private DemoPanel jPanel1;
	
	public Demo(Vector[] v)
	{
		{
			this.setSize(450, 450);
			jPanel1=new DemoPanel(v,1000);
			this.add(jPanel1);
			this.setVisible(true);
		}
	}
}

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/

class DemoPanel extends RunnablePlotJPanel
{
	private static final long serialVersionUID = 6087048793274476363L;
	private Vector[] v;
	
	public DemoPanel(Vector[] v, int i)
	{
		super(i);
		this.v=v;
	}

	public void update(Graphics g)
	{
		this.setGraphics2D(g);
		this.locate(20,10,400,400);
		this.scale(-7.,7.,-7.,7.);
		this.pen(Color.black);
		this.axes(.2,.2,0.,0.,1,1);
		this.pen(Color.red);
		
		for(Vector a : v)
			this.drawCircle(a.get(0),a.get(1),.05);
		
		Vector vv=Vector.firstEncounter(v[0], new Vector(1.,0.), v);
		this.pen(Color.blue);
		this.move(v[0].get(0),v[0].get(1));
		this.draw(vv.get(0), vv.get(1));
	}
}
