package com.linkui.problems;

public class ValidSudoku {
	public static void main(String[] args){
		new ValidSudoku().start();
	}
	
	public void start(){
		char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
						   {'6','.','.','1','9','5','.','.','.'},
						   {'.','9','8','.','.','.','.','6','.'},
						   {'8','.','.','.','6','.','.','.','3'},
						   {'4','.','.','8','.','3','.','.','1'},
						   {'7','.','.','.','2','.','.','.','6'},
						   {'.','6','.','.','.','.','2','8','.'},
						   {'.','.','.','4','1','9','.','.','5'},
						   {'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(sudoku));
	}
	
	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
		char c;
		
		for (int i = 0; i < 9; i++){ // i is row and j is column
			for (int j = 0; j < 9; j++){
				c = board[i][j];
				
				if (c == '.') continue;
				if (c < '1' || c > '9') 
					return false;
				
				int num = c - '1';
				if (row[i][num] || col[j][num] || box[(i/3) * 3 + j / 3][num]){
					return false;
				}
				row[i][num] = true;
				col[j][num] = true;
				box[(i/3) * 3 + j/3][num] = true;
			}
		}
		return true;
	}
}
