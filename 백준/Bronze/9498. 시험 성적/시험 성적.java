import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        char score = ' ';
        
        if(a >= 90) score = 'A';
        else if(a >= 80) score = 'B';
        else if(a >= 70) score = 'C';
        else if(a >= 60) score = 'D';
        else score = 'F';
        
        System.out.println(score);
    }
}