package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class Parser {

    static String[] getResults(String html){
        Document document = Jsoup.parse(html);
        Elements results = document.getElementsByAttributeValue("id","results");
        String[] colors = new String[8];
        results.forEach(element -> {
            for (int i = 0; i < 8; i++) {
                String colour = element.child(i).getElementsByAttribute("src").toString();
                if (colour.contains("red")){
                    colors[i] = "Red";
                }
                if(colour.contains("green")){
                    colors[i] = "Green";
                }
                if(colour.contains("orange")){
                    colors[i] = "Orange";
                }
            }
        });
        return colors;
    }

    public static int getBonuses(String html){
        Document document = Jsoup.parse(html);
        Elements element = document.getElementsByAttributeValue("class","user_bonuses");
        return Integer.valueOf(element.text().replaceAll(" ",""));
    }

    static String getRaund(String html){
        Document document = Jsoup.parse(html);
        Elements element = document.getElementsByAttributeValue("id","double_game_num");
        return element.text();
    }

    public static int getTimer(String html){
        Document document = Jsoup.parse(html);
        Elements element = document.getElementsByAttributeValue("id","countdown");
        return Integer.valueOf(element.text());
    }

}
