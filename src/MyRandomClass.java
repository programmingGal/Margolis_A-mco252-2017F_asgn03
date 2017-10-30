import java.util.Random;

public class MyRandomClass implements IRandomValueGenerator
{  
	private int randNum;
	
   public MyRandomClass(int min,int max)
   {
	   getRandomValue(min,max);
   }
   
   public int getRandomValue(int min, int max)
   {
	   Random generator = new Random();
	   randNum = min + generator.nextInt(max-min + 1);
	  return  randNum;
   }
   
   public String toString()
   {
	   StringBuilder output = new StringBuilder();
	   output.append(randNum);
	   return output.toString();
   }
}
