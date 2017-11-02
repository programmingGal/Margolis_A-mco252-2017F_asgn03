
public class MyMockRandomClass implements IRandomValueGenerator
{
  int randNum;
  boolean fakeRandBoolean;
  
  public MyMockRandomClass()
  {
	  
  }
  
  
  // this method is  there to be able to implement the interface
  // and you could pass it anything for testing purposes , the second parameter is just there to keep the same method signature
  public int getRandomValue(int min,int max)
  {
	  randNum = min;
	  return randNum;
  }
  
  
  public void setFakeRandBoolean(int x)
  {
	  if (x==0)
	  {
		  fakeRandBoolean = false;
	  }
	  
	  else if (x==1)
	  {
		  fakeRandBoolean = true;
	  }
	  
  }
  
  public boolean getRandBoolean()
  {
	  return fakeRandBoolean;
  }
 
  
}
