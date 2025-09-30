package org.example;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;


public final class BoardGame {
    private final UUID id;
    private final String title;
    private final int minPlayers;
    private final int maxPlayers;
    private final int playTimeMinutes; // duração média
    private final String publisher;
    private final int year;
    private final Set<String> mechanics; // ex: "deck-building", "worker placement"
    private final double rating; // 0.0 a 10.0


    public BoardGame(UUID id, String title, int minPlayers, int maxPlayers,
                     int playTimeMinutes, String publisher, int year,
                     Set<String> mechanics, double rating) {
        if (id == null) throw new ValidationException("id não pode ser nulo");
        if (title == null || title.isBlank()) throw new ValidationException("title obrigatório");
        if (minPlayers <= 0) throw new ValidationException("minPlayers deve ser > 0");
        if (maxPlayers < minPlayers) throw new ValidationException("maxPlayers deve ser >= minPlayers");
        if (playTimeMinutes <= 0) throw new ValidationException("playTimeMinutes deve ser > 0");
        if (year < 1900) throw new ValidationException("year inválido");
        if (rating < 0 || rating > 10) throw new ValidationException("rating deve estar entre 0 e 10");


        this.id = id;
        this.title = title.trim();
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTimeMinutes = playTimeMinutes;
        this.publisher = publisher == null ? "" : publisher.trim();
        this.year = year;
        this.mechanics = mechanics == null ? Set.of() : Set.copyOf(mechanics);
        this.rating = rating;
    }


    public static BoardGame of(String title, int minPlayers, int maxPlayers, int playTimeMinutes,
                               String publisher, int year, Set<String> mechanics, double rating) {
        return new BoardGame(UUID.randomUUID(), title, minPlayers, maxPlayers, playTimeMinutes, publisher, year, mechanics, rating);
    }


    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public int getMinPlayers() { return minPlayers; }
    public int getMaxPlayers() { return maxPlayers; }
    public int getPlayTimeMinutes() { return playTimeMinutes; }
    public String getPublisher() { return publisher; }
    public int getYear() { return year; }
    public Set<String> getMechanics() { return mechanics; }
    public double getRating() { return rating; }


    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardGame that)) return false;
        return id.equals(that.id);
    }


    @Override public int hashCode() { return Objects.hash(id); }


    @Override public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", players=" + minPlayers + "-" + maxPlayers +
                ", time=" + playTimeMinutes + "min" +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}