package leetcode;

public class LongestPalindromicSubstring {
//
//    public static void main(String[] args) {
//        String ex = "tbabade";

    /// /        String ex = "racecar";
//        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
//        String s = longestPalindromicSubstring.longestPalindrome(ex);
//    }
    public static void main(String[] args) {
        // Створюємо об'єкт класу, як у вашому прикладі
        LongestPalindromicSubstring solver = new LongestPalindromicSubstring();

        int passed = 0;
        int failed = 0;

        // Вхідні дані для тестування
        String[] inputs = {"tbabade", "racecar",                           // Ваші два приклади
                "babad", "cbbd", "forgeeksskeegfor", "abacaba", // Базові
                "a", "ac", "bb", "",                            // Граничні
                "aaaa", "ccccc", "abcdaaaaa",                   // Повторення
                "abcdeeffgh", "abcdegegfh",                     // Парні/Непарні
                "abacahohoh", "abcdefgfedcba", "abcbaeffe"       // Складні
        };

        // Очікувані результати
        String[] expected = {"babad", "racecar", "bab", "bb", "geeksskeeg", "abacaba", "a", "a", "bb", "", "aaaa", "ccccc", "aaaaa", "ee", "ege", "hohoh", "abcdefgfedcba", "abcba"};

        System.out.println("=== ЗАПУСК ТЕСТІВ ===\n");

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expectedOutput = expected[i];

            // Виклик методу через створений об'єкт
            String actualOutput = solver.longestPalindrome(input);

            // Обробка випадків, де LeetCode приймає кілька варіантів відповіді
            boolean isCorrect = actualOutput.equals(expectedOutput);
            if (input.equals("tbabade") && (actualOutput.equals("bab") || actualOutput.equals("aba"))) isCorrect = true;
            if (input.equals("babad") && actualOutput.equals("aba")) isCorrect = true;
            if (input.equals("ac") && actualOutput.equals("c")) isCorrect = true;

            if (isCorrect) {
                System.out.println("[ PASS ] Тест " + (i + 1) + ": Вхід: \"" + input + "\" -> Отримано: \"" + actualOutput + "\"");
                passed++;
            } else {
                System.out.println("[ FAIL ] Тест " + (i + 1) + ": Вхід: \"" + input + "\"");
                System.out.println("         Очікувалось: \"" + expectedOutput + "\"");
                System.out.println("         Отримано:    \"" + actualOutput + "\"");
                failed++;
            }
        }

        System.out.println("\n=== РЕЗУЛЬТАТИ ===");
        System.out.println("Успішно: " + passed + " / " + inputs.length);
        System.out.println("Провалено: " + failed);
    }


    public String longestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = s.toCharArray();
        if (s.length() < 2) {
            return s;
        }
        //todo Суть рішення, Якщо взяти паліндром babab у нас є центр(ПРАЦЮЄ ДЛЯ СЛІВ ТИПУ SOS ABA, Дописати механіку для forgeeksskeegfor ss
        for (int i = 1; i < charArray.length; i++) {
            StringBuilder palindromeByCenter = findPalindromeByCenter(i, new StringBuilder().append(charArray[i]), charArray, 1);
            if (stringBuilder.length() < palindromeByCenter.length()) {
                stringBuilder = palindromeByCenter;
            }
            if (charArray[i - 1] == charArray[i]) {
                StringBuilder forPairedCenter = findPalindromeByPairCenter(i, new StringBuilder().append(charArray[i - 1]).append(charArray[i]), charArray, 1);
                if (forPairedCenter != null && stringBuilder.length() < forPairedCenter.length()) {
                    stringBuilder = forPairedCenter;
                }
            }

        }

        return stringBuilder.toString();
    }

    private StringBuilder findPalindromeByPairCenter(int i, StringBuilder res, char[] charArray, int offset) {
        if (i - offset - 1 >= 0 && i + offset < charArray.length) {
            if (charArray[i - offset] == charArray[i + offset]) {
                res.insert(0, charArray[i - offset]);
                res.append(charArray[i + offset]);
                return findPalindromeByCenter(i, res, charArray, offset + 1);
            }
        }

        return null;
    }

    private StringBuilder findPalindromeByCenter(int i, StringBuilder res, char[] charArray, int offset) {
        if (i - offset >= 0 && i + offset < charArray.length) {
            if (charArray[i - offset] == charArray[i + offset]) {
                res.insert(0, charArray[i - offset]);
                res.append(charArray[i + offset]);
                return findPalindromeByCenter(i, res, charArray, offset + 1);
            }
        }
        return res;
    }


}
