import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.util.Set;


class BoardGameTest {


    @Test
    void shouldCreateValidBoardGame() {
        var g = BoardGame.of("Catan", 3, 4, 75, "Kosmos", 1995, Set.of("trading", "tile placement"), 8.2);
        Assertions.assertEquals("Catan", g.getTitle());
        Assertions.assertEquals(3, g.getMinPlayers());
        Assertions.assertEquals(4, g.getMaxPlayers());
    }


    @Test
    void shouldFailWhenInvalidPlayers() {
        Assertions.assertThrows(ValidationException.class, () ->
                BoardGame.of("X", 0, 4, 60, "Pub", 2020, Set.of(), 7.0));
        Assertions.assertThrows(ValidationException.class, () ->
                BoardGame.of("X", 2, 1, 60, "Pub", 2020, Set.of(), 7.0));
    }


    @Test
    void shouldFailWhenRatingOutOfBounds() {
        Assertions.assertThrows(ValidationException.class, () ->
                BoardGame.of("X", 1, 2, 30, "Pub", 2020, Set.of(), -1));
        Assertions.assertThrows(ValidationException.class, () ->
                BoardGame.of("X", 1, 2, 30, "Pub", 2020, Set.of(), 10.5));
    }
}