import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        
        int time = h * 60 + m;
        time += p;
        if(time >= 1440) time -= 1440;
        
        h = time / 60;
        m = time % 60;
        
        System.out.printf("%d %d", h, m);
    }
}