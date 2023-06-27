package dev.jay.mobarenas;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class RTPManager {

    private final MobArenas plugin;
    public RTPManager(MobArenas plugin){
        this.plugin = plugin;
    }

     public void onRTP(Player player){
        String world = plugin.getConfig().getString("Structures.Arena.World");
        Integer ArenaX1 = plugin.getConfig().getInt("Structures.Arena.Position1.X");
        Integer ArenaY1 = plugin.getConfig().getInt("Structures.Arena.Position1.Y");
        Integer ArenaZ1 = plugin.getConfig().getInt("Structures.Arena.Position1.Z");
        Integer ArenaX2 = plugin.getConfig().getInt("Structures.Arena.Position2.X");
        Integer ArenaY2 = plugin.getConfig().getInt("Structures.Arena.Position2.Y");
        Integer ArenaZ2 = plugin.getConfig().getInt("Structures.Arena.Position2.Z");

        for (Player p : Bukkit.getOnlinePlayers()) {
            Random random = new Random();
            int x = random.nextInt(ArenaX1, ArenaX2);
            int y = random.nextInt(ArenaY1, ArenaY2);
            int z = random.nextInt(ArenaZ1, ArenaZ2);

            if (areCoordinatesBetween(ArenaX1, ArenaY1, ArenaZ1, ArenaX2, ArenaY2, ArenaZ2, x, y, z)){

                Location location1 = new Location(Bukkit.getWorld(world), x, y, z);
                player.teleport(location1);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Plugin.Prefix") + " " + plugin.getConfig().getString("Messages.RandomlyTeleported")));

            }
        }





     }



    public boolean areCoordinatesBetween(double x1, double y1, double z1, double x2, double y2, double z2, double targetX, double targetY, double targetZ) {

        double xMin = Math.min(x1, x2);
        double xMax = Math.max(x1, x2);
        double yMin = Math.min(y1, y2);
        double yMax = Math.max(y1, y2);
        double zMin = Math.min(z1, z2);
        double zMax = Math.max(z1, z2);

        return targetX >= xMin && targetX <= xMax && targetY >= yMin && targetY <= yMax && targetZ >= zMin && targetZ <= zMax;

    }
}
