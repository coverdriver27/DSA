/**
 * Project 1, MainMatrix Class
 * Comp 182 Spring 2019.
 * @author (Dhulian Pereira)
 * @Date (05/12/2019)
 */

package Matrix;
import java.util.*;
public class MainMatrix 
{
    Scanner input= new Scanner(System.in);
    public static void main(String [] args)
    {
        MainMatrix T=new MainMatrix();
        T.test();
    }
    void test()
    {
        
        Matrix A = getMatrix("1st Matrix");
        System.out.println(A.toString());
        Matrix B=getMatrix("2nd Matrix");
        System.out.println(B.toString());
        Matrix C = performOperation(A,B);
        System.out.println(C.toString());
    }
    Matrix performOperation(Matrix A, Matrix B)
    {
        int op=selectOP();
        boolean valid=isValid(A,B,op);
        while(!valid)
        {
             A=getMatrix("1st Matrix");
             B=getMatrix("2nd Matrix");
            valid = isValid(A,B,op);
        }
        return calculate(A,B,op);
    }
    Matrix calculate(Matrix A, Matrix B, int op)
    {
        switch (op)
        {
            case 1:return A.Add(B);       
            case 2:return A.Substract(B);
            case 3:return A.Dot(B);
            default:return A.Hadamard(B);
        }
    }
    boolean isValid(Matrix A, Matrix B, int op)
    {
        if(op==1 || op==2 || op==4)
            return Matrix.checkForValidSHA(A,B);
        else if (op==3)
            return Matrix.checkForValidDOT(A,B);
        return false;
    }
    
    int selectOP()
    {
        System.out.println("Please enter the number Associated to the Operation:\n 1).Add (1) \n 2).Substract (2) \n 3).Dot (3) \n 4).Hadamard (4)");
        return input.nextInt();
    }
    Matrix getMatrix(String matrixName)
    {
        int Row;
        int Col;
        System.out.println("Please provide the Rows and Colummns for " + matrixName );
        Row=input.nextInt();
        Col=input.nextInt();
        return new Matrix(Row, Col);
    }
}
