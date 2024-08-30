// using System;
// using System.Collections.Generic;
// using System.Linq;

// public class Solution {
//     public string solution(string myString, string pat) {
//         string answer = "";
//         List temp = new List();
//         int num = 0;

//         for (int i = 0; i < myString.Length; i ++)
//         {
//             if (myString[i] == pat[num])
//             {
//                 num++;
//                 if (num == pat.Length)
//                 {
//                     temp.Add(myString.Substring(0, i+1));
//                     num = 0; 
//                 }
//             }
//             else
//             {
//                 num = 0; 
//             }
//         }

//         temp.Sort();
//         return answer = temp[temp.Count -1];
//     }
// }



using System;

public class Solution {
    public string solution(string myString, string pat) {
        string answer = "";
        int patLength = pat.Length;

        for (int i = 0; i <= myString.Length; i++) {
            // Extract substring from i to end
            string substring = myString.Substring( 0, i);

            // Check if substring ends with pat
            if (substring.EndsWith(pat)) {
                // Update answer if this substring is longer than the current answer
                if (substring.Length > answer.Length) {
                    answer = substring;
                }
            }
        }

        return answer;
    }
}