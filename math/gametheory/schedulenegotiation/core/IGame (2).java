package positronic.math.gametheory.schedulenegotiation.core;

public interface IGame 
{
	IPayoff getOutcome(IWorkerPlay w, IBossPlay b);
	void setOutcome(IWorkerPlay w, IBossPlay b, IPayoff o);
}
