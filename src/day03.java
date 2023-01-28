import java.util.ArrayList;

public class day03 {

public static void main(String[] args) {

    System.out.println(task1());
    System.out.println(task2());

}


    public static int task1() {

        ArrayList<String> input = FileReader.readFile(".\\input\\day03input.txt");

        int priorityCounter = 0;

        for (String line : input) {
            String[] separatedString = separateString(line);
            char duplicateChar = findDuplicate(separatedString[0], separatedString[1]);
            priorityCounter += valueOf(duplicateChar);

        }

        return priorityCounter;

    }

    public static int task2() {

        ArrayList<String> input = FileReader.readFile(".\\input\\day03input.txt");

        int priorityCounter = 0;
        ArrayList<String> trio = new ArrayList<>(3);

        for(String line : input) {
            trio.add(line);
            if(trio.size() == 3) {

                char triplicateChar = findTriplicate(trio.get(0), trio.get(1), trio.get(2));
                priorityCounter += valueOf(triplicateChar);
                trio.clear();

            }
        }

        return priorityCounter;

    }


    public static String[] separateString(String s) {

    int midPoint = (s.length()/2);

    String[] result = {s.substring(0, midPoint), s.substring(midPoint)};

    return result;

    }

    public static int valueOf(char c) {

        if(c < 91) {
            return c - 38;
        } else {
            return c - 96;
        }

    }

    public static char findDuplicate(String s1, String s2) {

        for(int i = 0 ; i < s1.length() ; i++) {
            if (s2.indexOf(s1.charAt(i)) != -1) {
                return s1.charAt(i);
            }
        }

        return ' ';

    }

    public static char findTriplicate(String s1, String s2, String s3) {

        for(int i = 0 ; i < s1.length() ; i++) {
            char checkChar = s1.charAt(i);
            if ((s2.indexOf(checkChar) != -1) && (s3.indexOf(checkChar) != -1)) {
                return checkChar;
            }
        }

        return ' ';

    }

}
