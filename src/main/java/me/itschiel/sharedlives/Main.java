package me.itschiel.sharedlives;

import me.itschiel.sharedlives.manager.LiveManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Instance
    private static Main INSTANCE;
    public static Main get() {return INSTANCE;}


    @Override
    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();


        getServer().getPluginManager().registerEvents(new LiveManager(), this);
    }
}
