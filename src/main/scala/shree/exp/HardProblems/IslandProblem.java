package shree.exp.HardProblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all islands in a matrix
 */
public class IslandProblem {

    List<Set<String>> islandList = new ArrayList<>();

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1}
        };

        IslandProblem i = new IslandProblem();
        i.islandProblem(matrix);
    }



    private void islandProblem(int[][] matrix) {

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 1) {
                    Set<String> set = new HashSet<>();
                    recurse(matrix, i, j, set);
                    if(!set.isEmpty()) {
                        islandList.add(set);
                    }
                }
            }
        }

        System.out.println("Number of islands : "+ islandList.size());
    }


    private void recurse(int[][] matrix, int i, int j, Set<String> islandSet) {
        if((i >= 0  && i < matrix.length) && (j >= 0 && j < matrix.length)) {
           if(matrix[i][j] == 0) {
               return;
           }

            if(isPartOfIsland(i, j) || islandSet.contains(String.valueOf(i) + "-" + String.valueOf(j))) {
                return;
            }

            islandSet.add(String.valueOf(i) + "-" + String.valueOf(j));

            recurse(matrix, i-1, j, islandSet);
            recurse(matrix, i, j-1, islandSet);
            recurse(matrix, i+1, j, islandSet);
            recurse(matrix, i, j+1, islandSet);
        }
    }

    private boolean isPartOfIsland(int i, int j) {
       return islandList.stream()
                .filter(island -> island.contains(String.valueOf(i) + "-" + String.valueOf(j)))
                .findAny()
                .isPresent();
    }
}
