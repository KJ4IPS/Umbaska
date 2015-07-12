package uk.co.umbaska.Utils.TitleManager;

import org.bukkit.entity.Player;

/**
 * Created by KJ4IPS on 7/12/2015.
 */
public abstract class AbstractTitleManager {
    public static void sendTitle(Player p, String title) {
        throw new RuntimeException("Unimplemented Class!");
    }

    public static void sendActionTitle(Player p, String action){
        throw new RuntimeException("Unimplemented Class!");
    }

    public static void sendSubTitle(Player p, String subtitle) {
        throw new RuntimeException("Unimplemented Class!");
    }
}
