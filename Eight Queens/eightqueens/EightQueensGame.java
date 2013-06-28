package eightqueens;
import javax.swing.JFrame;


import java.io.*;

public class EightQueensGame
{
   public static void main( String args[] )
   {
		
		  
		  
		EightQueens eightQueens = new EightQueens();
		
		if (eightQueens.solve())
		{
			eightQueens.printBoard();
		}
		else
			System.out.println("Sorry, there is no solution");
	} 
} 