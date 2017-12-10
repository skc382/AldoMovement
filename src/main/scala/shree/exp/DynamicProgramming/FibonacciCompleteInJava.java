package shree.exp.DynamicProgramming;


public class FibonacciCompleteInJava {

    public static void main(String[] args) {
//        (new FibNaive()).execute();
        (new FibMemoizedTopDown()).execute();
    }

    private static class FibNaive {
        public void execute() {
            System.out.println(fib(50));
        }

        private int fib(int n) {
            if(n < 1) return 0;

            if(n == 1) return 1;

            int result = fib(n-1) + fib(n-2);

            return result;
        }
    }

    private static class FibMemoizedTopDown {
        public void execute() {
            int n = 40;
            int[] arr = new int[n+1];
            System.out.println(fib(n, arr));
        }

        private int fib(int n, int[] array) {
            if(n < 1) {
                array[0] = 0;
                return array[0];
            }

            if(n == 1) {
                array[1] = 1;
                return array[1];
            }

            if(array[n] < 1) {
                array[n] = fib(n-1, array) + fib(n-2, array);
            }

            return array[n];
        }
    }
}
