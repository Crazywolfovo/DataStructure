package com.datastructure.Stack;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution {

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') return false;
                if (c == ']' && topChar != '[') return false;
                if (c == '}' && topChar != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertTrue(new Solution().isValid("()[]{}"));
        assertFalse((new Solution()).isValid("([)]"));
    }
}
