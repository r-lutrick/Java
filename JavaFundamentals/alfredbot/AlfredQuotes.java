import java.util.Date;

import javax.lang.model.util.ElementScanner14;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello, " + name + ". Lovely to see you";
    }

    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date;
    }

    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        String alexis = "Right away, sir. She certainly isn't sophisticated enough for that.";
        String alfred = "At your service. As you wish, naturally.";
        String neither = "Right. And with that I shall retire.";
        String output = "";
        if (conversation.contains("Alexis")) {
            output = alexis;
        } else if (conversation.contains("Alfred")) {
            output = alfred;
        } else {
            output = neither;
        }
        return output;
    }

    // NINJA BONUS
    // See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have
    // learned!
}