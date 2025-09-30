import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.util.Set;


class BoardGameCatalogTest {


    @Test
    void addAndSearchAndTopRated() {
        var cat = new BoardGameCatalog();
        var a = BoardGame.of("Azul", 2, 4, 45, "Plan B", 2017, Set.of("pattern building"), 8.0);
        var c = BoardGame.of("Codenames", 2, 8, 15, "CGE", 2015, Set.of("party"), 7.8);
        var g = BoardGame.of("Gloomhaven", 1, 4, 120, "Cephalofair", 2017, Set.of("campaign"), 8.8);


        cat.add(a); cat.add(c); cat.add(g);


        Assertions.assertEquals(3, cat.size());
        Assertions.assertTrue(cat.findByTitle("code").stream().anyMatch(b -> b.getTitle().equals("Codenames")));
        Assertions.assertEquals(3, cat.all().size());


        var top2 = cat.topRated(2);
        Assertions.assertEquals(2, top2.size());
        Assertions.assertEquals("Gloomhaven", top2.get(0).getTitle());


        Assertions.assertTrue(cat.remove(a.getId()));
        Assertions.assertEquals(2, cat.size());
    }


    @Test
    void averagePlayTimeCalculates() {
        var cat = new BoardGameCatalog();
        cat.add(BoardGame.of("Azul", 2, 4, 45, "Plan B", 2017, Set.of("pattern"), 8.0));
        cat.add(BoardGame.of("Patchwork", 2, 2, 30, "Lookout", 2014, Set.of("tile"), 7.7));
        Assertions.assertEquals(37.5, cat.averagePlayTime());
    }
}