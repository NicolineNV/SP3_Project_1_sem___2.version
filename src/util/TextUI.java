package util;

public class TextUI {

        FileIO fileIO = new FileIO();

        //public TextUI (String ){
        //   this.fileIO = fileIO;
        //}

        public String displayMessage(String msg) {
            System.out.println(msg);
            return "";
        }

        public String promptText(String output) {
            displayMessage(output);
            String answer = fileIO.readUserInput(); // hardkode så denne!!
            return answer;
        }


        // Added a while loop - because there were a chance for stackoverflow = recursive call without restriction
        public boolean promptQuestion() { // user question yes or no metode
       /* while () {
            String answer = fileIO.readUserInput(); // hardkode denne!!
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Illegal input. Try again");
            }
        }*/
            return true;
        }

        public static String IOExceptionMessage(String exception){
            System.out.println();
            return exception;
        }


}
