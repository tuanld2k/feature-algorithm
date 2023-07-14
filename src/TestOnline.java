import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestOnline {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input:");
        String input = scanner.nextLine();
        scanner.close();

        List<String> vnword = findvnword(input);
        int count = vnword.size();

        System.out.print("Output:" + count +"(");
        for (String character : vnword) {
            if(character!=vnword.get(count-1)) {
                System.out.print(character+",");
            } else {
                System.out.print(character);
            }
        }
        System.out.print(")");
    }

    public static List<String> findvnword(String input) {
        List<String> vnword = new ArrayList<>();

        int length = input.length();
        int i = 0;
        while (i < length) {
            char currentChar = input.charAt(i);

            if (currentChar == 'a') {
                if (i < length - 1) {
                    char nextChar = input.charAt(i + 1);
                    if (nextChar == 'w') {
                        vnword.add("aw");
                        i++;
                    } else if (nextChar == 'a') {
                        vnword.add("aa");
                        i++;
                    }
                }
            } else if (currentChar == 'd') {
                if (i < length - 1 && input.charAt(i + 1) == 'd') {
                    vnword.add("dd");
                    i++;
                }
            } else if (currentChar == 'e') {
                if (i < length - 1 && input.charAt(i + 1) == 'e') {
                    vnword.add("ee");
                    i++;
                }
            } else if (currentChar == 'o') {
                if (i < length - 1) {
                    char nextChar = input.charAt(i + 1);
                    if (nextChar == 'o') {
                        vnword.add("oo");
                        i++;
                    } else if (nextChar == 'w') {
                        vnword.add("ow");
                        i++;
                    }
                }
            } else if (currentChar == 'u') {
                if (i < length - 1 && input.charAt(i + 1) == 'w') {
                    vnword.add("uw");
                    i++;
                }
            } else if (currentChar == 'w') {
                vnword.add(String.valueOf(currentChar));
            }

            i++;
        }

        return vnword;
    }
}
