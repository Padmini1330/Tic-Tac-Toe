package com.bridgelabz.tictactoe;


import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame 
{
	public char[] board= new char[10];
	public char playerKey;
	public char computerKey;
	public int isEmpty=0;
	public int[] freeSpaces=new int[10];
	public static int emptyIndex=0;
	int win=0;
	
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
		playerKey=scanner.next().toUpperCase().charAt(0);
		if (playerKey=='X')
		{
			computerKey='O';
		}
		else
			computerKey='X';
		System.out.println("Player :" +playerKey+ " computer:" +computerKey);

	}
	
	public void freeIndexOnBoard()
	{
		emptyIndex=1;
		Arrays.fill(freeSpaces, 0);
		for(int index=1;index<=9;index++)
		{
			if(board[index]== ' ')
			{
				freeSpaces[emptyIndex]=index;
				emptyIndex++;
			}
				
		}
	}
	public void playerMove() 
	{
		freeIndexOnBoard();
		int flag=0;
		
			for(int index=1;index<=9;index++)
			{
				if(freeSpaces[index]!=0)
				{
					System.out.print(freeSpaces[index]+ " ");
					flag=1;
				}
				
			}
			if(flag==1)
			{
				System.out.print(" are available spaces ");
				System.out.println();
		       	showBoard();
		        System.out.println("Choose index to make move:");
		    	int moveIndex=scanner.nextInt();
		    	if(board[moveIndex]!=' ')
		    	{
		    		System.out.println("Invalid move! Choose the index that is free on board");
		    	}
		    	board[moveIndex]=playerKey;
		    	computerMove();
			}
	            
		else
		{
			System.out.println("Game tie");
			System.exit(0);
		}
		
			
	}
	
	public void computerMove()
	{
		showBoard();
		freeIndexOnBoard();
		if(emptyIndex!=1)
		{
			for(int index=1;index<=9;index++)
			{
				board[freeSpaces[index]]=computerKey;
				if(result(computerKey)==2)
				{
					playerMove();
					
					
				}
				board[freeSpaces[index]]=' ';
			}	
			for(int index=1;index<=9;index++)
			{
				board[freeSpaces[index]]=playerKey;
				if(result(playerKey)==1)
				{
					board[freeSpaces[index]]=computerKey;
					playerMove();
					
				}
				board[freeSpaces[index]]=' ';
			}
			for(int index=1;index<=9;index++)
			{
				if(freeSpaces[index]==1) 
				{
					board[1]=computerKey;
				}
				else if(freeSpaces[index]==3)
				{
					board[3]=computerKey;
				}
				else if(freeSpaces[index]==7)
				{
					board[7]=computerKey;
				}
				else
				{
					board[9]=computerKey;
				}
				playerMove();
				
			}
			if(board[freeSpaces[5]]==' ')
				board[5]=computerKey;
			for(int index=1;index<=9;index++)
			{
				board[freeSpaces[index]]=computerKey;
				break;
			}
			playerMove();
			
		}
		else
		{
			System.out.println("Game finished!");
			
		}
				
	}
	
	public void showBoard() 
	{
		int count=0;
		for(int index1=1;index1<=9;index1++)
		{
			System.out.print("|"+board[index1]+"|"+" ");
			count++;
			if(count==3)
			{
				System.out.println();
				count=0;
			}
			
		}
		
	}


	public int isWin(char key) 
	{
		int row=1,column=1;
		if(board[1]==key && board[5]==key && board[9]==key)
			win=1;
		else if(board[3]==key && board[5]==key && board[7]==key)
			win=1;
		for(int index=1;index<=3;index++)
		{
			if(board[row]==key && board[row+1]==key && board[row+2]==key) 
				win=1;
			row=4;				
		}
		for(int index=1;index<=3;index++)
		{
			if(board[column]==key && board[column+3]==key && board[column+6]==key) 
				win=1;
			column=2;				
		}
		
		return win;
			
	}

	public int result(char key)
	{
		if(isWin(key)==1) 
		{
			if(key==playerKey)
				return 1;
			else
				return 2;
		}
		else
			return 3;
	}
	
	public void checkToss() 
	{
		System.out.println("Select Heads or Tails[H or T]:");
		char toss=scanner.next().toUpperCase().charAt(0);
		char result;
		if(Math.random()<0.5)
			result='H';
		else
			result='T';
		if(toss==result)
		{
			System.out.println("Player plays first!");
			playerMove();
		}
		else
		{
			System.out.println("Computer plays first!");
			computerMove();
		}
			
	}

	

	public static void main(String[] args) 
	{
		TicTacToeGame tictactoe=new TicTacToeGame();
		System.out.println("**Welcome to Tic-tac-toe game**");
		tictactoe.createBoard();
		tictactoe.getInput();
		tictactoe.checkToss();
		if(emptyIndex!=1)
		{
			System.out.println("Game finished!");
		}
		
			
		
	}

}
