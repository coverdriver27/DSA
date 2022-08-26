/**
 * Project 1, PMatrix Class
 * Comp 182 Spring 2019.
 * @author (Dhulian Pereira)
 * @Date (05/12/2019)
 */

package Matrix; 
import java.util.stream.*;

public class PMatrix extends Matrix 
{

    public PMatrix(int Row, int Col) 
    {
        super(Row, Col);
    }

    public PMatrix() 
    {
    }

    public PMatrix(int[][] Elements) {
        super(Elements);
    }
    @Override
    Matrix Add (Matrix input)
    {
        return new Matrix (
                IntStream.range(0,super.Row).parallel().mapToObj(x
                -> IntStream.range(0,super.Col).parallel().map(y 
                        ->super.Elements[x][y]+input.Elements[x][y]
                ).toArray()
        ).toArray(int[][]:: new));
    }
    @Override
    Matrix Dot (Matrix input)
    {
        return new Matrix (
                IntStream.range(0, super.Row).mapToObj(i
                        -> IntStream.range(0,input.Col).map(j
                                -> IntStream.range(0,super.Row).map(k 
                                        -> super.Elements [i][k]*input.Elements[k][j]).reduce(0,(a,b)->a+b)
                        ).toArray()
                ).toArray(int[][]::new));
        
    }
    @Override
    Matrix Substract(Matrix input)
    {
        return new Matrix (
                IntStream.range(0,super.Row).parallel().mapToObj(x
                -> IntStream.range(0,super.Col).parallel().map(y 
                        ->super.Elements[x][y]-input.Elements[x][y]
                ).toArray()
        ).toArray(int[][]:: new));
    }
    @Override
    Matrix Hadamard(Matrix input)
    {
        return new Matrix (
                IntStream.range(0,super.Row).parallel().mapToObj(x
                -> IntStream.range(0,super.Col).parallel().map(y 
                        ->super.Elements[x][y]*input.Elements[x][y]
                ).toArray()
        ).toArray(int[][]:: new));
    }
}
