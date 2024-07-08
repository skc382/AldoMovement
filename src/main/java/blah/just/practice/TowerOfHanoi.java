package blah.just.practice;

public class TowerOfHanoi {

    public static void main(String[] args) {
        towerOfHanoi(3, 1,2,3);
    }

    static void towerOfHanoi(int n, int src, int dst, int aux) {
        System.out.printf("Calling params [%d, %d, %d, %d]%n", n, src, dst, aux);
        if(n == 1) {
            System.out.println("Move disk from " + src + " to " + dst);
        } else {
            towerOfHanoi(n-1, src, aux, dst);
            System.out.println("Move disk FROM " + src + " to " + dst);
            towerOfHanoi(n-1, aux, dst, src);
        }
    }
}
