package ee.mihkel.cardgame.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {
    Player findPlayerByGamesContains(Game game);
}
