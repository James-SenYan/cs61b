/**
 * @author Sen Yan
 * @create 2021-04-10-18:47
 */
public class Discussion2 {
    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib(n - 1)+fib(n - 2);
    }

    public static int fib2(int n, int f0, int f1){
        if(n == 0){
            return f0;
        }
        if(n == 1){
            return f1;
        }
        return fib2(n - 1, f1, f0 + f1);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(fib2(i, 0, 1));
        }

    }
}
