
/* This class provides the methods needed for a betting activity. Each instance has a minimum balance of >=0
 * and a running balance. 2 ways to bet and win money are 1) guess a random # from a specified range and 2)bet on the probability of an event happening. 
 * These methods can increase and decrease the balance of the object, and throw an exception when balance tries to go below the minimum. 
 * The "main" programmer must deal with this and call the addMoney() method or quit the program.  
 */


public class BettingActivity 
{ 
	int balance=0;
	int minBalance;    // minimum balance that user can have before it requires that $ be added manually
	IRandomValueGenerator randObj;

	public BettingActivity (int minBalance, IRandomValueGenerator randObj)
	{
		if (minBalance<0)
		{
			throw new NegativeValueException();
		}
		
		this.minBalance = minBalance;
		
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
		// throws: min.... if balance tries to go below minimum or if user enters negative, or enters invalidrange,
		
		if (amnt <0 || min<0 || max<0 || selectedNumber<0)
		{
			throw new NegativeValueException();
		}
		
		else if (max < min)
		{
			throw new InvalidRangeException();
		}
		
		int randNum = randObj.getRandomValue(min, max);
		
		
		// check if guess was right
		   if (randNum==selectedNumber)
		   {   
			   // increase balance by this expression: (range -1)*amount   (range is max-min +1)
			    
			   balance += ((max-min)*amnt);
		   }
		   
		   else                // guess was not right
		   {
			   // decrease balance by amount
			   
			   if (balance - amnt < minBalance)
			   {
				   throw new MinimumBalanceException();  // balance may not go below minimum
			   }
			   
			   else        // you can decrease balance 
			   {
				   balance-=amnt;
			   }
		   }
	    
	}
	
	
	
	public void betOnProbability(int amnt,double p)
	{
		if (amnt <0)
		{
			throw new NegativeValueException();
		}
		
		// checking validity of probability
		else if (p < 0 || p>1)
		{
			throw new InvalidProbabilityException();
		}
		
		
		// generate a random boolean value
		boolean happened = randObj.getRandBoolean();
		
		
		if (happened)  // event actually occurred
		{
			balance += (((Math.pow(p, -1))- 1) * amnt);
		}
		
		else              // event didn't occur
		{
			if (balance - amnt < minBalance)
			{
				throw new MinimumBalanceException();          // bec. balance can't go below minimum
			}
			
			else
			{
				balance -= amnt;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
