package mission2.셔플;

public class Main {

    public static int pibo(int a){
        int n=a;
        if(n <3){
            return 1;
        }
        return pibo(n-1) + pibo(n-2);
    }

    public static int factorial(int a){
        int n = a;
        if(n<2){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }
}
