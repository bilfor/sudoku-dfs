public class SudokuSolver_Billy implements SudokuSolver {

  public int[][] solve_dfs(int i, int j, int[][] cells) {
    int[] coords = find_empty(i,j,cells);
    if(coords[0] == 10 && coords[1] == 10) return cells; 
    for(int val = 1; val < 10; val++) {
      if(check_move(i,j,val,cells)) {
        cells[i][j] = val;
        //inferences <- INFERENCE(csp,var,assignment)
        //if (inferences != failure) {
        //  add inferences to csp
        //  result <- solve_dfs(csp,assignment)
        //  if (result != failure)
        //    return result
        //    remove inferences from csp
        //    remove {var=value} from assignment
    //return failure
      }
      break;
    } //unroll
    solve_dfs(i,j,cells);
    return cells;
  }
  
  private int[] find_empty(int i, int j, int[][] cells) {
    int[] coords = new int[2];
    for(int row = i; row < 9; row++) {
      for(int col = j; col < 9; col++) { 
        if(cells[row][col] == 0) {
          coords[0] = row;
          coords[1] = col; 
          return coords;
        }
      }
    } 
    coords[0] = 10;
    coords[1] = 10;
    return coords;
  }
  

  public boolean check_move(int i, int j, int val, int[][] cells) {
 
    int i2;
    int j2; 
    int row;
    int col;
    int row_rem = i / 3;
    int col_rem = j / 3;
  
    switch(row_rem) {
      case 0: i2 = 0; break; 
      case 1: i2 = 3; break;
      default: i2 = 6; break;
    }

    switch(col_rem) {
      case 0: j2 = 0; break; 
      case 1: j2 = 3; break;
      default: j2 = 6; break;
    }

    for (col=i2; col<i2+3; col++)
    {
      for (row=j2; row<j2+3; row++)
      {
        if(val == cells[row][col] && row != i && col != j) return false;  
      }
    }

    for(col=0; col < cells[0].length; col++)
    {
      if(val == cells[i][col] && col != j) return false; 
    }

    for(row=0; row < cells.length; row++)
    {
      if(val == cells[row][j] && row != i) return false; 
    }

   return true; 
  }
}
