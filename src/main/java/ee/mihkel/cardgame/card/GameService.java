package ee.mihkel.cardgame.card;

import ee.mihkel.cardgame.database.DatabaseService;
import ee.mihkel.cardgame.database.Game;
import ee.mihkel.cardgame.database.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Controller - võtab päringuid vastu
//@RestController
//@Component - ei ole eriomadusi
//@Repository
@Service // ei ole eriomadusi
public class GameService {

    private Card card;
    private long roundStartTime;
    private int correctAnswers = 0;
    private int lives = 3;

    public Card getNewCard() {
        lives = 3;
        correctAnswers = 0;
        card = new Card();
        roundStartTime = System.currentTimeMillis();
        return card;
    }

    public String userGuess(String choice) {
        Card newCard = new Card();
        if (System.currentTimeMillis()-10000 > roundStartTime) {
            card = newCard;
            lives--;
            if (lives <= 0) {
                databaseService.saveFinishedGameToDb(correctAnswers);
                return "MÄNG LÄBI! KOLMAS ELU LÄINUD, KUNA OOTASID LIIGA KAUA!";
            }
            return "TIMEOUT";
        }
        String response;
        if (card.getValue() < newCard.getValue() && choice.equals("higher")) {
            correctAnswers++;
            response = "ÕIGESTI (debug: " + newCard.getValue() + ")";
        } else if (card.getValue() == newCard.getValue() && choice.equals("equal")) {
            correctAnswers++;
            response = "ÕIGESTI (debug: " + newCard.getValue() + ")";
        } else if (card.getValue() > newCard.getValue() && choice.equals("lower")) {
            correctAnswers++;
            response = "ÕIGESTI (debug: " + newCard.getValue() + ")";
        } else {
            lives--;
            response = "VALESTI (debug: " + newCard.getValue() + ")";
        }
        card = newCard;
        if (lives <= 0) {
            databaseService.saveFinishedGameToDb(correctAnswers);
            return "MÄNG LÄBI! VASTASID KOLMANDAT KORDA VALESTI!";
        }
        return response;
    }

    @Autowired
    DatabaseService databaseService;

    public Card startNewRound() {
        roundStartTime = System.currentTimeMillis();
        return card;
    }
}
