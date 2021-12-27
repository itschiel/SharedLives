package me.itschiel.sharedlives.entity;

import me.itschiel.sharedlives.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public final class PlayerList {

    private static Main main = Main.get();

    private static int lives = main.getConfig().getInt("lives");
    private static int death_count = main.getConfig().getInt("death_count");

    private static String header = (lives - death_count) + "/" + lives + " lives are left";


    // Getters and Setters
    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        PlayerList.lives = lives;
    }

    public static int getDeath_count() {
        return death_count;
    }

    public static void setDeath_count(int death_count) {
        PlayerList.death_count = death_count;
    }

    public static String getHeader() {
        return header;
    }


    // Methods
    public static void updateAll(){
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();

        for (Player player: players){
            player.setPlayerListHeader(header);
        }
    }

    public static void update(Player player){
        player.setPlayerListHeader(header);
    }

    public static void reload(){
        main.reloadConfig();
        lives = main.getConfig().getInt("lives");
        death_count = main.getConfig().getInt("death_count");
        updateAll();
    }
}
