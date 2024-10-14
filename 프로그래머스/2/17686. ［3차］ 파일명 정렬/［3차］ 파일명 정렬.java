import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        String[][] parseFile = new String[files.length][3];
        for(int i=0;i<files.length;i++){
            String[] result = parse(files[i]);
            parseFile[i][0] = result[0];
            parseFile[i][1] = result[1];
            parseFile[i][2] = result[2];
        }

        Arrays.sort(files, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String head1 = parse(s1.toLowerCase())[0];
                String head2 = parse(s2.toLowerCase())[0];
                if (head1.equals(head2)) {
                    int num1 = Integer.parseInt(parse(s1)[1]);
                    int num2 = Integer.parseInt(parse(s2)[1]);
                    return num1 - num2;
                } else return head1.compareTo(head2);
            }
        });
            
        // for(int i=0;i<parseFile.length-1;i++){
        //     for(int j=i+1;j<parseFile.length;j++){
        //         String head1 = parseFile[i][0].toLowerCase();
        //         String head2 = parseFile[j][0].toLowerCase();
        //         if (head1.equals(head2)) {
        //             int num1 = Integer.parseInt(parseFile[i][1]);
        //             int num2 = Integer.parseInt(parseFile[j][1]);
        //             if (num1 > num2) {
        //                 swap(parseFile, i, j);
        //             }
        //         } else if (head1.compareTo(head2) > 0) {
        //             swap(parseFile, i, j);
        //         }
        //     }
        // }
        // answer = new String[files.length];
        // for (int i = 0; i < parseFile.length; i++) {
        //     answer[i] = parseFile[i][0] + parseFile[i][1] + parseFile[i][2];
        // }

        // return answer;
            return files;
    }


    public String[] parse(String file){
        String head = "";
        String number = "";
        String tail = "";
        int i = 0;

        while (i < file.length() && !('0' <= file.charAt(i) && file.charAt(i) <= '9')) {
            head += file.charAt(i);
            i++;
        }

        while (i < file.length() && ('0' <= file.charAt(i) && file.charAt(i) <= '9') && number.length() < 5) {
            number += file.charAt(i);
            i++;
        }

        if (i < file.length()) {
            tail = file.substring(i);
        }

        return new String[]{head, number, tail};
    }
    public void swap(String[][] arr , int i , int j){
        String[] temp = new String[3];
        for(int k = 0; k < 3; k++) temp[k] = arr[i][k];
        for(int k = 0; k < 3; k++) arr[i][k] = arr[j][k];
        for(int k = 0; k < 3; k++) arr[j][k] = temp[k];
    }
}