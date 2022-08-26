/**
 * Project 1, Matrix Class
 * Comp 182 Spring 2019.
 * @author (Dhulian Pereira)
 * @Date (05/12/2019)
 */

package Matrix; 
import java.util.Arrays;
public class Matrix 
{
    final int Row;
    final int Col;
    final int [][] Elements;
    Matrix(int Row, int Col)
    {
        this.Row=Row;
        this.Col=Col;
        this.Elements = new int [Row][Col];
        for (int i=0; i < Row; i++)
        {
            for(int j = 0; j < Col; j++)
            {
                this.Elements[i][j]= (int)((Math.random()*1000)-500);
            }
        }
    }
    Matrix()
    {
        this(3,3);
    }
    Matrix Add(Matrix input)
    {
        int[][]result = new int [Row][Col];
        for(int i=0; i < Row; i++)for(int j = 0; j < Col; j++)
        {
            result [i][j] = this.Elements[i][j] + input.Elements[i][j];
        }
        return new Matrix(result);
    }
    Matrix (int [][] input)
    {
        this.Row=input.length;
        this.Col=input[0].length;
        this.Elements=new int [Row][Col];
        for(int i=0; i< Row; i++)
        {
            this.Elements[i]=Arrays.copyOf(input[i],this.Col);
        }
    }
    Matrix Dot(Matrix input)
    {
        int [][] result = new int[this.Row][input.Col];
        for(int i=0; i<this.Row;i++)
            for(int j=0; j<input.Col; j++)
                for(int k=0; k<this.Row; k++)
                {
                    result[i][j]+=this.Elements[i][k]*input.Elements[k][j];
                }
        return new Matrix(result);
    }
    Matrix Substract(Matrix input)
    {
        int[][]result = new int [Row][Col];
        for(int i=0; i < Row; i++)for(int j = 0; j < Col; j++)
        {
            result [i][j] = this.Elements[i][j] - input.Elements[i][j];
        }
        return new Matrix(result);
    }
    Matrix Hadamard(Matrix input)
    {
        int[][]result = new int [Row][Col];
        for(int i=0; i < Row; i++)for(int j = 0; j < Col; j++)
        {
            result [i][j] = this.Elements[i][j] * input.Elements[i][j];
        }
        return new Matrix(result);
    }
    static boolean checkForValidSHA(Matrix A, Matrix B)
    {
        return (A.Row==B.Row && A.Col==B.Col);
    }
    static boolean checkForValidDOT(Matrix A, Matrix B)
    {
        return (A.Col==B.Row);
    }
    @Override
    public String toString()
    {
        String result="";
        for (int [] arrays : this.Elements)
        {
            result += "[";
            for(int element : arrays)
            {
                result += String.format(" %3d ", element);
            }
            result += "] \n";
        }
        return result;
    }
    public Object Clone()
    {
        return (Object) new Matrix(this.Elements);
    }
    @Override
    public boolean equals(Object value)
    {
        if (value instanceof Matrix)
        {
            Matrix test = (Matrix)value;
            if (this.Elements.length != test.Elements.length)
            {
                return false;
            }
            if (this.Elements[0].length != test.Elements[0].length)
            {
                return false;
            }
            for(int i =0; i<this.Row;i+=1) for(int z=0; z<this.Col;z+=1)
            {
                if (this.Elements[i][z] != test.Elements [i][z])
                {
                    return false;
                }
            }
            return true;
        }
            return false;
    }
}
