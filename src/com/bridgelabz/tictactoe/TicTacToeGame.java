package com.bridgelabz.tictactoe;

public class TicTacToeGame 
{
	public static char[] board=new char[10];
	
	public void createBoard()
	{
		for(int index=1;index<=9;index++)
		{
			board[index]=' ';
		}
	}
	public static void main(String[] args) 
	{
		TicTacToeGame tictactoe=new TicTacToeGame();
		System.out.println("**Welcome to Tic-tac-toe game**");
		tictactoe.createBoard();
		
		
	}

}
