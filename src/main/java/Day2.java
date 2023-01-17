public class Day2 extends Day {

    public static void main(String[] args) {
        Day2 day = new Day2();  // https://adventofcode.com/2021/day/2

        String sample = readFile("%s_sample.txt".formatted(day.name()));
        String full = readFile("%s.txt".formatted(day.name()));

        assertEquals(150, day.part1(sample));
        assertEquals(1868935, day.part1(full));

        assertEquals(900, day.part2(sample));
        assertEquals(1965970888, day.part2(full));

        day.run(full, day::part1, "Part 1 result");
        day.run(full, day::part2, "Part 2 result");
    }


    @Override
    public String part1(String input) {

        int propulsion = 0;
        int depth = 0;
        for (String line : input.split("\n")) {
            String[] command = line.split(" ");
            String direction = command[0];
            int distance = Integer.parseInt(command[1]);

            switch (direction) {
                case "forward" -> propulsion += distance;
                case "down" -> depth += distance;
                case "up" -> depth -= distance;
            }
        }

        return String.valueOf(propulsion * depth);
    }

    @Override
    public String part2(String input) {

        int propulsion = 0;
        int depth = 0;
        int aim = 0;
        for (String line : input.split("\n")) {
            String[] command = line.split(" ");
            String direction = command[0];
            int distance = Integer.parseInt(command[1]);

            switch (direction) {
                case "forward" -> {
                    propulsion += distance;
                    depth += aim * distance;
                }
                case "down" -> aim += distance;
                case "up" -> aim -= distance;
            }
        }

        return String.valueOf(propulsion * depth);
    }
}
