package ee.mihkel.cardgame;

import ee.mihkel.cardgame.card.Card;
import ee.mihkel.cardgame.card.GameService;
import ee.mihkel.cardgame.card.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    GameService gameService = new GameService();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getNewCard() {
        Card card = gameService.getNewCard();
        boolean cardValueCorrect = card.getValue() >= 2 && card.getValue() <= 10;
        assertTrue(cardValueCorrect);
    }

    @Test
    void userGuess() {
        gameService.getNewCard();
        String response = gameService.userGuess("suvaline");
        boolean responseWrong = response.startsWith("VALESTI");
        assertTrue(responseWrong);
    }

    @Test
    void isTimeout() throws InterruptedException {
        gameService.getNewCard();
        Thread.sleep(10005);
        String response = gameService.userGuess("suvaline");
        assertEquals("TIMEOUT", response);
    }

    @Test
    void startNewRound() {
        gameService.getNewCard();
        Card card = gameService.startNewRound();
//        Suit[] suits = {Suit.CLUB, Suit.DIAMOND, Suit.DIAMOND, Suit.SPADE};
        List<Suit> suits = new ArrayList<>(Arrays.asList(Suit.CLUB, Suit.DIAMOND, Suit.HEART, Suit.SPADE));
        boolean suitIsInList = suits.contains(card.getSuit());
        assertTrue(suitIsInList);
    }
}
