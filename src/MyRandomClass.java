import java.util.Random;

public class MyRandomClass implements IRandomValueGenerator
{  
	private int randNum;
	
   public MyRandomClass()
   {
	  
   }
   
   
   // returns a random int in the specified range
   public int getRandomValue(int min, int max)
   {
	   Random generator = new Random();
	   randNum = min + generator.nextInt(max-min + 1);   // generates a random value in this range, inclusive
	  return  randNum;
   }
   
   
   // returns a random boolean value
   public boolean getRandBoolean()
   {
	   Random generator = new Random();
	   
	   boolean randBoolean = generator.nextBoolean();
	   
	   return randBoolean;
   }
   
   
   public String toString()
   {
	   StringBuilder output = new StringBuilder();
	   output.append(randNum);
	   return output.toString();
   }
}
