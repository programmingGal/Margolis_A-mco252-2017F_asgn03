import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BettingActivityTests 

{
    // this class tests the methods of the BettingActivity class.
	    
		    MyMockRandomClass randObj;
		    BettingActivity better ;
		
		    @Before
		    public void setUp()
		    {
			randObj = new MyMockRandomClass();
		    better = new BettingActivity (0, randObj);
		    
		    }
		    
  // testing the addMoney() method:
		    
		    // this tests that adding a negative number to increase your balance will throw an exception
		    @Test    (expected = NegativeValueException.class)
		    public void addingNegativeAmountThrowsException()
		    {
		    	better.addMoney(-20);
		    	
		    }
	
 // testing the betOnANumber method:
			
	        //This test checks that a lost bet on guessing a # from a certain range throws an exception
		    // when balance is zero
			@Test   (expected = MinimumBalanceException.class)
			public void lostBetWithZeroBalanceThrowsException ()
			{  
				int amount = 10;
				int bet = 25;
				int actualNum = 30; // # I will pass to the method
				
				
				better.betOnANumber(amount, actualNum, 35, bet);   
			
			}
			
			
			// this method tests that for a 2nd bet, a lost bet will cause the balance to go down by amount betted . 
			// Not starting at 1st bet, because want balance to have some $ in it. 
			@Test 
			public void lostSecondBetDecreasesBalanceByAmount()
			{  
				// bet #1 - winning bet that increases balance by $100 ((35-25 +1 -1)*10)
				int amount = 10, bet = 25;
				int actualNum=25;
				int min = actualNum;
				int max= 35;
				
				
				better.betOnANumber(amount, min, max, bet);
				
				// balance is now $100
				
				// bet #2 - losing bet - decreases balance by amount($25)
				 amount = 25;
				 bet = 25;
				 actualNum= 30;
				 min = actualNum;
				 max = 35;
				 
				 better.betOnANumber(amount, min, max, bet);
				 
				 assertEquals((75), better.getCurrentBalance());
				 
				 
			}
			
			
			// this method tests that a correct bet makes balance increase by ((range-1)*amount)
			@Test 
			public void winningBetIncreasesBalanceUsingRangeAndAmount()
			{
				int amount = 25, bet = 25;
				int actualNum=25;
				int min = actualNum;
				int max= 35;
				
				
				better.betOnANumber(amount, min, max, bet);
				
				assertEquals(((((max-min+1)-1 ) *amount)), better.getCurrentBalance());   // because starts at 0, so winning should increase balance by (range-1)* amount
				
			}
			
			
			// This tests that any negatives entered will throw an exception
			@Test   (expected = NegativeValueException.class)
			public void negativeInputThrowsException()
			{
				int amount = 25;
				int bet = -25;
				int actualNum=25;
				int min = actualNum;
				int max= 35;
				
				better.betOnANumber(amount, min, max, bet);
				
			}
			
			//This tests that the range must be valid - max entered must be greater than min
			@Test (expected = InvalidRangeException.class )
			public void invalidRangeThrowsException()
			{
				int amount = 25;
				int bet = 20;
				int actualNum=25;
				int min = actualNum;
				int max= 15;
				
				better.betOnANumber(amount, min, max, bet);
				
			}
			
  // testing betOnProbability method:
			
			// this tests that negative amount entered throws exception
			@Test (expected = NegativeValueException.class)
			public void negativeAmountThrowsException()
			{
				int amount = -10;
				double probability = .3;
				
				better.betOnProbability(amount, probability);
			}
			
			
			//this method tests that an invalid probability of >1 throws an exception
			@Test (expected =  InvalidProbabilityException.class)
			public void greaterThanOneProbabilityThrowsException()
			{
				int amount = 100;
				double prob = 2;
				
				better.betOnProbability(amount, prob);
			}
			
			
			//this method tests that an invalid probability of <0 throws an exception
			@Test (expected =  InvalidProbabilityException.class)
			public void LessThanZeroProbabilityThrowsException()
			{
				int amount = 100;
				double prob = -1;
				
				better.betOnProbability(amount, prob);
			}
			
			// this tests that a loss throws an exception if balance is zero
			@Test (expected = MinimumBalanceException.class)
			public void LossOnProbabilityWithZeroBalanceThrowsException()
			{
				randObj.setFakeRandBoolean(0);   // sets it to false
				
				int amount = 20;
				double probability = .2;
				
				//this must return false, they lose, and throws an exception when trying to lower balance 
				better.betOnProbability (amount,probability);
			}
			
			
			   // this tests that a loss decreases balance by amount if balance doesn't go below minimum
			       @Test
			       public void losingBetDecreasesBalance()
			       {
			    	// 1st add money so it doesn't throw an exception
						  better.addMoney(100);
						  
						// use mock object to set outcome to false - lose!
						  randObj.setFakeRandBoolean(0);
						  
						 // now place bet 
						int amount = 10;
						double probability=.3; 
						
						better.betOnProbability(amount, probability);
						// now balance should decrease by 10.
						
						assertEquals(90,better.getCurrentBalance());  
			       }
			
			
				// this tests that a win on probability bet makes balance increase by (p^-1 - 1)* amount
				
				@Test
				public void winningBetIncreasesBalanceCorrectly()
				{   
					
					// use mock object to set outcome to true - win!
					  randObj.setFakeRandBoolean(1);
					  
					 // now place bet 
					int amount = 10;
					double probability=.3; 
					
					better.betOnProbability(amount, probability);
				    double x = ((Math.pow(probability,-1)) - 1) * amount;
				     
				    int expected = (int) x;
					
					assertSame(expected,better.getCurrentBalance());   //  got this error:
					                                                            //The method assertEquals(double, double) from the type Assert is deprecated
				}
				
				
			
			
			
			
			
			
}














