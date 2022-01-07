package raul.target;

//Essa é a 2
public class FibonacciChecker {

    public static void main(String[] args)
    {
        int[] numeros = { 1 ,2 ,3 ,4, 5, 6 };

        for (int n : numeros) {
            if (isFibonacci(n)) {
                System.out.println(n + " faz parte da sequência Fibonacci");
            } else {
                System.out.println(n + " não faz parte da sequência Fibonacci");
            }
        }
    }

    private static boolean isFibonacci(int n)
    {
        return isPerfectSquare(5 * n * n + 4) ||
                isPerfectSquare(5 * n * n - 4);
    }

    private static  boolean isPerfectSquare(int x)
    {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

}
