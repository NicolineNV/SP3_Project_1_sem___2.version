import util.TextUI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Serie {

    TextUI tui = new TextUI();
    public static String line;


    static ArrayList<String> seriesArray = new ArrayList<>();

    public String getseries() {

        try (Scanner scan = new Scanner(new File("Data/SeriesData.csv"))) {
            //int nummer = 0;

            while (scan.hasNextLine()) {
                seriesArray.add(scan.nextLine()); // tilføjer til array
                //System.out.println(scan.nextLine());
            }

            for (String serieLine : seriesArray) {
                int i = seriesArray.indexOf(serieLine);
                System.out.println(i +" "+ serieLine);
                //nummer++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        int userSerieChoice = Integer.parseInt(tui.promptText("\nWhich serie would you like to watch? Please enter the number of the movie"));
        line = seriesArray.get(userSerieChoice);
        return "";
    }
}

