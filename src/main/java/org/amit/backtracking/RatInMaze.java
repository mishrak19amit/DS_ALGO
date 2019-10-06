package org.amit.backtracking;

public class RatInMaze {
	// Size of the maze 
    static int N; 
    
	public static void main(String[] args) {
		RatInMaze rat = new RatInMaze(); 
        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } }; 
  
        N = maze.length; 
        rat.solveMaze(maze); 
	}

	private void solveMaze(int[][] maze) {
		

		int sol[][]= new int[N][N];
		
		if(solveMazeUtil(maze, sol, 0, 0))
			printSol(sol);
		
		
	}

	private void printSol(int[][] sol) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private boolean solveMazeUtil(int[][] maze, int[][] sol, int i, int j) {
		
		if(i==N-1&&j==N-1) {
			sol[i][j]=1;
			return true;
		}
			
		
		if(isSafe(maze, i, j)) {
			
			sol[i][j]=1;
			
			if(solveMazeUtil(maze, sol, i+1, j))
				return true;
			

			if(solveMazeUtil(maze, sol, i, j+1))
				return true;
			
			sol[i][j]=0;
			
			return false;
			
		}
		
		return false;
		
	}

	private boolean isSafe(int[][] maze, int i, int j) {
		
		return (0<=i&&i<N&&0<=j&&j<N&&maze[i][j]==1);
		
	}

}
