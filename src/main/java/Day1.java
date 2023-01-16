import java.util.Deque;
import java.util.LinkedList;

public class Day1 extends Day {

    public static void main(String[] args) {
        Day1 day = new Day1();  // https://adventofcode.com/2021/day/1

        String sample = readFile("%s_sample.txt".formatted(day.name()));
        String full = readFile("%s.txt".formatted(day.name()));

        assertEquals(7, day.part1(sample));
        assertEquals(1184, day.part1(full));

        assertEquals(5, day.part2(sample));
        assertEquals(1158, day.part2(full));

        day.run(full, day::part1, "Part 1 result");
        day.run(full, day::part2, "Part 2 result");
    }


    @Override
    public String part1(String input) {

        Integer prev = null;
        int timesIncreased = 0;

        for (String line : input.split("\n")) {
            int current = Integer.parseInt(line);

            if (prev != null && current > prev) {
                timesIncreased++;
            }

            prev = current;
        }

        return String.valueOf(timesIncreased);
    }

    @Override
    public String part2(String input) {
        Deque<Integer> queue = new LinkedList<>();
        int prev;
        int current = 0;
        int windowSize = 0;
        int timesIncreased = 0;
        for (String line : input.split("\n")) {
            int next = Integer.parseInt(line);

            prev = current;
            current += next;
            queue.push(next);

            if (windowSize < 3) {
                windowSize++;
                continue;
            }

            current -= queue.removeLast();

            if (current > prev) {
                timesIncreased++;
            }
        }

        return String.valueOf(timesIncreased);
    }
}
