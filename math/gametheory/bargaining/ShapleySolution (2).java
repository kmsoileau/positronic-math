package positronic.math.gametheory.bargaining;

import java.util.ArrayList;

import positronic.awt.geometry.LineSegment;
import positronic.awt.geometry.Point;

public class ShapleySolution 
{
	private static Point[] pts;
	
	public static Point[] filter(Point[] points, Point threat)
	{
		ArrayList<Point> arp=new ArrayList<Point>();
		for(Point point : points)
			if(point.x>=threat.x && point.y>=threat.y)
				arp.add(point);
		
		if(arp.size()==0)
			return new Point[]{threat};
		else
			return (Point[])arp.toArray(new Point[0]);
	}

	public static void main(String[] args) 
	{
		Point[] p=new Point[]
				{
					new Point(.9,.4),
					new Point(.7,.9),
					new Point(.2,.95),
					new Point(-.4,.7),
					new Point(-.6,-.3),
					new Point(.3,-.6)
				};
		
		ArrayList<Point> x = new LineSegment(p[0],p[1]).subdivideArray(100);
		x.addAll(new LineSegment(p[1],p[2]).subdivideArray(100));
		x.addAll(new LineSegment(p[2],p[3]).subdivideArray(100));
		x.addAll(new LineSegment(p[3],p[4]).subdivideArray(100));
		x.addAll(new LineSegment(p[4],p[5]).subdivideArray(100));
		x.addAll(new LineSegment(p[5],p[0]).subdivideArray(100));
		
		System.out.println(solve(x));
	}
	
	public static Point rightMost(Point[] pts)
	{
		double bx=Double.NEGATIVE_INFINITY;
		Point px=null;
		
		for(Point p : pts)
		{
			double x=p.x;
			if(x>bx)
			{
				px=p;
				bx=x;
			}
		}
		return px;
	}
	
	public static Point solve(ArrayList<Point> points)
	{
		return ShapleySolution.solve((Point[])points.toArray(new Point[0]));
	}
	
	public static Point solve(Point[] points)
	{
		Point[] pts=new Point[points.length];
		for(int i=0;i<points.length;i++)
			pts[i]=new Point(points[i]);
		int oldsize=0;
		while(pts.length!=oldsize)
		{
			oldsize=pts.length;
			pts=ShapleySolution.filter(pts,ShapleySolution.threatPoint(
					ShapleySolution.upperMost(pts),ShapleySolution.rightMost(pts)));
		}
		return pts[0];
	}
	
	public static Point threatPoint(Point p1, Point p2)
	{
		return new Point((p1.x+p2.x)/2,(p1.y+p2.y)/2);
	}
	
	public static Point upperMost(Point[] pts)
	{
		double by=Double.NEGATIVE_INFINITY;
		Point py=null;
		
		for(Point p : pts)
		{
			double y=p.y;
			if(y>by)
			{
				py=p;
				by=y;
			}
		}
		return py;
	}

}
