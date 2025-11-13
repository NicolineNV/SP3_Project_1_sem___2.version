import util.TextUI;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class MediaSearch {

    private String username = "Hans"; // lav kobling til login brugeren i stedet
    public String userMovieChoice;
    public ArrayList<String> watchSaved = new ArrayList<>();
    LoopMainMenuSolution runMenu = new LoopMainMenuSolution();
    TextUI tui = new TextUI();

    public MediaSearch(String userMovieChoice) {
        this.userMovieChoice = userMovieChoice;
    }

    public String UsersActionsWatchedSavedControl(String userMovieChoice) {
              //Reads SavedDokument and makes an Array
        try (Scanner scan = new Scanner(new File("Data/docSav.csv"))) {
            while (scan.hasNextLine()) {
                watchSaved.add(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //You end here if your movie is already WATCHED.
        if (watchSaved.contains(username + ", " + userMovieChoice + ", Watched")) {
            String userInput = tui.promptText("do you want to watch it again? \n yes: y \n want to go back to menu? :m" + "\n");

            switch (userInput.toUpperCase()) {
                case "Y":
                    tui.displayMessage(" You are now watching " + userMovieChoice + "\n");
                    runMenu.solution();
                    break;

                case "M":
                    runMenu.solution();

                    break;

                default:
                    tui.displayMessage("not vailibul input");
            }
        }


        //You end here if your movie is already SAVED.
        if (watchSaved.contains(username + ", " + userMovieChoice + ", Saved")) {
            String userInput = tui.promptText("Movie is already saved.\nWant to watch it now?: W\nRemove from saved: R\nWant to go back to menu?: B");

            switch (userInput.toUpperCase()) {
                case "W":
                    //This method sets the movie from saved to watched.
                    watchSaved.set(watchSaved.indexOf(username + ", " + userMovieChoice  + ", Saved"), username + ", " + userMovieChoice + ", Watched");
                    tui.displayMessage(" you watch now: " + userMovieChoice + "\n");
                    break;

                case "R":
                    //This method removes the movie from the saved list.
                    watchSaved.remove(watchSaved.indexOf(username + ", " + userMovieChoice  + ", Saved"));
                    runMenu.solution();
                    break;

                case "B":
                    //This method takes you back to menu...
                    runMenu.solution();

                    break;

                default:
                    tui.displayMessage("not vailibul input");
            }
        }
        // you end here if the movie or serie is not on one of the list
        if(!watchSaved.contains(username + ", " + userMovieChoice + "Watched") && !watchSaved.contains(username + ", " + userMovieChoice + ", Saved")){
            String userInput = tui.promptText("W: Watch? \n S: Save \n B Go back to menu"+ "\n");

            switch (userInput.toUpperCase()) {
                case "W":
                    //This method add the title the user want to watch to the array and say it is watched.
                    watchSaved.add(username + ", " + userMovieChoice + ", Watched");
                    tui.displayMessage(" You Watch now: " + userMovieChoice + "\n");
                    runMenu.solution();// user will be sent back to the menu
                    break;

                case "S":
                    // This method add the title to the arraylist and tell it is Saved
                    watchSaved.add(username + ", " + userMovieChoice + ", Saved");
                    tui.displayMessage("The Media is now add to you save list " + userMovieChoice + "\n");
                    runMenu.solution(); // user will be sent back to the menu
                    break;

                case "B":
                    //This method takes you back to menu.
                    runMenu.solution();

                    break;

                default:
                    tui.displayMessage("not vailibul input");
            }
        }


        try {
            BufferedWriter movieSavedAndWatched = new BufferedWriter(new FileWriter("Data/docSav.csv"));
            for (String runLine : watchSaved)
                movieSavedAndWatched.write(runLine+"\n");
            movieSavedAndWatched.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return " ";
    }
}