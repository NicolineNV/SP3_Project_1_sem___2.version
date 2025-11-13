import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class MediaSearch {

    private String username = "Hans"; // lav kobling til login brugeren istedet
    public String userMovieChoice;
    public ArrayList<String> watchSaved = new ArrayList<>();

    public MediaSearch(String userMovieChoice) {
        this.userMovieChoice = userMovieChoice;
    }

    public String UsersAcctionsWatchedSavedControl(String userMovieChoice) {
        System.out.println("Type something");  // ændre til tui kald
        Scanner scanner = new Scanner(System.in);
        userMovieChoice = scanner.nextLine();

        //Læser SavedDokument og laver et Array
        try (Scanner scan = new Scanner(new File("Data/docSav.csv"))) {
            while (scan.hasNextLine()) {
                watchSaved.add(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //You end here if your movie is already WATCHED.
        if (watchSaved.contains(username + ", " + userMovieChoice + " Watched")) {
            System.out.println("do you want to watch it again? \n yes: y \n want to go back to menu? :m");
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();
            switch (userInput.toUpperCase()) {
                case "Y":
                    System.out.println(" Du ser nu " + userMovieChoice);
                    break;
                case "M":
                    System.out.println(" kald metode til at vende tilbage til hovedmenu");
                    break;
                default:
                    System.out.println("not vailibul input");
            }
        }


        //You end here if your movie is already SAVED.
        if (watchSaved.contains(username + ", " + userMovieChoice + "Saved")) {
            System.out.println("Movie is already saved.\nWant to watch it now?: W\nRemove from saved: R\nWant to go back to menu?: B");
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine();

            switch (userInput.toUpperCase()) {
                case "W":
                    //This method sets the movie from saved to watched.
                    watchSaved.set(watchSaved.indexOf(username + ", " + userMovieChoice + "Saved"), username + ", " + userMovieChoice + "Watched");
                    System.out.println(" Du ser nu " + userMovieChoice);
                    break;

                case "R":
                    //This method removes the movie from the saved list.
                    watchSaved.remove(watchSaved.indexOf(username + ", " + userMovieChoice + "Saved"));
                    // kald tilbage tiæl
                    break;

                case "B":
                    //This method takes you back to ...
                    System.out.println(" kald metode til at vende tilbage til hovedmenu");

                    break;

                default:
                    System.out.println("not vailibul input");
            }
        }
        // you end here if the movie or serie is not on one of the list
        //if() nået her til


        try {
            BufferedWriter forfatter = new BufferedWriter(new FileWriter("Data/docSav.csv"));
            for (String fuckThis : watchSaved)
                forfatter.write(fuckThis);
            forfatter.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return " ";
    }
}