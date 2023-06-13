package dev.jay.mobarenas;

import it.unimi.dsi.fastutil.Hash;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class MobArenas extends JavaPlugin {

    // Key is playername and value is the number of kills.
    private HashMap<String, Integer> kills = new HashMap<>();
    // Key is the player name, status is dead or alive.
    private HashMap<String, String> status = new HashMap<>();
    // Kits, Key is the playername and value is the kit the user has.
    private HashMap<String, String> kits = new HashMap<>();
    // Wave: Key is the wave number, value is the amount of spawns per wave.
    private HashMap<Integer, Integer> wave = new HashMap<>();
    // Have key as the wave number and value as mob count. Once mobs are killed
    // remove 1 from mobcount then when it hits 0 the next wave can start the countdown.
    private HashMap<Integer, Integer> mobcount = new HashMap<>();


    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public HashMap<Integer, Integer> getWave(){
        return wave;
    }
    public HashMap<String, String> getStatus(){
        return status;
    }
    public HashMap<String, String> getKits(){
        return kits;
    }
    public HashMap<String, Integer> getKills(){
        return kills;
    }
}
