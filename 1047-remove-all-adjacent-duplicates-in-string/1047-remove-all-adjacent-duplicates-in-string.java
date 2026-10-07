// //import java.util.*;

// class Solution {
//     public String removeDuplicates(String s) {

//         Stack<Character> stack = new Stack<>();

//         for (char ch : s.toCharArray()) {

//             if (!stack.isEmpty() && stack.peek() == ch) {
//                 stack.pop();
//             } else {
//                 stack.push(ch);
//             }
//         }

//         StringBuilder result = new StringBuilder();

//         for (char ch : stack) {
//             result.append(ch);
//         }

//         return result.toString();
//     }
// }

class Solution {

        static {
        for(int i = 0; i < 500; i++) removeDuplicates("a");
    }
    public static String removeDuplicates(String s) {

        char[] result = new char[s.length()];
        char[] ip = s.toCharArray();

        String resultString = "";
        int k=0;

        for(int i=0; i< ip.length; i++){
            if(k == 0){
                result[k] = ip[i];
                k++;
            }else{
                if(result[k-1] == ip[i]){
                    k--;
                }else{
                    result[k] = ip[i];
                    k++;
                }
            }
        }

        return new String(result, 0, k);
        
    }
}