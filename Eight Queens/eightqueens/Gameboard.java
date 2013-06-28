package eightqueens;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Gameboard extends JFrame
{
	private JLabel headerLbl, footerLbl;
	private JPanel gridPnl;
	private JTextField[][] textFields;
	
	public Gameboard(int n)
	{
		setLayout(new BorderLayout());
		headerLbl = new JLabel();
		footerLbl = new JLabel();
		gridPnl = new JPanel(new GridLayout(n,n));
		textFields = new JTextField[n][n];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				textFields[i][j] = new JTextField("*");
				gridPnl.add(textFields[i][j]);
			}
		}
		
		add(headerLbl, BorderLayout.NORTH);
		add(footerLbl, BorderLayout.SOUTH);
		add(gridPnl, BorderLayout.CENTER);
		
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	 
		
	}
	public void setHeader(String header)
	{
		headerLbl.setText(header);
	}
	
	public void setFooter(String footer)
	{
		footerLbl.setText(footer);
	}
	public void setSquare(int row, int col, String info)
	{
		textFields[row][col].setText(info);
	}
	public String getSquare(int row, int col)
	{
		return textFields[row][col].getText();
	}
	
}