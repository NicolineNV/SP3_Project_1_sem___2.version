import util.FileIO;
import util.TextUI;

import java.util.*;
import java.util.ArrayList;
import java.io.*;

public class UserAccount {
    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    private String userName;
    private String passWord;
    private ArrayList <String> userNamesDoc = new ArrayList<>();
    private ArrayList<String> passWordDoc = new ArrayList<>();

    /*private UserAccount(String userName, String passWord){
        this.userName = userName;
        this.passWord= passWord;
    }
     */

    //Updaterer informationerne fra userNamesDoc og laver en ny ArrayList
    private String userNamesDoc() {
        try (Scanner scan = new Scanner(new File("Data/Accountinfo.csv"))){
            while (scan.hasNextLine()) {
                userNamesDoc.add(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    //Updaterer informationerne fra passWordDoc og laver en ny ArrayList
    private String passWordDoc() {
        try (Scanner scan = new Scanner(new File("Data/Accountinfo.csv"))){
            while (scan.hasNextLine()) {
                passWordDoc.add(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String userName() {  // for a new login
        String userNameInput = ui.promptText("Please enter your userName");
        return userNameInput;
    }

    private String password() { // for a new password
        String userPassword = ui.promptText("please enter your password");
        return userPassword;
    }

    public void welcome() {
        ui.displayMessage("Welcome to this Streaming service!"); // messenge to the user
        // a question to the user and a scanner there read the users answer. the answer been saved to the String resolved


        String resolved = ui.promptText("Do you want to: A: Login to an existing account\s B: Create a new account");

        switch (resolved.toUpperCase()) {

            case "A":
                // calling the login method
                ui.displayMessage("Type your username");
                login();
                break;

            case "B":
                createAccount();
                break;

            default:
                System.out.println("Nothing found");
        }

    }

//  *********************************** SE på mig senerer !!!!! ******************************

/*
        void createAccounts (String [] accounts) {
            for (int i = 0; i <= accounts.length; i++) {
                String[] position = accounts[i].split(";");
                String userName = position[0].trim();
                String passWord = position[1].trim();

                UserAccount a = new UserAccount (userName, passWord);
                accounts[i] = a;
            }
            Collections.shuffle(Arrays.asList(accounts));
        }


        private ArrayList <String> klunk (ArrayList <String> accounts){
        for(int i = 0; i <= 20; i++ );
            ArrayList <String> klunk2 = accounts.get(0).split(",");
        }
*/

        private String createAccount() {
        String newUserName = userName();
        // indsæt metode der kontrollere brugernavn (unikt) hvis taget giv bruger besked om at tast på nyt
        String newPassword = password();
        userNamesDoc.add(newUserName);
        passWordDoc.add(newPassword);
        return newPassword + newUserName;
    }

    String a;
    private String login() {
        String userNameInput = io.readUserInput();
        for(String name : userNamesDoc ) {
            a = name;
        }
            if (!userNameInput.equals(a)) {
                password();
            } else {
                ui.displayMessage("Username not found");
                threeOptions();
            }
        return userNameInput;
    }

    private String threeOptions() {
        String input = ui.promptText("would you like to Try again? a: \\n create account? b: \\n go back to start menu? c:\"");
        switch (input.toUpperCase()) {

            case "A":
                //try again?
                login();
                break;

            case "B":
                //create account
                createAccount();
                break;

            case "C":
                //Go back to start menu
                welcome();
                break;

            default:
                System.out.println("Nothing found");
        }
        return "";
    }
}
