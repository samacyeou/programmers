import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        int y = sc.nextInt();
        int pos = 0;
        
        if(x > 0) {
            if(y > 0) pos = 1;
            else pos = 4;
        } else {
            if(y > 0) pos = 2;
            else pos = 3;
        }
        
        System.out.println(pos);
    }
}