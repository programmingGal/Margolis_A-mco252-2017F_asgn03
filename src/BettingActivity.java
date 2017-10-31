
public class BettingActivity 
{ 
	int balance;
	IRandomValueGenerator randObj;

	public BettingActivity (int minBalance, IRandomValueGenerator randObj)
	{
		if (minBalance<0)
		{
			throw new NegativeValueException();
		}
		
		balance = minBalance;
		
		this.randObj = randObj;
		
		
	}
	
	public int getCurrentBalance()
	{
		return balance;
	}
	
	
	public void addMoney(int amount)
	{
		if (amount<0)
		{
			throw new NegativeValueException();
		}
		
		balance += amount;
	}
	
	
	public void betOnANumber(int amnt, int min, int max,int selectedNumber)
	{
		throw new IllegalArgumentException();
	}
	
	public void betOnProbability(int amnt,double p)
	{
		throw new IllegalArgumentException();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
