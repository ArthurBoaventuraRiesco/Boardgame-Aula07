package org.example;


import java.util.Set;

public class Main {
    public static void main(String[] args) {
        BoardGameCatalog catalog = new BoardGameCatalog();

        // cria alguns jogos
        BoardGame azul = BoardGame.of(
                "Azul", 2, 4, 45, "Plan B", 2017, Set.of("pattern building"), 8.0
        );
        BoardGame catan = BoardGame.of(
                "Catan", 3, 4, 75, "Kosmos", 1995, Set.of("trading", "tile placement"), 8.2
        );

        // adiciona no catálogo
        catalog.add(azul);
        catalog.add(catan);

        // imprime top 1
        System.out.println("Top rated: " + catalog.topRated(1));

        // imprime tempo médio
        System.out.println("Tempo médio de jogo: " + catalog.averagePlayTime() + " minutos");
    }
}