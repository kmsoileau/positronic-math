package positronic.math.statistics;

import java.util.Arrays;

public class RandomMonotoneDoubleSequence 
{
	public static int NONINCREASING=-1;
	public static int NONDECREASING=1;
	
	public static void main(String[] args)
	{
		new RandomMonotoneIntegerSequence(2, 41, NONDECREASING, 11);
	}
	
	double[] terms;
	
	public RandomMonotoneDoubleSequence(double lowerbound, double upperbound, int direction, int numberOfTerms)
	{
		this.terms=new double[numberOfTerms];
		
		for(int i=0;i<terms.length;i++)
			terms[i]=(direction)*(Math.random()*(upperbound-lowerbound)+lowerbound);
		
		Arrays.sort(terms, 0, numberOfTerms);
		for(int i=0;i<terms.length;i++)
			terms[i]*=direction;
		for(int i=0;i<terms.length;i++)
			System.out.println(i+"\t"+terms[i]);
	}
}
