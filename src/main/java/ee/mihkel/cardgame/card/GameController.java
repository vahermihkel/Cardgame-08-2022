package ee.mihkel.cardgame.card;

import ee.mihkel.cardgame.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    GameService gameService;
//     GameService gameService = new GameService();

    @Autowired
    DatabaseService databaseService;

    @GetMapping("start-game/{playerName}")   // localhost:8080/start-game/Mihkel
    public Card startGame(@PathVariable String playerName) {
        databaseService.addToDabase(playerName);
        return gameService.getNewCard();
    }

    @PostMapping("guess/{choice}")   // localhost:8080/guess
    public String guess(@PathVariable String choice) {
        return gameService.userGuess(choice);
    }

    @GetMapping("new-round")   // localhost:8080/new-round
    public Card newRound() {
        return gameService.startNewRound();
    }
}
