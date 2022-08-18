package ee.mihkel.cardgame.card;

public enum Rank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGTH, NINE, TEN, JACK, QUEEN, KING, ACE;

    public static int getRandomRankNumber() {
                                    // 0.0001-0.99999 * 13 =  0.000013-12.9999999
                                    // (int)  --->   0 - 12
        return (int) (Math.random() * values().length);
//        return values()[randomNumber];
        // new ArrayList()   ühe võtmiseks kasutan .get(index) <-- ArrayList võimaldab muuta
        // string[]          ühe võtmiseks kasutan [index]  <-- ainult lugemiseks
    }
}
