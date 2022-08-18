package ee.mihkel.cardgame.card;

public enum Suit {
    HEART, SPADE, DIAMOND, CLUB;

    public static Suit getRandomSuit() {
        int randomNumber = (int) (Math.random() * values().length);
        return values()[randomNumber];
    }
}
