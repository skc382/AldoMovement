package shree.exp.HardProblems;

/**
 * Created by shreedharkempanayakanahallichampakaram on 10/26/17.
 */
public class SingleIslandProblem {

    public static void main(String[] args) {
        int[][] image = {
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,1},
                {1,1,1,1,0,0,0,1},
                {1,1,1,1,1,1,1,1}
        };

        String start = "", end = "";
        for (int i = 0; i < image.length ; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if(image[i][j] == 0) {
                    start = i +"-"+j;
                    System.out.println("Start-"+start+ "End-" + func(image, i, j));
                    System.exit(0);
                }
            }
        }
    }

    private static String func(int[][] matrix, int i, int j) {
        return recurse(matrix, i, j);
    }

    private static String recurse(int[][] matrix, int i, int j) {
        String location = "";
        if(i < matrix.length && j< matrix[0].length) {

            if(matrix[i][j] != 0) {
                return (i-1) +"-"+(j-1);
            }

            location = recurse(matrix, i, j+1);
            location = recurse(matrix, i+1, j);

        }

        return location;
    }



}
