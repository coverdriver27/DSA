import java.util.stream.*;
public class Project2a {

  interface FPFunction
  {
    double eval(double n);
  }
 
  public static double rectangularLeft(double a, double b, int n, FPFunction f)
  {
    return rectangular(a, b, n, f, 0);
  }
 
  public static double rectangularMidpoint(double a, double b, int n, FPFunction f)
  {
    return rectangular(a, b, n, f, 1);
  }
 
  public static double rectangularRight(double a, double b, int n, FPFunction f)
  {
    return rectangular(a, b, n, f, 2);
  }
 
  public static double trapezium(double a, double b, int n, FPFunction f)
  {
double range = checkParamsGetRange(a, b, n); double nFloat = (double)n;
double sum = 0.0;

sum = IntStream.range(1,n).mapToDouble(i -> i * 1.0).
        map(i -> a + range * i/nFloat).map(x -> f.eval(x)).
        reduce(0, (c,d) -> c+d);
sum += (f.eval(a) + f.eval(b)) / 2.0;
return sum * range / nFloat;
  }
 
  public static double simpsons(double a, double b, int n, FPFunction f)
  {
    double range = checkParamsGetRange(a, b, n);
    double nFloat = (double)n;
    double sum1 = f.eval(a + range / (nFloat * 2.0));
    double sum2 = 0.0;
    for (int i = 1; i < n; i++)
    {
      double x1 = a + range * ((double)i + 0.5) / nFloat;
      sum1 += f.eval(x1);
      double x2 = a + range * (double)i / nFloat;
      sum2 += f.eval(x2);
    }
    return (f.eval(a) + f.eval(b) + sum1 * 4.0 + sum2 * 2.0) * range / (nFloat * 6.0);
  }
 
  private static double rectangular(double a, double b, int n, FPFunction f, int mode)
  {
    double range = checkParamsGetRange(a, b, n);
    double modeOffset = (double)mode / 2.0;
    double nFloat = (double)n;
    double sum = 0.0;
    for (int i = 0; i < n; i++)
    {
      double x = a + range * ((double)i + modeOffset) / nFloat;
      sum += f.eval(x);
    }
    return sum * range / nFloat;
  }
 
  private static double checkParamsGetRange(double a, double b, int n)
  {
    if (n <= 0)
      throw new IllegalArgumentException("Invalid value of n");
    double range = b - a;
    if (range <= 0)
      throw new IllegalArgumentException("Invalid range");
    return range;
  }
 
 
  private static void testFunction(String fname, double a, double b, int n, FPFunction f)
  {
      int maxThreads       = Runtime.getRuntime().availableProcessors();
    long start = System.nanoTime();
    trapezium(a, b, n, f);
    long finish = System.nanoTime();
            // Then you solve for the actual execution time
    long algTime =  finish - start;
    System.out.println("For n= " + n + " it takes " + algTime + "Processor is " + maxThreads);
   
    return;
  }
 
  public static void main(String[] args)
  {
    // write a for loop
      int maxThreads       = Runtime.getRuntime().availableProcessors();
      for (int i=0; i<=20; i++){
    testFunction("3+ x^2", 0.0, 1.0, 10000000*(i+1  ), new FPFunction() {
        public double eval(double n) {
            System.out.println( "Processor is " + maxThreads);
          return n * n  +3;
        }
      }
    );
      }
 
    return;
  }
}