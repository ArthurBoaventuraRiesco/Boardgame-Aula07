package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class BoardGameCatalog {
    private final Map<UUID, BoardGame> byId = new HashMap<>();


    public BoardGame add(BoardGame game) {
        if (game == null) throw new ValidationException("game não pode ser nulo");
        if (byId.containsKey(game.getId())) throw new ValidationException("jogo com id já existente");
        byId.put(game.getId(), game);
        return game;
    }


    public boolean remove(UUID id) {
        return byId.remove(id) != null;
    }


    public Optional<BoardGame> findById(UUID id) { return Optional.ofNullable(byId.get(id)); }


    public List<BoardGame> findByTitle(String term) {
        if (term == null || term.isBlank()) return List.of();
        String t = term.toLowerCase(Locale.ROOT);
        return byId.values().stream()
                .filter(g -> g.getTitle().toLowerCase(Locale.ROOT).contains(t))
                .sorted(Comparator.comparing(BoardGame::getTitle))
                .toList();
    }


    public List<BoardGame> listByMechanic(String mechanic) {
        if (mechanic == null || mechanic.isBlank()) return List.of();
        String m = mechanic.toLowerCase(Locale.ROOT);
        return byId.values().stream()
                .filter(g -> g.getMechanics().stream().anyMatch(s -> s.toLowerCase(Locale.ROOT).equals(m)))
                .sorted(Comparator.comparing(BoardGame::getTitle))
                .toList();
    }


    public List<BoardGame> topRated(int n) {
        if (n <= 0) return List.of();
        return byId.values().stream()
                .sorted(Comparator.comparingDouble(BoardGame::getRating).reversed())
                .limit(n)
                .toList();
    }


    public double averagePlayTime() {
        return byId.isEmpty() ? 0 : byId.values().stream().collect(Collectors.averagingInt(BoardGame::getPlayTimeMinutes));
    }


    public int size() { return byId.size(); }


    public List<BoardGame> all() { return List.copyOf(byId.values()); }
}
