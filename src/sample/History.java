package sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

class History {
    private static final String file = "C:\\Users\\Comandante\\Desktop\\Roulette Robot\\resources\\series.txt";

    private static int count = 0;
    private static StringBuilder batch = new StringBuilder();
    private static Map<Integer, Integer> seriesMap = new HashMap<>();

    static void remember(String line) {
        batch.append(line);
        count++;
        if (count == 5) {
            Human.write(batch.toString());
            batch.setLength(0);
            count = 0;
        }
    }

    static void addSeries(Integer seriesLength) {
        int count = seriesMap.containsKey(seriesLength) ? seriesMap.get(seriesLength) : 0;
        seriesMap.put(seriesLength, count + 1);
    }

    static void saveSeries() {
        StringBuilder text = new StringBuilder("--------------------------------------\n");

        seriesMap.forEach( (key, value) -> text.append(key)
                                               .append(" : ")
                                               .append(value)
                                               .append("\n"));

        try (PrintStream printStream = new PrintStream(new FileOutputStream(file, true), true)) {
            printStream.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
