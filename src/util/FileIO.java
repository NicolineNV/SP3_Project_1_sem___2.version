package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    // new version of fileIO:

    //instansvariabler:
    private String userSearch;
    private String path;
    private Scanner scan = new Scanner(System.in);


    public FileIO () {
        this.userSearch = userSearch;
        this.path = ("Data/movieData.csv" + "Data/seriesData.csv");
    }

        public String readUserInput() {
            String userInput = scan.nextLine();
            return userInput;
        }

        public ArrayList<String> readData (String userSearch) {
            ArrayList<String> dataFile = new ArrayList<>();
            File file = new File(path);
            {
                try {
                    Scanner scan = new Scanner(file);
                    scan.nextLine(); // skips header "title; year; categories; rating;"

                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        dataFile.add(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(TextUI.IOExceptionMessage("We are experiencing some technical difficulties - sorry for the inconvenience"));
                }
                return dataFile;
            }
        }
    }


