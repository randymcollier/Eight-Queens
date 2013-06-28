package eightqueens;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.Formatter;

public class EightQueens extends JPanel
{

	// declare class constants as needed
	private Gameboard gameboard;
   
	// declare instance variables
	int backtracks = 0, comparisons = 0;
	// CREATE AND INITIALIZE THE OUTPUT FILE
	
	Formatter formatter;
   
	// constructor method
	public EightQueens()
	{
   
		//Create output file
		File file = new File("traceQueens.txt");
		try
		{
			formatter = new Formatter(file);
		}catch(Exception e){}
		
		// CREATE AND INITIALIZE BOARD
		gameboard = new Gameboard(8);		
		gameboard.setHeader("Eight Queens Game");
	 
   
	} //end constructor

	//user interface method used to wrap the parameter representing the first column
	public boolean solve()
	{
		return solve(0);
	}

	//recursive method solve 
	public boolean solve(int column)
	{      
		//The Queen has been placed on the board in column
		//if column is beyond the last column, then the problem is solved
		if (column > 7) 
		{
			//CLOSE FILE
			formatter.format("Summary statistics: number of backtracks = " + backtracks + ", number of comparisons = " +
						comparisons + ". ");
			gameboard.setFooter("Finished!");
			formatter.close();
			//RETURN TRUE
			return true;
		}
		else // attempt a solution from column 
		{
			formatter.format("Now attempting solution from column " + column + ". \n");
			gameboard.setFooter("Now attempting solution from column " + column);
			for (int i = 0; i < 8; i++)//for each row of this column  
			{
				if (isOpen(i, column))//this square is open (i.e. no other queen in same row, col, or diagonal)
				{
					//place queen on this square
					formatter.format("Placing queen at [" + i + ", " + column + "]. \n");
					gameboard.setFooter("Placing queen at [" + i + ", " + column + "]");
					gameboard.setSquare(i, column, "Q");
					try
					{
						Thread.sleep(0);
					}catch(Exception e){}
					//printBoard();
               
					//solve the "rest of the board"
					if (solve(column + 1))
						return true;
				
					else 
					{
							//problem not solvable with queen in current square
							//remove the queen
							formatter.format("Queen cannot be placed at [" + i + ", " + column + "]. \n");
							gameboard.setFooter("Queen cannot be placed at [" + i + ", " + column + "]");
							gameboard.setSquare(i, column, "*");
					}
					//Queen cannot be placed at this square
				}
			} 
			backtracks++;
			return false; //to Backtrack to previous column since no squares in current row will solve problem         
		} 
	} 
   
	//Method to verify that the square is open.
	public boolean isOpen(int row, int column)
	{
		int col1, col2;
		for (int i = 0; i < 8; i++)
		{
			comparisons++;
			if (gameboard.getSquare(row, i).equals("Q"))
			{
				return false;
			}
		}
		for (int i = 0; i < 8; i++)
		{
			comparisons++;
			if (gameboard.getSquare(i, column).equals("Q"))
			{
				return false;
			}
		}
		col1 = col2 = column;
		for (int i = row; i < 7; i++)
		{		
			if (col1 < 7 && i < 7)
			{
				comparisons++;
				if (gameboard.getSquare(i + 1, col1 + 1).equals("Q"))
				{
					return false;
				}
				col1++;
			}
			if (col2 > 0 && i < 7)	
			{	
				comparisons++;
				if (gameboard.getSquare(i + 1, col2 - 1).equals("Q"))
				{
					return false;
				}
				col2--;
			}
		}
		col1 = col2 = column;
		for (int i = row; i > 0; i--)
		{
			if (col1 < 7 && i < 7)
			{			
				comparisons++;
				if (gameboard.getSquare(i - 1, col1 + 1).equals("Q"))
				{
					return false;
				}
				col1++;
			}
			if (col2 > 0 && i < 7)
			{
				comparisons++;
				if (gameboard.getSquare(i - 1, col2 - 1).equals("Q"))
				{
					return false;
				}
				col2--;
			}
		}
		return true;
		
		
		// if there is a Queen occupies any square in the same row, column or diagonal
			// return false
		// else
			// return true;
	} 
   
	//output the board 
	public void printBoard()
	{
		System.out.println("Finished!");
	}
   
} // end class EightQueens