package ee.mihkel.cardgame.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    private Long gameId;

    public void addToDabase(String playerName) {
        // Optional<null> VÕI Optional<{name: "Mihkel"}>
        Optional<Player> player = playerRepository.findById(playerName);
        Player playerFound = player.orElseGet(() -> playerRepository.save(new Player(playerName, new ArrayList<>())));
        // playerFound üks mäng juurde
        List<Game> playerGames = playerFound.getGames();
        Game game = new Game();
        game.setStartTime(new Date());
        // mäng andmebaasi
        Game playerGame = gameRepository.save(game);
        gameId = playerGame.getId();    // korrektne ID on alles pärast .save() -mist
        playerGames.add(playerGame);
        playerFound.setGames(playerGames);
        playerRepository.save(playerFound);
    }

    public void saveFinishedGameToDb(int correctAnswers) {
            Game game = gameRepository.findById(gameId).get();
            game.setCorrectAnswers(correctAnswers);
            game.setDuration(System.currentTimeMillis() - game.getStartTime().getTime());
            gameRepository.save(game);
    }
}
