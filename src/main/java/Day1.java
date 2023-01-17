import java.util.Arrays;

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
        int[] values = Arrays.stream(input.split("\n")).mapToInt(Integer::parseInt).toArray();

        int prev = Integer.MAX_VALUE;
        int result = 0;
        for (int current : values) {
            if (current > prev) {
                result++;
            }

            prev = current;
        }

        return String.valueOf(result);
    }

    @Override
    public String part2(String input) {
        int[] values = Arrays.stream(input.split("\n")).mapToInt(Integer::parseInt).toArray();

        int prev;
        int current = 0;
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            prev = current;
            current += values[i];

            if (i < 3) {
                continue;
            }

            current -= values[i - 3];

            if (current > prev) {
                result++;
            }
        }

        return String.valueOf(result);
    }
}
