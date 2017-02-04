package positronic.math.statistics;

import java.util.Arrays;

public class RandomMonotoneIntegerSequence 
{
	public static int NONINCREASING=-1;
	public static int NONDECREASING=1;
	
	public static void main(String[] args)
	{
		new RandomMonotoneIntegerSequence(2, 41, NONDECREASING, 20);
	}
	
	int[] terms;
	
	public RandomMonotoneIntegerSequence(int lowerbound, int upperbound, int direction, int numberOfTerms)
	{
		this.terms=new int[numberOfTerms];
		
		for(int i=0;i<terms.length;i++)
			terms[i]=(direction)*(int)(Math.random()*(upperbound-lowerbound)+lowerbound);
		
		Arrays.sort(terms, 0, numberOfTerms);
		for(int i=0;i<terms.length;i++)
			terms[i]*=direction;
		for(int i=0;i<terms.length;i++)
			System.out.println(i+"\t"+terms[i]);
	}
}
