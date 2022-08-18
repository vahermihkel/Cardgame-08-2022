package ee.mihkel.cardgame.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
public class DatabaseController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @GetMapping("games/{playerName}")
    public List<Game> getGamesByPlayer(@PathVariable String playerName) {
        Player player = playerRepository.findById(playerName).get();
        return player.getGames();
    }

    @GetMapping("player/{gameId}")
    public Player getPlayerByGame(@PathVariable Long gameId) {
        Game game = gameRepository.findById(gameId).get();
        Player player = playerRepository.findPlayerByGamesContains(game);
        return player;
    }

    @GetMapping("top-games")
    public List<Game> getTopGames() {
        List<Game> games = gameRepository.findAll();
//        games.sort((a,b) -> a.getCorrectAnswers() - b.getCorrectAnswers());
        games.sort(Comparator.comparingInt(Game::getCorrectAnswers).reversed());
//        int gamesCount = games.size() >= 10 ? 10 : games.size();
        int gamesCount = Math.min(games.size(), 10);
        return games.subList(0,gamesCount);
    }
}
