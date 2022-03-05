
public class SudokuRunner {

	public static void main(String[] args) {
		
		int[][] matrix;
		 
		SudokuSolver test_ps=new SudokuSolver_Billy();
		
		matrix = SudokuUtil.load_problem("./Test_Problem_Hardest.txt");
		SudokuUtil.write_matrix(matrix);
		int[][] sol= test_ps.solve_dfs(0, 0, matrix); 
		SudokuUtil.write_matrix(sol);
		if (SudokuUtil.check_solution (sol))
			 System.out.println("You pass the first test! Congratulations!");
		else 
			System.out.println("Sorry, your solution is incorrect!");
	}			 

}
