
public interface SudokuSolver {
	/**
	 * Solve the puzzle using depth first search
	 * @param i: the current row index
	 * @param j: the current column index 
	 * @param cells: the current board configuration
	 * @return the board configuration of the solution, void if no solution found
	 */
	public int[][] solve_dfs(int i, int j, int[][] cells);

	/**
	 * Check whether the current move (putting val at the position [i,j]) is legal
	 * @param i: the current row index
	 * @param j: the current column index
	 * @param val: the current value assignment
	 * @param cells: the current board configuration
	 * @return true if legal. Otherwise false
	 */
	 public boolean check_move(int i, int j, int val, int[][] cells);

}
