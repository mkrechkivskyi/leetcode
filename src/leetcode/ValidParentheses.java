package leetcode;


import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();

        // Тест 1: Базовий випадок
        boolean res1 = validParentheses.isValid("()");
        System.out.println("Expected result " + true + " Actual result " + res1);

        // Тест 2: Послідовні пари різних типів
        boolean res2 = validParentheses.isValid("()[]{}");
        System.out.println("Expected result " + true + " Actual result " + res2);

        // Тест 3: Правильне вкладення (дзеркальний кейс)
        boolean res3 = validParentheses.isValid("([])");
        System.out.println("Expected result " + true + " Actual result " + res3);

        // Тест 4: Складне правильне вкладення
        boolean res4 = validParentheses.isValid("{[()]}");
        System.out.println("Expected result " + true + " Actual result " + res4);

        // Тест 5: Невідповідність типів при закритті
        boolean res5 = validParentheses.isValid("(]");
        System.out.println("Expected result " + false + " Actual result " + res5);

        // Тест 6: Неправильний порядок перетину дужок
        boolean res6 = validParentheses.isValid("([)]");
        System.out.println("Expected result " + false + " Actual result " + res6);

        // Тест 7: Тільки відкриваючий символ
        boolean res7 = validParentheses.isValid("[");
        System.out.println("Expected result " + false + " Actual result " + res7);

        // Тест 8: Тільки закриваючий символ (захист від EmptyStackException)
        boolean res8 = validParentheses.isValid("]");
        System.out.println("Expected result " + false + " Actual result " + res8);

        // Тест 9: Непарна довжина рядка
        boolean res9 = validParentheses.isValid("()[]}");
        System.out.println("Expected result " + false + " Actual result " + res9);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
