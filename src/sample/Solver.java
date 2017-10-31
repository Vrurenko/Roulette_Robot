package sample;

class Solver {

    public static int getSeriesLength(String[] results){
        int length = 1;
        for (int i = 1; i < results.length; i++) {
            if (results[0].equals(results[i]) || results[i].equals("Orange")){
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}
