import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class day01 {
    public static class Elf implements Comparable<Elf> {
        int number;
        int calorieCount;

        public Elf(int number, int calorieCount) {
            this.number = number;
            this.calorieCount = calorieCount;
        }


        @Override
        public int compareTo(Elf o) {
            return Integer.compare(this.calorieCount, o.calorieCount);
        }

    }

    public static void main(String[] args) {

        ArrayList<String> input = FileReader.readFile(".\\input\\day01input.txt");


        PriorityQueue<Elf> pq = new PriorityQueue<>(Collections.reverseOrder());

        int elfCounter = 1;                                     //Unfortunately elves start at 1.
        int elfCalories = 0;
        for (String line : input) {
            if(line.equals("")) {
                pq.add(new Elf(elfCounter, elfCalories));
                elfCounter++;
                elfCalories = 0;
            } else {
                elfCalories += Integer.parseInt(line);
            }
        }
        System.out.println(pq.remove().calorieCount);
    }

}
