package me.itschiel.sharedlives.manager;

import me.itschiel.sharedlives.Main;
import me.itschiel.sharedlives.entity.PlayerList;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Collection;

public class LiveManager implements Listener {

    Main main = Main.get();

    @EventHandler
    public void onDead(PlayerDeathEvent event){

        main.reloadConfig();
        int death_count = main.getConfig().getInt("death_count");
        int lives = main.getConfig().getInt("lives");

        death_count++;
        main.getConfig().set("death_count", death_count);
        main.saveConfig();

        if (death_count == lives){
            Collection<? extends Player> players = main.getServer().getOnlinePlayers();

            for (Player player: players){
                player.setGameMode(GameMode.SPECTATOR);
            }
        }

        PlayerList.updateAll();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.SPECTATOR){return;}

        main.reloadConfig();
        int death_count = main.getConfig().getInt("death_count");
        int lives = main.getConfig().getInt("lives");

        if (death_count == lives){
            player.setGameMode(GameMode.SPECTATOR);
        }

        PlayerList.update(player);
    }
}
