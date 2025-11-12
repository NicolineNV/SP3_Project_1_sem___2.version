import util.FileIO;
import util.TextUI;

public class UserAccount {
    TextUI ui = new TextUI();
    FileIO io = new FileIO();

    String username = "Hans";
    String passWord = "ABC";

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


        String resolved = ui.promptText("""
                Do you want to: A: Login to an existing account\s
                B: Create a new account""");

        switch (resolved.toUpperCase()) {

            case "A":
                // calling the login method
                login();
                break;

            case "B":
                createAccount();
                break;

            default:
                System.out.println("Nothing found");
        }

    }

    private String createAccount() {
        String newUserName = userName();
        String newPassword = password();
        String newAccountInfo = newUserName + newPassword;
        return newAccountInfo;
    }

    private String login() {
        String input = io.readUserInput();
        if (input.equals(username)) {
            password();
        } else {
            ui.displayMessage("Username not found");
            threeOptions();
        }
        return "";
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
