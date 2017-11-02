
public class InvalidRangeException extends RuntimeException
{
  public InvalidRangeException()
  {
	  super("Range entered was invalid. Max value must be greater than Min value.");
  }
}
