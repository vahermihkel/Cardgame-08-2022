package ee.mihkel.cardgame.database;

import ee.mihkel.cardgame.card.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DatabaseControllerTest {

    private MockMvc mvc;

    @Mock
    PlayerRepository playerRepository;

    @Mock
    GameRepository gameRepository;

    @Mock
    DatabaseService databaseService;

    @InjectMocks
    private DatabaseController databaseController;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(databaseController).build();
        databaseService.addToDabase("Juku");
    }

//    @Test
//    void getGamesByPlayer() throws Exception {
//        Player player = new Player();
//        player.setName("Juku");
//        playerRepository.save(player);
//        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/games/Juku"))
//                .andReturn().getResponse();
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//    }
//
//    @Test
//    void getPlayerByGame() throws Exception {
//        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("player/1"))
//                .andReturn().getResponse();
//        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//    }

    @Test
    void getTopGames() throws Exception {
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/top-games"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
