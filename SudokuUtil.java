import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public  class SudokuUtil {
	
	
	/**
	 * Load the problem from a text file
	 * @param file_name: encode the problem.
	 * @return the initial board configuration
	 */
	static public int[][] load_problem(String file_name) {
		int[][] problem = new int[9][9]; // default 0 vals
		BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file_name));
            String line;
            while ((line = br.readLine()) != null) {
            	//System.out.println(line);
            	int i = Integer.parseInt(line.substring(0, 1));
    			int j = Integer.parseInt(line.substring(1, 2));
    			int val = Integer.parseInt(line.substring(2, 3));
    			problem[i][j] = val;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return problem;
	}
		
	
	static void write_matrix(int[][] solution) {
		for (int i = 0; i < 9; ++i) {
			if (i % 3 == 0)
				System.out.println(" -----------------------");
			for (int j = 0; j < 9; ++j) {
				if (j % 3 == 0)
					System.out.print("| ");
				System.out.print(solution[i][j] == 0 ? " " : Integer
						.toString(solution[i][j]));

				System.out.print(' ');
			}
			System.out.println("|");
		}
		System.out.println(" -----------------------");
	}
	
	static boolean check_solution(int[][] cells) {
		// TODO Auto-generated method stub
		HashMap<Integer, Boolean> number_map=new HashMap<Integer, Boolean>();
		//check rows
				for (int i=0;i<9;++i) {
					// initialize the hashmap
					for (int m=1;m<=9;++m){
						number_map.put(m, false);
					}
					for (int j=0;j<9;++j){
						if (cells[i][j]==0) {
							System.out.println ("Incomplete Solution!");
							return false;
						}
						if (!(Boolean) number_map.get(cells[i][j])) {
							number_map.put(cells[i][j], true);
						}
						else {
							return false;
						}
					}
				}
				//check columns
				for (int j=0;j<9;++j) {
					// initialize the hashmap
					for (int m=1;m<=9;++m){
						number_map.put(m, false);
					}
					for (int i=0;i<9;++i){
						if (cells[i][j]==0) {
							System.out.println ("Incomplete Solution!");
							return false;
						}
						if (!(Boolean) number_map.get(cells[i][j])) {
							number_map.put(cells[i][j], true);
						}
						else {
							return false;
						}
					}
				}
				
				//check blocks
				
				for (int i=0;i<3;++i)
					for (int j=0;j<3;++j){
						// initialize the hashmap
						for (int m=1;m<=9;++m){
							number_map.put(m, false);
						}
						for (int p=0;p<3;++p)
							for (int q=0;q<3;++q){
								int x=i*3+p;
								int y=j*3+q;
								if (!(Boolean) number_map.get(cells[x][y])){
									number_map.put(cells[x][y], true);
								}
								else {
									return false;
								}
							}
					}
				
				return true;
	}
	

}
