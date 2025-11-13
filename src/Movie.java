import util.TextUI;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Movie {
    TextUI tui = new TextUI();
    public static String line;


    static ArrayList<String> movieArray = new ArrayList<>();

    public String getmovie() {

        try (Scanner scan = new Scanner(new File("Data/MovieData.csv"))) {
            //int nummer = 0;

            while (scan.hasNextLine()) {
                movieArray.add(scan.nextLine()); // tilføjer til array
                //System.out.println(scan.nextLine());
            }

                for (String movieLine : movieArray) {
                    int i = movieArray.indexOf(movieLine);
                    System.out.println(i +" "+ movieLine);
                    //nummer++;
                }


        } catch (IOException e) {
            e.printStackTrace();
        }
        int userMovieChoice = Integer.parseInt(tui.promptText("\nWhich movie would you like to watch? Please enter the number of the movie"));
        line = movieArray.get(userMovieChoice);
        return "";
    }
}


/*
        try (Scanner scan1 = new Scanner(new File("Data/MovieData.csv"))) {
            while (scan1.hasNextLine()) {
                movieArray.add(scan1.nextLine());
            }
                if (movieArray.contains(userMovieChoice)) {

                for(int i = 0;  ;i++){
                list.contains(userMovieChoice);
                }


                    line = movieArray.get(movieArray.indexOf(userMovieChoice));
                    // ask the user are your choise :
                    String answer = tui.promptText("You have chosen " + line + " would you like to continue y/n: "); // call yes/ no boolean method.
                    if (answer.equals("y")) {
                        return line; // add the full line off the title to the arraylist.
                    }
                    if (answer.equals("n")) {
                        getmovie();
                    }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

 */





