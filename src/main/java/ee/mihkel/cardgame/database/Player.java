package ee.mihkel.cardgame.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    private String name;

    @OneToMany  // vasak tähistab classi ja parem tähistab muutujat
    private List<Game> games;
}
