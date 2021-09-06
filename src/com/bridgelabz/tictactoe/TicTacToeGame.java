package com.bridgelabz.tictactoe;


import java.util.Scanner;

public class TicTacToeGame 
{
	public static char[] board= new char[10];
	
	Scanner scanner=new Scanner(System.in);
	public void createBoard()
	{
		for(int index=1;index<=9;index++)
		{
			board[index]=' ';
		}
	}
	
	public void getInput() 
	{
		System.out.println("Choose X or O");
		char playerMark=scanner.next().toUpperCase().charAt(0);
		char computerMark;
		if (playerMark=='X')
		{
			computerMark='O';
		}
		else
			computerMark='X';
		System.out.println("Player :" +playerMark+ " computer:" +computerMark);

	}
	
	public void makeMove() 
	{
		System.out.println("Available spaces to make a move on board: ");
		int isEmpty=0;
		for(int index=1;index<=9;index++)
		{
			if(board[index]== ' ')
			{
				isEmpty=1;
				System.out.print(index+ " ");
			}
				
		}
        System.out.println();
        if(isEmpty==1)
        {
        	System.out.println("Choose index to make move:");
    		int moveIndex=scanner.nextInt();
    		if(board[moveIndex]!=' ')
    		{
    			System.out.println("Invalid move! Choose the index that is free on board");
    		}
        }
			
	}
	
	public void showBoard() 
	{
		int count=0;
		for(int index1=1;index1<=9;index1++)
		{
			System.out.print("|"+board[index1]+" ");
			count++;
			if(count==3)
			{
				System.out.println();
				count=0;
			}
			
		}
		
	}

	public static void main(String[] args) 
	{
		TicTacToeGame tictactoe=new TicTacToeGame();
		System.out.println("**Welcome to Tic-tac-toe game**");
		tictactoe.createBoard();
		tictactoe.getInput();
		tictactoe.showBoard();
		tictactoe.makeMove();
		
	}

	
	

}
