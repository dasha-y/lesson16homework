import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите массив строк: ");
        String[] str = new String[a];
        for (int i = 0; i < a; i++) {
            str[i] = scanner.nextLine() + " ";
        }

        Map<String, Boolean> stringBooleanMap = stringMap(str);
        System.out.println(stringBooleanMap);

        System.out.println();

        System.out.println("Задание 2: ");
        System.out.println("Введите размер массива: ");
        int a2 = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите массив строк: ");
        String[] strings = new String[a2];
        for (int i = 0; i < a2; i++) {
            strings[i] = scanner.nextLine() + " ";
        }
        Map<String, String> stringStringMap = num2(strings);
        System.out.println(stringStringMap);

        System.out.println();

        System.out.println("Задание *: ");
        String string="({[)}]";
        boolean result = balanced(string);
        System.out.println(result);


    }
    public static Map<String, Boolean> stringMap(String str[]){
        Map<String, Boolean> mapStr = new HashMap<>();
        for (String s:str){
            if(mapStr.containsKey(s)){
                mapStr.put(s, true);
            } else {
                mapStr.put(s, false);
            }
        }
        return mapStr;
    }

    public static Map<String, String> num2(String strings[]){
        Map<String, String> strStrMap = new HashMap<>();
        for (String s: strings){
                strStrMap.put(s.substring(0, 1), s.substring(s.length()-2));
        }
        return strStrMap;
    }
    public static boolean balanced(String string){
        char[] stack = new char[string.length()];
        int top = -1;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else if (c == ')' && top >= 0 && stack[top] == '(') {
                top--;
            } else if (c == ']' && top >= 0 && stack[top] == '[') {
                top--;
            } else if (c == '}' && top >= 0 && stack[top] == '{') {
                top--;
            } else {
                return false;
            }
        }
        return top == -1;
    }
}