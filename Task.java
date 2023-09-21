import java.util.*;

public class Task {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(prefix(strs));
    }
     // На случай, если будет пустой массив
    public static String prefix(String[] strs) {
        if (strs.length == 0) {
            return "Empty list";
        }
        
     // Если все первые символы уникальны и их столько же, сколько слов в массиве, то возвращаем ""
        Set<Character> firstLetters = new HashSet<>();
        for (String str : strs) {
            firstLetters.add(str.charAt(0));
        }
        if (firstLetters.size() == strs.length) {
            System.out.println("\"\"");
        }
     // Находим самое короткое слово и перебираем его символы, сравнивая с символами других слов на тех же позициях
     // При обнаружении несоответствия, возвращается префикс до этой точки
        String shortestWord = findShortestWord(strs);
        for (int i = 0; i < shortestWord.length(); i++) {
            char character = shortestWord.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != character) {
                    return shortestWord.substring(0, i);
                }
            }
        }

        return shortestWord;
    }
    // Посредством метода findShortestWord находим и возвращаем самое короткое слово в массиве, сравнивая длины каждой строки
    public static String findShortestWord(String[] strs) {
        String shortestWord = strs[0];
        for (String str : strs) {
            if (str.length() < shortestWord.length()) {
                shortestWord = str;
            }
        }
        return shortestWord;
    }
}