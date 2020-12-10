package model;

/**
 * @author Maxim Derboven
 * @version 1.0 9/12/2020 18:44
 */
public class Player {
    private String name;
    private Scoreboard scoreboard;

    public Player(String name, Scoreboard scoreboard) {
        this.name = name;
        this.scoreboard = scoreboard;
    }

    public void showScoreboard() {
        System.out.println("--------\n" + name);
        scoreboard.draw();
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}