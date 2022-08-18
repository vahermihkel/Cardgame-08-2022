package ee.mihkel.cardgame.card;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
//    List<String> mastid = new ArrayList<>(Arrays.asList("poti", "ärtu", "risti", "ruutu"));

    private Rank rank;
    private Suit suit;
    private int value;

    public Card() {
        this.suit = Suit.getRandomSuit();
        int randomNumber = Rank.getRandomRankNumber();
        this.rank = Rank.values()[randomNumber];
        this.value = randomNumber >= 8 ? 10 : randomNumber + 2;

//         if (randomNumber >= 8) {
//            this.value = 10;
//         } else {
//             this.value = randomNumber + 2;
//         }
        // ctrl+alt+m
//        getValueByRank();
    }

//    private void getValueByRank() {
//        switch (rank) {
//            case TWO:
//                this.value = 2;
//                break;
//            case THREE:
//                this.value = 3;
//                break;
//            case FOUR:
//                this.value = 4;
//                break;
//            case FIVE:
//                this.value = 5;
//                break;
//            case SIX:
//                this.value = 6;
//                break;
//            case SEVEN:
//                this.value = 7;
//                break;
//            case EIGTH:
//                this.value = 8;
//                break;
//            case NINE:
//                this.value = 9;
//                break;
//            case TEN:
//            case JACK:
//            case QUEEN:
//            case KING:
//            case ACE:
//                this.value = 10;
//                break;
//        }
//    }
}
