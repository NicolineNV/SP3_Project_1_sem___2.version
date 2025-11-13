import util.TextUI;

public class Menu {

    TextUI tui = new TextUI();
    Movie movie = new Movie();
    MediaSearch search = new MediaSearch(" ");


    public void mainMenu() {
        String selected = tui.promptText("""
                Welcome to the Menu, what do you want to do?:\
                
                 M: Watch movie? \
                
                 S: Watch series?\
                
                 C: Choose category? \
                
                 W: See your watched list? \
                
                 A: See your saved for later list?""");

        switch (selected.toUpperCase()) {

            case "M": // Movies
                movie.getmovie();
                System.out.println(Movie.line);

                search.UsersActionsWatchedSavedControl(Movie.line);
                break;

            case "S": // Series

                break;

            case "C": // Categories
                break;

            case "W": // Watched list
                break;

            case "A": // Saved List
                break;

            default:
                tui.displayMessage(" Illigal input ");
                break;
        }

    }
}
