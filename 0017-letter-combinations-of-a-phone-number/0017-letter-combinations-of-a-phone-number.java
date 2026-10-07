import java.util.*;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] keypad = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, "", keypad, result);

        return result;
    }

    private void backtrack(int index, String digits,
                           String current, String[] keypad,
                           List<String> result) {

        // Combination completed
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = keypad[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            backtrack(index + 1, digits,
                      current + ch, keypad, result);
        }
    }
}