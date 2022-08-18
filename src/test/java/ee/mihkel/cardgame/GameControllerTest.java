package ee.mihkel.cardgame;

import ee.mihkel.cardgame.card.GameController;
import ee.mihkel.cardgame.card.GameService;
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


@ExtendWith(MockitoExtension.class) // controlleri juures on vaja mock
class GameControllerTest {

    private MockMvc mvc;

    @Mock   // @Autowired tõttu  // <--- seda osa ei pea tegema kui @Autowired GameService gameService asemel oleks
            GameService gameService;  // GameService gameService = new GameService();

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(gameController).build();
    }

    @Test
    void startGame() throws Exception {
       MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/start-game"))
               .andReturn().getResponse();
       assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void guess() throws Exception {
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/guess/higher"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void newRound() throws Exception {
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/new-round"))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
