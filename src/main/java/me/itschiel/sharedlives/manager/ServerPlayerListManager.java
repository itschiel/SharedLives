package me.itschiel.sharedlives.manager;

import me.itschiel.sharedlives.Main;
import me.itschiel.sharedlives.entity.PlayerList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerLoadEvent;

import java.util.Collection;

public class ServerPlayerListManager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        PlayerList.update(player);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        PlayerList.updateAll();
    }

    @EventHandler
    public void onReload(ServerLoadEvent event){
        PlayerList.reload();
    }
}
