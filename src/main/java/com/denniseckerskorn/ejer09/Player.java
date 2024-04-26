package com.denniseckerskorn.ejer09;

/**
 * Class which represents a Player for the dictionary Game.
 */
public class Player {
    private static int nextID = 1;
    private final int id;
    private final String name;
    private int points;

    /**
     * Constructor of the player, the id is incremented automatically and the player starts with 0 points.
     *
     * @param name Player name
     */
    public Player(String name, int points) {
        this.id = nextID++;
        this.name = name;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void incrementPoints() {
        points += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", points=" + points +
                '}';
    }
}
