package aa.wayfair.just.practice.hard.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class IslandProblemCount {

    private static class Pair {
        int i, j;
        String coOrdinates;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
            this.coOrdinates = String.format("(%d, %d)", this.i, this.j);
        }

        @Override
        public boolean equals(Object other) {
            Pair otherPair = (Pair)other;
            return this.i == otherPair.i && this.j == otherPair.j;
        }

        @Override
        public int hashCode() {
            return  new Integer(this.i).hashCode() + new Integer(this.j).hashCode();
        }
    }

    private static ArrayList<HashSet<Pair>> isLandList = new ArrayList<>();

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1}
        };

        findIslands(matrix);
        System.out.println("Number of islands : "+ isLandList.size());

        for (HashSet<Pair> island : isLandList) {
            island.stream()
                    .forEach(p -> {
                        System.out.print(String.format("(%d, %d)", p.i, p.j));
                    });
            System.out.println();
        }


    }

    private static void findIslands(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !isPartOfIslands(i, j)) {
                    HashSet<Pair> island = new HashSet<>();
                    exploreIsland(matrix, i, j, island);
                    if (!island.isEmpty()) {
                        isLandList.add(island);
                    }
                }
            }
        }
    }

    private static void exploreIsland(int[][] matrix, int i, int j, HashSet<Pair> island) {
        if (i >= 0 && j >= 0 && i < matrix.length && j < matrix.length && matrix[i][j] == 1) {
            Pair p = new Pair(i, j);
            if(island.contains(p) || isPartOfIslands(i, j)) {
                return;
            }

            island.add(p);
            exploreIsland(matrix, i - 1, j, island);
            exploreIsland(matrix, i, j - 1, island);
            exploreIsland(matrix, i + 1, j, island);
            exploreIsland(matrix, i, j + 1, island);
        }
    }

    private static boolean isPartOfIslands(int x, int y) {
        for (HashSet<Pair> island : isLandList) {
            if (island.contains(new Pair(x, y))) {
                return true;
            }
        }
        return false;
    }


}
