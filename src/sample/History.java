package sample;

class History {
    private static int count = 0;
    private static StringBuilder batch = new StringBuilder();

    static void remember(String line) {
        batch.append(line);
        count++;
        if (count == 5) {
            Human.write(batch.toString());
            batch = new StringBuilder();
            count = 0;
        }
    }

}
