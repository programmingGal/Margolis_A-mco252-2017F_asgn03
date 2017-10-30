
public class MyMockRandomClass implements IRandomValueGenerator
{
  int randNum;
  
  public MyMockRandomClass()
  {
	  
  }
  
  
  // this method is just there to be able to implement the interface
  public int getRandomValue(int min,int max)
  {
	  return randNum;
  }
  
  
  // this method returns a fake random # - you could pass in anything for testing purposes
  
  public int getMockRandomValue(int amount)
  {
	  randNum = amount;
	  
	  return randNum;
  }
  
  
}
