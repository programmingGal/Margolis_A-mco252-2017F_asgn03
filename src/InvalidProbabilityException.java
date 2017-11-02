
public class InvalidProbabilityException extends RuntimeException
{
   public InvalidProbabilityException()
   {
	   super("Probability was invalid. Value must be between 0 and 1.");
   }
}
