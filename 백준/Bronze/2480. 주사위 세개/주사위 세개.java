import java.util.Scanner;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dice = new int[3];
        
        dice[0] = sc.nextInt();
        dice[1] = sc.nextInt();
        dice[2] = sc.nextInt();
        
        int score = 0;
        int[] point = new int[7];
        int high = 0;
        
        for(int i = 0; i < dice.length; i++) point[dice[i]]++;
        
        for(int i = 1; i < point.length; i++) {
            if(point[i] == 3) score = 10000 + i * 1000;
            else if(point[i] == 2) score = 1000 + i * 100;
            else if(point[i] == 1) high = i;
        }
        
        if(score == 0) score = high * 100;
        
        System.out.println(score);
    }
}