package positronic.math.gametheory.schedulenegotiation.core;

import java.util.Vector;

import positronic.math.gametheory.schedulenegotiation.case1.DatePair;

public interface IWorkerPlay 
{
	Vector<IWorkerPlay> generateWorkerPlays();
	DatePair getDates();
	int numberPlays();
	int totalUtility();
}
