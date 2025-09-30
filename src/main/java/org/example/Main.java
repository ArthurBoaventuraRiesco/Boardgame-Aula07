package org.example;


import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BoardGameCatalog catalog = new BoardGameCatalog();


        BoardGame azul = BoardGame.of(
                "Azul", 2, 4, 45, "Plan B", 2017, Set.of("pattern building"), 8.0
        );
        BoardGame catan = BoardGame.of(
                "Catan", 3, 4, 75, "Kosmos", 1995, Set.of("trading", "tile placement"), 8.2
        );


        catalog.add(azul);
        catalog.add(catan);


        System.out.println("Top rated: " + catalog.topRated(1));


        System.out.println("Tempo médio de jogo: " + catalog.averagePlayTime() + " minutos");
    }
}