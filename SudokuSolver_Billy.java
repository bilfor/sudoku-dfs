public class SudokuSolver_Billy implements SudokuSolver {
    private boolean flag = false;

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

    //make this call backtrack()
    public int[][] solve_dfs (int i, int j, int[][] cells) {
      return backtrack(i,j,cells);
    }

    private int[][] backtrack(int i, int j, int[][] cells) {
      int[] coords = find_empty(i,j,cells);
      if(coords[0] == 10 || coords[1] == 10) {
        flag = true;
        return cells;
      }

      for(int val = 1; val < 10; val++) {
          if(!flag) cells[coords[0]][coords[1]] = val;
          if(check_move(coords[0], coords[1], val, cells)) {
              cells = solve_dfs(i, j, cells);
          }
      }
      if(!flag) cells[coords[0]][coords[1]] = 0;

      return cells;
    }
    
    public boolean check_move(int i, int j, int val, int[][] cells) {
        int box_row = i/3;
        int box_col = j/3;
        int row_start;
        int col_start;
        int col;
        int row;

        switch(box_row) {
          case 0:  row_start = 0; break;
          case 1:  row_start = 3; break;
          default: row_start = 6; break;
        }
        switch(box_col) {
          case 0:  col_start = 0; break;
          case 1:  col_start = 3; break;
          default: col_start = 6; break;
        }

        for(col = col_start; col < col_start + 3; col++) {
          for(row = row_start; row < row_start + 3; row++) {
            if(val == cells[row][col] && row != i && col != j) return false;
          }
        }

        for(col = 0; col < cells[0].length; col++) {
          if(cells[i][col] == val && col != j) return false;
        }

        for(row = 0; row < cells.length; row++) {
          if(cells[row][j] == val && row != i) return false;
        }

        return true;
    }
}
