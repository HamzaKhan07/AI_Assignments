package com.sudoko;

public class SudokuSolver {

	public static boolean isValid(int[][] board, int x, int y, int val) {
		//check in row
		for(int i=0; i<board[0].length; i++) {
			if(board[x][i]==val) {
				return false;
			}
		}
		//check in column
		for(int i=0; i<board.length; i++) {
			if(board[i][y]==val) {
			return false;
			}
		}
		//check in 3x3 matrix
		int smi=(x/3)*3;
		int smj=(y/3)*3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[smi+i][smj+j]==val) {
				return false;
				}
			}
		}
		return true;
		}
		public static void display(int[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
			}
		}

		public static void solve(int[][] board, int i, int j) {
			if(i==board.length) {
				display(board);
				return;
			}
			int ni=0;
			int nj=0;
			if(j==board[0].length-1) {
				ni=i+1;
				nj=0;
			}
			else {
				ni=i;
				nj=j+1;
			}
			if(board[i][j]!=0) {
				solve(board, ni, nj);
			}
			else {
			for(int pos=1; pos<=9; pos++) {
				if(isValid(board, i, j, pos)==true) {
				board[i][j]=pos;
				solve(board, ni ,nj);
				board[i][j]=0;
				}
			}
		}
	}
		
		public static void main(String[] args) {
		int[][] board= {

		{3, 0, 6, 5, 0, 8, 4, 0, 0},
		{5, 2, 0, 0, 0, 0, 0, 0, 0},
		{0, 8, 7, 0, 0, 0, 0, 3, 1},
		{0, 0, 3, 0, 1, 0, 0, 8, 0},
		{9, 0, 0, 8, 6, 3, 0, 0, 5},
		{0, 5, 0, 0, 9, 0, 6, 0, 0},
		{1, 3, 0, 0, 0, 0, 2, 5, 0},
		{0, 0, 0, 0, 0, 0, 0, 7, 4},
		{0, 0, 5, 2, 0, 6, 3, 0, 0}

		};
		//Example2
		int[][] board1= {

		{8, 0, 5, 0, 3, 0, 0, 0, 0},
		{0, 0, 0, 5, 0, 8, 6, 2, 1},
		{0, 0, 9, 0, 6, 4, 0, 0, 0},
		{0, 4, 0, 0, 0, 0, 0, 1, 8},
		{5, 0, 0, 0, 0, 9, 0, 6, 7},
		{0, 9, 0, 8, 0, 1, 0, 5, 3},
		{0, 5, 8, 0, 0, 0, 1, 3, 0},
		{4, 3, 0, 9, 1, 5, 8, 0, 0},
		{0, 1, 0, 6, 0, 0, 5, 4, 2}

		};
		int i=0;
		int j=0;
		System.out.println("Problem: \n");

		display(board);
		System.out.println("\n");
		System.out.println("Solution: \n");
		solve(board, i, j);
		
	}

}
